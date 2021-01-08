package com.imnu.mm.pojo;

import java.util.ArrayList;
import java.util.List;

public class WeatherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeatherExample() {
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

        public Criteria andWeatheridIsNull() {
            addCriterion("weatherid is null");
            return (Criteria) this;
        }

        public Criteria andWeatheridIsNotNull() {
            addCriterion("weatherid is not null");
            return (Criteria) this;
        }

        public Criteria andWeatheridEqualTo(Integer value) {
            addCriterion("weatherid =", value, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridNotEqualTo(Integer value) {
            addCriterion("weatherid <>", value, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridGreaterThan(Integer value) {
            addCriterion("weatherid >", value, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("weatherid >=", value, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridLessThan(Integer value) {
            addCriterion("weatherid <", value, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridLessThanOrEqualTo(Integer value) {
            addCriterion("weatherid <=", value, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridIn(List<Integer> values) {
            addCriterion("weatherid in", values, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridNotIn(List<Integer> values) {
            addCriterion("weatherid not in", values, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridBetween(Integer value1, Integer value2) {
            addCriterion("weatherid between", value1, value2, "weatherid");
            return (Criteria) this;
        }

        public Criteria andWeatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("weatherid not between", value1, value2, "weatherid");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNull() {
            addCriterion("humidity is null");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNotNull() {
            addCriterion("humidity is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityEqualTo(String value) {
            addCriterion("humidity =", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotEqualTo(String value) {
            addCriterion("humidity <>", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThan(String value) {
            addCriterion("humidity >", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThanOrEqualTo(String value) {
            addCriterion("humidity >=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThan(String value) {
            addCriterion("humidity <", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThanOrEqualTo(String value) {
            addCriterion("humidity <=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLike(String value) {
            addCriterion("humidity like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotLike(String value) {
            addCriterion("humidity not like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityIn(List<String> values) {
            addCriterion("humidity in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotIn(List<String> values) {
            addCriterion("humidity not in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityBetween(String value1, String value2) {
            addCriterion("humidity between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotBetween(String value1, String value2) {
            addCriterion("humidity not between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andRainfallIsNull() {
            addCriterion("rainfall is null");
            return (Criteria) this;
        }

        public Criteria andRainfallIsNotNull() {
            addCriterion("rainfall is not null");
            return (Criteria) this;
        }

        public Criteria andRainfallEqualTo(String value) {
            addCriterion("rainfall =", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallNotEqualTo(String value) {
            addCriterion("rainfall <>", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallGreaterThan(String value) {
            addCriterion("rainfall >", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallGreaterThanOrEqualTo(String value) {
            addCriterion("rainfall >=", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallLessThan(String value) {
            addCriterion("rainfall <", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallLessThanOrEqualTo(String value) {
            addCriterion("rainfall <=", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallLike(String value) {
            addCriterion("rainfall like", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallNotLike(String value) {
            addCriterion("rainfall not like", value, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallIn(List<String> values) {
            addCriterion("rainfall in", values, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallNotIn(List<String> values) {
            addCriterion("rainfall not in", values, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallBetween(String value1, String value2) {
            addCriterion("rainfall between", value1, value2, "rainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallNotBetween(String value1, String value2) {
            addCriterion("rainfall not between", value1, value2, "rainfall");
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