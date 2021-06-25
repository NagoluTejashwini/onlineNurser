package com.ec.onlineplantnursery.entity;

import javax.persistence.Embeddable;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class Address {
	
	@ApiModelProperty(name = "addressID",value = "Hold the address id ",required = true)
	private Integer addressId;
	

	@ApiModelProperty(name = "HouseNo",value = "Hold the house no",required = true)
	@NotEmpty(message = "Housenumber cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid housenumber ,housenumber should have minimum 3 and maximum 50 characters")
	
	private String houseNo;
	

	@ApiModelProperty(name = "Colony",value = "Hold the min 3 char only",required = true)
	@NotEmpty(message = "Colony cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid colony ,Colony should have minimum 3 and maximum 50 characters")
	private String colony;
	
	@ApiModelProperty(name = "City",value = "Hold the min 3 char only",required = true)
	@NotEmpty(message = "City cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid City ,City should have minimum 3 and maximum 50 characters")
	private String city;
	
	@ApiModelProperty(name = "State",value = "Hold the min 3 char only",required = true)
	@NotEmpty(message = "State cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid State ,State should have minimum 3 and maximum 50 characters")
	private String state;
	
	@ApiModelProperty(name = "Pincode",value = "Hold the 7 digit number ",required = true)
	@Min(value = 100000, message = "Enter valid pincode")
	private Long pincode;

	public Address() {
		super();
	}

	public Address(@NotNull @Min(value = 1, message = "Enter valid addressID") Integer addressId,
			@NotEmpty(message = "Housenumber cannot be left blank or null") @Size(min = 3, max = 50, message = "Invalid housenumber ,housenumber should have minimum 3 and maximum 50 characters") String houseNo,
			@NotEmpty(message = "Colony cannot be left blank or null") @Size(min = 3, max = 50, message = "Invalid colony ,Colony should have minimum 3 and maximum 50 characters") String colony,
			@NotEmpty(message = "City cannot be left blank or null") @Size(min = 3, max = 50, message = "Invalid City ,City should have minimum 3 and maximum 50 characters") String city,
			@NotEmpty(message = "State cannot be left blank or null") @Size(min = 3, max = 50, message = "Invalid State ,State should have minimum 3 and maximum 50 characters") String state,
			@NotNull @Min(value = 6, message = "Enter valid Pincode") @Max(value = 6, message = "Enter valid Pincode") Long pincode) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the houseNo
	 */
	public String getHouseNo() {
		return houseNo;
	}
	/**
	 * @param houseNo the houseNo to set
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	/**
	 * @return the colony
	 */	
	public String getColony() {
		return colony;
	}
	/**
	 * @param colony the colony to set
	 */
	public void setColony(String colony) {
		this.colony = colony;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public Long getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((colony == null) ? 0 : colony.hashCode());
		result = prime * result + ((houseNo == null) ? 0 : houseNo.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (colony == null) {
			if (other.colony != null)
				return false;
		} else if (!colony.equals(other.colony))
			return false;
		if (houseNo == null) {
			if (other.houseNo != null)
				return false;
		} else if (!houseNo.equals(other.houseNo))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", colony=" + colony + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
}
