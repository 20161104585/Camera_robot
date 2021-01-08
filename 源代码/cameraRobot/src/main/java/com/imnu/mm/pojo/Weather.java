package com.imnu.mm.pojo;

public class Weather {
    private Integer weatherid;

    private String temperature;

    private String humidity;

    private String rainfall;

    public Integer getWeatherid() {
        return weatherid;
    }

    public void setWeatherid(Integer weatherid) {
        this.weatherid = weatherid;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall == null ? null : rainfall.trim();
    }
}