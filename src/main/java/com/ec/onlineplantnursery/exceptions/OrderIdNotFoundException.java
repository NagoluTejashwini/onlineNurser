package com.ec.onlineplantnursery.exceptions;

public class OrderIdNotFoundException extends Exception {

private int id;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderIdNotFoundException() {
		
	}

	public OrderIdNotFoundException(int id) {
		super();
		this.id = id;
		
	}

	public OrderIdNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

	public OrderIdNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public OrderIdNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
