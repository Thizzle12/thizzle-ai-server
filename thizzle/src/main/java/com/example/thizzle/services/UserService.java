package com.example.thizzle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thizzle.dto.responses.UserRs;
import com.example.thizzle.dto.responses.UserRs.Gender;

@Service
public class UserService {
	
	@Autowired
	
	public UserRs getUser() {
		
		return createUser();
	}
	
	private UserRs createUser() {
		UserRs newUser = new UserRs(10293, "Theis Friis", "thefir@hotmail.dk", "testOfPassword123!", Gender.MALE);
		return newUser;
	}
	
	
	public UserRs getUserViaId(String id) {
		
		return new UserRs(10294, "Theis Friis2", "thefir2@hotmail.dk", "testOfPassword123!", Gender.MALE);
	}
	

}
