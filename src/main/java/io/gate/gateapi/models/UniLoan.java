package io.gate.gateapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UniLoan {
    private String currency;
    @SerializedName("currency_pair")
    private String currencyPair;
    private String amount;
    @SerializedName("change_time")
    private String changeTime;
    @SerializedName("create_time")
    private String createTime;
}
