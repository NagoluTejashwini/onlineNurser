package com.ec.onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Customer Bean")
@DiscriminatorValue(value = "1")
public class Customer extends User{
	
	/**@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_generator")
	private Integer customerId;**/
    
	@Column
	@ApiModelProperty(name = "CustomerName", value = "Hold the min 3 char Customer name", required = true)
	@NotEmpty(message = "Customer Name cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid Customer Name,Customer Name should have minimum 3 and maximum 50 characters")
	private String customerName;
	
    
	@Column
	@ApiModelProperty(name = "CustomerUserName", value = "Hold the min 3 char Customer username", required = true)
	@NotEmpty(message = "Customer UserName cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid Customer UserName,Customer UserName should have minimum 3 and maximum 50 characters")
	private String username;
	
	/**@Column
	@ApiModelProperty(name = "Customer Password", value = "Hold the min 8 char Customer Password", required = true)
	@Size(min = 8, max = 15, message = "Invalid Customer Password ,Customer password should have minimum 8 and maximum 15 characters")
	@NotEmpty(message = "Please enter the password, password cannot be null")
	private String password;**/
	
	@Embedded
	@Valid
	private Address address;

	
	public Customer() {
		super();
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Customer(
			@NotEmpty(message = "Customer Name cannot be left blank or null") @Size(min = 3, max = 50, message = "Invalid Customer Name,Customer Name should have minimum 3 and maximum 50 characters") String customerName,
			@NotEmpty(message = "Customer UserName cannot be left blank or null") @Size(min = 3, max = 50, message = "Invalid Customer UserName,Customer UserName should have minimum 3 and maximum 50 characters") String username,
			@Valid Address address) {
		super();
		this.customerName = customerName;
		this.username = username;
		this.address = address;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", username=" + username + ", address=" + address + "]";
	}

	
	

}
	