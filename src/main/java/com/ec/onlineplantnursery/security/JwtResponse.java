package com.ec.onlineplantnursery.security;

public class JwtResponse {

	String token;
	int userId;

	public JwtResponse() {
		super();
		
	}

	public JwtResponse(String token, int userId) {
		super();
		this.token = token;
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}