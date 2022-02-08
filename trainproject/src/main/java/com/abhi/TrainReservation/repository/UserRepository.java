package com.abhi.TrainReservation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.abhi.TrainReservation.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public User findById(int id);

	public Optional<User> findByUserNameAndPassword(String userName, String password);
}

