package com.ec.onlineplantnursery.requestDto;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.entity.Planter;

import lombok.Data;

@Data
public class OrderRequestDTO {

	private Integer bookingOrderId;

	@FutureOrPresent(message = "Date cannot be in Past")
	private LocalDate orderDate;

	@NotEmpty(message = "transactionMode cannot be left blank or null")
	private String transactionMode;

	@Positive(message = "quantity should be positive")
	private int quantity;

	private double totalCost;

	private Customer customer;

	private List<Planter> planters;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Planter> getPlanters() {
		return planters;
	}

	public void setPlanters(List<Planter> planters) {
		this.planters = planters;
	}

}
