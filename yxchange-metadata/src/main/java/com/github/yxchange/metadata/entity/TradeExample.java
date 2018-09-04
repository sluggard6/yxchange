package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNull() {
            addCriterion("match_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNotNull() {
            addCriterion("match_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchIdEqualTo(String value) {
            addCriterion("match_id =", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotEqualTo(String value) {
            addCriterion("match_id <>", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThan(String value) {
            addCriterion("match_id >", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("match_id >=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThan(String value) {
            addCriterion("match_id <", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThanOrEqualTo(String value) {
            addCriterion("match_id <=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLike(String value) {
            addCriterion("match_id like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotLike(String value) {
            addCriterion("match_id not like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdIn(List<String> values) {
            addCriterion("match_id in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotIn(List<String> values) {
            addCriterion("match_id not in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdBetween(String value1, String value2) {
            addCriterion("match_id between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotBetween(String value1, String value2) {
            addCriterion("match_id not between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdIsNull() {
            addCriterion("ask_order_id is null");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdIsNotNull() {
            addCriterion("ask_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdEqualTo(Integer value) {
            addCriterion("ask_order_id =", value, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdNotEqualTo(Integer value) {
            addCriterion("ask_order_id <>", value, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdGreaterThan(Integer value) {
            addCriterion("ask_order_id >", value, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ask_order_id >=", value, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdLessThan(Integer value) {
            addCriterion("ask_order_id <", value, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("ask_order_id <=", value, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdIn(List<Integer> values) {
            addCriterion("ask_order_id in", values, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdNotIn(List<Integer> values) {
            addCriterion("ask_order_id not in", values, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("ask_order_id between", value1, value2, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andAskOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ask_order_id not between", value1, value2, "askOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdIsNull() {
            addCriterion("bid_order_id is null");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdIsNotNull() {
            addCriterion("bid_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdEqualTo(Integer value) {
            addCriterion("bid_order_id =", value, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdNotEqualTo(Integer value) {
            addCriterion("bid_order_id <>", value, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdGreaterThan(Integer value) {
            addCriterion("bid_order_id >", value, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_order_id >=", value, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdLessThan(Integer value) {
            addCriterion("bid_order_id <", value, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("bid_order_id <=", value, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdIn(List<Integer> values) {
            addCriterion("bid_order_id in", values, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdNotIn(List<Integer> values) {
            addCriterion("bid_order_id not in", values, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("bid_order_id between", value1, value2, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andBidOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_order_id not between", value1, value2, "bidOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdIsNull() {
            addCriterion("taker_order_id is null");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdIsNotNull() {
            addCriterion("taker_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdEqualTo(Integer value) {
            addCriterion("taker_order_id =", value, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdNotEqualTo(Integer value) {
            addCriterion("taker_order_id <>", value, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdGreaterThan(Integer value) {
            addCriterion("taker_order_id >", value, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("taker_order_id >=", value, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdLessThan(Integer value) {
            addCriterion("taker_order_id <", value, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("taker_order_id <=", value, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdIn(List<Integer> values) {
            addCriterion("taker_order_id in", values, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdNotIn(List<Integer> values) {
            addCriterion("taker_order_id not in", values, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("taker_order_id between", value1, value2, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andTakerOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("taker_order_id not between", value1, value2, "takerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdIsNull() {
            addCriterion("maker_order_id is null");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdIsNotNull() {
            addCriterion("maker_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdEqualTo(Integer value) {
            addCriterion("maker_order_id =", value, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdNotEqualTo(Integer value) {
            addCriterion("maker_order_id <>", value, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdGreaterThan(Integer value) {
            addCriterion("maker_order_id >", value, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("maker_order_id >=", value, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdLessThan(Integer value) {
            addCriterion("maker_order_id <", value, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("maker_order_id <=", value, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdIn(List<Integer> values) {
            addCriterion("maker_order_id in", values, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdNotIn(List<Integer> values) {
            addCriterion("maker_order_id not in", values, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("maker_order_id between", value1, value2, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andMakerOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("maker_order_id not between", value1, value2, "makerOrderId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andLotsIsNull() {
            addCriterion("lots is null");
            return (Criteria) this;
        }

        public Criteria andLotsIsNotNull() {
            addCriterion("lots is not null");
            return (Criteria) this;
        }

        public Criteria andLotsEqualTo(BigDecimal value) {
            addCriterion("lots =", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsNotEqualTo(BigDecimal value) {
            addCriterion("lots <>", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsGreaterThan(BigDecimal value) {
            addCriterion("lots >", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lots >=", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsLessThan(BigDecimal value) {
            addCriterion("lots <", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lots <=", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsIn(List<BigDecimal> values) {
            addCriterion("lots in", values, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsNotIn(List<BigDecimal> values) {
            addCriterion("lots not in", values, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lots between", value1, value2, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lots not between", value1, value2, "lots");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifytime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}