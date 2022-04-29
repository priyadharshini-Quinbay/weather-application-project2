package com.example.Forecast.service;


import com.example.Forecast.dto.CurrentHourStatus;
import com.example.Forecast.entity.CurrentHourStatusEntity;
import com.example.Forecast.entity.CurrentWeekStatusEntity;
import com.example.Forecast.entity.WeatherImageEntity;

import java.util.List;
import java.util.Optional;

public interface WeatherService {
//
    Optional<CurrentHourStatusEntity> getCurrentWeather(String city, String date, int time) ;
    List<CurrentWeekStatusEntity> getCurrentNextSix(String city, String date) ;
List<CurrentHourStatusEntity> getCurrentRange(String city, String date,int starttime) ;
    List<WeatherImageEntity> getImage1(String weather, int i);
    void addImage(WeatherImageEntity data);
    //    List<Ads> getAds() ;
//    List<Brands> getBrands() ;
//
//
//    Ads addAds(Ads ads);
//    Brands addBrands(Brands ads);
//
//    List<LikeAds> getAllLikes() ;
//
//    LikeAds addLikes(LikeAds like);
//
//    List<Analysis> Analysis() ;
//    List<Analysis> Analysis2() ;
//    List<Analysis> Analysis3() ;
//    List<Analysis> Analysis4() ;
//
//
//    List<UserEntity> getUser() ;
//    ReturnAfterSavingUser addUser(UserEntity like);
    void addWeatherHour(CurrentHourStatusEntity weather);
    void addWeatherWeek(CurrentWeekStatusEntity weather);

//    CurrentHourStatusEntity updateWeather(CurrentHourStatusEntity weather);

}
