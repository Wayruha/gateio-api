package io.gate.gateapi.models;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.Data;

import java.io.IOException;

@Data
public class BorrowRepayReq {
    private String currency;
    private String amount;
    private Type type;
    @SerializedName("currency_pair")
    private String currencyPair;
    @SerializedName("repaid_all")
    private Boolean repaidAll;

    @JsonAdapter(Type.Adapter.class)
    public enum Type {
        BORROW("borrow"),
        REPAY("repay");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static BorrowRepayReq.Type fromValue(String value) {
            for (BorrowRepayReq.Type b : values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<BorrowRepayReq.Type> {
            @Override
            public void write(final JsonWriter jsonWriter, final BorrowRepayReq.Type enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public BorrowRepayReq.Type read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return BorrowRepayReq.Type.fromValue(value);
            }
        }
    }
}
