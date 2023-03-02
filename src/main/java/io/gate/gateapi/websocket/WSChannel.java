package io.gate.gateapi.websocket;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gate.gateapi.websocket.response.SpotOrderBookUpdate;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@JsonAdapter(WSChannel.WSChannelAdapter.class)
public enum WSChannel {
    @SerializedName("spot.balances")
    SPOT_BALANCES("spot.balances"),
    @SerializedName("spot.margin_balances")
    MARGIN_BALANCES("spot.margin_balances"),
    @SerializedName("spot.cross_balances")
    CROSS_MARGIN_BALANCES("spot.cross_balances"),
    @SerializedName("spot.cross_loan")
    CROSS_MARGIN_LOAN("spot.cross_loan");

    private String code;

    WSChannel(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static WSChannel fromCode(String code) {
        return Arrays.stream(values()).filter(channel -> channel.code.equals(code)).findFirst().orElse(null);
    }

    public class WSChannelAdapter extends TypeAdapter<WSChannel> {
        @Override
        public void write(JsonWriter out, WSChannel value) throws IOException {
            out.value(value.code);
        }

        @Override
        public WSChannel read(JsonReader in) throws IOException {
            return WSChannel.fromCode(in.nextString());
        }
    }
}
