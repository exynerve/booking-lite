package com.rivigo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class BookingResponseDto {

    @JsonProperty(value = "Vehicle Number")
    private String vehicleNumber = null;

    @JsonProperty(value = "Cost")
    private Double cost = null;

    @ApiModelProperty(required = true ,value = "Vehicle number blocked for booking")
    @NotNull
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public BookingResponseDto vehicleNumber(final String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    @ApiModelProperty(required = true ,value = "Cost of Booking")
    @NotNull
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public BookingResponseDto cost(final Double cost){
        this.cost = cost;
        return this;
    }

    @Override
    public String toString() {
        return "BookingResponseDto{" +
                "   vehicleNumber: '" + vehicleNumber + '\'' +","+
                "   cost=" + cost +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingResponseDto)) return false;
        BookingResponseDto that = (BookingResponseDto) o;
        return Objects.equals(vehicleNumber, that.vehicleNumber) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, cost);
    }
}
