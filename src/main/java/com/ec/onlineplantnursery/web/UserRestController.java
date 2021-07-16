package com.ec.onlineplantnursery.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.entity.User;
import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;
import com.ec.onlineplantnursery.security.JwtResponse;
import com.ec.onlineplantnursery.service.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@Api("Online Plant Nursery Application")
public class UserRestController {
	@Autowired
	UserServiceImpl userService;

	
	  @ApiOperation(value = "User Post mapping for user signing in", response = User.class)
	  
	  @PostMapping("/signin") public ResponseEntity<JwtResponse>signuser(@RequestBody @Valid User user) throws InvalidCredentialException {
	
		  return new ResponseEntity<>(new JwtResponse(this.userService.signIn(user),1),HttpStatus.OK);
	  }

	@ApiOperation(value = "User Post mapping for user signing out", response = User.class)
	@PostMapping("/signout")
	public ResponseEntity<User> signoutuser(@RequestBody @Valid User user) {
		this.userService.signOut(user);
		return new ResponseEntity<>(user, HttpStatus.RESET_CONTENT);

	}

}