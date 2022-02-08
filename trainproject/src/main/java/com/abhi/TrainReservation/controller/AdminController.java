package com.abhi.TrainReservation.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.TrainReservation.model.Admin;
import com.abhi.TrainReservation.model.Passenger;
import com.abhi.TrainReservation.model.Train;
import com.abhi.TrainReservation.model.User;
import com.abhi.TrainReservation.repository.AdminRepository;
import com.abhi.TrainReservation.repository.PassengerRepository;
import com.abhi.TrainReservation.repository.TrainRepository;
import com.abhi.TrainReservation.repository.UserRepository;
import com.abhi.TrainReservation.service.PassengerService;
import com.abhi.TrainReservation.service.TrainService;
import com.abhi.TrainReservation.service.UserService;


@Controller
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	TrainRepository trainRepository;
	
	@Autowired
	private TrainService trainService;
	
	@GetMapping(value = "/admin")
	public ModelAndView getAdmin() {

		ModelAndView modelAndView = new ModelAndView("admin");

		return modelAndView;
	}
	
	@GetMapping(value = "/index")
	public ModelAndView getIndex() {

		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;
	}
	
	@PostMapping("/admin")
	public String loginAdmin(@RequestParam String userName, @RequestParam String password)
	{
		Optional<Admin> adminOptional=adminRepository.findByUserNameAndPassword(userName,password);
		if(adminOptional.isPresent())
		{
			return "redirect:/index";
		}
		else
		{
			return "redirect:/admin";
		}
	}

	@GetMapping(value = "/showPassenger")
	public ModelAndView getPassenger() {
		List<User> allUsers = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("showPassenger");
		modelAndView.addObject("allUsers", allUsers);
		return modelAndView;
	}
	
	@GetMapping(value = "/showPassenger2")
	public ModelAndView getPassenger2() {
		List<Passenger> allPassengers = passengerService.getAllPassengers();
		ModelAndView modelAndView = new ModelAndView("showPassenger2");
		modelAndView.addObject("allPassengers", allPassengers);
		return modelAndView;
	}
	
	@GetMapping(value = "/addTrain")
	public ModelAndView getaddTrain() {
		ModelAndView modelAndView = new ModelAndView("addTrain");

		return modelAndView;
	}
	
	@PostMapping("/addTrain")
	public String addTrain(Train train) {
		trainRepository.save(train);
		return "addTrain";
	}
	
	@GetMapping(value = "/updateTrain")
	public ModelAndView getUpdateTrain() {

		ModelAndView modelAndView = new ModelAndView("updateTrain");

		return modelAndView;
	}

	@GetMapping(value = "/deleteTrain")
	public ModelAndView getdeleteTrain() {
		ModelAndView modelAndView = new ModelAndView("deleteTrain");
		
		return modelAndView;
	}
	
	@PostMapping(value = "/deleteTrain")
	public String deleteTrain(Train train) {
		trainRepository.delete(train);
		
		return "deleteTrain";
	}
	
	@GetMapping(value = "/GetTrains")
	public ModelAndView getHomePage() {

		List<Train> allTrains = trainService.getAllTrains();

		ModelAndView modelAndView = new ModelAndView("GetTrains");
		modelAndView.addObject("allTrains", allTrains);

		return modelAndView;
	}
}
