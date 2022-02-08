package com.abhi.TrainReservation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhi.TrainReservation.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

	Optional<Admin> findByUserNameAndPassword(String userName, String password);

}
