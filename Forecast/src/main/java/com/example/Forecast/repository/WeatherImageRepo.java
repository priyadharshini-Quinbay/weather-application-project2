package com.example.Forecast.repository;
        import com.example.Forecast.entity.WeatherImageEntity;
        import com.example.Forecast.entity.WeatherTypeEntity;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;
@Repository
public interface WeatherImageRepo extends MongoRepository<WeatherImageEntity, String> {
    List<WeatherImageEntity> findByWeatherAndI(String weather,int i) ;


}
