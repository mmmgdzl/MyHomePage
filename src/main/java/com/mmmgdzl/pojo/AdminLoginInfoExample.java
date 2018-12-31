package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminLoginInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminLoginInfoExample() {
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

        public Criteria andAlidIsNull() {
            addCriterion("alId is null");
            return (Criteria) this;
        }

        public Criteria andAlidIsNotNull() {
            addCriterion("alId is not null");
            return (Criteria) this;
        }

        public Criteria andAlidEqualTo(Integer value) {
            addCriterion("alId =", value, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidNotEqualTo(Integer value) {
            addCriterion("alId <>", value, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidGreaterThan(Integer value) {
            addCriterion("alId >", value, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidGreaterThanOrEqualTo(Integer value) {
            addCriterion("alId >=", value, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidLessThan(Integer value) {
            addCriterion("alId <", value, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidLessThanOrEqualTo(Integer value) {
            addCriterion("alId <=", value, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidIn(List<Integer> values) {
            addCriterion("alId in", values, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidNotIn(List<Integer> values) {
            addCriterion("alId not in", values, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidBetween(Integer value1, Integer value2) {
            addCriterion("alId between", value1, value2, "alid");
            return (Criteria) this;
        }

        public Criteria andAlidNotBetween(Integer value1, Integer value2) {
            addCriterion("alId not between", value1, value2, "alid");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aId is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aId is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aId =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aId <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aId >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aId >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aId <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aId <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aId in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aId not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aId between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aId not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAlipIsNull() {
            addCriterion("alIP is null");
            return (Criteria) this;
        }

        public Criteria andAlipIsNotNull() {
            addCriterion("alIP is not null");
            return (Criteria) this;
        }

        public Criteria andAlipEqualTo(String value) {
            addCriterion("alIP =", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipNotEqualTo(String value) {
            addCriterion("alIP <>", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipGreaterThan(String value) {
            addCriterion("alIP >", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipGreaterThanOrEqualTo(String value) {
            addCriterion("alIP >=", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipLessThan(String value) {
            addCriterion("alIP <", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipLessThanOrEqualTo(String value) {
            addCriterion("alIP <=", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipLike(String value) {
            addCriterion("alIP like", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipNotLike(String value) {
            addCriterion("alIP not like", value, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipIn(List<String> values) {
            addCriterion("alIP in", values, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipNotIn(List<String> values) {
            addCriterion("alIP not in", values, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipBetween(String value1, String value2) {
            addCriterion("alIP between", value1, value2, "alip");
            return (Criteria) this;
        }

        public Criteria andAlipNotBetween(String value1, String value2) {
            addCriterion("alIP not between", value1, value2, "alip");
            return (Criteria) this;
        }

        public Criteria andAladdressIsNull() {
            addCriterion("alAddress is null");
            return (Criteria) this;
        }

        public Criteria andAladdressIsNotNull() {
            addCriterion("alAddress is not null");
            return (Criteria) this;
        }

        public Criteria andAladdressEqualTo(String value) {
            addCriterion("alAddress =", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressNotEqualTo(String value) {
            addCriterion("alAddress <>", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressGreaterThan(String value) {
            addCriterion("alAddress >", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressGreaterThanOrEqualTo(String value) {
            addCriterion("alAddress >=", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressLessThan(String value) {
            addCriterion("alAddress <", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressLessThanOrEqualTo(String value) {
            addCriterion("alAddress <=", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressLike(String value) {
            addCriterion("alAddress like", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressNotLike(String value) {
            addCriterion("alAddress not like", value, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressIn(List<String> values) {
            addCriterion("alAddress in", values, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressNotIn(List<String> values) {
            addCriterion("alAddress not in", values, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressBetween(String value1, String value2) {
            addCriterion("alAddress between", value1, value2, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAladdressNotBetween(String value1, String value2) {
            addCriterion("alAddress not between", value1, value2, "aladdress");
            return (Criteria) this;
        }

        public Criteria andAldateIsNull() {
            addCriterion("alDate is null");
            return (Criteria) this;
        }

        public Criteria andAldateIsNotNull() {
            addCriterion("alDate is not null");
            return (Criteria) this;
        }

        public Criteria andAldateEqualTo(Date value) {
            addCriterion("alDate =", value, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateNotEqualTo(Date value) {
            addCriterion("alDate <>", value, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateGreaterThan(Date value) {
            addCriterion("alDate >", value, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateGreaterThanOrEqualTo(Date value) {
            addCriterion("alDate >=", value, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateLessThan(Date value) {
            addCriterion("alDate <", value, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateLessThanOrEqualTo(Date value) {
            addCriterion("alDate <=", value, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateIn(List<Date> values) {
            addCriterion("alDate in", values, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateNotIn(List<Date> values) {
            addCriterion("alDate not in", values, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateBetween(Date value1, Date value2) {
            addCriterion("alDate between", value1, value2, "aldate");
            return (Criteria) this;
        }

        public Criteria andAldateNotBetween(Date value1, Date value2) {
            addCriterion("alDate not between", value1, value2, "aldate");
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