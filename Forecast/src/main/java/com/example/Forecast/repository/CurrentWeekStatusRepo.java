package com.example.Forecast.repository;
        import com.example.Forecast.entity.CurrentWeekStatusEntity;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface CurrentWeekStatusRepo extends MongoRepository<CurrentWeekStatusEntity,String> {
        Optional<CurrentWeekStatusEntity> findFirstByCityAndDate(String city, String date) ;
        List<CurrentWeekStatusEntity> findByCity(String city) ;


}
