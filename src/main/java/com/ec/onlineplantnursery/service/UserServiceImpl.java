package com.ec.onlineplantnursery.service;

import java.util.ArrayList;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.ec.onlineplantnursery.entity.User;
import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;
import com.ec.onlineplantnursery.repository.IUserRepository;
import com.ec.onlineplantnursery.security.JwtUtil;


@Service
public class UserServiceImpl implements IUserService, UserDetailsService{
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	AuthenticationManager authManager;

	@Override
	public String signIn(User user) throws InvalidCredentialException {
		
		try {
			this.authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (Exception e) {
			throw new InvalidCredentialException("Invalid credentials");
		}
		UserDetails userDetail = this.loadUserByUsername(user.getEmail());
		String token = this.util.generateToken(userDetail);
		return token;

	}

	@Override
	public User signOut(User user) {
		
		return null;
	}

	
	

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByemail(email);
		if(user.isPresent()) {
			return new org.springframework.security.core.userdetails.User(email, user.get().getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException(email);
		}
	}

	

}