package io.gate.gateapi.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BalanceChangeType {
    WITHDRAW("withdraw"),
    DEPOSIT("deposit"),
    TRADE_FEE_DEDUCT("trade-fee-deduct"),
    ORDER_CREATE("order-create"),
    ORDER_MATCH("order-match"),
    ORDER_UPDATE("order-update"),
    MARGIN_TRANSFER("margin-transfer"),
    FUTURE_TRANSFER("future-transfer"),
    CROSS_MARGIN_TRANSFER("cross-margin-transfer"),
    OTHER("other");

    private final String name;

    BalanceChangeType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
