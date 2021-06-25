package com.ec.onlineplantnursery.exceptions;

public class MyExceptionResponse {

	
	private int httpStatus;
	private String exceptionMsg;
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	public MyExceptionResponse(int httpStatus, String exceptionMsg) {
		super();
		this.httpStatus = httpStatus;
		this.exceptionMsg = exceptionMsg;
	}
	public MyExceptionResponse() {
		super();
	}

}
