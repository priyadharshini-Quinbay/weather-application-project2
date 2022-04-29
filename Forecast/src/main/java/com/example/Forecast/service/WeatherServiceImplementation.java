package com.example.Forecast.service;


import com.example.Forecast.entity.CurrentHourStatusEntity;
import com.example.Forecast.entity.CurrentWeekStatusEntity;
import com.example.Forecast.entity.WeatherImageEntity;
import com.example.Forecast.repository.CurrentHourStatusRepo;
import com.example.Forecast.repository.CurrentWeekStatusRepo;
import com.example.Forecast.repository.WeatherImageRepo;
import com.example.Forecast.repository.WeatherTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImplementation implements WeatherService
{


    @Autowired
    CurrentHourStatusRepo currentHourStatusRepo;
    @Autowired
    CurrentWeekStatusRepo currentWeekStatusRepo;
    @Autowired
    WeatherTypeRepo weathertypeRepo;
    @Autowired
    WeatherImageRepo weatherimageeRepo;



    public void addWeatherHour(CurrentHourStatusEntity data) {
//            double z;
        if (data.getAltitude() != null || data.getCity() != null || data.getDate() != null || ((data.getStartTime()>=0)&&(data.getStartTime()<24))|| data.getHumidity() != null || data.getTemperature() != null || data.getPrecipitation() != null) {
            Optional<CurrentHourStatusEntity> ad = currentHourStatusRepo.findFirstByCityAndDateAndStartTime(data.getCity(),data.getDate(), data.getStartTime());
            if (ad.isPresent()) {
                ad.get().setHumidity(data.getHumidity());
                ad.get().setPrecipitation(data.getPrecipitation());
                ad.get().setTemperature(
                        data.getTemperature());
                ad.get().setWeatherType(setWeather(data.getPrecipitation(),data.getStartTime(),data.getTemperature()));
                setCurrentWeek(data);
                currentHourStatusRepo.save(ad.get());
            } else {
                data.setWeatherType(setWeather(data.getPrecipitation(),data.getStartTime(),data.getTemperature()));
                currentHourStatusRepo.save(data);
                setCurrentWeek(data);

            }



        }
    }
    public void addWeatherWeek(CurrentWeekStatusEntity data) {
//            double z;
        if (data.getWeatherType() != null || data.getCity() != null || data.getDate() != null || data.getAltitude() != null || data.getAvgHumidity() != null || data.getMaxTemperature() != null || data.getMinTemperature() != null || data.getAvgPrecipitation() != null||data.getAvgTemperature() != null) {


            data.setWeatherType(setWeather(data.getAvgPrecipitation(),19,data.getAvgTemperature()));

            currentWeekStatusRepo.save(data);
//


        }
    }
    public void addImage(WeatherImageEntity data) {
        if (data.getImage() != null || data.getWeather() != null || data.getImage() != null ) {
            weatherimageeRepo.save(data);
        }
    }
    public List<WeatherImageEntity> getImage1(String weather,int i)
    {
        List<WeatherImageEntity> list=weatherimageeRepo.findByWeatherAndI(weather,i);
        return list;
    }

    public void setCurrentWeek(CurrentHourStatusEntity week)

    {
        int t=0;
         float Pressure = 0,Temperature=0,Humidity=0,maxTemperature=0,minTemperature=week.getTemperature();
        Optional<CurrentWeekStatusEntity> filterrecord = currentWeekStatusRepo.findFirstByCityAndDate(week.getCity(),week.getDate());
        for (CurrentHourStatusEntity current : currentHourStatusRepo.findByCityAndDate(week.getCity(), week.getDate())) {
            t++;
            Pressure += current.getPrecipitation();
            Temperature += current.getTemperature();
            Humidity += current.getHumidity();


            if (maxTemperature < current.getTemperature())
                maxTemperature = current.getTemperature();
            if (minTemperature > current.getTemperature())
                minTemperature = current.getTemperature();

        }
        if (filterrecord.isPresent()) {

            filterrecord.get().setCity(week.getCity());
            filterrecord.get().setAltitude(week.getAltitude());
            filterrecord.get().setDate(week.getDate());
            filterrecord.get().setAvgHumidity(Humidity/t);
            filterrecord.get().setAvgPrecipitation(Pressure/t);
            filterrecord.get().setAvgTemperature(Temperature/t);
            filterrecord.get().setMaxTemperature(maxTemperature);
            filterrecord.get().setMinTemperature(minTemperature);
            filterrecord.get().setWeatherType(setWeather(Pressure/t,19,Temperature/t));
            currentWeekStatusRepo.save(filterrecord.get());
        }
        else {
            CurrentWeekStatusEntity data = new CurrentWeekStatusEntity(week.getCity(), week.getAltitude(), week.getDate(), week.getHumidity(), week.getPrecipitation(), week.getTemperature(), week.getTemperature(), week.getTemperature(), week.getWeatherType());
            data.setWeatherType(setWeather(week.getPrecipitation(),week.getStartTime(),week.getTemperature()));
            currentWeekStatusRepo.save(data);
        }

    }


    public String setWeather(float precipitation,int time,float temperature)
    {


        if(time<18 && precipitation>=0&&precipitation<=6)
          {
              if (precipitation == 0 && temperature > 4)
                  return "sunny";
              else if (precipitation == 0 && temperature < 4)
                  return "partially cloudy";

              else if(precipitation>0&&precipitation<=4&&temperature > 4)
                      return "sunny & clouds";
              else if(precipitation>0&&precipitation<=4&&temperature <4)
                  return "mostly cloudy";

              else if(precipitation>4&&precipitation<=6&&temperature > 4)
                  return "sun showers";
              else if(precipitation>4&&precipitation<=6&&temperature < 4)
                  return "fog";

              else
                  return "not available";
          }
          else if(time>=18&&precipitation>=0&&precipitation<=6) {
              if (precipitation == 0)
                  return "clear";

              else if (precipitation > 0 && precipitation <= 4 && temperature > 4)
                  return "partially cloudy";
              else if (precipitation > 0 && precipitation <= 4 && temperature < 4)
                  return "partially cloudy";

              else if (precipitation > 4 && precipitation <= 6 && temperature > 4)
                  return "showers";
              else if (precipitation > 4 && precipitation <= 6 && temperature < 4)
                  return "fog";

              else
                  return "not available";
          }
          else if(precipitation>6&&precipitation<=10)
          {
              if(temperature>4)
                  return "haze";
              else if(temperature<4)
                  return "mist";
              else
                  return "not available";
          }
          else if(precipitation>10&&precipitation<=15)
          {
              if(temperature>4)
                  return "cloudy";
              else if(temperature<4)
                  return "cloudy";
              else
                  return "not available";
          }
          else if(precipitation>15&&precipitation<=18)
          {
              if(temperature>4)
                  return "mist";
              else if(temperature<4)
                  return "snow hail";
              else
                  return "not available";
          }

          else if(precipitation>18&&precipitation<=22)
          {
              if(temperature>4)
                  return "drizzle";
              else if(temperature<4)
                  return "cloudy showers";
              else
                  return "not available";
          }
          else if(precipitation>22&&precipitation<=28)
          {
              if(temperature>4)
                  return "clouds & thunder";
              else if(temperature<4)
                  return "snowsquall";
              else
                  return "not available";
          }
          else if(precipitation>28&&precipitation<=45)
          {
              if(temperature>4)
                  return "rain";
              else if(temperature<4)
                  return "blizzard";
              else
                  return "not available";
          }
          else if(precipitation>45&&precipitation<=65)
          {
              if(temperature>4)
                  return "heavy rain";
              else if(temperature<4)
                  return "snow flurry";
              else
                  return "not available";
          }
          else if(precipitation>65&&precipitation<=80)
          {
              if(temperature>4)
                  return "thunder & rain";
              else if(temperature<4)
                  return "thundersnow";
              else
                  return "not available";
          }
          else if(precipitation>80&&precipitation<=90)
          {
              if(temperature>4)
                  return "storm";
              else if(temperature<4)
                  return "wintersnow";
              else
                  return "not available";
          }
          else if(precipitation>90&&precipitation<=100)
          {
              if(temperature>4)
                  return "thunderstorm";
              else if(temperature<4)
                  return "snowstorm";
              else
                  return "not available";
          }
          else {
              return "not available";
          }



    }

    public Optional<CurrentHourStatusEntity> getCurrentWeather(String city, String date, int time) {
       return currentHourStatusRepo.findFirstByCityAndDateAndStartTime(city,date,time);
    }
    public List<CurrentWeekStatusEntity> getCurrentNextSix(String city, String date)
    {
        int totalnoofdays=0;
        LocalDate currentDate = LocalDate.parse(date);
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                totalnoofdays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                totalnoofdays = 30;
                break;
            case 2:
                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                    totalnoofdays = 29;
                } else {
                    totalnoofdays = 28;

                }
                break;
            default:
                totalnoofdays = 0;
        }


        List<CurrentWeekStatusEntity> sort=new ArrayList<>();

        List<CurrentWeekStatusEntity> six=currentWeekStatusRepo.findByCity(city) ;
        int tt=day+1;
        int csix=1;
        int check=0;
        Float altitude=0f;
              for(CurrentWeekStatusEntity sorts:six)
              {
                  altitude=sorts.getAltitude();
                  break;
              }
        if(tt==totalnoofdays+1) {
            tt = 1;
            if (month == 12) {
                month = 1;
                year += 1;
            } else {
                month += 1;
            }
        }


        while(tt<=totalnoofdays&&csix<=6) {
            for (CurrentWeekStatusEntity sixs : six) {
                LocalDate getdate = LocalDate.parse(sixs.getDate());
                int getday = getdate.getDayOfMonth();
                int getmonth = getdate.getMonthValue();
                int getyear = getdate.getYear();
                if (getday == tt&&getyear==year&&getmonth==month) {
                    sort.add(sixs);
                        check=1;
                    break;
                }
              }
            if(check==1)
                check=0;

             else {
                 String d=year+"-"+month+"-"+tt;
                 sort.add(new CurrentWeekStatusEntity("not available", city, altitude,d, 0.0f, 0.0f,0.0f,0.0f,0.0f,"not available"));
             }



            if(tt==totalnoofdays){
                tt=1;
                csix++;
                if(month==12)
                {
                    month=1;
                    year+=1;
                }
                else {
                    month+=1;
                }
            }
            else {
            tt++;
            csix++;}
        }
        return sort;
        }


public List<CurrentHourStatusEntity> sortList(String city, String date,int time){
    List<CurrentHourStatusEntity> sort=new ArrayList<>();

    List<CurrentHourStatusEntity> hour=currentHourStatusRepo.findByCityAndDate(city,date) ;
    int tt=time;
    while(tt<24) {
        for (CurrentHourStatusEntity hours : hour) {
            if (hours.getStartTime() == tt) {
                sort.add(hours);
                break;
            }
        }
        tt++;
    }
    return sort;
}
    public List<CurrentHourStatusEntity> getlist(List<CurrentHourStatusEntity> sort,int starttime)
    {
        List<CurrentHourStatusEntity> list=new ArrayList<>();

        Float altitude=0f;
        int t=0,checkpresent=0;
        int current=starttime+1;
        String city="";
        String date="";
        for(CurrentHourStatusEntity sorts:sort)
        {
            altitude=sorts.getAltitude();
            city=sorts.getCity();
            date=sorts.getDate();
            break;
        }
        while (t<6 && current<=23)
        {
            for(CurrentHourStatusEntity sorts:sort)
            {
                if(sorts.getStartTime()==current)
                {
                    list.add(sorts);
                    t++;
                    checkpresent=1;
                    current++;
                    break;
                }
            }
            if(checkpresent!=1) {
                list.add(new CurrentHourStatusEntity("not available",city, altitude, date, current, 0.0f, 0.0f,"not available",0.0f));
                t++;
                current++;
            }
            else
                checkpresent=0;
        }
        return  list;


    }
    public List<CurrentHourStatusEntity> getCurrentRange(String city, String date,int starttime) {
        List<CurrentHourStatusEntity> sort=sortList(city,date,starttime);
        List<CurrentHourStatusEntity> list=getlist(sort,starttime);
        int size=list.size();

        if(size<6)

        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar c = Calendar.getInstance();

            try {
                c.setTime(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            c.add(Calendar.DATE, 1);  // number of days to add

            date = sdf.format(c.getTime());
            sort = sortList(city,date,0);
            List<CurrentHourStatusEntity> list2=getlist(sort,-1);

                for (CurrentHourStatusEntity counters : list2) {
                    if(size<6)
                    {
                    list.add(counters);

                    size++;
                }
                else
                    break;
            }

        }
        return  list;

    }


}
