package com.ec.onlineplantnursery.requestDto;

import javax.persistence.Column;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ec.onlineplantnursery.entity.Address;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerRequestDto {

	private Integer customerId;

	@Column
	@ApiModelProperty(name = "CustomerName", value = "Hold the min 3 char Customer name", required = true)
	@NotEmpty(message = "Customer Name cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid Customer Name,Customer Name should have minimum 3 and maximum 50 characters")
	private String customerName;

	@Column
	@ApiModelProperty(name = "CustomerEmail", value = "holds valid email id", required = true)
	@NotEmpty(message = "Customer Email cannot be left blank or null")
	@Email
	private String customerEmail;

	@Column
	@ApiModelProperty(name = "CustomerUserName", value = "Hold the min 3 char Customer username", required = true)
	@NotEmpty(message = "Customer UserName cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid Customer UserName,Customer UserName should have minimum 3 and maximum 50 characters")
	private String username;

	@Column
	@ApiModelProperty(name = "Customer Password", value = "Hold the min 8 char Customer Password", required = true)
	@Size(min = 8, max = 15, message = "Invalid Customer Password ,Customer password should have minimum 8 and maximum 15 characters")
	@NotEmpty(message = "Please enter the password, password cannot be null")
	private String password;

	@Valid
	private Address address;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
