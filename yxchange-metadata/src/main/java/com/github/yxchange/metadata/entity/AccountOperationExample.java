package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountOperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountOperationExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("operation is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("operation is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(Integer value) {
            addCriterion("operation =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(Integer value) {
            addCriterion("operation <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(Integer value) {
            addCriterion("operation >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(Integer value) {
            addCriterion("operation <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(Integer value) {
            addCriterion("operation <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<Integer> values) {
            addCriterion("operation in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<Integer> values) {
            addCriterion("operation not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(Integer value1, Integer value2) {
            addCriterion("operation between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(Integer value1, Integer value2) {
            addCriterion("operation not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdIsNull() {
            addCriterion("freeze_order_id is null");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdIsNotNull() {
            addCriterion("freeze_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdEqualTo(String value) {
            addCriterion("freeze_order_id =", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdNotEqualTo(String value) {
            addCriterion("freeze_order_id <>", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdGreaterThan(String value) {
            addCriterion("freeze_order_id >", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("freeze_order_id >=", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdLessThan(String value) {
            addCriterion("freeze_order_id <", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdLessThanOrEqualTo(String value) {
            addCriterion("freeze_order_id <=", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdLike(String value) {
            addCriterion("freeze_order_id like", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdNotLike(String value) {
            addCriterion("freeze_order_id not like", value, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdIn(List<String> values) {
            addCriterion("freeze_order_id in", values, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdNotIn(List<String> values) {
            addCriterion("freeze_order_id not in", values, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdBetween(String value1, String value2) {
            addCriterion("freeze_order_id between", value1, value2, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andFreezeOrderIdNotBetween(String value1, String value2) {
            addCriterion("freeze_order_id not between", value1, value2, "freezeOrderId");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeIsNull() {
            addCriterion("available_before is null");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeIsNotNull() {
            addCriterion("available_before is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeEqualTo(BigDecimal value) {
            addCriterion("available_before =", value, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeNotEqualTo(BigDecimal value) {
            addCriterion("available_before <>", value, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeGreaterThan(BigDecimal value) {
            addCriterion("available_before >", value, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("available_before >=", value, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeLessThan(BigDecimal value) {
            addCriterion("available_before <", value, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("available_before <=", value, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeIn(List<BigDecimal> values) {
            addCriterion("available_before in", values, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeNotIn(List<BigDecimal> values) {
            addCriterion("available_before not in", values, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_before between", value1, value2, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_before not between", value1, value2, "availableBefore");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterIsNull() {
            addCriterion("available_after is null");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterIsNotNull() {
            addCriterion("available_after is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterEqualTo(BigDecimal value) {
            addCriterion("available_after =", value, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterNotEqualTo(BigDecimal value) {
            addCriterion("available_after <>", value, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterGreaterThan(BigDecimal value) {
            addCriterion("available_after >", value, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("available_after >=", value, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterLessThan(BigDecimal value) {
            addCriterion("available_after <", value, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("available_after <=", value, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterIn(List<BigDecimal> values) {
            addCriterion("available_after in", values, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterNotIn(List<BigDecimal> values) {
            addCriterion("available_after not in", values, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_after between", value1, value2, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andAvailableAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_after not between", value1, value2, "availableAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeIsNull() {
            addCriterion("freezed_before is null");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeIsNotNull() {
            addCriterion("freezed_before is not null");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeEqualTo(BigDecimal value) {
            addCriterion("freezed_before =", value, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeNotEqualTo(BigDecimal value) {
            addCriterion("freezed_before <>", value, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeGreaterThan(BigDecimal value) {
            addCriterion("freezed_before >", value, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freezed_before >=", value, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeLessThan(BigDecimal value) {
            addCriterion("freezed_before <", value, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freezed_before <=", value, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeIn(List<BigDecimal> values) {
            addCriterion("freezed_before in", values, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeNotIn(List<BigDecimal> values) {
            addCriterion("freezed_before not in", values, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freezed_before between", value1, value2, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freezed_before not between", value1, value2, "freezedBefore");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterIsNull() {
            addCriterion("freezed_after is null");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterIsNotNull() {
            addCriterion("freezed_after is not null");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterEqualTo(BigDecimal value) {
            addCriterion("freezed_after =", value, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterNotEqualTo(BigDecimal value) {
            addCriterion("freezed_after <>", value, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterGreaterThan(BigDecimal value) {
            addCriterion("freezed_after >", value, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freezed_after >=", value, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterLessThan(BigDecimal value) {
            addCriterion("freezed_after <", value, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freezed_after <=", value, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterIn(List<BigDecimal> values) {
            addCriterion("freezed_after in", values, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterNotIn(List<BigDecimal> values) {
            addCriterion("freezed_after not in", values, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freezed_after between", value1, value2, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andFreezedAfterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freezed_after not between", value1, value2, "freezedAfter");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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