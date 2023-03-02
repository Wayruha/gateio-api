package io.gate.gateapi.websocket;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.util.zip.Inflater;

public class WebSocketClientHandler<T> extends SimpleChannelInboundHandler<Object> {
    private ChannelPromise handshakeFuture;
    private final WebSocketClientHandshaker handshaker;
    private WebSocketClient<T> webSocketClient;
    private ObjectMapper mapper;

    public WebSocketClientHandler(WebSocketClient<T> webSocketClient, WebSocketClientHandshaker handshaker) {
        this.handshaker = handshaker;
        this.webSocketClient = webSocketClient;
        mapper = new ObjectMapper();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel ch = ctx.channel();
        if (!handshaker.isHandshakeComplete()) {
            handshaker.finishHandshake(ch, (FullHttpResponse) msg);
            handshakeFuture.setSuccess();
            webSocketClient.listener.onWebsocketOpen(this.webSocketClient);
            this.webSocketClient.beginTimer();
            return;
        }

        if (msg instanceof FullHttpResponse) {
            FullHttpResponse response = (FullHttpResponse) msg;
            throw new IllegalStateException(
                    "Unexpected FullHttpResponse (getStatus=" + response.status() +
                            ", content=" + response.content().toString(CharsetUtil.UTF_8) + ')');
        }

        WebSocketFrame frame = (WebSocketFrame) msg;
        if (frame instanceof PongWebSocketFrame) {
            webSocketClient.listener.onWebsocketPong(webSocketClient);
        } else if (frame instanceof CloseWebSocketFrame) {
            CloseWebSocketFrame closeFrame = (CloseWebSocketFrame) frame;
            int closeCode = closeFrame.statusCode();
            webSocketClient.listener.onWebsocketClose(webSocketClient, closeCode);
        } else if (frame instanceof BinaryWebSocketFrame) {
            //这里处理收到的逻辑
            String msgStr = decode(msg);
            if (msgStr.equals("pong")) {
                webSocketClient.listener.onWebsocketPong(webSocketClient);
            } else {
                BinaryWebSocketFrame binaryWebSocketFrame = (BinaryWebSocketFrame) frame;
                this.webSocketClient.listener.onResponse(webSocketClient, parseResponse(decode(binaryWebSocketFrame.content()), webSocketClient.listener.getType()));
            }
        } else if (frame instanceof TextWebSocketFrame) {
            String txt = ((TextWebSocketFrame) frame).text();
            if (txt.equals("pong")) {
                webSocketClient.listener.onWebsocketPong(webSocketClient);
            } else if (txt.contains("\"result\":[{")) {
                webSocketClient.listener.onResponse(webSocketClient, parseResponse(txt, webSocketClient.listener.getType()));
            }
            webSocketClient.listener.onText(webSocketClient, txt);
        } else {
            webSocketClient.listener.handleCallbackError(webSocketClient, new RuntimeException("cannot decode message"));
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        handshakeFuture = ctx.newPromise();
    }

    public ChannelFuture handshakeFuture() {
        return handshakeFuture;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        handshaker.handshake(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
    }

    private static String uncompress(ByteBuf buf) {
        try {
            byte[] temp = new byte[buf.readableBytes()];
            ByteBufInputStream bis = new ByteBufInputStream(buf);
            bis.read(temp);
            bis.close();
            Inflater decompresser = new Inflater(true);
            decompresser.setInput(temp, 0, temp.length);
            StringBuilder sb = new StringBuilder();
            byte[] result = new byte[1024];
            while (!decompresser.finished()) {
                int resultLength = decompresser.inflate(result);
                sb.append(new String(result, 0, resultLength, "UTF-8"));
            }
            decompresser.end();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String decode(Object msg) {
        BinaryWebSocketFrame frameBinary = (BinaryWebSocketFrame) msg;
        byte[] bytes = new byte[frameBinary.content().readableBytes()];
        frameBinary.content().readBytes(bytes);
        ByteBuf byteBuf = Unpooled.wrappedBuffer(bytes);
        String str = uncompress(byteBuf);
        return str;
    }

    private <X> X parseResponse(String json, TypeReference<X> ref) {
        try {
            return mapper.readValue(json, ref);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
