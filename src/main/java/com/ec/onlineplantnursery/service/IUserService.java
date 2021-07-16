package com.ec.onlineplantnursery.service;

import com.ec.onlineplantnursery.entity.User;
import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;


public interface IUserService {

	public String signIn(User user) throws InvalidCredentialException;
	public User signOut(User user);

	

}