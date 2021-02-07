package com.rivigo.service.business;

import com.rivigo.service.config.VehicleNumberGenerator;
import com.rivigo.service.dao.BookingRepository;
import com.rivigo.service.dao.CityRepository;
import com.rivigo.service.dao.TransportFareRepository;
import com.rivigo.service.entity.Booking;
import com.rivigo.service.entity.City;
import com.rivigo.service.exception.CityNotFoundException;
import com.rivigo.service.exception.DateFormatException;
import com.rivigo.service.exception.InvalidDateException;
import com.rivigo.service.exception.VehicleNotAvailableException;
import com.rivigo.service.model.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookingService {

    private VehicleNumberGenerator vehicleNumberGenerator = new VehicleNumberGenerator();

    @Autowired
    private TransportFareRepository fareRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CityRepository cityRepository;

    public BookingDetails createBooking (String source, String destination, String pickUpDate) throws CityNotFoundException, InvalidDateException, VehicleNotAvailableException, DateFormatException {
        final BookingDetails bookingDetails = new BookingDetails();
        City sourceCity = null;
        City destinationCity = null;


        if (validateCity(source)) {
            if (validateCity(destination)) {
                sourceCity = cityRepository.findByCityName(source);
                destinationCity = cityRepository.findByCityName(destination);
            }
        }

        if (validateDate(pickUpDate)) {
            if(vehicleAvailableInCity(source) || vehicleAvailableInCityBeforePickUp(source, pickUpDate)) {

                bookingDetails.setVehicleNumber(vehicleNumberGenerator.generator());
                bookingDetails.setCost(fareRepository.getFare(sourceCity.getCityId(), destinationCity.getCityId()));

            }
            else{
                throw new VehicleNotAvailableException("THERE ARE NO VEHICLES AVAILABLE IN THE SOURCE CITY ON THE GIVEN PICK-UP DATE");
            }
        }


        final Booking booking;
        booking = new Booking();

        booking.setSource(sourceCity);
        booking.setDestination(destinationCity);
        booking.setCost(bookingDetails.getCost());
        booking.setUUID(UUID.randomUUID().toString());
        booking.setPickupDate(formatStringToDate(pickUpDate));
        bookingRepository.save(booking);

        cityRepository.updateVehicleCountInSourceCity(sourceCity.getCityId());
        cityRepository.updateVehicleCountInDestinationCity(destinationCity.getCityId());

        return bookingDetails;
    }

    private boolean vehicleAvailableInCityBeforePickUp(String source, String pickUpDate) throws DateFormatException {
        City currentCity = cityRepository.findByCityName(source);
        Integer vehicleAvailable = bookingRepository.countByPickupDateIsGreaterThanEqualAndPickupDateLessThanAndDestinationEquals(LocalDate.now(), formatStringToDate(pickUpDate), currentCity);
        return vehicleAvailable > 0;
    }

    private LocalDate formatStringToDate(String pickUpDate) throws DateFormatException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            final LocalDate parsedDate = LocalDate.parse(pickUpDate, formatter);
            return parsedDate;
        }catch (Exception exception){
            throw new DateFormatException("INVALID DATE FORMAT, TRY AGAIN");
        }
    }

    private boolean vehicleAvailableInCity(String source){

        Integer vehicleAvailable = cityRepository.findVehicleCountInCity(source);

        return vehicleAvailable > 0;
    }

    private boolean validateDate(String pickUpDate) throws InvalidDateException, DateFormatException {
        LocalDate date;
        try {
            date = formatStringToDate(pickUpDate);
        }catch (Exception exception){
            throw new DateFormatException("INVALID DATE FORMAT, TRY AGAIN");
        }
            if (LocalDate.now().isEqual(date) || LocalDate.now().isAfter(date)) {
                throw new InvalidDateException("INVALID DATE! ENTER A DATE ONE DAY OR AFTER FROM TODAY");
            }

        return true;
    }

    private boolean validateCity(String cityName) throws CityNotFoundException {

        City city;
        city = cityRepository.findByCityName(cityName);
        if (city==null) {
            throw new CityNotFoundException("SOURCE / DESTINATION CITY DOES NOT EXIST");
        }

        return true;
    }

}
