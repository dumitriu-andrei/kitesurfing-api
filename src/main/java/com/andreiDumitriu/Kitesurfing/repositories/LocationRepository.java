package com.andreiDumitriu.Kitesurfing.repositories;

import com.andreiDumitriu.Kitesurfing.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long>{

    @Query("SELECT id,name,longitude,latitude,windProbability,whenToGo FROM Location WHERE country=:name")
    List<Location> uniqueCountry(@Param("name") String name);

    @Query("SELECT id,name,longitude,latitude,country,whenToGo FROM Location WHERE windProbability=:wind")
    List<Location> uniqueWind(@Param("wind") int wind);

    @Query("SELECT country FROM Location")
    List<String> getCountry();

    @Query(value = "SELECT l.name FROM Location l INNER JOIN favorites f ON l.id = f.location_id",nativeQuery = true)
    List<Object> getFav();
}

