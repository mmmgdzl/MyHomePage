package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rId is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rId is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rId =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rId <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rId >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rId >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rId <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rId <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rId in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rId not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rId between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rId not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRtitleIsNull() {
            addCriterion("rTitle is null");
            return (Criteria) this;
        }

        public Criteria andRtitleIsNotNull() {
            addCriterion("rTitle is not null");
            return (Criteria) this;
        }

        public Criteria andRtitleEqualTo(String value) {
            addCriterion("rTitle =", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleNotEqualTo(String value) {
            addCriterion("rTitle <>", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleGreaterThan(String value) {
            addCriterion("rTitle >", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleGreaterThanOrEqualTo(String value) {
            addCriterion("rTitle >=", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleLessThan(String value) {
            addCriterion("rTitle <", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleLessThanOrEqualTo(String value) {
            addCriterion("rTitle <=", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleLike(String value) {
            addCriterion("rTitle like", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleNotLike(String value) {
            addCriterion("rTitle not like", value, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleIn(List<String> values) {
            addCriterion("rTitle in", values, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleNotIn(List<String> values) {
            addCriterion("rTitle not in", values, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleBetween(String value1, String value2) {
            addCriterion("rTitle between", value1, value2, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleNotBetween(String value1, String value2) {
            addCriterion("rTitle not between", value1, value2, "rtitle");
            return (Criteria) this;
        }

        public Criteria andRtitleimgIsNull() {
            addCriterion("rTitleImg is null");
            return (Criteria) this;
        }

        public Criteria andRtitleimgIsNotNull() {
            addCriterion("rTitleImg is not null");
            return (Criteria) this;
        }

        public Criteria andRtitleimgEqualTo(String value) {
            addCriterion("rTitleImg =", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgNotEqualTo(String value) {
            addCriterion("rTitleImg <>", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgGreaterThan(String value) {
            addCriterion("rTitleImg >", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgGreaterThanOrEqualTo(String value) {
            addCriterion("rTitleImg >=", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgLessThan(String value) {
            addCriterion("rTitleImg <", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgLessThanOrEqualTo(String value) {
            addCriterion("rTitleImg <=", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgLike(String value) {
            addCriterion("rTitleImg like", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgNotLike(String value) {
            addCriterion("rTitleImg not like", value, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgIn(List<String> values) {
            addCriterion("rTitleImg in", values, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgNotIn(List<String> values) {
            addCriterion("rTitleImg not in", values, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgBetween(String value1, String value2) {
            addCriterion("rTitleImg between", value1, value2, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRtitleimgNotBetween(String value1, String value2) {
            addCriterion("rTitleImg not between", value1, value2, "rtitleimg");
            return (Criteria) this;
        }

        public Criteria andRcolumnIsNull() {
            addCriterion("rColumn is null");
            return (Criteria) this;
        }

        public Criteria andRcolumnIsNotNull() {
            addCriterion("rColumn is not null");
            return (Criteria) this;
        }

        public Criteria andRcolumnEqualTo(Integer value) {
            addCriterion("rColumn =", value, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnNotEqualTo(Integer value) {
            addCriterion("rColumn <>", value, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnGreaterThan(Integer value) {
            addCriterion("rColumn >", value, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnGreaterThanOrEqualTo(Integer value) {
            addCriterion("rColumn >=", value, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnLessThan(Integer value) {
            addCriterion("rColumn <", value, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnLessThanOrEqualTo(Integer value) {
            addCriterion("rColumn <=", value, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnIn(List<Integer> values) {
            addCriterion("rColumn in", values, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnNotIn(List<Integer> values) {
            addCriterion("rColumn not in", values, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnBetween(Integer value1, Integer value2) {
            addCriterion("rColumn between", value1, value2, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcolumnNotBetween(Integer value1, Integer value2) {
            addCriterion("rColumn not between", value1, value2, "rcolumn");
            return (Criteria) this;
        }

        public Criteria andRcreatedateIsNull() {
            addCriterion("rCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andRcreatedateIsNotNull() {
            addCriterion("rCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andRcreatedateEqualTo(Date value) {
            addCriterion("rCreateDate =", value, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateNotEqualTo(Date value) {
            addCriterion("rCreateDate <>", value, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateGreaterThan(Date value) {
            addCriterion("rCreateDate >", value, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("rCreateDate >=", value, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateLessThan(Date value) {
            addCriterion("rCreateDate <", value, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("rCreateDate <=", value, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateIn(List<Date> values) {
            addCriterion("rCreateDate in", values, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateNotIn(List<Date> values) {
            addCriterion("rCreateDate not in", values, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateBetween(Date value1, Date value2) {
            addCriterion("rCreateDate between", value1, value2, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("rCreateDate not between", value1, value2, "rcreatedate");
            return (Criteria) this;
        }

        public Criteria andRcreaterIsNull() {
            addCriterion("rCreater is null");
            return (Criteria) this;
        }

        public Criteria andRcreaterIsNotNull() {
            addCriterion("rCreater is not null");
            return (Criteria) this;
        }

        public Criteria andRcreaterEqualTo(Integer value) {
            addCriterion("rCreater =", value, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterNotEqualTo(Integer value) {
            addCriterion("rCreater <>", value, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterGreaterThan(Integer value) {
            addCriterion("rCreater >", value, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("rCreater >=", value, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterLessThan(Integer value) {
            addCriterion("rCreater <", value, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterLessThanOrEqualTo(Integer value) {
            addCriterion("rCreater <=", value, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterIn(List<Integer> values) {
            addCriterion("rCreater in", values, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterNotIn(List<Integer> values) {
            addCriterion("rCreater not in", values, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterBetween(Integer value1, Integer value2) {
            addCriterion("rCreater between", value1, value2, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRcreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("rCreater not between", value1, value2, "rcreater");
            return (Criteria) this;
        }

        public Criteria andRupdatedateIsNull() {
            addCriterion("rUpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andRupdatedateIsNotNull() {
            addCriterion("rUpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andRupdatedateEqualTo(Date value) {
            addCriterion("rUpdateDate =", value, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateNotEqualTo(Date value) {
            addCriterion("rUpdateDate <>", value, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateGreaterThan(Date value) {
            addCriterion("rUpdateDate >", value, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("rUpdateDate >=", value, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateLessThan(Date value) {
            addCriterion("rUpdateDate <", value, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateLessThanOrEqualTo(Date value) {
            addCriterion("rUpdateDate <=", value, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateIn(List<Date> values) {
            addCriterion("rUpdateDate in", values, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateNotIn(List<Date> values) {
            addCriterion("rUpdateDate not in", values, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateBetween(Date value1, Date value2) {
            addCriterion("rUpdateDate between", value1, value2, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdatedateNotBetween(Date value1, Date value2) {
            addCriterion("rUpdateDate not between", value1, value2, "rupdatedate");
            return (Criteria) this;
        }

        public Criteria andRupdaterIsNull() {
            addCriterion("rUpdater is null");
            return (Criteria) this;
        }

        public Criteria andRupdaterIsNotNull() {
            addCriterion("rUpdater is not null");
            return (Criteria) this;
        }

        public Criteria andRupdaterEqualTo(Integer value) {
            addCriterion("rUpdater =", value, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterNotEqualTo(Integer value) {
            addCriterion("rUpdater <>", value, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterGreaterThan(Integer value) {
            addCriterion("rUpdater >", value, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("rUpdater >=", value, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterLessThan(Integer value) {
            addCriterion("rUpdater <", value, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterLessThanOrEqualTo(Integer value) {
            addCriterion("rUpdater <=", value, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterIn(List<Integer> values) {
            addCriterion("rUpdater in", values, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterNotIn(List<Integer> values) {
            addCriterion("rUpdater not in", values, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterBetween(Integer value1, Integer value2) {
            addCriterion("rUpdater between", value1, value2, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRupdaterNotBetween(Integer value1, Integer value2) {
            addCriterion("rUpdater not between", value1, value2, "rupdater");
            return (Criteria) this;
        }

        public Criteria andRviewsIsNull() {
            addCriterion("rViews is null");
            return (Criteria) this;
        }

        public Criteria andRviewsIsNotNull() {
            addCriterion("rViews is not null");
            return (Criteria) this;
        }

        public Criteria andRviewsEqualTo(Integer value) {
            addCriterion("rViews =", value, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsNotEqualTo(Integer value) {
            addCriterion("rViews <>", value, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsGreaterThan(Integer value) {
            addCriterion("rViews >", value, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("rViews >=", value, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsLessThan(Integer value) {
            addCriterion("rViews <", value, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsLessThanOrEqualTo(Integer value) {
            addCriterion("rViews <=", value, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsIn(List<Integer> values) {
            addCriterion("rViews in", values, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsNotIn(List<Integer> values) {
            addCriterion("rViews not in", values, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsBetween(Integer value1, Integer value2) {
            addCriterion("rViews between", value1, value2, "rviews");
            return (Criteria) this;
        }

        public Criteria andRviewsNotBetween(Integer value1, Integer value2) {
            addCriterion("rViews not between", value1, value2, "rviews");
            return (Criteria) this;
        }

        public Criteria andRenableIsNull() {
            addCriterion("rEnable is null");
            return (Criteria) this;
        }

        public Criteria andRenableIsNotNull() {
            addCriterion("rEnable is not null");
            return (Criteria) this;
        }

        public Criteria andRenableEqualTo(Integer value) {
            addCriterion("rEnable =", value, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableNotEqualTo(Integer value) {
            addCriterion("rEnable <>", value, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableGreaterThan(Integer value) {
            addCriterion("rEnable >", value, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("rEnable >=", value, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableLessThan(Integer value) {
            addCriterion("rEnable <", value, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableLessThanOrEqualTo(Integer value) {
            addCriterion("rEnable <=", value, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableIn(List<Integer> values) {
            addCriterion("rEnable in", values, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableNotIn(List<Integer> values) {
            addCriterion("rEnable not in", values, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableBetween(Integer value1, Integer value2) {
            addCriterion("rEnable between", value1, value2, "renable");
            return (Criteria) this;
        }

        public Criteria andRenableNotBetween(Integer value1, Integer value2) {
            addCriterion("rEnable not between", value1, value2, "renable");
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