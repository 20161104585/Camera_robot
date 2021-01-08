package com.imnu.mm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImageExample() {
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

        public Criteria andImgidIsNull() {
            addCriterion("imgID is null");
            return (Criteria) this;
        }

        public Criteria andImgidIsNotNull() {
            addCriterion("imgID is not null");
            return (Criteria) this;
        }

        public Criteria andImgidEqualTo(Integer value) {
            addCriterion("imgID =", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotEqualTo(Integer value) {
            addCriterion("imgID <>", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidGreaterThan(Integer value) {
            addCriterion("imgID >", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("imgID >=", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLessThan(Integer value) {
            addCriterion("imgID <", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLessThanOrEqualTo(Integer value) {
            addCriterion("imgID <=", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidIn(List<Integer> values) {
            addCriterion("imgID in", values, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotIn(List<Integer> values) {
            addCriterion("imgID not in", values, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidBetween(Integer value1, Integer value2) {
            addCriterion("imgID between", value1, value2, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotBetween(Integer value1, Integer value2) {
            addCriterion("imgID not between", value1, value2, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgnameIsNull() {
            addCriterion("imgName is null");
            return (Criteria) this;
        }

        public Criteria andImgnameIsNotNull() {
            addCriterion("imgName is not null");
            return (Criteria) this;
        }

        public Criteria andImgnameEqualTo(String value) {
            addCriterion("imgName =", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotEqualTo(String value) {
            addCriterion("imgName <>", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameGreaterThan(String value) {
            addCriterion("imgName >", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameGreaterThanOrEqualTo(String value) {
            addCriterion("imgName >=", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameLessThan(String value) {
            addCriterion("imgName <", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameLessThanOrEqualTo(String value) {
            addCriterion("imgName <=", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameLike(String value) {
            addCriterion("imgName like", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotLike(String value) {
            addCriterion("imgName not like", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameIn(List<String> values) {
            addCriterion("imgName in", values, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotIn(List<String> values) {
            addCriterion("imgName not in", values, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameBetween(String value1, String value2) {
            addCriterion("imgName between", value1, value2, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotBetween(String value1, String value2) {
            addCriterion("imgName not between", value1, value2, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeIsNull() {
            addCriterion("imgDatetime is null");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeIsNotNull() {
            addCriterion("imgDatetime is not null");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeEqualTo(Date value) {
            addCriterion("imgDatetime =", value, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeNotEqualTo(Date value) {
            addCriterion("imgDatetime <>", value, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeGreaterThan(Date value) {
            addCriterion("imgDatetime >", value, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("imgDatetime >=", value, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeLessThan(Date value) {
            addCriterion("imgDatetime <", value, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("imgDatetime <=", value, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeIn(List<Date> values) {
            addCriterion("imgDatetime in", values, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeNotIn(List<Date> values) {
            addCriterion("imgDatetime not in", values, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeBetween(Date value1, Date value2) {
            addCriterion("imgDatetime between", value1, value2, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andImgdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("imgDatetime not between", value1, value2, "imgdatetime");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
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