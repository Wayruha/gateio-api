package io.gate.gateapi.websocket;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    private String method;
    @SerializedName("KEY")
    private String key;
    @SerializedName("SIGN")
    private String sign;
}
