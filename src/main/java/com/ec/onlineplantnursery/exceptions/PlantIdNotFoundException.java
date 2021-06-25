package com.ec.onlineplantnursery.exceptions;

public class PlantIdNotFoundException extends Exception {

	public PlantIdNotFoundException() {
		
	}
	private int id;
	public PlantIdNotFoundException(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PlantIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
	public PlantIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}
	public PlantIdNotFoundException(String message) {
		super(message);
		
	}
	public PlantIdNotFoundException(Throwable cause) {
		super(cause);
		
	}
	

}
