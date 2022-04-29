package com.example.Forecast.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WeatherImageEntity {
@Id
    String id;
    String weather;
    int i;
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public WeatherImageEntity() {

    }

    public WeatherImageEntity(String weather, int i, String image) {

        this.weather = weather;
        this.i = i;
        this.image = image;
    }

    public WeatherImageEntity(String id, String weather, int i, String image) {

        this.id = id;
        this.weather = weather;
        this.i = i;
        this.image = image;
    }
}
