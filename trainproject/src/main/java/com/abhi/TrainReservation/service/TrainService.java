package com.abhi.TrainReservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.TrainReservation.model.Train;
import com.abhi.TrainReservation.repository.TrainRepository;

@Service
public class TrainService {

	private final TrainRepository trainRepository;

	@Autowired
	public TrainService(TrainRepository trainRepository) {

		this.trainRepository = trainRepository;

		Train train1 = new Train(12961, "Avantika Express", "Mumbai", "Indore", 530.0);

		Train train2 = new Train(22691, "Rajdhani Express", "Bengaluru", "Delhi", 700.0);

		Train train3 = new Train(12302, "Howrah Express", "Howrah", "Delhi", 750.0);

		Train train4 = new Train(16128, "Chennai Express", "Mumbai", "chennai", 650.0);	
		
		Train train5 = new Train(12989, "Ajmer SF Special", "Dadar", "Ajmer", 500.0);
		
		Train train6 = new Train(82901, "Tejas Express", "Mumbai", "Ahemdabad", 270.0);
		
		Train train7 = new Train(20903, "Mahamana Express", "Varanasi", "Surat", 600.0);

		Train train8 = new Train(22436, "Vande Bharat Express", "Delhi", "Prayagraj", 580.0);

		Train train9 = new Train(20802, "Magadh Express", "Delhi", "Patna", 510.0);
		Train train10 = new Train(12533, "Pushpak Express", "Bhopal", "Mumbai", 465.0);
		Train train11 = new Train(11072, "Kamayani Express", "Bhopal", "Delhi", 425.0);
		Train train12 = new Train(22436, "Mandovi Express", "Mandovi", "Mumbai", 390.0);
		Train train13 = new Train(12925, "Paschim SF Express", "Delhi", "Chandigarh JN", 275.0);
		Train train14 = new Train(19167, "Sabarmati Express", "Ahemdabad", "Varanasi JN", 645.0);
		Train train15 = new Train(12009, "Shatabdi Express", "Surat", "Mumbai", 580.0);
		Train train16 = new Train(19015, "Saurastra Express", "Mumbai", "Vadodara", 555.0);
		Train train17 = new Train(12903, "Golden Temple Mail", "Ahemdabad", "Chennai", 716.0);
		
		
	
		List<Train> trains = new ArrayList<Train>();
		trains.add(train1);  
		trains.add(train2);
		trains.add(train3);
		trains.add(train4);
		trains.add(train5);
		trains.add(train6);
		trains.add(train7);
		trains.add(train8);
		trains.add(train9);
		trains.add(train10);
		trains.add(train11);
		trains.add(train12);
		trains.add(train13);
		trains.add(train14);
		trains.add(train15);
		trains.add(train16);
		trains.add(train17);


		trainRepository.saveAll(trains);
	}

	public Optional<Train> getTrainByNumber(int trainNumber) {
		return trainRepository.findById(trainNumber);
	}

	public List<Train> getAllTrains() {
		return trainRepository.findAll();
	}
	
	public void deleteTrain(int trainNo)
	{
		trainRepository.deleteById(trainNo);
	}

	

}