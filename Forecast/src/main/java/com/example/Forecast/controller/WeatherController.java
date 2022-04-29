package com.example.Forecast.controller;


import com.example.Forecast.dto.CurrentHourStatus;
import com.example.Forecast.entity.CurrentHourStatusEntity;
import com.example.Forecast.entity.CurrentWeekStatusEntity;
import com.example.Forecast.entity.WeatherImageEntity;
import com.example.Forecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/Weather")
public class WeatherController {



    @Autowired
    WeatherService weather;


    @GetMapping(value="/getCurrent/{city}/{date}/{time}")
    public Optional<CurrentHourStatusEntity> getCurrentWeather1(@PathVariable(value="city") String city,@PathVariable(value="date") String date,@PathVariable(value="time") int time) {
//
        Optional<CurrentHourStatusEntity> w=weather.getCurrentWeather(city,date,time);
        return w;
    }
    @GetMapping(value="/getRange/{city}/{date}/{time}")
    public List<CurrentHourStatusEntity> getRange1(@PathVariable(value="city") String city,@PathVariable(value="date") String date,@PathVariable(value="time") int time) {
//
        List<CurrentHourStatusEntity> w=weather.getCurrentRange(city,date,time);
        return w;
    }

    @GetMapping(value="/getNextSix/{city}/{date}")
    public List<CurrentWeekStatusEntity> getSix(@PathVariable(value="city") String city,@PathVariable(value="date") String date) {
//
        List<CurrentWeekStatusEntity> w=weather.getCurrentNextSix(city,date);
        return w;
    }
    @GetMapping(value="/getImage/{weather}/{i}")
    public List<WeatherImageEntity> getSix1(@PathVariable(value="weather") String weather1,@PathVariable(value="i") int i) {
//        System.out.println(formatter.format(date));
        List<WeatherImageEntity> w=weather.getImage1(weather1,i);
        return w;
    }
    @PostMapping("/Image")
    public void addImage(@RequestBody WeatherImageEntity data) {

        weather.addImage(data);
    }
    @PostMapping("/Hour")
    public void addHour(@RequestBody CurrentHourStatusEntity data) {

        weather.addWeatherHour(data);
    }
    @PostMapping("/Week")
    public void addWeek(@RequestBody CurrentWeekStatusEntity data) {

        weather.addWeatherWeek(data);
    }

    @GetMapping(value="/getCurrent/{city}")
    public Optional<CurrentHourStatusEntity> getCurrentWeather(@PathVariable(value="city") String city) {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        SimpleDateFormat timeformatter = new SimpleDateFormat("HH");
        Date time = new Date();

        Optional<CurrentHourStatusEntity> w=weather.getCurrentWeather(city,dateformatter.format(date), Integer.parseInt(timeformatter.format(time)));
        return w;
    }
    @GetMapping(value="/getRange/{city}")
    public  List<CurrentHourStatusEntity> getRange(@PathVariable(value="city") String city) {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        SimpleDateFormat timeformatter = new SimpleDateFormat("HH");
        Date time = new Date();

        List<CurrentHourStatusEntity> w=weather.getCurrentRange(city,dateformatter.format(date), Integer.parseInt(timeformatter.format(time)));
        return w;
    }

    @GetMapping(value="/getNextSix/{city}")
    public  List<CurrentWeekStatusEntity> getSix(@PathVariable(value="city") String city) {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
//        System.out.println(formatter.format(date));
        List<CurrentWeekStatusEntity> w=weather.getCurrentNextSix(city,dateformatter.format(date));
        return w;
    }

}
