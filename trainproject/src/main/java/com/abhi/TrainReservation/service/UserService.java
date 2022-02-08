package com.abhi.TrainReservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.TrainReservation.model.User;
import com.abhi.TrainReservation.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	public List<User> getAllUsers()
	{
		List<User> list = (List<User>)this.userrepository.findAll();
		return list;
	}
	
	public User getUserById(int id)
	{
		User user = null;
		try{
			user = this.userrepository.findById(id);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User addUser(User user)
	{
		User result = userrepository.save(user);
		return result;
	}
	
	public void deleteUser(int bid)
	{
		userrepository.deleteById(bid);
	}
	
	public void updateuser(User user,int id)
	{
		user.setsNo(id);
		userrepository.save(user);
	}
	
}
