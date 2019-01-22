package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemResourceColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemResourceColumnExample() {
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

        public Criteria andSrcidIsNull() {
            addCriterion("srcId is null");
            return (Criteria) this;
        }

        public Criteria andSrcidIsNotNull() {
            addCriterion("srcId is not null");
            return (Criteria) this;
        }

        public Criteria andSrcidEqualTo(Integer value) {
            addCriterion("srcId =", value, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidNotEqualTo(Integer value) {
            addCriterion("srcId <>", value, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidGreaterThan(Integer value) {
            addCriterion("srcId >", value, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("srcId >=", value, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidLessThan(Integer value) {
            addCriterion("srcId <", value, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidLessThanOrEqualTo(Integer value) {
            addCriterion("srcId <=", value, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidIn(List<Integer> values) {
            addCriterion("srcId in", values, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidNotIn(List<Integer> values) {
            addCriterion("srcId not in", values, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidBetween(Integer value1, Integer value2) {
            addCriterion("srcId between", value1, value2, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcidNotBetween(Integer value1, Integer value2) {
            addCriterion("srcId not between", value1, value2, "srcid");
            return (Criteria) this;
        }

        public Criteria andSrcnameIsNull() {
            addCriterion("srcName is null");
            return (Criteria) this;
        }

        public Criteria andSrcnameIsNotNull() {
            addCriterion("srcName is not null");
            return (Criteria) this;
        }

        public Criteria andSrcnameEqualTo(String value) {
            addCriterion("srcName =", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameNotEqualTo(String value) {
            addCriterion("srcName <>", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameGreaterThan(String value) {
            addCriterion("srcName >", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameGreaterThanOrEqualTo(String value) {
            addCriterion("srcName >=", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameLessThan(String value) {
            addCriterion("srcName <", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameLessThanOrEqualTo(String value) {
            addCriterion("srcName <=", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameLike(String value) {
            addCriterion("srcName like", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameNotLike(String value) {
            addCriterion("srcName not like", value, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameIn(List<String> values) {
            addCriterion("srcName in", values, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameNotIn(List<String> values) {
            addCriterion("srcName not in", values, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameBetween(String value1, String value2) {
            addCriterion("srcName between", value1, value2, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcnameNotBetween(String value1, String value2) {
            addCriterion("srcName not between", value1, value2, "srcname");
            return (Criteria) this;
        }

        public Criteria andSrcenableIsNull() {
            addCriterion("srcEnable is null");
            return (Criteria) this;
        }

        public Criteria andSrcenableIsNotNull() {
            addCriterion("srcEnable is not null");
            return (Criteria) this;
        }

        public Criteria andSrcenableEqualTo(Integer value) {
            addCriterion("srcEnable =", value, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableNotEqualTo(Integer value) {
            addCriterion("srcEnable <>", value, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableGreaterThan(Integer value) {
            addCriterion("srcEnable >", value, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("srcEnable >=", value, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableLessThan(Integer value) {
            addCriterion("srcEnable <", value, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableLessThanOrEqualTo(Integer value) {
            addCriterion("srcEnable <=", value, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableIn(List<Integer> values) {
            addCriterion("srcEnable in", values, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableNotIn(List<Integer> values) {
            addCriterion("srcEnable not in", values, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableBetween(Integer value1, Integer value2) {
            addCriterion("srcEnable between", value1, value2, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrcenableNotBetween(Integer value1, Integer value2) {
            addCriterion("srcEnable not between", value1, value2, "srcenable");
            return (Criteria) this;
        }

        public Criteria andSrccreaterIsNull() {
            addCriterion("srcCreater is null");
            return (Criteria) this;
        }

        public Criteria andSrccreaterIsNotNull() {
            addCriterion("srcCreater is not null");
            return (Criteria) this;
        }

        public Criteria andSrccreaterEqualTo(Integer value) {
            addCriterion("srcCreater =", value, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterNotEqualTo(Integer value) {
            addCriterion("srcCreater <>", value, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterGreaterThan(Integer value) {
            addCriterion("srcCreater >", value, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("srcCreater >=", value, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterLessThan(Integer value) {
            addCriterion("srcCreater <", value, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterLessThanOrEqualTo(Integer value) {
            addCriterion("srcCreater <=", value, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterIn(List<Integer> values) {
            addCriterion("srcCreater in", values, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterNotIn(List<Integer> values) {
            addCriterion("srcCreater not in", values, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterBetween(Integer value1, Integer value2) {
            addCriterion("srcCreater between", value1, value2, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("srcCreater not between", value1, value2, "srccreater");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateIsNull() {
            addCriterion("srcCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateIsNotNull() {
            addCriterion("srcCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateEqualTo(Date value) {
            addCriterion("srcCreateDate =", value, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateNotEqualTo(Date value) {
            addCriterion("srcCreateDate <>", value, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateGreaterThan(Date value) {
            addCriterion("srcCreateDate >", value, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("srcCreateDate >=", value, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateLessThan(Date value) {
            addCriterion("srcCreateDate <", value, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateLessThanOrEqualTo(Date value) {
            addCriterion("srcCreateDate <=", value, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateIn(List<Date> values) {
            addCriterion("srcCreateDate in", values, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateNotIn(List<Date> values) {
            addCriterion("srcCreateDate not in", values, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateBetween(Date value1, Date value2) {
            addCriterion("srcCreateDate between", value1, value2, "srccreatedate");
            return (Criteria) this;
        }

        public Criteria andSrccreatedateNotBetween(Date value1, Date value2) {
            addCriterion("srcCreateDate not between", value1, value2, "srccreatedate");
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