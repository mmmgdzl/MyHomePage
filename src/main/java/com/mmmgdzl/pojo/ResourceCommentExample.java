package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResourceCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceCommentExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRcIdIsNull() {
            addCriterion("rc_id is null");
            return (Criteria) this;
        }

        public Criteria andRcIdIsNotNull() {
            addCriterion("rc_id is not null");
            return (Criteria) this;
        }

        public Criteria andRcIdEqualTo(Integer value) {
            addCriterion("rc_id =", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotEqualTo(Integer value) {
            addCriterion("rc_id <>", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdGreaterThan(Integer value) {
            addCriterion("rc_id >", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rc_id >=", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdLessThan(Integer value) {
            addCriterion("rc_id <", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdLessThanOrEqualTo(Integer value) {
            addCriterion("rc_id <=", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdIn(List<Integer> values) {
            addCriterion("rc_id in", values, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotIn(List<Integer> values) {
            addCriterion("rc_id not in", values, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdBetween(Integer value1, Integer value2) {
            addCriterion("rc_id between", value1, value2, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rc_id not between", value1, value2, "rcId");
            return (Criteria) this;
        }

        public Criteria andRccreatedateIsNull() {
            addCriterion("rcCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andRccreatedateIsNotNull() {
            addCriterion("rcCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andRccreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("rcCreateDate =", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("rcCreateDate <>", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("rcCreateDate >", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rcCreateDate >=", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateLessThan(Date value) {
            addCriterionForJDBCDate("rcCreateDate <", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rcCreateDate <=", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("rcCreateDate in", values, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("rcCreateDate not in", values, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rcCreateDate between", value1, value2, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rcCreateDate not between", value1, value2, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreaterIsNull() {
            addCriterion("rcCreater is null");
            return (Criteria) this;
        }

        public Criteria andRccreaterIsNotNull() {
            addCriterion("rcCreater is not null");
            return (Criteria) this;
        }

        public Criteria andRccreaterEqualTo(Integer value) {
            addCriterion("rcCreater =", value, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterNotEqualTo(Integer value) {
            addCriterion("rcCreater <>", value, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterGreaterThan(Integer value) {
            addCriterion("rcCreater >", value, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcCreater >=", value, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterLessThan(Integer value) {
            addCriterion("rcCreater <", value, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterLessThanOrEqualTo(Integer value) {
            addCriterion("rcCreater <=", value, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterIn(List<Integer> values) {
            addCriterion("rcCreater in", values, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterNotIn(List<Integer> values) {
            addCriterion("rcCreater not in", values, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterBetween(Integer value1, Integer value2) {
            addCriterion("rcCreater between", value1, value2, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRccreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("rcCreater not between", value1, value2, "rccreater");
            return (Criteria) this;
        }

        public Criteria andRcresourceIsNull() {
            addCriterion("rcResource is null");
            return (Criteria) this;
        }

        public Criteria andRcresourceIsNotNull() {
            addCriterion("rcResource is not null");
            return (Criteria) this;
        }

        public Criteria andRcresourceEqualTo(Integer value) {
            addCriterion("rcResource =", value, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceNotEqualTo(Integer value) {
            addCriterion("rcResource <>", value, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceGreaterThan(Integer value) {
            addCriterion("rcResource >", value, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcResource >=", value, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceLessThan(Integer value) {
            addCriterion("rcResource <", value, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceLessThanOrEqualTo(Integer value) {
            addCriterion("rcResource <=", value, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceIn(List<Integer> values) {
            addCriterion("rcResource in", values, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceNotIn(List<Integer> values) {
            addCriterion("rcResource not in", values, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceBetween(Integer value1, Integer value2) {
            addCriterion("rcResource between", value1, value2, "rcresource");
            return (Criteria) this;
        }

        public Criteria andRcresourceNotBetween(Integer value1, Integer value2) {
            addCriterion("rcResource not between", value1, value2, "rcresource");
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