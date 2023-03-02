package io.gate.gateapi.websocket;

import java.util.List;

public interface WebSocket {

    void connect();

    void close();

    void subscribe(WSChannel args, List<String> payload) throws Exception;

    void unSubscribe(WSChannel args, List<String> payload) throws Exception;

    void sendPing();

    boolean checkSum(String data);
}
