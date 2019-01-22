package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemResourceExample() {
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

        public Criteria andSridIsNull() {
            addCriterion("srId is null");
            return (Criteria) this;
        }

        public Criteria andSridIsNotNull() {
            addCriterion("srId is not null");
            return (Criteria) this;
        }

        public Criteria andSridEqualTo(Integer value) {
            addCriterion("srId =", value, "srid");
            return (Criteria) this;
        }

        public Criteria andSridNotEqualTo(Integer value) {
            addCriterion("srId <>", value, "srid");
            return (Criteria) this;
        }

        public Criteria andSridGreaterThan(Integer value) {
            addCriterion("srId >", value, "srid");
            return (Criteria) this;
        }

        public Criteria andSridGreaterThanOrEqualTo(Integer value) {
            addCriterion("srId >=", value, "srid");
            return (Criteria) this;
        }

        public Criteria andSridLessThan(Integer value) {
            addCriterion("srId <", value, "srid");
            return (Criteria) this;
        }

        public Criteria andSridLessThanOrEqualTo(Integer value) {
            addCriterion("srId <=", value, "srid");
            return (Criteria) this;
        }

        public Criteria andSridIn(List<Integer> values) {
            addCriterion("srId in", values, "srid");
            return (Criteria) this;
        }

        public Criteria andSridNotIn(List<Integer> values) {
            addCriterion("srId not in", values, "srid");
            return (Criteria) this;
        }

        public Criteria andSridBetween(Integer value1, Integer value2) {
            addCriterion("srId between", value1, value2, "srid");
            return (Criteria) this;
        }

        public Criteria andSridNotBetween(Integer value1, Integer value2) {
            addCriterion("srId not between", value1, value2, "srid");
            return (Criteria) this;
        }

        public Criteria andSrnameIsNull() {
            addCriterion("srName is null");
            return (Criteria) this;
        }

        public Criteria andSrnameIsNotNull() {
            addCriterion("srName is not null");
            return (Criteria) this;
        }

        public Criteria andSrnameEqualTo(String value) {
            addCriterion("srName =", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameNotEqualTo(String value) {
            addCriterion("srName <>", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameGreaterThan(String value) {
            addCriterion("srName >", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameGreaterThanOrEqualTo(String value) {
            addCriterion("srName >=", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameLessThan(String value) {
            addCriterion("srName <", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameLessThanOrEqualTo(String value) {
            addCriterion("srName <=", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameLike(String value) {
            addCriterion("srName like", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameNotLike(String value) {
            addCriterion("srName not like", value, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameIn(List<String> values) {
            addCriterion("srName in", values, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameNotIn(List<String> values) {
            addCriterion("srName not in", values, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameBetween(String value1, String value2) {
            addCriterion("srName between", value1, value2, "srname");
            return (Criteria) this;
        }

        public Criteria andSrnameNotBetween(String value1, String value2) {
            addCriterion("srName not between", value1, value2, "srname");
            return (Criteria) this;
        }

        public Criteria andSrcolumnIsNull() {
            addCriterion("srColumn is null");
            return (Criteria) this;
        }

        public Criteria andSrcolumnIsNotNull() {
            addCriterion("srColumn is not null");
            return (Criteria) this;
        }

        public Criteria andSrcolumnEqualTo(Integer value) {
            addCriterion("srColumn =", value, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnNotEqualTo(Integer value) {
            addCriterion("srColumn <>", value, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnGreaterThan(Integer value) {
            addCriterion("srColumn >", value, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnGreaterThanOrEqualTo(Integer value) {
            addCriterion("srColumn >=", value, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnLessThan(Integer value) {
            addCriterion("srColumn <", value, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnLessThanOrEqualTo(Integer value) {
            addCriterion("srColumn <=", value, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnIn(List<Integer> values) {
            addCriterion("srColumn in", values, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnNotIn(List<Integer> values) {
            addCriterion("srColumn not in", values, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnBetween(Integer value1, Integer value2) {
            addCriterion("srColumn between", value1, value2, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcolumnNotBetween(Integer value1, Integer value2) {
            addCriterion("srColumn not between", value1, value2, "srcolumn");
            return (Criteria) this;
        }

        public Criteria andSrcreaterIsNull() {
            addCriterion("srCreater is null");
            return (Criteria) this;
        }

        public Criteria andSrcreaterIsNotNull() {
            addCriterion("srCreater is not null");
            return (Criteria) this;
        }

        public Criteria andSrcreaterEqualTo(Integer value) {
            addCriterion("srCreater =", value, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterNotEqualTo(Integer value) {
            addCriterion("srCreater <>", value, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterGreaterThan(Integer value) {
            addCriterion("srCreater >", value, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("srCreater >=", value, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterLessThan(Integer value) {
            addCriterion("srCreater <", value, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterLessThanOrEqualTo(Integer value) {
            addCriterion("srCreater <=", value, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterIn(List<Integer> values) {
            addCriterion("srCreater in", values, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterNotIn(List<Integer> values) {
            addCriterion("srCreater not in", values, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterBetween(Integer value1, Integer value2) {
            addCriterion("srCreater between", value1, value2, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("srCreater not between", value1, value2, "srcreater");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateIsNull() {
            addCriterion("srCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateIsNotNull() {
            addCriterion("srCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateEqualTo(Date value) {
            addCriterion("srCreateDate =", value, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateNotEqualTo(Date value) {
            addCriterion("srCreateDate <>", value, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateGreaterThan(Date value) {
            addCriterion("srCreateDate >", value, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("srCreateDate >=", value, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateLessThan(Date value) {
            addCriterion("srCreateDate <", value, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("srCreateDate <=", value, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateIn(List<Date> values) {
            addCriterion("srCreateDate in", values, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateNotIn(List<Date> values) {
            addCriterion("srCreateDate not in", values, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateBetween(Date value1, Date value2) {
            addCriterion("srCreateDate between", value1, value2, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("srCreateDate not between", value1, value2, "srcreatedate");
            return (Criteria) this;
        }

        public Criteria andSrenableIsNull() {
            addCriterion("srEnable is null");
            return (Criteria) this;
        }

        public Criteria andSrenableIsNotNull() {
            addCriterion("srEnable is not null");
            return (Criteria) this;
        }

        public Criteria andSrenableEqualTo(Integer value) {
            addCriterion("srEnable =", value, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableNotEqualTo(Integer value) {
            addCriterion("srEnable <>", value, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableGreaterThan(Integer value) {
            addCriterion("srEnable >", value, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("srEnable >=", value, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableLessThan(Integer value) {
            addCriterion("srEnable <", value, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableLessThanOrEqualTo(Integer value) {
            addCriterion("srEnable <=", value, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableIn(List<Integer> values) {
            addCriterion("srEnable in", values, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableNotIn(List<Integer> values) {
            addCriterion("srEnable not in", values, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableBetween(Integer value1, Integer value2) {
            addCriterion("srEnable between", value1, value2, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrenableNotBetween(Integer value1, Integer value2) {
            addCriterion("srEnable not between", value1, value2, "srenable");
            return (Criteria) this;
        }

        public Criteria andSrdescIsNull() {
            addCriterion("srDesc is null");
            return (Criteria) this;
        }

        public Criteria andSrdescIsNotNull() {
            addCriterion("srDesc is not null");
            return (Criteria) this;
        }

        public Criteria andSrdescEqualTo(String value) {
            addCriterion("srDesc =", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescNotEqualTo(String value) {
            addCriterion("srDesc <>", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescGreaterThan(String value) {
            addCriterion("srDesc >", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescGreaterThanOrEqualTo(String value) {
            addCriterion("srDesc >=", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescLessThan(String value) {
            addCriterion("srDesc <", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescLessThanOrEqualTo(String value) {
            addCriterion("srDesc <=", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescLike(String value) {
            addCriterion("srDesc like", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescNotLike(String value) {
            addCriterion("srDesc not like", value, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescIn(List<String> values) {
            addCriterion("srDesc in", values, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescNotIn(List<String> values) {
            addCriterion("srDesc not in", values, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescBetween(String value1, String value2) {
            addCriterion("srDesc between", value1, value2, "srdesc");
            return (Criteria) this;
        }

        public Criteria andSrdescNotBetween(String value1, String value2) {
            addCriterion("srDesc not between", value1, value2, "srdesc");
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