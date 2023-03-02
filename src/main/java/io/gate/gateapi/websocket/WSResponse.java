package io.gate.gateapi.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WSResponse<T> {
    private String time;
    private String time_ms;
    private String channel;
    private String event;
    private T result;
}