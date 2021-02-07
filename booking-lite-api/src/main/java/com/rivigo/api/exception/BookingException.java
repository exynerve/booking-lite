package com.rivigo.api.exception;

import com.rivigo.api.dto.ErrorResponseDto;
import com.rivigo.service.exception.CityNotFoundException;
import com.rivigo.service.exception.DateFormatException;
import com.rivigo.service.exception.InvalidDateException;
import com.rivigo.service.exception.VehicleNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BookingException {


    @ExceptionHandler(VehicleNotAvailableException.class)
    public ResponseEntity<ErrorResponseDto> vehicleNotAvailable(VehicleNotAvailableException exception, WebRequest request){
        return new ResponseEntity<ErrorResponseDto>(
                new ErrorResponseDto().errorMessage(exception.getErrorMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateFormatException.class)
    public ResponseEntity<ErrorResponseDto> dateFormat(DateFormatException exception, WebRequest request){
        return new ResponseEntity<ErrorResponseDto>(
                new ErrorResponseDto().errorMessage(exception.getErrorMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<ErrorResponseDto> invalidDate(InvalidDateException exception, WebRequest request){
        return new ResponseEntity<ErrorResponseDto>(
                new ErrorResponseDto().errorMessage(exception.getErrorMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> cityNotFound(CityNotFoundException exception, WebRequest request){
        return new ResponseEntity<ErrorResponseDto>(
                new ErrorResponseDto().errorMessage(exception.getErrorMessage()), HttpStatus.NOT_FOUND);
    }


}
