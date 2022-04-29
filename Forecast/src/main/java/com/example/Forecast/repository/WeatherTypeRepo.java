package com.example.Forecast.repository;
        import com.example.Forecast.entity.WeatherTypeEntity;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;
@Repository
public interface WeatherTypeRepo extends MongoRepository<WeatherTypeEntity, String> {
  String findByForecastNumber(double type) ;

}
