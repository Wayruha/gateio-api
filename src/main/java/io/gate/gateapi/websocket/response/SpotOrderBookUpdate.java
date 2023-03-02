package io.gate.gateapi.websocket.response;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpotOrderBookUpdate {
    @SerializedName("t")
    private String timestamp;
    @SerializedName("s")
    private String currencyPair;
    @SerializedName("U")
    private String firstUpdateId;
    @SerializedName("u")
    private String lastUpdateId;
    @SerializedName("b")
    private List<BookItem> bidUpdates;
    @SerializedName("a")
    private List<BookItem> askUpdates;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonAdapter(BookItemAdapter.class)
    public class BookItem {
        private BigDecimal price;
        private BigDecimal amount;
    }

    private class BookItemAdapter extends TypeAdapter<BookItem> {

        @Override
        public void write(JsonWriter out, BookItem value) throws IOException {
           out.beginArray();
           out.value(value.getPrice());
           out.value(value.getAmount());
           out.endArray();
        }

        @Override
        public BookItem read(JsonReader in) throws IOException {
            in.beginArray();
            final BigDecimal price = NumberUtils.createBigDecimal(in.nextString());
            final BigDecimal amount = NumberUtils.createBigDecimal(in.nextString());
            return new BookItem(price, amount);
        }
    }
}
