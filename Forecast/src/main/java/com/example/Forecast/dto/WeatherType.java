package com.example.Forecast.dto;

public class WeatherType {

    String id;
    double forecastNumber;
    String type;

    public WeatherType(double forecastNumber, String type) {
        this.forecastNumber = forecastNumber;
        this.type = type;
    }

    public WeatherType() {

    }

    public WeatherType(String id, double forecastNumber, String type) {

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
