package com.rivigo.service.dao;

import com.rivigo.service.model.Fare;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class TransportFareRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Double getFare(Integer source, Integer destination){
        TypedQuery<Double> query = (TypedQuery<Double>) entityManager.createNativeQuery("Select fare from Fares where source_id = ?1 and destination_id = ?2").setParameter(1, source).setParameter(2, destination);
        return query.getSingleResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertFare(Fare fare){
        entityManager.createNativeQuery("INSERT INTO FARES(SOURCE_ID, DESTINATION_ID, FARE) VALUES (?1,?2,?3)")
                .setParameter(1, fare.getSourceCityId())
                .setParameter(2, fare.getDestinationCityId())
                .setParameter(3, fare.getFare())
                .executeUpdate();
    }

}
