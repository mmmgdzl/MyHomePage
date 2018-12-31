package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceColumnExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cId is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cId is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cId =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cId <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cId >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cId >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cId <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cId <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cId in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cId not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cId between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cId not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cName is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cName is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cName =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cName <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cName >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cName >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cName <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cName <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cName like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cName not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cName in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cName not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cName between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cName not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCcreatedateIsNull() {
            addCriterion("cCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCcreatedateIsNotNull() {
            addCriterion("cCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCcreatedateEqualTo(Date value) {
            addCriterion("cCreateDate =", value, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateNotEqualTo(Date value) {
            addCriterion("cCreateDate <>", value, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateGreaterThan(Date value) {
            addCriterion("cCreateDate >", value, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("cCreateDate >=", value, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateLessThan(Date value) {
            addCriterion("cCreateDate <", value, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("cCreateDate <=", value, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateIn(List<Date> values) {
            addCriterion("cCreateDate in", values, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateNotIn(List<Date> values) {
            addCriterion("cCreateDate not in", values, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateBetween(Date value1, Date value2) {
            addCriterion("cCreateDate between", value1, value2, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("cCreateDate not between", value1, value2, "ccreatedate");
            return (Criteria) this;
        }

        public Criteria andCcreaterIsNull() {
            addCriterion("cCreater is null");
            return (Criteria) this;
        }

        public Criteria andCcreaterIsNotNull() {
            addCriterion("cCreater is not null");
            return (Criteria) this;
        }

        public Criteria andCcreaterEqualTo(Integer value) {
            addCriterion("cCreater =", value, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterNotEqualTo(Integer value) {
            addCriterion("cCreater <>", value, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterGreaterThan(Integer value) {
            addCriterion("cCreater >", value, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("cCreater >=", value, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterLessThan(Integer value) {
            addCriterion("cCreater <", value, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterLessThanOrEqualTo(Integer value) {
            addCriterion("cCreater <=", value, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterIn(List<Integer> values) {
            addCriterion("cCreater in", values, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterNotIn(List<Integer> values) {
            addCriterion("cCreater not in", values, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterBetween(Integer value1, Integer value2) {
            addCriterion("cCreater between", value1, value2, "ccreater");
            return (Criteria) this;
        }

        public Criteria andCcreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("cCreater not between", value1, value2, "ccreater");
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