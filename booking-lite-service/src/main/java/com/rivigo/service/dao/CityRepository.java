package com.rivigo.service.dao;

import com.rivigo.service.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "select city from City city where city.cityName = :cityName")
    City findByCityName(@Param(value = "cityName") String cityName);

    @Query(value = "select city.vehiclesAvailable from City city where city.cityName = :cityName")
    Integer findVehicleCountInCity(@Param(value = "cityName") String cityName);

    @Modifying
    @Query(value = "update City city set city.vehiclesAvailable = city.vehiclesAvailable - 1 where city.cityId = :cityId and city.vehiclesAvailable > 0")
    void updateVehicleCountInSourceCity(@Param(value = "cityId") Integer cityId);

    @Modifying
    @Query(value = "update City city set city.vehiclesAvailable = city.vehiclesAvailable + 1 where city.cityId = :cityId")
    void updateVehicleCountInDestinationCity(@Param(value = "cityId") Integer cityId);
}
