package com.ec.onlineplantnursery.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionsInfo")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int transactionId;
	
	private String transactionMode;
	
	@OneToOne
	@JoinColumn(name = "OrderInfo", referencedColumnName = "bookingOrderId")
	private Order order;

	public Transaction() {
		super();
		
	}

	public Transaction(int transactionId, String transactionMode, Order order) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.order = order;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + transactionId;
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
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
		Transaction other = (Transaction) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionMode=" + transactionMode + ", order="
				+ order + "]";
	}

	
}