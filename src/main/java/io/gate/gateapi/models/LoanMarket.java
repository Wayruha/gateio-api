package io.gate.gateapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanMarket {
    @SerializedName("currency_pair")
    String currencyPair;
    @SerializedName("base_min_borrow_amount")
    BigDecimal baseMinBorrow;
    @SerializedName("quote_min_borrow_amount")
    BigDecimal quoteMinBorrow;
    int leverage;
}
