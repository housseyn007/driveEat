package com.driveeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driveeat.entity.Users;
import com.driveeat.repository.UsersRepository;

@Service
public class UsersService {

//	@Autowired private BCryptPasswordEncoder encoder;
	
	@Autowired private UsersRepository usersRepository;

	public void save(Users users) {
		
//		user.setPassword(encoder.encode(user.getPassword()));
		
		usersRepository.save(users);
	}
}
