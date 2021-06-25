package com.ec.onlineplantnursery.exceptions;

public class SeedIdNotFoundException extends Exception {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SeedIdNotFoundException() {
		
	}

	public SeedIdNotFoundException(int  id) {
		super();
		this.id = id;
		
	}

	public SeedIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public SeedIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SeedIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
