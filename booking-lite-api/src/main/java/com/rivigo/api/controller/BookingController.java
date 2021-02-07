package com.rivigo.api.controller;

import com.rivigo.api.dto.BookingRequestDto;
import com.rivigo.api.dto.BookingResponseDto;
import com.rivigo.service.business.BookingService;
import com.rivigo.service.business.InitializationService;
import com.rivigo.service.exception.CityNotFoundException;
import com.rivigo.service.exception.DateFormatException;
import com.rivigo.service.exception.InvalidDateException;
import com.rivigo.service.exception.VehicleNotAvailableException;
import com.rivigo.service.model.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private InitializationService initializationService;

    @RequestMapping(method = RequestMethod.POST,name = "booking-request", path = "/booking", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BookingResponseDto> createBooking(@RequestBody final BookingRequestDto bookingRequest) throws InvalidDateException, CityNotFoundException, DateFormatException, VehicleNotAvailableException {

        final String source = bookingRequest.getSourceCity();
        final String destination = bookingRequest.getDestinationCity();
        final String dateOfPickUp = bookingRequest.getDateOfPickUp();

        BookingDetails bookingDetails = bookingService.createBooking(source, destination, dateOfPickUp);

        BookingResponseDto response = new BookingResponseDto().vehicleNumber(bookingDetails.getVehicleNumber()).cost(bookingDetails.getCost());
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping(name = "Initializer", value = "/init")
    public ResponseEntity<String> initialize(){
        initializationService.init();
        return new ResponseEntity<>("Init Success", HttpStatus.OK);
    }
}
