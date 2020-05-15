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
public class MyUsersDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = usersRepository.findByEmail(email);

		if (users == null) {
			throw new UsernameNotFoundException("L'adresse e-mail n'est pas valide!");
		}

		return new UserPrincipal(users);
	}

}
