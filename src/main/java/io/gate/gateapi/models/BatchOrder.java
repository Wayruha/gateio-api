/*
 * Gate API v4
 * Welcome to Gate.io API  APIv4 provides spot, margin and futures trading operations. There are public APIs to retrieve the real-time market statistics, and private APIs which needs authentication to trade on user's behalf.
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.gate.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * Batch order details
 */
public class BatchOrder {
    public static final String SERIALIZED_NAME_TEXT = "text";
    @SerializedName(SERIALIZED_NAME_TEXT)
    private String text;

    public static final String SERIALIZED_NAME_SUCCEEDED = "succeeded";
    @SerializedName(SERIALIZED_NAME_SUCCEEDED)
    private Boolean succeeded;

    public static final String SERIALIZED_NAME_LABEL = "label";
    @SerializedName(SERIALIZED_NAME_LABEL)
    private String label;

    public static final String SERIALIZED_NAME_MESSAGE = "message";
    @SerializedName(SERIALIZED_NAME_MESSAGE)
    private String message;

    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_CREATE_TIME = "create_time";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME)
    private String createTime;

    public static final String SERIALIZED_NAME_UPDATE_TIME = "update_time";
    @SerializedName(SERIALIZED_NAME_UPDATE_TIME)
    private String updateTime;

    public static final String SERIALIZED_NAME_CREATE_TIME_MS = "create_time_ms";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME_MS)
    private Long createTimeMs;

    public static final String SERIALIZED_NAME_UPDATE_TIME_MS = "update_time_ms";
    @SerializedName(SERIALIZED_NAME_UPDATE_TIME_MS)
    private Long updateTimeMs;

    /**
     * Order status  - &#x60;open&#x60;: to be filled - &#x60;closed&#x60;: filled - &#x60;cancelled&#x60;: cancelled
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        OPEN("open"),
        
        CLOSED("closed"),
        
        CANCELLED("cancelled");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return StatusEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private StatusEnum status;

    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    /**
     * Order type. limit - limit order
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        LIMIT("limit");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return TypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    private TypeEnum type = TypeEnum.LIMIT;

    /**
     * Account type. spot - use spot account; margin - use margin account; cross_margin - use cross margin account
     */
    @JsonAdapter(AccountEnum.Adapter.class)
    public enum AccountEnum {
        SPOT("spot"),
        
        MARGIN("margin"),
        
        CROSS_MARGIN("cross_margin");

        private String value;

        AccountEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AccountEnum fromValue(String value) {
            for (AccountEnum b : AccountEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<AccountEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AccountEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AccountEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return AccountEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_ACCOUNT = "account";
    @SerializedName(SERIALIZED_NAME_ACCOUNT)
    private AccountEnum account = AccountEnum.SPOT;

    /**
     * Order side
     */
    @JsonAdapter(SideEnum.Adapter.class)
    public enum SideEnum {
        BUY("buy"),
        
        SELL("sell");

        private String value;

        SideEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SideEnum fromValue(String value) {
            for (SideEnum b : SideEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<SideEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SideEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SideEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return SideEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SIDE = "side";
    @SerializedName(SERIALIZED_NAME_SIDE)
    private SideEnum side;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;

    /**
     * Time in force  - gtc: GoodTillCancelled - ioc: ImmediateOrCancelled, taker only - poc: PendingOrCancelled, makes a post-only order that always enjoys a maker fee
     */
    @JsonAdapter(TimeInForceEnum.Adapter.class)
    public enum TimeInForceEnum {
        GTC("gtc"),
        
        IOC("ioc"),
        
        POC("poc");

        private String value;

        TimeInForceEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TimeInForceEnum fromValue(String value) {
            for (TimeInForceEnum b : TimeInForceEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TimeInForceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TimeInForceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TimeInForceEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return TimeInForceEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TIME_IN_FORCE = "time_in_force";
    @SerializedName(SERIALIZED_NAME_TIME_IN_FORCE)
    private TimeInForceEnum timeInForce = TimeInForceEnum.GTC;

    public static final String SERIALIZED_NAME_ICEBERG = "iceberg";
    @SerializedName(SERIALIZED_NAME_ICEBERG)
    private String iceberg;

    public static final String SERIALIZED_NAME_AUTO_BORROW = "auto_borrow";
    @SerializedName(SERIALIZED_NAME_AUTO_BORROW)
    private Boolean autoBorrow;

    public static final String SERIALIZED_NAME_AUTO_REPAY = "auto_repay";
    @SerializedName(SERIALIZED_NAME_AUTO_REPAY)
    private Boolean autoRepay;

    public static final String SERIALIZED_NAME_LEFT = "left";
    @SerializedName(SERIALIZED_NAME_LEFT)
    private String left;

    public static final String SERIALIZED_NAME_FILL_PRICE = "fill_price";
    @SerializedName(SERIALIZED_NAME_FILL_PRICE)
    private String fillPrice;

    public static final String SERIALIZED_NAME_FILLED_TOTAL = "filled_total";
    @SerializedName(SERIALIZED_NAME_FILLED_TOTAL)
    private String filledTotal;

    public static final String SERIALIZED_NAME_FEE = "fee";
    @SerializedName(SERIALIZED_NAME_FEE)
    private String fee;

    public static final String SERIALIZED_NAME_FEE_CURRENCY = "fee_currency";
    @SerializedName(SERIALIZED_NAME_FEE_CURRENCY)
    private String feeCurrency;

    public static final String SERIALIZED_NAME_POINT_FEE = "point_fee";
    @SerializedName(SERIALIZED_NAME_POINT_FEE)
    private String pointFee;

    public static final String SERIALIZED_NAME_GT_FEE = "gt_fee";
    @SerializedName(SERIALIZED_NAME_GT_FEE)
    private String gtFee;

    public static final String SERIALIZED_NAME_GT_DISCOUNT = "gt_discount";
    @SerializedName(SERIALIZED_NAME_GT_DISCOUNT)
    private Boolean gtDiscount;

    public static final String SERIALIZED_NAME_REBATED_FEE = "rebated_fee";
    @SerializedName(SERIALIZED_NAME_REBATED_FEE)
    private String rebatedFee;

    public static final String SERIALIZED_NAME_REBATED_FEE_CURRENCY = "rebated_fee_currency";
    @SerializedName(SERIALIZED_NAME_REBATED_FEE_CURRENCY)
    private String rebatedFeeCurrency;


    public BatchOrder text(String text) {
        
        this.text = text;
        return this;
    }

     /**
     * User defined information. If not empty, must follow the rules below:  1. prefixed with &#x60;t-&#x60; 2. no longer than 28 bytes without &#x60;t-&#x60; prefix 3. can only include 0-9, A-Z, a-z, underscore(_), hyphen(-) or dot(.) 
     * @return text
    **/
    @javax.annotation.Nullable
    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public BatchOrder succeeded(Boolean succeeded) {
        
        this.succeeded = succeeded;
        return this;
    }

     /**
     * Whether order succeeds
     * @return succeeded
    **/
    @javax.annotation.Nullable
    public Boolean getSucceeded() {
        return succeeded;
    }


    public void setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
    }

    public BatchOrder label(String label) {
        
        this.label = label;
        return this;
    }

     /**
     * Error label, empty string if order succeeds
     * @return label
    **/
    @javax.annotation.Nullable
    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public BatchOrder message(String message) {
        
        this.message = message;
        return this;
    }

     /**
     * Detailed error message, empty string if order succeeds
     * @return message
    **/
    @javax.annotation.Nullable
    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

     /**
     * Order ID
     * @return id
    **/
    @javax.annotation.Nullable
    public String getId() {
        return id;
    }


     /**
     * Order creation time
     * @return createTime
    **/
    @javax.annotation.Nullable
    public String getCreateTime() {
        return createTime;
    }


     /**
     * Order last modification time
     * @return updateTime
    **/
    @javax.annotation.Nullable
    public String getUpdateTime() {
        return updateTime;
    }


     /**
     * Order creation time in milliseconds
     * @return createTimeMs
    **/
    @javax.annotation.Nullable
    public Long getCreateTimeMs() {
        return createTimeMs;
    }


     /**
     * Order last modification time in milliseconds
     * @return updateTimeMs
    **/
    @javax.annotation.Nullable
    public Long getUpdateTimeMs() {
        return updateTimeMs;
    }


     /**
     * Order status  - &#x60;open&#x60;: to be filled - &#x60;closed&#x60;: filled - &#x60;cancelled&#x60;: cancelled
     * @return status
    **/
    @javax.annotation.Nullable
    public StatusEnum getStatus() {
        return status;
    }


    public BatchOrder currencyPair(String currencyPair) {
        
        this.currencyPair = currencyPair;
        return this;
    }

     /**
     * Currency pair
     * @return currencyPair
    **/
    @javax.annotation.Nullable
    public String getCurrencyPair() {
        return currencyPair;
    }


    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public BatchOrder type(TypeEnum type) {
        
        this.type = type;
        return this;
    }

     /**
     * Order type. limit - limit order
     * @return type
    **/
    @javax.annotation.Nullable
    public TypeEnum getType() {
        return type;
    }


    public void setType(TypeEnum type) {
        this.type = type;
    }

    public BatchOrder account(AccountEnum account) {
        
        this.account = account;
        return this;
    }

     /**
     * Account type. spot - use spot account; margin - use margin account; cross_margin - use cross margin account
     * @return account
    **/
    @javax.annotation.Nullable
    public AccountEnum getAccount() {
        return account;
    }


    public void setAccount(AccountEnum account) {
        this.account = account;
    }

    public BatchOrder side(SideEnum side) {
        
        this.side = side;
        return this;
    }

     /**
     * Order side
     * @return side
    **/
    @javax.annotation.Nullable
    public SideEnum getSide() {
        return side;
    }


    public void setSide(SideEnum side) {
        this.side = side;
    }

    public BatchOrder amount(String amount) {
        
        this.amount = amount;
        return this;
    }

     /**
     * Trade amount
     * @return amount
    **/
    @javax.annotation.Nullable
    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public BatchOrder price(String price) {
        
        this.price = price;
        return this;
    }

     /**
     * Order price
     * @return price
    **/
    @javax.annotation.Nullable
    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public BatchOrder timeInForce(TimeInForceEnum timeInForce) {
        
        this.timeInForce = timeInForce;
        return this;
    }

     /**
     * Time in force  - gtc: GoodTillCancelled - ioc: ImmediateOrCancelled, taker only - poc: PendingOrCancelled, makes a post-only order that always enjoys a maker fee
     * @return timeInForce
    **/
    @javax.annotation.Nullable
    public TimeInForceEnum getTimeInForce() {
        return timeInForce;
    }


    public void setTimeInForce(TimeInForceEnum timeInForce) {
        this.timeInForce = timeInForce;
    }

    public BatchOrder iceberg(String iceberg) {
        
        this.iceberg = iceberg;
        return this;
    }

     /**
     * Amount to display for the iceberg order. Null or 0 for normal orders. Set to -1 to hide the amount totally
     * @return iceberg
    **/
    @javax.annotation.Nullable
    public String getIceberg() {
        return iceberg;
    }


    public void setIceberg(String iceberg) {
        this.iceberg = iceberg;
    }

    public BatchOrder autoBorrow(Boolean autoBorrow) {
        
        this.autoBorrow = autoBorrow;
        return this;
    }

     /**
     * Used in margin or cross margin trading to allow automatic loan of insufficient amount if balance is not enough.
     * @return autoBorrow
    **/
    @javax.annotation.Nullable
    public Boolean getAutoBorrow() {
        return autoBorrow;
    }


    public void setAutoBorrow(Boolean autoBorrow) {
        this.autoBorrow = autoBorrow;
    }

    public BatchOrder autoRepay(Boolean autoRepay) {
        
        this.autoRepay = autoRepay;
        return this;
    }

     /**
     * Enable or disable automatic repayment for automatic borrow loan generated by cross margin order. Default is disabled. Note that:  1. This field is only effective for cross margin orders. Margin account does not support setting auto repayment for orders. 2. &#x60;auto_borrow&#x60; and &#x60;auto_repay&#x60; cannot be both set to true in one order.
     * @return autoRepay
    **/
    @javax.annotation.Nullable
    public Boolean getAutoRepay() {
        return autoRepay;
    }


    public void setAutoRepay(Boolean autoRepay) {
        this.autoRepay = autoRepay;
    }

     /**
     * Amount left to fill
     * @return left
    **/
    @javax.annotation.Nullable
    public String getLeft() {
        return left;
    }


     /**
     * Total filled in quote currency. Deprecated in favor of &#x60;filled_total&#x60;
     * @return fillPrice
    **/
    @javax.annotation.Nullable
    public String getFillPrice() {
        return fillPrice;
    }


     /**
     * Total filled in quote currency
     * @return filledTotal
    **/
    @javax.annotation.Nullable
    public String getFilledTotal() {
        return filledTotal;
    }


     /**
     * Fee deducted
     * @return fee
    **/
    @javax.annotation.Nullable
    public String getFee() {
        return fee;
    }


     /**
     * Fee currency unit
     * @return feeCurrency
    **/
    @javax.annotation.Nullable
    public String getFeeCurrency() {
        return feeCurrency;
    }


     /**
     * Point used to deduct fee
     * @return pointFee
    **/
    @javax.annotation.Nullable
    public String getPointFee() {
        return pointFee;
    }


     /**
     * GT used to deduct fee
     * @return gtFee
    **/
    @javax.annotation.Nullable
    public String getGtFee() {
        return gtFee;
    }


     /**
     * Whether GT fee discount is used
     * @return gtDiscount
    **/
    @javax.annotation.Nullable
    public Boolean getGtDiscount() {
        return gtDiscount;
    }


     /**
     * Rebated fee
     * @return rebatedFee
    **/
    @javax.annotation.Nullable
    public String getRebatedFee() {
        return rebatedFee;
    }


     /**
     * Rebated fee currency unit
     * @return rebatedFeeCurrency
    **/
    @javax.annotation.Nullable
    public String getRebatedFeeCurrency() {
        return rebatedFeeCurrency;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BatchOrder batchOrder = (BatchOrder) o;
        return Objects.equals(this.text, batchOrder.text) &&
                Objects.equals(this.succeeded, batchOrder.succeeded) &&
                Objects.equals(this.label, batchOrder.label) &&
                Objects.equals(this.message, batchOrder.message) &&
                Objects.equals(this.id, batchOrder.id) &&
                Objects.equals(this.createTime, batchOrder.createTime) &&
                Objects.equals(this.updateTime, batchOrder.updateTime) &&
                Objects.equals(this.createTimeMs, batchOrder.createTimeMs) &&
                Objects.equals(this.updateTimeMs, batchOrder.updateTimeMs) &&
                Objects.equals(this.status, batchOrder.status) &&
                Objects.equals(this.currencyPair, batchOrder.currencyPair) &&
                Objects.equals(this.type, batchOrder.type) &&
                Objects.equals(this.account, batchOrder.account) &&
                Objects.equals(this.side, batchOrder.side) &&
                Objects.equals(this.amount, batchOrder.amount) &&
                Objects.equals(this.price, batchOrder.price) &&
                Objects.equals(this.timeInForce, batchOrder.timeInForce) &&
                Objects.equals(this.iceberg, batchOrder.iceberg) &&
                Objects.equals(this.autoBorrow, batchOrder.autoBorrow) &&
                Objects.equals(this.autoRepay, batchOrder.autoRepay) &&
                Objects.equals(this.left, batchOrder.left) &&
                Objects.equals(this.fillPrice, batchOrder.fillPrice) &&
                Objects.equals(this.filledTotal, batchOrder.filledTotal) &&
                Objects.equals(this.fee, batchOrder.fee) &&
                Objects.equals(this.feeCurrency, batchOrder.feeCurrency) &&
                Objects.equals(this.pointFee, batchOrder.pointFee) &&
                Objects.equals(this.gtFee, batchOrder.gtFee) &&
                Objects.equals(this.gtDiscount, batchOrder.gtDiscount) &&
                Objects.equals(this.rebatedFee, batchOrder.rebatedFee) &&
                Objects.equals(this.rebatedFeeCurrency, batchOrder.rebatedFeeCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, succeeded, label, message, id, createTime, updateTime, createTimeMs, updateTimeMs, status, currencyPair, type, account, side, amount, price, timeInForce, iceberg, autoBorrow, autoRepay, left, fillPrice, filledTotal, fee, feeCurrency, pointFee, gtFee, gtDiscount, rebatedFee, rebatedFeeCurrency);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BatchOrder {\n");
        sb.append("      text: ").append(toIndentedString(text)).append("\n");
        sb.append("      succeeded: ").append(toIndentedString(succeeded)).append("\n");
        sb.append("      label: ").append(toIndentedString(label)).append("\n");
        sb.append("      message: ").append(toIndentedString(message)).append("\n");
        sb.append("      id: ").append(toIndentedString(id)).append("\n");
        sb.append("      createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("      updateTime: ").append(toIndentedString(updateTime)).append("\n");
        sb.append("      createTimeMs: ").append(toIndentedString(createTimeMs)).append("\n");
        sb.append("      updateTimeMs: ").append(toIndentedString(updateTimeMs)).append("\n");
        sb.append("      status: ").append(toIndentedString(status)).append("\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      type: ").append(toIndentedString(type)).append("\n");
        sb.append("      account: ").append(toIndentedString(account)).append("\n");
        sb.append("      side: ").append(toIndentedString(side)).append("\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
        sb.append("      timeInForce: ").append(toIndentedString(timeInForce)).append("\n");
        sb.append("      iceberg: ").append(toIndentedString(iceberg)).append("\n");
        sb.append("      autoBorrow: ").append(toIndentedString(autoBorrow)).append("\n");
        sb.append("      autoRepay: ").append(toIndentedString(autoRepay)).append("\n");
        sb.append("      left: ").append(toIndentedString(left)).append("\n");
        sb.append("      fillPrice: ").append(toIndentedString(fillPrice)).append("\n");
        sb.append("      filledTotal: ").append(toIndentedString(filledTotal)).append("\n");
        sb.append("      fee: ").append(toIndentedString(fee)).append("\n");
        sb.append("      feeCurrency: ").append(toIndentedString(feeCurrency)).append("\n");
        sb.append("      pointFee: ").append(toIndentedString(pointFee)).append("\n");
        sb.append("      gtFee: ").append(toIndentedString(gtFee)).append("\n");
        sb.append("      gtDiscount: ").append(toIndentedString(gtDiscount)).append("\n");
        sb.append("      rebatedFee: ").append(toIndentedString(rebatedFee)).append("\n");
        sb.append("      rebatedFeeCurrency: ").append(toIndentedString(rebatedFeeCurrency)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n        ");
    }

}

