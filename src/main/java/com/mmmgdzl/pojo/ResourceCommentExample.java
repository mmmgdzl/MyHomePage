package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andRcidIsNull() {
            addCriterion("rcId is null");
            return (Criteria) this;
        }

        public Criteria andRcidIsNotNull() {
            addCriterion("rcId is not null");
            return (Criteria) this;
        }

        public Criteria andRcidEqualTo(Integer value) {
            addCriterion("rcId =", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidNotEqualTo(Integer value) {
            addCriterion("rcId <>", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidGreaterThan(Integer value) {
            addCriterion("rcId >", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcId >=", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidLessThan(Integer value) {
            addCriterion("rcId <", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidLessThanOrEqualTo(Integer value) {
            addCriterion("rcId <=", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidIn(List<Integer> values) {
            addCriterion("rcId in", values, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidNotIn(List<Integer> values) {
            addCriterion("rcId not in", values, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidBetween(Integer value1, Integer value2) {
            addCriterion("rcId between", value1, value2, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidNotBetween(Integer value1, Integer value2) {
            addCriterion("rcId not between", value1, value2, "rcid");
            return (Criteria) this;
        }

        public Criteria andRccountIsNull() {
            addCriterion("rcCount is null");
            return (Criteria) this;
        }

        public Criteria andRccountIsNotNull() {
            addCriterion("rcCount is not null");
            return (Criteria) this;
        }

        public Criteria andRccountEqualTo(Integer value) {
            addCriterion("rcCount =", value, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountNotEqualTo(Integer value) {
            addCriterion("rcCount <>", value, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountGreaterThan(Integer value) {
            addCriterion("rcCount >", value, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcCount >=", value, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountLessThan(Integer value) {
            addCriterion("rcCount <", value, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountLessThanOrEqualTo(Integer value) {
            addCriterion("rcCount <=", value, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountIn(List<Integer> values) {
            addCriterion("rcCount in", values, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountNotIn(List<Integer> values) {
            addCriterion("rcCount not in", values, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountBetween(Integer value1, Integer value2) {
            addCriterion("rcCount between", value1, value2, "rccount");
            return (Criteria) this;
        }

        public Criteria andRccountNotBetween(Integer value1, Integer value2) {
            addCriterion("rcCount not between", value1, value2, "rccount");
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

        public Criteria andRccreatedateIsNull() {
            addCriterion("rcCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andRccreatedateIsNotNull() {
            addCriterion("rcCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andRccreatedateEqualTo(Date value) {
            addCriterion("rcCreateDate =", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateNotEqualTo(Date value) {
            addCriterion("rcCreateDate <>", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateGreaterThan(Date value) {
            addCriterion("rcCreateDate >", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("rcCreateDate >=", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateLessThan(Date value) {
            addCriterion("rcCreateDate <", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateLessThanOrEqualTo(Date value) {
            addCriterion("rcCreateDate <=", value, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateIn(List<Date> values) {
            addCriterion("rcCreateDate in", values, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateNotIn(List<Date> values) {
            addCriterion("rcCreateDate not in", values, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateBetween(Date value1, Date value2) {
            addCriterion("rcCreateDate between", value1, value2, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRccreatedateNotBetween(Date value1, Date value2) {
            addCriterion("rcCreateDate not between", value1, value2, "rccreatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdaterIsNull() {
            addCriterion("rcUpdater is null");
            return (Criteria) this;
        }

        public Criteria andRcupdaterIsNotNull() {
            addCriterion("rcUpdater is not null");
            return (Criteria) this;
        }

        public Criteria andRcupdaterEqualTo(Integer value) {
            addCriterion("rcUpdater =", value, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterNotEqualTo(Integer value) {
            addCriterion("rcUpdater <>", value, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterGreaterThan(Integer value) {
            addCriterion("rcUpdater >", value, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcUpdater >=", value, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterLessThan(Integer value) {
            addCriterion("rcUpdater <", value, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterLessThanOrEqualTo(Integer value) {
            addCriterion("rcUpdater <=", value, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterIn(List<Integer> values) {
            addCriterion("rcUpdater in", values, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterNotIn(List<Integer> values) {
            addCriterion("rcUpdater not in", values, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterBetween(Integer value1, Integer value2) {
            addCriterion("rcUpdater between", value1, value2, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdaterNotBetween(Integer value1, Integer value2) {
            addCriterion("rcUpdater not between", value1, value2, "rcupdater");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateIsNull() {
            addCriterion("rcUpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateIsNotNull() {
            addCriterion("rcUpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateEqualTo(Date value) {
            addCriterion("rcUpdateDate =", value, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateNotEqualTo(Date value) {
            addCriterion("rcUpdateDate <>", value, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateGreaterThan(Date value) {
            addCriterion("rcUpdateDate >", value, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("rcUpdateDate >=", value, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateLessThan(Date value) {
            addCriterion("rcUpdateDate <", value, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateLessThanOrEqualTo(Date value) {
            addCriterion("rcUpdateDate <=", value, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateIn(List<Date> values) {
            addCriterion("rcUpdateDate in", values, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateNotIn(List<Date> values) {
            addCriterion("rcUpdateDate not in", values, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateBetween(Date value1, Date value2) {
            addCriterion("rcUpdateDate between", value1, value2, "rcupdatedate");
            return (Criteria) this;
        }

        public Criteria andRcupdatedateNotBetween(Date value1, Date value2) {
            addCriterion("rcUpdateDate not between", value1, value2, "rcupdatedate");
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

        public Criteria andRcreplyIsNull() {
            addCriterion("rcReply is null");
            return (Criteria) this;
        }

        public Criteria andRcreplyIsNotNull() {
            addCriterion("rcReply is not null");
            return (Criteria) this;
        }

        public Criteria andRcreplyEqualTo(Integer value) {
            addCriterion("rcReply =", value, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyNotEqualTo(Integer value) {
            addCriterion("rcReply <>", value, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyGreaterThan(Integer value) {
            addCriterion("rcReply >", value, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcReply >=", value, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyLessThan(Integer value) {
            addCriterion("rcReply <", value, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyLessThanOrEqualTo(Integer value) {
            addCriterion("rcReply <=", value, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyIn(List<Integer> values) {
            addCriterion("rcReply in", values, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyNotIn(List<Integer> values) {
            addCriterion("rcReply not in", values, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyBetween(Integer value1, Integer value2) {
            addCriterion("rcReply between", value1, value2, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRcreplyNotBetween(Integer value1, Integer value2) {
            addCriterion("rcReply not between", value1, value2, "rcreply");
            return (Criteria) this;
        }

        public Criteria andRccontentIsNull() {
            addCriterion("rcContent is null");
            return (Criteria) this;
        }

        public Criteria andRccontentIsNotNull() {
            addCriterion("rcContent is not null");
            return (Criteria) this;
        }

        public Criteria andRccontentEqualTo(String value) {
            addCriterion("rcContent =", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentNotEqualTo(String value) {
            addCriterion("rcContent <>", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentGreaterThan(String value) {
            addCriterion("rcContent >", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentGreaterThanOrEqualTo(String value) {
            addCriterion("rcContent >=", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentLessThan(String value) {
            addCriterion("rcContent <", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentLessThanOrEqualTo(String value) {
            addCriterion("rcContent <=", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentLike(String value) {
            addCriterion("rcContent like", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentNotLike(String value) {
            addCriterion("rcContent not like", value, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentIn(List<String> values) {
            addCriterion("rcContent in", values, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentNotIn(List<String> values) {
            addCriterion("rcContent not in", values, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentBetween(String value1, String value2) {
            addCriterion("rcContent between", value1, value2, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRccontentNotBetween(String value1, String value2) {
            addCriterion("rcContent not between", value1, value2, "rccontent");
            return (Criteria) this;
        }

        public Criteria andRcenableIsNull() {
            addCriterion("rcEnable is null");
            return (Criteria) this;
        }

        public Criteria andRcenableIsNotNull() {
            addCriterion("rcEnable is not null");
            return (Criteria) this;
        }

        public Criteria andRcenableEqualTo(Integer value) {
            addCriterion("rcEnable =", value, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableNotEqualTo(Integer value) {
            addCriterion("rcEnable <>", value, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableGreaterThan(Integer value) {
            addCriterion("rcEnable >", value, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcEnable >=", value, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableLessThan(Integer value) {
            addCriterion("rcEnable <", value, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableLessThanOrEqualTo(Integer value) {
            addCriterion("rcEnable <=", value, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableIn(List<Integer> values) {
            addCriterion("rcEnable in", values, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableNotIn(List<Integer> values) {
            addCriterion("rcEnable not in", values, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableBetween(Integer value1, Integer value2) {
            addCriterion("rcEnable between", value1, value2, "rcenable");
            return (Criteria) this;
        }

        public Criteria andRcenableNotBetween(Integer value1, Integer value2) {
            addCriterion("rcEnable not between", value1, value2, "rcenable");
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