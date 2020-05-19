package com.driveeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.driveeat.entity.Users;
import com.driveeat.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UsersRepository usersRepository;

	public void save(Users users) {

		users.setPassword(encoder.encode(users.getPassword()));

		usersRepository.save(users);
	}
}
