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
public class CrossMarginLoanUpdate {
    private String timestamp;
    private String user;
    private String currency;
    private BigDecimal change;
    private BigDecimal total;
    private BigDecimal available;
    private BigDecimal borrowed;
    private BigDecimal interest;
}
