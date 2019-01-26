package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.List;

public class DataIndexExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataIndexExample() {
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

        public Criteria andDiidIsNull() {
            addCriterion("diId is null");
            return (Criteria) this;
        }

        public Criteria andDiidIsNotNull() {
            addCriterion("diId is not null");
            return (Criteria) this;
        }

        public Criteria andDiidEqualTo(Integer value) {
            addCriterion("diId =", value, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidNotEqualTo(Integer value) {
            addCriterion("diId <>", value, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidGreaterThan(Integer value) {
            addCriterion("diId >", value, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("diId >=", value, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidLessThan(Integer value) {
            addCriterion("diId <", value, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidLessThanOrEqualTo(Integer value) {
            addCriterion("diId <=", value, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidIn(List<Integer> values) {
            addCriterion("diId in", values, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidNotIn(List<Integer> values) {
            addCriterion("diId not in", values, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidBetween(Integer value1, Integer value2) {
            addCriterion("diId between", value1, value2, "diid");
            return (Criteria) this;
        }

        public Criteria andDiidNotBetween(Integer value1, Integer value2) {
            addCriterion("diId not between", value1, value2, "diid");
            return (Criteria) this;
        }

        public Criteria andDinameIsNull() {
            addCriterion("diName is null");
            return (Criteria) this;
        }

        public Criteria andDinameIsNotNull() {
            addCriterion("diName is not null");
            return (Criteria) this;
        }

        public Criteria andDinameEqualTo(String value) {
            addCriterion("diName =", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameNotEqualTo(String value) {
            addCriterion("diName <>", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameGreaterThan(String value) {
            addCriterion("diName >", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameGreaterThanOrEqualTo(String value) {
            addCriterion("diName >=", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameLessThan(String value) {
            addCriterion("diName <", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameLessThanOrEqualTo(String value) {
            addCriterion("diName <=", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameLike(String value) {
            addCriterion("diName like", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameNotLike(String value) {
            addCriterion("diName not like", value, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameIn(List<String> values) {
            addCriterion("diName in", values, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameNotIn(List<String> values) {
            addCriterion("diName not in", values, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameBetween(String value1, String value2) {
            addCriterion("diName between", value1, value2, "diname");
            return (Criteria) this;
        }

        public Criteria andDinameNotBetween(String value1, String value2) {
            addCriterion("diName not between", value1, value2, "diname");
            return (Criteria) this;
        }

        public Criteria andDivalueIsNull() {
            addCriterion("diValue is null");
            return (Criteria) this;
        }

        public Criteria andDivalueIsNotNull() {
            addCriterion("diValue is not null");
            return (Criteria) this;
        }

        public Criteria andDivalueEqualTo(String value) {
            addCriterion("diValue =", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueNotEqualTo(String value) {
            addCriterion("diValue <>", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueGreaterThan(String value) {
            addCriterion("diValue >", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueGreaterThanOrEqualTo(String value) {
            addCriterion("diValue >=", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueLessThan(String value) {
            addCriterion("diValue <", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueLessThanOrEqualTo(String value) {
            addCriterion("diValue <=", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueLike(String value) {
            addCriterion("diValue like", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueNotLike(String value) {
            addCriterion("diValue not like", value, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueIn(List<String> values) {
            addCriterion("diValue in", values, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueNotIn(List<String> values) {
            addCriterion("diValue not in", values, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueBetween(String value1, String value2) {
            addCriterion("diValue between", value1, value2, "divalue");
            return (Criteria) this;
        }

        public Criteria andDivalueNotBetween(String value1, String value2) {
            addCriterion("diValue not between", value1, value2, "divalue");
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