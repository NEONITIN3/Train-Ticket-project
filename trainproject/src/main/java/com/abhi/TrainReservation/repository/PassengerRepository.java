package com.abhi.TrainReservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhi.TrainReservation.model.Passenger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

}
