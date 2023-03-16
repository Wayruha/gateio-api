package io.gate.gateapi.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebSocketClient<T> implements WebSocket {
    private final static HashFunction crc32 = Hashing.crc32();
    private Channel ch;
    protected WebSocketListener<T> listener;
    private static final String URL = "wss://api.gateio.ws/ws/v4/";
    private Timer timer = new HashedWheelTimer(Executors.defaultThreadFactory());
    private final String apiKey;
    private final String apiSecret;
    private ObjectMapper mapper;

    public WebSocketClient(String apiKey, String apiSecret, WebSocketListener<T> listener, ObjectMapper mapper) {
        this.listener = listener;
        this.mapper = mapper;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    private void init() {
        try {
            URI uri = new URI(URL);
            String scheme = uri.getScheme() == null ? "ws" : uri.getScheme();
            final String host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
            int port;

            if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
                this.listener.handleCallbackError(this, new RuntimeException("Only WS(S) is supported."));
                return;
            }

            if (uri.getPort() == -1) {
                if ("ws".equalsIgnoreCase(scheme)) {
                    port = 80;
                } else if ("wss".equalsIgnoreCase(scheme)) {
                    port = 443;
                } else {
                    port = -1;
                }
            } else {
                port = uri.getPort();
            }

            final boolean ssl = "wss".equalsIgnoreCase(scheme);
            final SslContext sslCtx;
            if (ssl) {
                sslCtx = SslContextBuilder.forClient()
                        .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            } else {
                sslCtx = null;
            }

            EventLoopGroup group = new NioEventLoopGroup();

            WebSocketClientHandshaker shaker = WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, true, new DefaultHttpHeaders());
            final WebSocketClientHandler<T> handler = new WebSocketClientHandler<>(this, shaker);

            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            if (sslCtx != null) {
                                p.addLast(sslCtx.newHandler(ch.alloc(), host, port));
                            }
                            p.addLast(new HttpClientCodec());
                            p.addLast(new HttpObjectAggregator(8192));
                            p.addLast(CustomWebSocketClientCompressionHandler.INSTANCE);
                            p.addLast(handler);
                            p.addLast(new IdleStateHandler(0, 30, 0));

                        }
                    });

            ch = b.connect(uri.getHost(), port).sync().channel();
            handler.handshakeFuture().sync();

        } catch (Exception e) {
            this.listener.handleCallbackError(this, e);
        }
    }


    @Override
    public void close() {
        ch.close();
    }

    @Override
    public void connect() {
        this.init();
    }

    public Auth auth(WSChannel channel, EventType event, long timestamp) {
        try {
            final String signatureString = String.format("channel=%s&event=%s&time=%d", channel, event, timestamp);
            Mac hmacSha512 = Mac.getInstance("HmacSHA512");
            final byte[] bytes = Objects.isNull(apiSecret) ? new byte[]{} : apiSecret.getBytes();
            SecretKeySpec spec = new SecretKeySpec(bytes, "HmacSHA512");
            hmacSha512.init(spec);
            final String signature = Hex.encodeHexString(hmacSha512.doFinal(signatureString.getBytes()));
            final Auth auth = new Auth();
            auth.setMethod("api_key");
            auth.setKey(apiKey);
            auth.setSign(signature);
            return auth;
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void subscribe(WSChannel arg, List<String> payload) {
        final long timestamp = System.currentTimeMillis() / 1000;
        final SubscriptionRequest request = new SubscriptionRequest();
        request.setTime(timestamp);
        request.setChannel(arg);
        request.setEvent(EventType.SUBSCRIBE);
        request.setAuth(auth(arg, EventType.SUBSCRIBE, timestamp));
        request.setPayload(payload);
        this.send(request);
    }

    @Override
    public void unSubscribe(WSChannel arg, List<String> payload) {
        final long timestamp = System.currentTimeMillis() / 1000;
        final SubscriptionRequest request = new SubscriptionRequest();
        request.setTime(timestamp);
        request.setChannel(arg);
        request.setEvent(EventType.UNSUBSCRIBE);
        request.setAuth(auth(arg, EventType.UNSUBSCRIBE, timestamp));
        request.setPayload(payload);
        this.send(request);
    }

    @Override
    public void sendPing() {
        final SubscriptionRequest request = new SubscriptionRequest();
        final long timestamp = System.currentTimeMillis() / 1000;
        request.setTime(timestamp);
        request.setChannel(WSChannel.PING);
        this.send(request);
    }

    @Override
    public boolean checkSum(String data) {
        try {
            JSONObject obj = (JSONObject) JSON.parse(data);
            JSONArray bidsArray = null;
            JSONArray asksArray = null;
            int checksum = 0;
            if (obj.get("table") != null && obj.get("action") != null) {
                JSONArray dataObj = (JSONArray) obj.get("data");
                JSONObject targetObj = (JSONObject) dataObj.get(0);
                bidsArray = (JSONArray) targetObj.get("bids");
                asksArray = (JSONArray) targetObj.get("asks");
                checksum = (int) targetObj.get("checksum");

            } else {
                bidsArray = (JSONArray) obj.get("bids");
                asksArray = (JSONArray) obj.get("asks");
                checksum = (int) obj.get("checksum");
            }

            StringBuilder targetStr = new StringBuilder();
            for (int index = 0; index < 25; index++) {
                if (bidsArray != null && index < bidsArray.size()) {
                    JSONArray bidsObject = (JSONArray) bidsArray.get(index);
                    for (int num = 0; num < 2; num++) {
                        targetStr.append(bidsObject.get(num));
                        targetStr.append(":");
                    }

                }
                if (asksArray != null && index < asksArray.size()) {
                    JSONArray asksObject = (JSONArray) asksArray.get(index);
                    for (int num = 0; num < 2; num++) {
                        targetStr.append(asksObject.get(num));
                        targetStr.append(":");
                    }
                }
            }

            final String strs;
            if (targetStr.length() > 0) {
                strs = targetStr.substring(0, targetStr.length() - 1);
            } else {
                strs = "";
            }

            int fianlStr = crc32.hashString(strs, StandardCharsets.UTF_8).asInt();
            return fianlStr == checksum;
        } catch (Exception e) {
            this.listener.handleCallbackError(this, e);
        }
        return false;
    }

    private void send(Object msg) {
        final Gson gson = new GsonBuilder().create();
        WebSocketFrame frame = new TextWebSocketFrame(gson.toJson(msg));
        ch.writeAndFlush(frame);
    }

    private String formatArgs(String... args) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (String str : args) {
            if (str.isEmpty()) {
                continue;
            }
            builder.append(str);
            if (args.length > 1 && ++count < args.length) {
                builder.append(",");
            }
        }
        return builder.toString();
    }

    public void beginTimer() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                addTask(this);
                timerTask();
            }
        };
        addTask(timerTask);
    }

    private void addTask(TimerTask task) {
        this.timer.newTimeout(task, 5000, TimeUnit.MILLISECONDS);
    }

    private void timerTask() {
        sendPing();
    }
}
