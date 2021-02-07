package com.rivigo.service.dao;

import com.rivigo.service.entity.Booking;
import com.rivigo.service.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    Integer countByPickupDateIsGreaterThanEqualAndPickupDateLessThanAndDestinationEquals(LocalDate pickupDate, LocalDate pickupDate2, City destination);
}
