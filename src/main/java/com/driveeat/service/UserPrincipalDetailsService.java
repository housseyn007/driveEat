package com.driveeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.driveeat.entity.UserPrincipal;
import com.driveeat.entity.Users;
import com.driveeat.repository.UsersRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = this.usersRepository.findByEmailIgnoreCase(email);
		UserPrincipal userPrincipal = new UserPrincipal(users);

		return userPrincipal;
	}

}
