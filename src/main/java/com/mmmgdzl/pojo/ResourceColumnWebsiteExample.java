package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceColumnWebsiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceColumnWebsiteExample() {
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

        public Criteria andRcwidIsNull() {
            addCriterion("rcwId is null");
            return (Criteria) this;
        }

        public Criteria andRcwidIsNotNull() {
            addCriterion("rcwId is not null");
            return (Criteria) this;
        }

        public Criteria andRcwidEqualTo(Integer value) {
            addCriterion("rcwId =", value, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidNotEqualTo(Integer value) {
            addCriterion("rcwId <>", value, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidGreaterThan(Integer value) {
            addCriterion("rcwId >", value, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcwId >=", value, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidLessThan(Integer value) {
            addCriterion("rcwId <", value, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidLessThanOrEqualTo(Integer value) {
            addCriterion("rcwId <=", value, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidIn(List<Integer> values) {
            addCriterion("rcwId in", values, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidNotIn(List<Integer> values) {
            addCriterion("rcwId not in", values, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidBetween(Integer value1, Integer value2) {
            addCriterion("rcwId between", value1, value2, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwidNotBetween(Integer value1, Integer value2) {
            addCriterion("rcwId not between", value1, value2, "rcwid");
            return (Criteria) this;
        }

        public Criteria andRcwcidIsNull() {
            addCriterion("rcwCid is null");
            return (Criteria) this;
        }

        public Criteria andRcwcidIsNotNull() {
            addCriterion("rcwCid is not null");
            return (Criteria) this;
        }

        public Criteria andRcwcidEqualTo(Integer value) {
            addCriterion("rcwCid =", value, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidNotEqualTo(Integer value) {
            addCriterion("rcwCid <>", value, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidGreaterThan(Integer value) {
            addCriterion("rcwCid >", value, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcwCid >=", value, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidLessThan(Integer value) {
            addCriterion("rcwCid <", value, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidLessThanOrEqualTo(Integer value) {
            addCriterion("rcwCid <=", value, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidIn(List<Integer> values) {
            addCriterion("rcwCid in", values, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidNotIn(List<Integer> values) {
            addCriterion("rcwCid not in", values, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidBetween(Integer value1, Integer value2) {
            addCriterion("rcwCid between", value1, value2, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwcidNotBetween(Integer value1, Integer value2) {
            addCriterion("rcwCid not between", value1, value2, "rcwcid");
            return (Criteria) this;
        }

        public Criteria andRcwnameIsNull() {
            addCriterion("rcwName is null");
            return (Criteria) this;
        }

        public Criteria andRcwnameIsNotNull() {
            addCriterion("rcwName is not null");
            return (Criteria) this;
        }

        public Criteria andRcwnameEqualTo(String value) {
            addCriterion("rcwName =", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameNotEqualTo(String value) {
            addCriterion("rcwName <>", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameGreaterThan(String value) {
            addCriterion("rcwName >", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameGreaterThanOrEqualTo(String value) {
            addCriterion("rcwName >=", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameLessThan(String value) {
            addCriterion("rcwName <", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameLessThanOrEqualTo(String value) {
            addCriterion("rcwName <=", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameLike(String value) {
            addCriterion("rcwName like", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameNotLike(String value) {
            addCriterion("rcwName not like", value, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameIn(List<String> values) {
            addCriterion("rcwName in", values, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameNotIn(List<String> values) {
            addCriterion("rcwName not in", values, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameBetween(String value1, String value2) {
            addCriterion("rcwName between", value1, value2, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwnameNotBetween(String value1, String value2) {
            addCriterion("rcwName not between", value1, value2, "rcwname");
            return (Criteria) this;
        }

        public Criteria andRcwhrefIsNull() {
            addCriterion("rcwHref is null");
            return (Criteria) this;
        }

        public Criteria andRcwhrefIsNotNull() {
            addCriterion("rcwHref is not null");
            return (Criteria) this;
        }

        public Criteria andRcwhrefEqualTo(String value) {
            addCriterion("rcwHref =", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefNotEqualTo(String value) {
            addCriterion("rcwHref <>", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefGreaterThan(String value) {
            addCriterion("rcwHref >", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefGreaterThanOrEqualTo(String value) {
            addCriterion("rcwHref >=", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefLessThan(String value) {
            addCriterion("rcwHref <", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefLessThanOrEqualTo(String value) {
            addCriterion("rcwHref <=", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefLike(String value) {
            addCriterion("rcwHref like", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefNotLike(String value) {
            addCriterion("rcwHref not like", value, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefIn(List<String> values) {
            addCriterion("rcwHref in", values, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefNotIn(List<String> values) {
            addCriterion("rcwHref not in", values, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefBetween(String value1, String value2) {
            addCriterion("rcwHref between", value1, value2, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwhrefNotBetween(String value1, String value2) {
            addCriterion("rcwHref not between", value1, value2, "rcwhref");
            return (Criteria) this;
        }

        public Criteria andRcwlogoIsNull() {
            addCriterion("rcwLogo is null");
            return (Criteria) this;
        }

        public Criteria andRcwlogoIsNotNull() {
            addCriterion("rcwLogo is not null");
            return (Criteria) this;
        }

        public Criteria andRcwlogoEqualTo(String value) {
            addCriterion("rcwLogo =", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoNotEqualTo(String value) {
            addCriterion("rcwLogo <>", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoGreaterThan(String value) {
            addCriterion("rcwLogo >", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoGreaterThanOrEqualTo(String value) {
            addCriterion("rcwLogo >=", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoLessThan(String value) {
            addCriterion("rcwLogo <", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoLessThanOrEqualTo(String value) {
            addCriterion("rcwLogo <=", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoLike(String value) {
            addCriterion("rcwLogo like", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoNotLike(String value) {
            addCriterion("rcwLogo not like", value, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoIn(List<String> values) {
            addCriterion("rcwLogo in", values, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoNotIn(List<String> values) {
            addCriterion("rcwLogo not in", values, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoBetween(String value1, String value2) {
            addCriterion("rcwLogo between", value1, value2, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwlogoNotBetween(String value1, String value2) {
            addCriterion("rcwLogo not between", value1, value2, "rcwlogo");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterIsNull() {
            addCriterion("rcwCreater is null");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterIsNotNull() {
            addCriterion("rcwCreater is not null");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterEqualTo(Integer value) {
            addCriterion("rcwCreater =", value, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterNotEqualTo(Integer value) {
            addCriterion("rcwCreater <>", value, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterGreaterThan(Integer value) {
            addCriterion("rcwCreater >", value, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcwCreater >=", value, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterLessThan(Integer value) {
            addCriterion("rcwCreater <", value, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterLessThanOrEqualTo(Integer value) {
            addCriterion("rcwCreater <=", value, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterIn(List<Integer> values) {
            addCriterion("rcwCreater in", values, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterNotIn(List<Integer> values) {
            addCriterion("rcwCreater not in", values, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterBetween(Integer value1, Integer value2) {
            addCriterion("rcwCreater between", value1, value2, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("rcwCreater not between", value1, value2, "rcwcreater");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateIsNull() {
            addCriterion("rcwCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateIsNotNull() {
            addCriterion("rcwCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateEqualTo(Date value) {
            addCriterion("rcwCreateDate =", value, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateNotEqualTo(Date value) {
            addCriterion("rcwCreateDate <>", value, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateGreaterThan(Date value) {
            addCriterion("rcwCreateDate >", value, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("rcwCreateDate >=", value, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateLessThan(Date value) {
            addCriterion("rcwCreateDate <", value, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("rcwCreateDate <=", value, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateIn(List<Date> values) {
            addCriterion("rcwCreateDate in", values, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateNotIn(List<Date> values) {
            addCriterion("rcwCreateDate not in", values, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateBetween(Date value1, Date value2) {
            addCriterion("rcwCreateDate between", value1, value2, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("rcwCreateDate not between", value1, value2, "rcwcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcwenableIsNull() {
            addCriterion("rcwEnable is null");
            return (Criteria) this;
        }

        public Criteria andRcwenableIsNotNull() {
            addCriterion("rcwEnable is not null");
            return (Criteria) this;
        }

        public Criteria andRcwenableEqualTo(Integer value) {
            addCriterion("rcwEnable =", value, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableNotEqualTo(Integer value) {
            addCriterion("rcwEnable <>", value, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableGreaterThan(Integer value) {
            addCriterion("rcwEnable >", value, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcwEnable >=", value, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableLessThan(Integer value) {
            addCriterion("rcwEnable <", value, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableLessThanOrEqualTo(Integer value) {
            addCriterion("rcwEnable <=", value, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableIn(List<Integer> values) {
            addCriterion("rcwEnable in", values, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableNotIn(List<Integer> values) {
            addCriterion("rcwEnable not in", values, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableBetween(Integer value1, Integer value2) {
            addCriterion("rcwEnable between", value1, value2, "rcwenable");
            return (Criteria) this;
        }

        public Criteria andRcwenableNotBetween(Integer value1, Integer value2) {
            addCriterion("rcwEnable not between", value1, value2, "rcwenable");
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