package io.gate.gateapi.websocket.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginBalanceUpdate {
    private String timestamp;
    private String timestamp_ms;
    private String user;
    private String currency_pair;
    private String currency;
    private BigDecimal change;
    private BigDecimal available;
    private BigDecimal freeze;
    private BigDecimal borrowed;
    private BigDecimal interest;
}
