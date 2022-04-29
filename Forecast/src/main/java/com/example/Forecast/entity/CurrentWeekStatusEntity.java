package com.example.Forecast.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CurrentWeekStatusEntity {
    @Id
    String id;
    String city;
    Float altitude;

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    String date;
    Float avgHumidity;
    Float avgPrecipitation;
    Float avgTemperature;
    Float maxTemperature;
    Float minTemperature;
    String weatherType;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public CurrentWeekStatusEntity(String id, String city, Float altitude, String date, Float avgHumidity, Float avgPrecipitation, Float avgTemperature, Float maxTemperature, Float minTemperature, String weatherType) {
        this.id = id;
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

    public CurrentWeekStatusEntity(String city, Float altitude, String date, Float avgHumidity, Float avgPrecipitation, Float avgTemperature, Float maxTemperature, Float minTemperature, String weatherType) {

        this.city = city;
        this.date = date;
        this.avgHumidity = avgHumidity;
        this.avgPrecipitation = avgPrecipitation;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.weatherType = weatherType;
        this.altitude = altitude;

    }

    public CurrentWeekStatusEntity() {

    }

}
