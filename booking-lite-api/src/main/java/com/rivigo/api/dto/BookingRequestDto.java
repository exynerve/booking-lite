package com.rivigo.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated

public class BookingRequestDto {

    @ApiModelProperty(
            name =  "Source City",
            value = "Enter Source City Name",
            example = "Delhi",
            required = true,
            position = 1)
    private String sourceCity;

    @ApiModelProperty(
            name =  "Destination City",
            value = "Enter Destination City Name",
            example = "Bangalore",
            required = true,
            position = 2)
    private String destinationCity;

    @ApiModelProperty(
            name =  "Pickup Date",
            value = "Enter Pickup Date in format 'YYYY-MM-DD'",
            example = "2020-11-08",
            required = true,
            position = 3)
    private String dateOfPickUp;


    @ApiModelProperty(value = "Source City")
    public String getSourceCity() {
        return sourceCity;
    }

    public BookingRequestDto source(String source){
        this.sourceCity = source;
        return this;
    }


    @ApiModelProperty(value = "Destination City")
    public String getDestinationCity() {
        return destinationCity;
    }

    public BookingRequestDto destination(String destination){
        this.destinationCity = destination;
        return this;
    }

    @ApiModelProperty(value = "Date of pickup")
    public String getDateOfPickUp() {
        return dateOfPickUp;
    }

    public BookingRequestDto pickupDate(String dateOfPickUp){
        this.dateOfPickUp = dateOfPickUp;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingRequestDto)) return false;
        BookingRequestDto that = (BookingRequestDto) o;
        return Objects.equals(getSourceCity(), that.getSourceCity()) &&
                Objects.equals(getDestinationCity(), that.getDestinationCity()) &&
                Objects.equals(getDateOfPickUp(), that.getDateOfPickUp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSourceCity(), getDestinationCity(), getDateOfPickUp());
    }

    @Override
    public String toString() {
        return "BookingRequestDto{" +
                "sourceCity='" + sourceCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", dateOfPickUp='" + dateOfPickUp + '\'' +
                '}';
    }
}

