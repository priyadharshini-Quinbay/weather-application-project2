package com.example.Forecast.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class CurrentHourStatusEntity {
    @Id
    String id;
    String city;
    Float altitude;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String date;

    int startTime;
    Float humidity;
    Float precipitation;
    String weatherType;
    Float temperature;
    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public CurrentHourStatusEntity() {
    }

    public CurrentHourStatusEntity(String city, Float altitude, String date, int startTime, Float humidity, Float precipitation, String weatherType, Float temperature) {

        this.city = city;
        this.altitude = altitude;
        this.date = date;
        this.startTime = startTime;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.temperature = temperature;
        this.weatherType = weatherType;
    }

    public CurrentHourStatusEntity(String id, String city, Float altitude, String date, int startTime, Float humidity, Float precipitation, String weatherType, Float temperature) {

        this.id = id;
        this.city = city;
        this.altitude = altitude;
        this.date = date;
        this.startTime = startTime;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.temperature = temperature;
        this.weatherType = weatherType;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Float precipitation) {
        this.precipitation = precipitation;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }
}