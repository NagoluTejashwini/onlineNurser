package com.ec.onlineplantnursery.responseDto;

import java.util.List;


import com.ec.onlineplantnursery.entity.Address;
import com.ec.onlineplantnursery.entity.Planter;

public class OrderResponseDto {

	private Integer bookingOrderId;
	private int quantity;
	private double totalCost;
	private String customerName;
	private Address address;
	private List<Planter> planterIds;

	public OrderResponseDto() {
		super();

	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Planter> getPlanterIds() {
		return planterIds;
	}

	public void setPlanterIds(List<Planter> planterIds) {
		this.planterIds = planterIds;
	}

}
