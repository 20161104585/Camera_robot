package com.imnu.mm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
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

        public Criteria andVideoidIsNull() {
            addCriterion("videoID is null");
            return (Criteria) this;
        }

        public Criteria andVideoidIsNotNull() {
            addCriterion("videoID is not null");
            return (Criteria) this;
        }

        public Criteria andVideoidEqualTo(Integer value) {
            addCriterion("videoID =", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotEqualTo(Integer value) {
            addCriterion("videoID <>", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidGreaterThan(Integer value) {
            addCriterion("videoID >", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("videoID >=", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidLessThan(Integer value) {
            addCriterion("videoID <", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidLessThanOrEqualTo(Integer value) {
            addCriterion("videoID <=", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidIn(List<Integer> values) {
            addCriterion("videoID in", values, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotIn(List<Integer> values) {
            addCriterion("videoID not in", values, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidBetween(Integer value1, Integer value2) {
            addCriterion("videoID between", value1, value2, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotBetween(Integer value1, Integer value2) {
            addCriterion("videoID not between", value1, value2, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideonameIsNull() {
            addCriterion("videoName is null");
            return (Criteria) this;
        }

        public Criteria andVideonameIsNotNull() {
            addCriterion("videoName is not null");
            return (Criteria) this;
        }

        public Criteria andVideonameEqualTo(String value) {
            addCriterion("videoName =", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameNotEqualTo(String value) {
            addCriterion("videoName <>", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameGreaterThan(String value) {
            addCriterion("videoName >", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameGreaterThanOrEqualTo(String value) {
            addCriterion("videoName >=", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameLessThan(String value) {
            addCriterion("videoName <", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameLessThanOrEqualTo(String value) {
            addCriterion("videoName <=", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameLike(String value) {
            addCriterion("videoName like", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameNotLike(String value) {
            addCriterion("videoName not like", value, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameIn(List<String> values) {
            addCriterion("videoName in", values, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameNotIn(List<String> values) {
            addCriterion("videoName not in", values, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameBetween(String value1, String value2) {
            addCriterion("videoName between", value1, value2, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideonameNotBetween(String value1, String value2) {
            addCriterion("videoName not between", value1, value2, "videoname");
            return (Criteria) this;
        }

        public Criteria andVideosizeIsNull() {
            addCriterion("videoSize is null");
            return (Criteria) this;
        }

        public Criteria andVideosizeIsNotNull() {
            addCriterion("videoSize is not null");
            return (Criteria) this;
        }

        public Criteria andVideosizeEqualTo(String value) {
            addCriterion("videoSize =", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeNotEqualTo(String value) {
            addCriterion("videoSize <>", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeGreaterThan(String value) {
            addCriterion("videoSize >", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeGreaterThanOrEqualTo(String value) {
            addCriterion("videoSize >=", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeLessThan(String value) {
            addCriterion("videoSize <", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeLessThanOrEqualTo(String value) {
            addCriterion("videoSize <=", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeLike(String value) {
            addCriterion("videoSize like", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeNotLike(String value) {
            addCriterion("videoSize not like", value, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeIn(List<String> values) {
            addCriterion("videoSize in", values, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeNotIn(List<String> values) {
            addCriterion("videoSize not in", values, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeBetween(String value1, String value2) {
            addCriterion("videoSize between", value1, value2, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideosizeNotBetween(String value1, String value2) {
            addCriterion("videoSize not between", value1, value2, "videosize");
            return (Criteria) this;
        }

        public Criteria andVideotypeIsNull() {
            addCriterion("videoType is null");
            return (Criteria) this;
        }

        public Criteria andVideotypeIsNotNull() {
            addCriterion("videoType is not null");
            return (Criteria) this;
        }

        public Criteria andVideotypeEqualTo(String value) {
            addCriterion("videoType =", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeNotEqualTo(String value) {
            addCriterion("videoType <>", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeGreaterThan(String value) {
            addCriterion("videoType >", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeGreaterThanOrEqualTo(String value) {
            addCriterion("videoType >=", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeLessThan(String value) {
            addCriterion("videoType <", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeLessThanOrEqualTo(String value) {
            addCriterion("videoType <=", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeLike(String value) {
            addCriterion("videoType like", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeNotLike(String value) {
            addCriterion("videoType not like", value, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeIn(List<String> values) {
            addCriterion("videoType in", values, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeNotIn(List<String> values) {
            addCriterion("videoType not in", values, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeBetween(String value1, String value2) {
            addCriterion("videoType between", value1, value2, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideotypeNotBetween(String value1, String value2) {
            addCriterion("videoType not between", value1, value2, "videotype");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeIsNull() {
            addCriterion("videoDatetime is null");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeIsNotNull() {
            addCriterion("videoDatetime is not null");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeEqualTo(Date value) {
            addCriterion("videoDatetime =", value, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeNotEqualTo(Date value) {
            addCriterion("videoDatetime <>", value, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeGreaterThan(Date value) {
            addCriterion("videoDatetime >", value, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("videoDatetime >=", value, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeLessThan(Date value) {
            addCriterion("videoDatetime <", value, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeLessThanOrEqualTo(Date value) {
            addCriterion("videoDatetime <=", value, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeIn(List<Date> values) {
            addCriterion("videoDatetime in", values, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeNotIn(List<Date> values) {
            addCriterion("videoDatetime not in", values, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeBetween(Date value1, Date value2) {
            addCriterion("videoDatetime between", value1, value2, "videodatetime");
            return (Criteria) this;
        }

        public Criteria andVideodatetimeNotBetween(Date value1, Date value2) {
            addCriterion("videoDatetime not between", value1, value2, "videodatetime");
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