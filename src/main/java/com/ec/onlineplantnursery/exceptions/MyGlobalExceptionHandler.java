package com.ec.onlineplantnursery.exceptions;

import javax.persistence.NoResultException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidResourceInputByUser(ResourceNotFoundException ex) {
		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid Resources, pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidCredentials(InvalidCredentialException e) {
		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid Resources, pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidSeedId(SeedIdNotFoundException ex) {
		int sid = ex.getId();
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid Seed Id "+sid+" doesn't exist , pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> wrongName(NoResultException ex)
	{
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Resource Not found enter proper name");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidOrderIdException(OrderIdNotFoundException ex) {
		int id = ex.getId();		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid OrderId "+id+" doesn't exist , pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidPlantId(PlantIdNotFoundException ex) {
		int pid = ex.getId();
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid Plant Id "+pid+" doesn't exist , pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidInputByUser(InvalidInputException ex) {
		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid input, pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	

}
