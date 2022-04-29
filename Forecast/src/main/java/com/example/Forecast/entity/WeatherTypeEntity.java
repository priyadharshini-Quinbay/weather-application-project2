package com.example.Forecast.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WeatherTypeEntity {
@Id
private String id;
    private double forecastNumber;
    private String type;
    public WeatherTypeEntity(double forecastNumber, String type) {
        this.forecastNumber = forecastNumber;
        this.type = type;
    }

    public WeatherTypeEntity() {

    }

    public WeatherTypeEntity(String id, double forecastNumber, String type) {

        this.id = id;
        this.forecastNumber = forecastNumber;
        this.type = type;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getForecastNumber() {
        return forecastNumber;
    }

    public void setForecastNumber(double forecastNumber) {
        this.forecastNumber = forecastNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


