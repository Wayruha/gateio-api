package io.gate.gateapi.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionRequest {
    private String id;
    private Long time;
    private WSChannel channel;
    private EventType event;
    private Auth auth;
    private List<String> payload;
}
