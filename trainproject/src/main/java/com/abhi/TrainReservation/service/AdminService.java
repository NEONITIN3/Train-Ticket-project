package com.abhi.TrainReservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.TrainReservation.model.Admin;
import com.abhi.TrainReservation.repository.AdminRepository;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository)
	{
		this.adminRepository = adminRepository;
		
		Admin admin1 = new Admin("admin","admin");
		
		List<Admin> admins = new ArrayList<Admin>();
		admins.add(admin1);
		adminRepository.saveAll(admins);
		
	}
}
