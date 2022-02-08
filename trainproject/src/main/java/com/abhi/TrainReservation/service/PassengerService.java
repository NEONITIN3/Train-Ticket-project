package com.abhi.TrainReservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.TrainReservation.model.Passenger;
import com.abhi.TrainReservation.model.User;
import com.abhi.TrainReservation.repository.PassengerRepository;
import com.abhi.TrainReservation.repository.UserRepository;

@Component
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<Passenger> getAllPassengers()
	{
		List<Passenger> list = (List<Passenger>)this.passengerRepository.findAll();
		return list;
	}

}
