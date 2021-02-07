package com.rivigo.service.business;

import com.rivigo.service.dao.CityRepository;
import com.rivigo.service.dao.TransportFareRepository;
import com.rivigo.service.entity.City;
import com.rivigo.service.model.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class InitializationService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TransportFareRepository fareRepository;

    public void init(){
        initCities();
        initFares();
    }

    public void initCities(){

        City delhi = new City();

        delhi.setCityName("Delhi");
        delhi.setUUID(UUID.randomUUID().toString());
        delhi.setVehiclesAvailable(10000);
        cityRepository.save(delhi);
        cityRepository.flush();

        City bangalore = new City();

        bangalore.setCityName("Bangalore");
        bangalore.setUUID(UUID.randomUUID().toString());
        bangalore.setVehiclesAvailable(10000);
        cityRepository.save(bangalore);
        cityRepository.flush();

        City mumbai = new City();

        mumbai.setCityName("Mumbai");
        mumbai.setUUID(UUID.randomUUID().toString());
        mumbai.setVehiclesAvailable(10000);
        cityRepository.save(mumbai);
        cityRepository.flush();

        City test1 = new City();

        test1.setCityName("Test-1");
        test1.setUUID(UUID.randomUUID().toString());
        test1.setVehiclesAvailable(0);
        cityRepository.saveAndFlush(test1);

        City test2 = new City();

        test2.setCityName("Test-2");
        test2.setUUID(UUID.randomUUID().toString());
        test2.setVehiclesAvailable(1);
        cityRepository.saveAndFlush(test2);

    }


    public void initFares(){
        Fare fare = new Fare();

        City delhi = cityRepository.findByCityName("Delhi");
        City bangalore = cityRepository.findByCityName("Bangalore");
        City mumbai = cityRepository.findByCityName("Mumbai");
        City test1 = cityRepository.findByCityName("Test-1");
        City test2 = cityRepository.findByCityName("Test-2");

        fare.setSourceCityId(delhi.getCityId());
        fare.setDestinationCityId(bangalore.getCityId());
        fare.setFare(1000D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(delhi.getCityId());
        fare.setDestinationCityId(mumbai.getCityId());
        fare.setFare(600D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(mumbai.getCityId());
        fare.setDestinationCityId(bangalore.getCityId());
        fare.setFare(200D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(mumbai.getCityId());
        fare.setDestinationCityId(delhi.getCityId());
        fare.setFare(800D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(bangalore.getCityId());
        fare.setDestinationCityId(mumbai.getCityId());
        fare.setFare(500D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(bangalore.getCityId());
        fare.setDestinationCityId(delhi.getCityId());
        fare.setFare(1200D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(test1.getCityId());
        fare.setDestinationCityId(test2.getCityId());
        fare.setFare(100D);
        fareRepository.insertFare(fare);

        fare.setSourceCityId(test2.getCityId());
        fare.setDestinationCityId(test1.getCityId());
        fare.setFare(100D);
        fareRepository.insertFare(fare);
    }
}

