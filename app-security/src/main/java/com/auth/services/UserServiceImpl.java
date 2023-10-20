package com.auth.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails ;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.domain.User;
import com.auth.repositories.UserRepository;
import com.datastax.oss.driver.api.core.uuid.Uuids;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public User save(User user) {
		log.info("Saving new user {}  to db ", user.getUsername());	
		user.setId(Uuids.timeBased().toString());		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username).orElse(null);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String s = "100";
		// ROLE_USER
		return new org.springframework.security.core.userdetails.User("badr", "$2a$10$YGiakT/cKZ7TPoM2R5ydVed.cADSXGwepHOPlh38/2t71ocx2D3S2", new ArrayList<GrantedAuthority>());
		// return null;
	}
}
