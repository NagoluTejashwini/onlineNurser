package com.ec.onlineplantnursery.requestDto;

import java.time.LocalDate;

import java.util.Map;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.entity.User;

import lombok.Data;

@Data
public class OrderRequestDTO {

	private Integer bookingOrderId;

	@FutureOrPresent(message = "Date cannot be in Past")
	private LocalDate orderDate;

	@NotEmpty(message = "transactionMode cannot be left blank or null")
	private String transactionMode;

	
	
	

	private double totalCost;

	//private Customer customer;

	private Map<Integer, Integer> productQuantityMap;
	
	private User user;

	public OrderRequestDTO() {
		super();

	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/*
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */

	public Map<Integer, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}

	public void setProductQuantityMap(Map<Integer, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}