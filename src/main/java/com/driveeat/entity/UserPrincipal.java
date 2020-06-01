package com.driveeat.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
	
	private Users users;	

	public UserPrincipal(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	public String getFirstName() {
		return this.users.getFirstName();
	}

	public String getLastName() {
		return this.users.getLastName();
	}
	
	@Override
	public String getPassword() {
		return this.users.getPassword();
	}

	@Override
	public String getUsername() {
		return this.users.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
//		return this.users.getActive() == 1;
		return true;
	}

}
