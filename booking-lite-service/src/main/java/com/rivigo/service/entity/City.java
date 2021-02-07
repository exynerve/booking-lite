package com.rivigo.service.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CITIES")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private Integer cityId;

    @Column(name = "UUID")
    private String UUID;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "VEHICLES_AVAILABLE")
    private Integer vehiclesAvailable;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getVehiclesAvailable() {
        return vehiclesAvailable;
    }

    public void setVehiclesAvailable(Integer vehiclesAvailable) {
        this.vehiclesAvailable = vehiclesAvailable;
    }
}
