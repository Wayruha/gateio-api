/*
 * Gate API v4
 * APIv4 provides spot, margin and futures trading operations. There are public APIs to retrieve the real-time market statistics, and private APIs which needs authentication to trade on user's behalf.
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
import java.math.BigDecimal;

/**
 * Futures contract details
 */
public class DeliveryContract {
    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;

    public static final String SERIALIZED_NAME_UNDERLYING = "underlying";
    @SerializedName(SERIALIZED_NAME_UNDERLYING)
    private String underlying;

    /**
     * Cycle type, e.g. WEEKLY, QUARTERLY
     */
    @JsonAdapter(CycleEnum.Adapter.class)
    public enum CycleEnum {
        WEEKLY("WEEKLY"),
        
        BI_WEEKLY("BI-WEEKLY"),
        
        QUARTERLY("QUARTERLY"),
        
        BI_QUARTERLY("BI-QUARTERLY");

        private String value;

        CycleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static CycleEnum fromValue(String value) {
            for (CycleEnum b : CycleEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<CycleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final CycleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public CycleEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return CycleEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_CYCLE = "cycle";
    @SerializedName(SERIALIZED_NAME_CYCLE)
    private CycleEnum cycle;

    /**
     * Futures contract type
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        INVERSE("inverse"),
        
        DIRECT("direct");

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
    private TypeEnum type;

    public static final String SERIALIZED_NAME_QUANTO_MULTIPLIER = "quanto_multiplier";
    @SerializedName(SERIALIZED_NAME_QUANTO_MULTIPLIER)
    private String quantoMultiplier;

    public static final String SERIALIZED_NAME_LEVERAGE_MIN = "leverage_min";
    @SerializedName(SERIALIZED_NAME_LEVERAGE_MIN)
    private String leverageMin;

    public static final String SERIALIZED_NAME_LEVERAGE_MAX = "leverage_max";
    @SerializedName(SERIALIZED_NAME_LEVERAGE_MAX)
    private String leverageMax;

    public static final String SERIALIZED_NAME_MAINTENANCE_RATE = "maintenance_rate";
    @SerializedName(SERIALIZED_NAME_MAINTENANCE_RATE)
    private String maintenanceRate;

    /**
     * Mark price type, internal - based on internal trading, index - based on external index price
     */
    @JsonAdapter(MarkTypeEnum.Adapter.class)
    public enum MarkTypeEnum {
        INTERNAL("internal"),
        
        INDEX("index");

        private String value;

        MarkTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static MarkTypeEnum fromValue(String value) {
            for (MarkTypeEnum b : MarkTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<MarkTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final MarkTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public MarkTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return MarkTypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_MARK_TYPE = "mark_type";
    @SerializedName(SERIALIZED_NAME_MARK_TYPE)
    private MarkTypeEnum markType;

    public static final String SERIALIZED_NAME_MARK_PRICE = "mark_price";
    @SerializedName(SERIALIZED_NAME_MARK_PRICE)
    private String markPrice;

    public static final String SERIALIZED_NAME_INDEX_PRICE = "index_price";
    @SerializedName(SERIALIZED_NAME_INDEX_PRICE)
    private String indexPrice;

    public static final String SERIALIZED_NAME_LAST_PRICE = "last_price";
    @SerializedName(SERIALIZED_NAME_LAST_PRICE)
    private String lastPrice;

    public static final String SERIALIZED_NAME_MAKER_FEE_RATE = "maker_fee_rate";
    @SerializedName(SERIALIZED_NAME_MAKER_FEE_RATE)
    private String makerFeeRate;

    public static final String SERIALIZED_NAME_TAKER_FEE_RATE = "taker_fee_rate";
    @SerializedName(SERIALIZED_NAME_TAKER_FEE_RATE)
    private String takerFeeRate;

    public static final String SERIALIZED_NAME_ORDER_PRICE_ROUND = "order_price_round";
    @SerializedName(SERIALIZED_NAME_ORDER_PRICE_ROUND)
    private String orderPriceRound;

    public static final String SERIALIZED_NAME_MARK_PRICE_ROUND = "mark_price_round";
    @SerializedName(SERIALIZED_NAME_MARK_PRICE_ROUND)
    private String markPriceRound;

    public static final String SERIALIZED_NAME_BASIS_RATE = "basis_rate";
    @SerializedName(SERIALIZED_NAME_BASIS_RATE)
    private String basisRate;

    public static final String SERIALIZED_NAME_BASIS_VALUE = "basis_value";
    @SerializedName(SERIALIZED_NAME_BASIS_VALUE)
    private String basisValue;

    public static final String SERIALIZED_NAME_BASIS_IMPACT_VALUE = "basis_impact_value";
    @SerializedName(SERIALIZED_NAME_BASIS_IMPACT_VALUE)
    private String basisImpactValue;

    public static final String SERIALIZED_NAME_SETTLE_PRICE = "settle_price";
    @SerializedName(SERIALIZED_NAME_SETTLE_PRICE)
    private String settlePrice;

    public static final String SERIALIZED_NAME_SETTLE_PRICE_INTERVAL = "settle_price_interval";
    @SerializedName(SERIALIZED_NAME_SETTLE_PRICE_INTERVAL)
    private Integer settlePriceInterval;

    public static final String SERIALIZED_NAME_SETTLE_PRICE_DURATION = "settle_price_duration";
    @SerializedName(SERIALIZED_NAME_SETTLE_PRICE_DURATION)
    private Integer settlePriceDuration;

    public static final String SERIALIZED_NAME_EXPIRE_TIME = "expire_time";
    @SerializedName(SERIALIZED_NAME_EXPIRE_TIME)
    private Long expireTime;

    public static final String SERIALIZED_NAME_RISK_LIMIT_BASE = "risk_limit_base";
    @SerializedName(SERIALIZED_NAME_RISK_LIMIT_BASE)
    private String riskLimitBase;

    public static final String SERIALIZED_NAME_RISK_LIMIT_STEP = "risk_limit_step";
    @SerializedName(SERIALIZED_NAME_RISK_LIMIT_STEP)
    private String riskLimitStep;

    public static final String SERIALIZED_NAME_RISK_LIMIT_MAX = "risk_limit_max";
    @SerializedName(SERIALIZED_NAME_RISK_LIMIT_MAX)
    private String riskLimitMax;

    public static final String SERIALIZED_NAME_ORDER_SIZE_MIN = "order_size_min";
    @SerializedName(SERIALIZED_NAME_ORDER_SIZE_MIN)
    private Long orderSizeMin;

    public static final String SERIALIZED_NAME_ORDER_SIZE_MAX = "order_size_max";
    @SerializedName(SERIALIZED_NAME_ORDER_SIZE_MAX)
    private Long orderSizeMax;

    public static final String SERIALIZED_NAME_ORDER_PRICE_DEVIATE = "order_price_deviate";
    @SerializedName(SERIALIZED_NAME_ORDER_PRICE_DEVIATE)
    private String orderPriceDeviate;

    public static final String SERIALIZED_NAME_REF_DISCOUNT_RATE = "ref_discount_rate";
    @SerializedName(SERIALIZED_NAME_REF_DISCOUNT_RATE)
    private String refDiscountRate;

    public static final String SERIALIZED_NAME_REF_REBATE_RATE = "ref_rebate_rate";
    @SerializedName(SERIALIZED_NAME_REF_REBATE_RATE)
    private String refRebateRate;

    public static final String SERIALIZED_NAME_ORDERBOOK_ID = "orderbook_id";
    @SerializedName(SERIALIZED_NAME_ORDERBOOK_ID)
    private Long orderbookId;

    public static final String SERIALIZED_NAME_TRADE_ID = "trade_id";
    @SerializedName(SERIALIZED_NAME_TRADE_ID)
    private Long tradeId;

    public static final String SERIALIZED_NAME_TRADE_SIZE = "trade_size";
    @SerializedName(SERIALIZED_NAME_TRADE_SIZE)
    private Long tradeSize;

    public static final String SERIALIZED_NAME_POSITION_SIZE = "position_size";
    @SerializedName(SERIALIZED_NAME_POSITION_SIZE)
    private Long positionSize;

    public static final String SERIALIZED_NAME_CONFIG_CHANGE_TIME = "config_change_time";
    @SerializedName(SERIALIZED_NAME_CONFIG_CHANGE_TIME)
    private BigDecimal configChangeTime;

    public static final String SERIALIZED_NAME_IN_DELISTING = "in_delisting";
    @SerializedName(SERIALIZED_NAME_IN_DELISTING)
    private Boolean inDelisting;

    public static final String SERIALIZED_NAME_ORDERS_LIMIT = "orders_limit";
    @SerializedName(SERIALIZED_NAME_ORDERS_LIMIT)
    private Integer ordersLimit;


    public DeliveryContract name(String name) {
        
        this.name = name;
        return this;
    }

     /**
     * Futures contract
     * @return name
    **/
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public DeliveryContract underlying(String underlying) {
        
        this.underlying = underlying;
        return this;
    }

     /**
     * Underlying
     * @return underlying
    **/
    @javax.annotation.Nullable
    public String getUnderlying() {
        return underlying;
    }


    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public DeliveryContract cycle(CycleEnum cycle) {
        
        this.cycle = cycle;
        return this;
    }

     /**
     * Cycle type, e.g. WEEKLY, QUARTERLY
     * @return cycle
    **/
    @javax.annotation.Nullable
    public CycleEnum getCycle() {
        return cycle;
    }


    public void setCycle(CycleEnum cycle) {
        this.cycle = cycle;
    }

    public DeliveryContract type(TypeEnum type) {
        
        this.type = type;
        return this;
    }

     /**
     * Futures contract type
     * @return type
    **/
    @javax.annotation.Nullable
    public TypeEnum getType() {
        return type;
    }


    public void setType(TypeEnum type) {
        this.type = type;
    }

    public DeliveryContract quantoMultiplier(String quantoMultiplier) {
        
        this.quantoMultiplier = quantoMultiplier;
        return this;
    }

     /**
     * Multiplier used in converting from invoicing to settlement currency in quanto futures
     * @return quantoMultiplier
    **/
    @javax.annotation.Nullable
    public String getQuantoMultiplier() {
        return quantoMultiplier;
    }


    public void setQuantoMultiplier(String quantoMultiplier) {
        this.quantoMultiplier = quantoMultiplier;
    }

    public DeliveryContract leverageMin(String leverageMin) {
        
        this.leverageMin = leverageMin;
        return this;
    }

     /**
     * Minimum leverage
     * @return leverageMin
    **/
    @javax.annotation.Nullable
    public String getLeverageMin() {
        return leverageMin;
    }


    public void setLeverageMin(String leverageMin) {
        this.leverageMin = leverageMin;
    }

    public DeliveryContract leverageMax(String leverageMax) {
        
        this.leverageMax = leverageMax;
        return this;
    }

     /**
     * Maximum leverage
     * @return leverageMax
    **/
    @javax.annotation.Nullable
    public String getLeverageMax() {
        return leverageMax;
    }


    public void setLeverageMax(String leverageMax) {
        this.leverageMax = leverageMax;
    }

    public DeliveryContract maintenanceRate(String maintenanceRate) {
        
        this.maintenanceRate = maintenanceRate;
        return this;
    }

     /**
     * Maintenance rate of margin
     * @return maintenanceRate
    **/
    @javax.annotation.Nullable
    public String getMaintenanceRate() {
        return maintenanceRate;
    }


    public void setMaintenanceRate(String maintenanceRate) {
        this.maintenanceRate = maintenanceRate;
    }

    public DeliveryContract markType(MarkTypeEnum markType) {
        
        this.markType = markType;
        return this;
    }

     /**
     * Mark price type, internal - based on internal trading, index - based on external index price
     * @return markType
    **/
    @javax.annotation.Nullable
    public MarkTypeEnum getMarkType() {
        return markType;
    }


    public void setMarkType(MarkTypeEnum markType) {
        this.markType = markType;
    }

    public DeliveryContract markPrice(String markPrice) {
        
        this.markPrice = markPrice;
        return this;
    }

     /**
     * Current mark price
     * @return markPrice
    **/
    @javax.annotation.Nullable
    public String getMarkPrice() {
        return markPrice;
    }


    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public DeliveryContract indexPrice(String indexPrice) {
        
        this.indexPrice = indexPrice;
        return this;
    }

     /**
     * Current index price
     * @return indexPrice
    **/
    @javax.annotation.Nullable
    public String getIndexPrice() {
        return indexPrice;
    }


    public void setIndexPrice(String indexPrice) {
        this.indexPrice = indexPrice;
    }

    public DeliveryContract lastPrice(String lastPrice) {
        
        this.lastPrice = lastPrice;
        return this;
    }

     /**
     * Last trading price
     * @return lastPrice
    **/
    @javax.annotation.Nullable
    public String getLastPrice() {
        return lastPrice;
    }


    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public DeliveryContract makerFeeRate(String makerFeeRate) {
        
        this.makerFeeRate = makerFeeRate;
        return this;
    }

     /**
     * Maker fee rate, where negative means rebate
     * @return makerFeeRate
    **/
    @javax.annotation.Nullable
    public String getMakerFeeRate() {
        return makerFeeRate;
    }


    public void setMakerFeeRate(String makerFeeRate) {
        this.makerFeeRate = makerFeeRate;
    }

    public DeliveryContract takerFeeRate(String takerFeeRate) {
        
        this.takerFeeRate = takerFeeRate;
        return this;
    }

     /**
     * Taker fee rate
     * @return takerFeeRate
    **/
    @javax.annotation.Nullable
    public String getTakerFeeRate() {
        return takerFeeRate;
    }


    public void setTakerFeeRate(String takerFeeRate) {
        this.takerFeeRate = takerFeeRate;
    }

    public DeliveryContract orderPriceRound(String orderPriceRound) {
        
        this.orderPriceRound = orderPriceRound;
        return this;
    }

     /**
     * Minimum order price increment
     * @return orderPriceRound
    **/
    @javax.annotation.Nullable
    public String getOrderPriceRound() {
        return orderPriceRound;
    }


    public void setOrderPriceRound(String orderPriceRound) {
        this.orderPriceRound = orderPriceRound;
    }

    public DeliveryContract markPriceRound(String markPriceRound) {
        
        this.markPriceRound = markPriceRound;
        return this;
    }

     /**
     * Minimum mark price increment
     * @return markPriceRound
    **/
    @javax.annotation.Nullable
    public String getMarkPriceRound() {
        return markPriceRound;
    }


    public void setMarkPriceRound(String markPriceRound) {
        this.markPriceRound = markPriceRound;
    }

    public DeliveryContract basisRate(String basisRate) {
        
        this.basisRate = basisRate;
        return this;
    }

     /**
     * Fair basis rate
     * @return basisRate
    **/
    @javax.annotation.Nullable
    public String getBasisRate() {
        return basisRate;
    }


    public void setBasisRate(String basisRate) {
        this.basisRate = basisRate;
    }

    public DeliveryContract basisValue(String basisValue) {
        
        this.basisValue = basisValue;
        return this;
    }

     /**
     * Fair basis value
     * @return basisValue
    **/
    @javax.annotation.Nullable
    public String getBasisValue() {
        return basisValue;
    }


    public void setBasisValue(String basisValue) {
        this.basisValue = basisValue;
    }

    public DeliveryContract basisImpactValue(String basisImpactValue) {
        
        this.basisImpactValue = basisImpactValue;
        return this;
    }

     /**
     * Funding used for calculating impact bid, ask price
     * @return basisImpactValue
    **/
    @javax.annotation.Nullable
    public String getBasisImpactValue() {
        return basisImpactValue;
    }


    public void setBasisImpactValue(String basisImpactValue) {
        this.basisImpactValue = basisImpactValue;
    }

    public DeliveryContract settlePrice(String settlePrice) {
        
        this.settlePrice = settlePrice;
        return this;
    }

     /**
     * Settle price
     * @return settlePrice
    **/
    @javax.annotation.Nullable
    public String getSettlePrice() {
        return settlePrice;
    }


    public void setSettlePrice(String settlePrice) {
        this.settlePrice = settlePrice;
    }

    public DeliveryContract settlePriceInterval(Integer settlePriceInterval) {
        
        this.settlePriceInterval = settlePriceInterval;
        return this;
    }

     /**
     * Settle price update interval
     * @return settlePriceInterval
    **/
    @javax.annotation.Nullable
    public Integer getSettlePriceInterval() {
        return settlePriceInterval;
    }


    public void setSettlePriceInterval(Integer settlePriceInterval) {
        this.settlePriceInterval = settlePriceInterval;
    }

    public DeliveryContract settlePriceDuration(Integer settlePriceDuration) {
        
        this.settlePriceDuration = settlePriceDuration;
        return this;
    }

     /**
     * Settle price update duration in seconds
     * @return settlePriceDuration
    **/
    @javax.annotation.Nullable
    public Integer getSettlePriceDuration() {
        return settlePriceDuration;
    }


    public void setSettlePriceDuration(Integer settlePriceDuration) {
        this.settlePriceDuration = settlePriceDuration;
    }

    public DeliveryContract expireTime(Long expireTime) {
        
        this.expireTime = expireTime;
        return this;
    }

     /**
     * Contract expiry timestamp
     * @return expireTime
    **/
    @javax.annotation.Nullable
    public Long getExpireTime() {
        return expireTime;
    }


    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public DeliveryContract riskLimitBase(String riskLimitBase) {
        
        this.riskLimitBase = riskLimitBase;
        return this;
    }

     /**
     * Risk limit base
     * @return riskLimitBase
    **/
    @javax.annotation.Nullable
    public String getRiskLimitBase() {
        return riskLimitBase;
    }


    public void setRiskLimitBase(String riskLimitBase) {
        this.riskLimitBase = riskLimitBase;
    }

    public DeliveryContract riskLimitStep(String riskLimitStep) {
        
        this.riskLimitStep = riskLimitStep;
        return this;
    }

     /**
     * Step of adjusting risk limit
     * @return riskLimitStep
    **/
    @javax.annotation.Nullable
    public String getRiskLimitStep() {
        return riskLimitStep;
    }


    public void setRiskLimitStep(String riskLimitStep) {
        this.riskLimitStep = riskLimitStep;
    }

    public DeliveryContract riskLimitMax(String riskLimitMax) {
        
        this.riskLimitMax = riskLimitMax;
        return this;
    }

     /**
     * Maximum risk limit the contract allowed
     * @return riskLimitMax
    **/
    @javax.annotation.Nullable
    public String getRiskLimitMax() {
        return riskLimitMax;
    }


    public void setRiskLimitMax(String riskLimitMax) {
        this.riskLimitMax = riskLimitMax;
    }

    public DeliveryContract orderSizeMin(Long orderSizeMin) {
        
        this.orderSizeMin = orderSizeMin;
        return this;
    }

     /**
     * Minimum order size the contract allowed
     * @return orderSizeMin
    **/
    @javax.annotation.Nullable
    public Long getOrderSizeMin() {
        return orderSizeMin;
    }


    public void setOrderSizeMin(Long orderSizeMin) {
        this.orderSizeMin = orderSizeMin;
    }

    public DeliveryContract orderSizeMax(Long orderSizeMax) {
        
        this.orderSizeMax = orderSizeMax;
        return this;
    }

     /**
     * Maximum order size the contract allowed
     * @return orderSizeMax
    **/
    @javax.annotation.Nullable
    public Long getOrderSizeMax() {
        return orderSizeMax;
    }


    public void setOrderSizeMax(Long orderSizeMax) {
        this.orderSizeMax = orderSizeMax;
    }

    public DeliveryContract orderPriceDeviate(String orderPriceDeviate) {
        
        this.orderPriceDeviate = orderPriceDeviate;
        return this;
    }

     /**
     * deviation between order price and current index price. If price of an order is denoted as order_price, it must meet the following condition:      abs(order_price - mark_price) &lt;&#x3D; mark_price * order_price_deviate
     * @return orderPriceDeviate
    **/
    @javax.annotation.Nullable
    public String getOrderPriceDeviate() {
        return orderPriceDeviate;
    }


    public void setOrderPriceDeviate(String orderPriceDeviate) {
        this.orderPriceDeviate = orderPriceDeviate;
    }

    public DeliveryContract refDiscountRate(String refDiscountRate) {
        
        this.refDiscountRate = refDiscountRate;
        return this;
    }

     /**
     * Referral fee rate discount
     * @return refDiscountRate
    **/
    @javax.annotation.Nullable
    public String getRefDiscountRate() {
        return refDiscountRate;
    }


    public void setRefDiscountRate(String refDiscountRate) {
        this.refDiscountRate = refDiscountRate;
    }

    public DeliveryContract refRebateRate(String refRebateRate) {
        
        this.refRebateRate = refRebateRate;
        return this;
    }

     /**
     * Referrer commission rate
     * @return refRebateRate
    **/
    @javax.annotation.Nullable
    public String getRefRebateRate() {
        return refRebateRate;
    }


    public void setRefRebateRate(String refRebateRate) {
        this.refRebateRate = refRebateRate;
    }

    public DeliveryContract orderbookId(Long orderbookId) {
        
        this.orderbookId = orderbookId;
        return this;
    }

     /**
     * Current orderbook ID
     * @return orderbookId
    **/
    @javax.annotation.Nullable
    public Long getOrderbookId() {
        return orderbookId;
    }


    public void setOrderbookId(Long orderbookId) {
        this.orderbookId = orderbookId;
    }

    public DeliveryContract tradeId(Long tradeId) {
        
        this.tradeId = tradeId;
        return this;
    }

     /**
     * Current trade ID
     * @return tradeId
    **/
    @javax.annotation.Nullable
    public Long getTradeId() {
        return tradeId;
    }


    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public DeliveryContract tradeSize(Long tradeSize) {
        
        this.tradeSize = tradeSize;
        return this;
    }

     /**
     * Historical accumulation trade size
     * @return tradeSize
    **/
    @javax.annotation.Nullable
    public Long getTradeSize() {
        return tradeSize;
    }


    public void setTradeSize(Long tradeSize) {
        this.tradeSize = tradeSize;
    }

    public DeliveryContract positionSize(Long positionSize) {
        
        this.positionSize = positionSize;
        return this;
    }

     /**
     * Current total long position size
     * @return positionSize
    **/
    @javax.annotation.Nullable
    public Long getPositionSize() {
        return positionSize;
    }


    public void setPositionSize(Long positionSize) {
        this.positionSize = positionSize;
    }

    public DeliveryContract configChangeTime(BigDecimal configChangeTime) {
        
        this.configChangeTime = configChangeTime;
        return this;
    }

     /**
     * Configuration&#39;s last changed time
     * @return configChangeTime
    **/
    @javax.annotation.Nullable
    public BigDecimal getConfigChangeTime() {
        return configChangeTime;
    }


    public void setConfigChangeTime(BigDecimal configChangeTime) {
        this.configChangeTime = configChangeTime;
    }

    public DeliveryContract inDelisting(Boolean inDelisting) {
        
        this.inDelisting = inDelisting;
        return this;
    }

     /**
     * Contract is delisting
     * @return inDelisting
    **/
    @javax.annotation.Nullable
    public Boolean getInDelisting() {
        return inDelisting;
    }


    public void setInDelisting(Boolean inDelisting) {
        this.inDelisting = inDelisting;
    }

    public DeliveryContract ordersLimit(Integer ordersLimit) {
        
        this.ordersLimit = ordersLimit;
        return this;
    }

     /**
     * Maximum number of open orders
     * @return ordersLimit
    **/
    @javax.annotation.Nullable
    public Integer getOrdersLimit() {
        return ordersLimit;
    }


    public void setOrdersLimit(Integer ordersLimit) {
        this.ordersLimit = ordersLimit;
    }
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeliveryContract deliveryContract = (DeliveryContract) o;
        return Objects.equals(this.name, deliveryContract.name) &&
                Objects.equals(this.underlying, deliveryContract.underlying) &&
                Objects.equals(this.cycle, deliveryContract.cycle) &&
                Objects.equals(this.type, deliveryContract.type) &&
                Objects.equals(this.quantoMultiplier, deliveryContract.quantoMultiplier) &&
                Objects.equals(this.leverageMin, deliveryContract.leverageMin) &&
                Objects.equals(this.leverageMax, deliveryContract.leverageMax) &&
                Objects.equals(this.maintenanceRate, deliveryContract.maintenanceRate) &&
                Objects.equals(this.markType, deliveryContract.markType) &&
                Objects.equals(this.markPrice, deliveryContract.markPrice) &&
                Objects.equals(this.indexPrice, deliveryContract.indexPrice) &&
                Objects.equals(this.lastPrice, deliveryContract.lastPrice) &&
                Objects.equals(this.makerFeeRate, deliveryContract.makerFeeRate) &&
                Objects.equals(this.takerFeeRate, deliveryContract.takerFeeRate) &&
                Objects.equals(this.orderPriceRound, deliveryContract.orderPriceRound) &&
                Objects.equals(this.markPriceRound, deliveryContract.markPriceRound) &&
                Objects.equals(this.basisRate, deliveryContract.basisRate) &&
                Objects.equals(this.basisValue, deliveryContract.basisValue) &&
                Objects.equals(this.basisImpactValue, deliveryContract.basisImpactValue) &&
                Objects.equals(this.settlePrice, deliveryContract.settlePrice) &&
                Objects.equals(this.settlePriceInterval, deliveryContract.settlePriceInterval) &&
                Objects.equals(this.settlePriceDuration, deliveryContract.settlePriceDuration) &&
                Objects.equals(this.expireTime, deliveryContract.expireTime) &&
                Objects.equals(this.riskLimitBase, deliveryContract.riskLimitBase) &&
                Objects.equals(this.riskLimitStep, deliveryContract.riskLimitStep) &&
                Objects.equals(this.riskLimitMax, deliveryContract.riskLimitMax) &&
                Objects.equals(this.orderSizeMin, deliveryContract.orderSizeMin) &&
                Objects.equals(this.orderSizeMax, deliveryContract.orderSizeMax) &&
                Objects.equals(this.orderPriceDeviate, deliveryContract.orderPriceDeviate) &&
                Objects.equals(this.refDiscountRate, deliveryContract.refDiscountRate) &&
                Objects.equals(this.refRebateRate, deliveryContract.refRebateRate) &&
                Objects.equals(this.orderbookId, deliveryContract.orderbookId) &&
                Objects.equals(this.tradeId, deliveryContract.tradeId) &&
                Objects.equals(this.tradeSize, deliveryContract.tradeSize) &&
                Objects.equals(this.positionSize, deliveryContract.positionSize) &&
                Objects.equals(this.configChangeTime, deliveryContract.configChangeTime) &&
                Objects.equals(this.inDelisting, deliveryContract.inDelisting) &&
                Objects.equals(this.ordersLimit, deliveryContract.ordersLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, underlying, cycle, type, quantoMultiplier, leverageMin, leverageMax, maintenanceRate, markType, markPrice, indexPrice, lastPrice, makerFeeRate, takerFeeRate, orderPriceRound, markPriceRound, basisRate, basisValue, basisImpactValue, settlePrice, settlePriceInterval, settlePriceDuration, expireTime, riskLimitBase, riskLimitStep, riskLimitMax, orderSizeMin, orderSizeMax, orderPriceDeviate, refDiscountRate, refRebateRate, orderbookId, tradeId, tradeSize, positionSize, configChangeTime, inDelisting, ordersLimit);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeliveryContract {\n");
        sb.append("      name: ").append(toIndentedString(name)).append("\n");
        sb.append("      underlying: ").append(toIndentedString(underlying)).append("\n");
        sb.append("      cycle: ").append(toIndentedString(cycle)).append("\n");
        sb.append("      type: ").append(toIndentedString(type)).append("\n");
        sb.append("      quantoMultiplier: ").append(toIndentedString(quantoMultiplier)).append("\n");
        sb.append("      leverageMin: ").append(toIndentedString(leverageMin)).append("\n");
        sb.append("      leverageMax: ").append(toIndentedString(leverageMax)).append("\n");
        sb.append("      maintenanceRate: ").append(toIndentedString(maintenanceRate)).append("\n");
        sb.append("      markType: ").append(toIndentedString(markType)).append("\n");
        sb.append("      markPrice: ").append(toIndentedString(markPrice)).append("\n");
        sb.append("      indexPrice: ").append(toIndentedString(indexPrice)).append("\n");
        sb.append("      lastPrice: ").append(toIndentedString(lastPrice)).append("\n");
        sb.append("      makerFeeRate: ").append(toIndentedString(makerFeeRate)).append("\n");
        sb.append("      takerFeeRate: ").append(toIndentedString(takerFeeRate)).append("\n");
        sb.append("      orderPriceRound: ").append(toIndentedString(orderPriceRound)).append("\n");
        sb.append("      markPriceRound: ").append(toIndentedString(markPriceRound)).append("\n");
        sb.append("      basisRate: ").append(toIndentedString(basisRate)).append("\n");
        sb.append("      basisValue: ").append(toIndentedString(basisValue)).append("\n");
        sb.append("      basisImpactValue: ").append(toIndentedString(basisImpactValue)).append("\n");
        sb.append("      settlePrice: ").append(toIndentedString(settlePrice)).append("\n");
        sb.append("      settlePriceInterval: ").append(toIndentedString(settlePriceInterval)).append("\n");
        sb.append("      settlePriceDuration: ").append(toIndentedString(settlePriceDuration)).append("\n");
        sb.append("      expireTime: ").append(toIndentedString(expireTime)).append("\n");
        sb.append("      riskLimitBase: ").append(toIndentedString(riskLimitBase)).append("\n");
        sb.append("      riskLimitStep: ").append(toIndentedString(riskLimitStep)).append("\n");
        sb.append("      riskLimitMax: ").append(toIndentedString(riskLimitMax)).append("\n");
        sb.append("      orderSizeMin: ").append(toIndentedString(orderSizeMin)).append("\n");
        sb.append("      orderSizeMax: ").append(toIndentedString(orderSizeMax)).append("\n");
        sb.append("      orderPriceDeviate: ").append(toIndentedString(orderPriceDeviate)).append("\n");
        sb.append("      refDiscountRate: ").append(toIndentedString(refDiscountRate)).append("\n");
        sb.append("      refRebateRate: ").append(toIndentedString(refRebateRate)).append("\n");
        sb.append("      orderbookId: ").append(toIndentedString(orderbookId)).append("\n");
        sb.append("      tradeId: ").append(toIndentedString(tradeId)).append("\n");
        sb.append("      tradeSize: ").append(toIndentedString(tradeSize)).append("\n");
        sb.append("      positionSize: ").append(toIndentedString(positionSize)).append("\n");
        sb.append("      configChangeTime: ").append(toIndentedString(configChangeTime)).append("\n");
        sb.append("      inDelisting: ").append(toIndentedString(inDelisting)).append("\n");
        sb.append("      ordersLimit: ").append(toIndentedString(ordersLimit)).append("\n");
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

