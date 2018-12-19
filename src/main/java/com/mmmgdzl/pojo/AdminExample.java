package com.mmmgdzl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAaccountIsNull() {
            addCriterion("aAccount is null");
            return (Criteria) this;
        }

        public Criteria andAaccountIsNotNull() {
            addCriterion("aAccount is not null");
            return (Criteria) this;
        }

        public Criteria andAaccountEqualTo(String value) {
            addCriterion("aAccount =", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountNotEqualTo(String value) {
            addCriterion("aAccount <>", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountGreaterThan(String value) {
            addCriterion("aAccount >", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountGreaterThanOrEqualTo(String value) {
            addCriterion("aAccount >=", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountLessThan(String value) {
            addCriterion("aAccount <", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountLessThanOrEqualTo(String value) {
            addCriterion("aAccount <=", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountLike(String value) {
            addCriterion("aAccount like", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountNotLike(String value) {
            addCriterion("aAccount not like", value, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountIn(List<String> values) {
            addCriterion("aAccount in", values, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountNotIn(List<String> values) {
            addCriterion("aAccount not in", values, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountBetween(String value1, String value2) {
            addCriterion("aAccount between", value1, value2, "aaccount");
            return (Criteria) this;
        }

        public Criteria andAaccountNotBetween(String value1, String value2) {
            addCriterion("aAccount not between", value1, value2, "aaccount");
            return (Criteria) this;
        }

        public Criteria andApasswordIsNull() {
            addCriterion("aPassword is null");
            return (Criteria) this;
        }

        public Criteria andApasswordIsNotNull() {
            addCriterion("aPassword is not null");
            return (Criteria) this;
        }

        public Criteria andApasswordEqualTo(String value) {
            addCriterion("aPassword =", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotEqualTo(String value) {
            addCriterion("aPassword <>", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordGreaterThan(String value) {
            addCriterion("aPassword >", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordGreaterThanOrEqualTo(String value) {
            addCriterion("aPassword >=", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordLessThan(String value) {
            addCriterion("aPassword <", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordLessThanOrEqualTo(String value) {
            addCriterion("aPassword <=", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordLike(String value) {
            addCriterion("aPassword like", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotLike(String value) {
            addCriterion("aPassword not like", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordIn(List<String> values) {
            addCriterion("aPassword in", values, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotIn(List<String> values) {
            addCriterion("aPassword not in", values, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordBetween(String value1, String value2) {
            addCriterion("aPassword between", value1, value2, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotBetween(String value1, String value2) {
            addCriterion("aPassword not between", value1, value2, "apassword");
            return (Criteria) this;
        }

        public Criteria andAlevelIsNull() {
            addCriterion("aLevel is null");
            return (Criteria) this;
        }

        public Criteria andAlevelIsNotNull() {
            addCriterion("aLevel is not null");
            return (Criteria) this;
        }

        public Criteria andAlevelEqualTo(Integer value) {
            addCriterion("aLevel =", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotEqualTo(Integer value) {
            addCriterion("aLevel <>", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelGreaterThan(Integer value) {
            addCriterion("aLevel >", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("aLevel >=", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelLessThan(Integer value) {
            addCriterion("aLevel <", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelLessThanOrEqualTo(Integer value) {
            addCriterion("aLevel <=", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelIn(List<Integer> values) {
            addCriterion("aLevel in", values, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotIn(List<Integer> values) {
            addCriterion("aLevel not in", values, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelBetween(Integer value1, Integer value2) {
            addCriterion("aLevel between", value1, value2, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("aLevel not between", value1, value2, "alevel");
            return (Criteria) this;
        }

        public Criteria andAenableIsNull() {
            addCriterion("aEnable is null");
            return (Criteria) this;
        }

        public Criteria andAenableIsNotNull() {
            addCriterion("aEnable is not null");
            return (Criteria) this;
        }

        public Criteria andAenableEqualTo(Integer value) {
            addCriterion("aEnable =", value, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableNotEqualTo(Integer value) {
            addCriterion("aEnable <>", value, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableGreaterThan(Integer value) {
            addCriterion("aEnable >", value, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("aEnable >=", value, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableLessThan(Integer value) {
            addCriterion("aEnable <", value, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableLessThanOrEqualTo(Integer value) {
            addCriterion("aEnable <=", value, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableIn(List<Integer> values) {
            addCriterion("aEnable in", values, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableNotIn(List<Integer> values) {
            addCriterion("aEnable not in", values, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableBetween(Integer value1, Integer value2) {
            addCriterion("aEnable between", value1, value2, "aenable");
            return (Criteria) this;
        }

        public Criteria andAenableNotBetween(Integer value1, Integer value2) {
            addCriterion("aEnable not between", value1, value2, "aenable");
            return (Criteria) this;
        }

        public Criteria andAactiveIsNull() {
            addCriterion("aActive is null");
            return (Criteria) this;
        }

        public Criteria andAactiveIsNotNull() {
            addCriterion("aActive is not null");
            return (Criteria) this;
        }

        public Criteria andAactiveEqualTo(Integer value) {
            addCriterion("aActive =", value, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveNotEqualTo(Integer value) {
            addCriterion("aActive <>", value, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveGreaterThan(Integer value) {
            addCriterion("aActive >", value, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("aActive >=", value, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveLessThan(Integer value) {
            addCriterion("aActive <", value, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveLessThanOrEqualTo(Integer value) {
            addCriterion("aActive <=", value, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveIn(List<Integer> values) {
            addCriterion("aActive in", values, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveNotIn(List<Integer> values) {
            addCriterion("aActive not in", values, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveBetween(Integer value1, Integer value2) {
            addCriterion("aActive between", value1, value2, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactiveNotBetween(Integer value1, Integer value2) {
            addCriterion("aActive not between", value1, value2, "aactive");
            return (Criteria) this;
        }

        public Criteria andAactivecodeIsNull() {
            addCriterion("aActiveCode is null");
            return (Criteria) this;
        }

        public Criteria andAactivecodeIsNotNull() {
            addCriterion("aActiveCode is not null");
            return (Criteria) this;
        }

        public Criteria andAactivecodeEqualTo(String value) {
            addCriterion("aActiveCode =", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeNotEqualTo(String value) {
            addCriterion("aActiveCode <>", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeGreaterThan(String value) {
            addCriterion("aActiveCode >", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeGreaterThanOrEqualTo(String value) {
            addCriterion("aActiveCode >=", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeLessThan(String value) {
            addCriterion("aActiveCode <", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeLessThanOrEqualTo(String value) {
            addCriterion("aActiveCode <=", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeLike(String value) {
            addCriterion("aActiveCode like", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeNotLike(String value) {
            addCriterion("aActiveCode not like", value, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeIn(List<String> values) {
            addCriterion("aActiveCode in", values, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeNotIn(List<String> values) {
            addCriterion("aActiveCode not in", values, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeBetween(String value1, String value2) {
            addCriterion("aActiveCode between", value1, value2, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAactivecodeNotBetween(String value1, String value2) {
            addCriterion("aActiveCode not between", value1, value2, "aactivecode");
            return (Criteria) this;
        }

        public Criteria andAcreatedateIsNull() {
            addCriterion("aCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andAcreatedateIsNotNull() {
            addCriterion("aCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andAcreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("aCreateDate =", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("aCreateDate <>", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("aCreateDate >", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("aCreateDate >=", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateLessThan(Date value) {
            addCriterionForJDBCDate("aCreateDate <", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("aCreateDate <=", value, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("aCreateDate in", values, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("aCreateDate not in", values, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("aCreateDate between", value1, value2, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAcreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("aCreateDate not between", value1, value2, "acreatedate");
            return (Criteria) this;
        }

        public Criteria andAnameIsNull() {
            addCriterion("aName is null");
            return (Criteria) this;
        }

        public Criteria andAnameIsNotNull() {
            addCriterion("aName is not null");
            return (Criteria) this;
        }

        public Criteria andAnameEqualTo(String value) {
            addCriterion("aName =", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotEqualTo(String value) {
            addCriterion("aName <>", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThan(String value) {
            addCriterion("aName >", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThanOrEqualTo(String value) {
            addCriterion("aName >=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThan(String value) {
            addCriterion("aName <", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThanOrEqualTo(String value) {
            addCriterion("aName <=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLike(String value) {
            addCriterion("aName like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotLike(String value) {
            addCriterion("aName not like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameIn(List<String> values) {
            addCriterion("aName in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotIn(List<String> values) {
            addCriterion("aName not in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameBetween(String value1, String value2) {
            addCriterion("aName between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotBetween(String value1, String value2) {
            addCriterion("aName not between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAgenderIsNull() {
            addCriterion("aGender is null");
            return (Criteria) this;
        }

        public Criteria andAgenderIsNotNull() {
            addCriterion("aGender is not null");
            return (Criteria) this;
        }

        public Criteria andAgenderEqualTo(Integer value) {
            addCriterion("aGender =", value, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderNotEqualTo(Integer value) {
            addCriterion("aGender <>", value, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderGreaterThan(Integer value) {
            addCriterion("aGender >", value, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("aGender >=", value, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderLessThan(Integer value) {
            addCriterion("aGender <", value, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderLessThanOrEqualTo(Integer value) {
            addCriterion("aGender <=", value, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderIn(List<Integer> values) {
            addCriterion("aGender in", values, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderNotIn(List<Integer> values) {
            addCriterion("aGender not in", values, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderBetween(Integer value1, Integer value2) {
            addCriterion("aGender between", value1, value2, "agender");
            return (Criteria) this;
        }

        public Criteria andAgenderNotBetween(Integer value1, Integer value2) {
            addCriterion("aGender not between", value1, value2, "agender");
            return (Criteria) this;
        }

        public Criteria andAmailIsNull() {
            addCriterion("aMail is null");
            return (Criteria) this;
        }

        public Criteria andAmailIsNotNull() {
            addCriterion("aMail is not null");
            return (Criteria) this;
        }

        public Criteria andAmailEqualTo(String value) {
            addCriterion("aMail =", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailNotEqualTo(String value) {
            addCriterion("aMail <>", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailGreaterThan(String value) {
            addCriterion("aMail >", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailGreaterThanOrEqualTo(String value) {
            addCriterion("aMail >=", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailLessThan(String value) {
            addCriterion("aMail <", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailLessThanOrEqualTo(String value) {
            addCriterion("aMail <=", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailLike(String value) {
            addCriterion("aMail like", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailNotLike(String value) {
            addCriterion("aMail not like", value, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailIn(List<String> values) {
            addCriterion("aMail in", values, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailNotIn(List<String> values) {
            addCriterion("aMail not in", values, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailBetween(String value1, String value2) {
            addCriterion("aMail between", value1, value2, "amail");
            return (Criteria) this;
        }

        public Criteria andAmailNotBetween(String value1, String value2) {
            addCriterion("aMail not between", value1, value2, "amail");
            return (Criteria) this;
        }

        public Criteria andAphoneIsNull() {
            addCriterion("aPhone is null");
            return (Criteria) this;
        }

        public Criteria andAphoneIsNotNull() {
            addCriterion("aPhone is not null");
            return (Criteria) this;
        }

        public Criteria andAphoneEqualTo(String value) {
            addCriterion("aPhone =", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotEqualTo(String value) {
            addCriterion("aPhone <>", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneGreaterThan(String value) {
            addCriterion("aPhone >", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneGreaterThanOrEqualTo(String value) {
            addCriterion("aPhone >=", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneLessThan(String value) {
            addCriterion("aPhone <", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneLessThanOrEqualTo(String value) {
            addCriterion("aPhone <=", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneLike(String value) {
            addCriterion("aPhone like", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotLike(String value) {
            addCriterion("aPhone not like", value, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneIn(List<String> values) {
            addCriterion("aPhone in", values, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotIn(List<String> values) {
            addCriterion("aPhone not in", values, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneBetween(String value1, String value2) {
            addCriterion("aPhone between", value1, value2, "aphone");
            return (Criteria) this;
        }

        public Criteria andAphoneNotBetween(String value1, String value2) {
            addCriterion("aPhone not between", value1, value2, "aphone");
            return (Criteria) this;
        }

        public Criteria andAheadimgIsNull() {
            addCriterion("aHeadImg is null");
            return (Criteria) this;
        }

        public Criteria andAheadimgIsNotNull() {
            addCriterion("aHeadImg is not null");
            return (Criteria) this;
        }

        public Criteria andAheadimgEqualTo(String value) {
            addCriterion("aHeadImg =", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgNotEqualTo(String value) {
            addCriterion("aHeadImg <>", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgGreaterThan(String value) {
            addCriterion("aHeadImg >", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgGreaterThanOrEqualTo(String value) {
            addCriterion("aHeadImg >=", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgLessThan(String value) {
            addCriterion("aHeadImg <", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgLessThanOrEqualTo(String value) {
            addCriterion("aHeadImg <=", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgLike(String value) {
            addCriterion("aHeadImg like", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgNotLike(String value) {
            addCriterion("aHeadImg not like", value, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgIn(List<String> values) {
            addCriterion("aHeadImg in", values, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgNotIn(List<String> values) {
            addCriterion("aHeadImg not in", values, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgBetween(String value1, String value2) {
            addCriterion("aHeadImg between", value1, value2, "aheadimg");
            return (Criteria) this;
        }

        public Criteria andAheadimgNotBetween(String value1, String value2) {
            addCriterion("aHeadImg not between", value1, value2, "aheadimg");
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