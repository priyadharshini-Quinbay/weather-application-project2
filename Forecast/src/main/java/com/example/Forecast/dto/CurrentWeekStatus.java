package com.example.Forecast.dto;

import java.util.Date;

public class CurrentWeekStatus {
    String id;
    String city;
    Float altitude;
    Date date;
    Float avgHumidity;
    Float avgPrecipitation;
    Float avgTemperature;
    Float maxTemperature;
    Float minTemperature;
    String weatherType;

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public CurrentWeekStatus(String city, Float altitude, Date date, Float avgHumidity, Float avgPrecipitation, Float avgTemperature, Float maxTemperature, Float minTemperature, String weatherType) {
        this.city = city;
        this.altitude = altitude;
        this.date = date;
        this.avgHumidity = avgHumidity;
        this.avgPrecipitation = avgPrecipitation;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.weatherType = weatherType;
    }

    public CurrentWeekStatus() {

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(Float avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public Float getAvgPrecipitation() {
        return avgPrecipitation;
    }

    public void setAvgPrecipitation(Float avgPrecipitation) {
        this.avgPrecipitation = avgPrecipitation;
    }

    public Float getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(Float avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public Float getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Float getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public CurrentWeekStatus(String id, String city, Date date, Float avgHumidity, Float avgPrecipitation, Float avgTemperature, Float maxTemperature, Float minTemperature) {

        this.id = id;
        this.city = city;
        this.date = date;
        this.avgHumidity = avgHumidity;
        this.avgPrecipitation = avgPrecipitation;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }
}
