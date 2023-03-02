package io.gate.gateapi.websocket;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;

@JsonAdapter(EventType.EventTypeAdapter.class)
public enum EventType {
    @SerializedName("subscribe")
    SUBSCRIBE("subscribe"),
    @SerializedName("unsubscribe")
    UNSUBSCRIBE("unsubscribe");

    private String code;

    EventType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static EventType fromCode(String code) {
        return Arrays.stream(values()).filter(channel -> channel.code.equals(code)).findFirst().orElse(null);
    }

    public class EventTypeAdapter extends TypeAdapter<EventType> {
        @Override
        public void write(JsonWriter out, EventType value) throws IOException {
            out.value(value.code);
        }

        @Override
        public EventType read(JsonReader in) throws IOException {
            return EventType.fromCode(in.nextString());
        }
    }
}
