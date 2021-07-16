package com.ec.onlineplantnursery.responseDto;


import java.util.Map;

import com.ec.onlineplantnursery.entity.Address;
public class OrderResponseDto {

	private Integer bookingOrderId;
	
	private double totalCost;
	
	private Map<Integer, Integer> productIds;
	
	private String email;
	
	/*
	 * private String customerName; private Address address;
	 */

	public OrderResponseDto() {
		super();

	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	
	/*
	 * public String getCustomerName() { return customerName; }
	 * 
	 * public void setCustomerName(String customerName) { this.customerName =
	 * customerName; }
	 * 
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<Integer, Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(Map<Integer, Integer> productIds) {
		this.productIds = productIds;
	}
	
	
}