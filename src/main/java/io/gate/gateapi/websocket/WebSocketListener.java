package io.gate.gateapi.websocket;

import com.fasterxml.jackson.core.type.TypeReference;

public interface WebSocketListener<T> {

    /**
     * Called when a string message was received.
     *
     * @param ws
     *         The WebSocket.
     *
     * @param message
     *         The text message.
     *
     * @throws Exception
     *         An exception thrown by an implementation of this method.
     *         The exception is passed to {@link #handleCallbackError(WebSocket, Throwable)}.
     */
    void onText(WebSocket ws, String message);

    /**
     * Called when a string message was received.
     *
     * @param ws
     *         The WebSocket.
     *
     * @param response
     *         Response.
     *
     * @throws Exception
     *         An exception thrown by an implementation of this method.
     *         The exception is passed to {@link #handleCallbackError(WebSocket, Throwable)}.
     */
    void onResponse(WebSocket ws, T response);

    /**
     * Called after onHandshakeReceived returns true
     * Indicates that a complete WebSocket connection has been established,
     * and we are ready to send/receive data.
     *
     * @param ws The WebSocket instance this event is occuring on.
     */
    void onWebsocketOpen(WebSocket ws);

    /**
     * Called when an method threw a {@code Throwable}.
     *
     * @param websocket
     *         The WebSocket.
     *
     * @param cause
     *
     * @throws Throwable
     *         An exception thrown by an implementation of this method.
     *         The exception is just ignored.
     *
     */
    void handleCallbackError(WebSocket websocket, Throwable cause);

    /**
     * Called after WebSocket#close is explicity called, or when the
     * other end of the WebSocket connection is closed.
     *
     * @param ws The WebSocket instance this event is occuring on.
     */
    void onWebsocketClose(WebSocket ws, int code);

    /**
     * Called when a pong frame is received.
     *
     * @param ws The WebSocket instance this event is occuring on.
     **/
    void onWebsocketPong(WebSocket ws);

    TypeReference<T> getType();
}
