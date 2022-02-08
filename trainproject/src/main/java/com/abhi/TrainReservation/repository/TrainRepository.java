package com.abhi.TrainReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.TrainReservation.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> 
{
}