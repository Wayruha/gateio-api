package io.gate.gateapi.websocket.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.gate.gateapi.models.BalanceChangeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotBalanceUpdate {
    private String timestamp;
    private String timestamp_ms;
    private String user;
    private String currency;
    private BigDecimal change;
    private BigDecimal total;
    private BigDecimal available;
    private BigDecimal freeze;
    @JsonProperty(value = "freeze_change")
    private BigDecimal freezeChange;
    @JsonProperty(value = "change_type")
    private BalanceChangeType changeType;
}
