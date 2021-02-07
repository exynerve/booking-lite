package com.rivigo.service.model;

public class Fare {

    private Integer sourceCityId;

    private Integer destinationCityId;

    private Double fare;

    public Integer getSourceCityId() {
        return sourceCityId;
    }

    public Integer getDestinationCityId() {
        return destinationCityId;
    }

    public Double getFare() {
        return fare;
    }

    public void setSourceCityId(Integer sourceCityId) {
        this.sourceCityId = sourceCityId;
    }

    public void setDestinationCityId(Integer destinationCityId) {
        this.destinationCityId = destinationCityId;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
