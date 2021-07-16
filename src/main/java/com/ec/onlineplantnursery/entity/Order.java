package com.ec.onlineplantnursery.entity;

import java.time.LocalDate;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;


import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "order_generator")
	private Integer bookingOrderId;
	


	@ApiModelProperty(name = "OrderDate", value = "Holds date of order and cannot be past")
	@FutureOrPresent(message ="Order date cannot be past")
	private LocalDate orderDate;

	
	/**@ApiModelProperty(name = "TransactionMode", value = "Cannot be empty")
	@NotEmpty(message = "transactionMode cannot be left blank or null")
	private String transactionMode;**/

	
	/*@ApiModelProperty(name = "Quantity", value = "Holds positive value")
	@ElementCollection
	private List<Integer> quantity;*/
	
	@ApiModelProperty(name = "TotalCost", value = "Holds positive value")
	private double totalCost;
	
	private int orderStatus;

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "Customer_Info", referencedColumnName = "userId")
	 * //@JoinTable(name = "Customer_Order_info", joinColumns = @JoinColumn(name =
	 * "bookingOrderId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	 * private Customer customer;
	 */
	
	
	@ManyToOne
	@JoinColumn(name = "User_Info", referencedColumnName = "userId")
	private User user;

	
	
	
	
	
	@ElementCollection
	@CollectionTable(name = "order_product",
	joinColumns =  {@JoinColumn(name = "orderId", referencedColumnName = "bookingOrderId")})
	@MapKeyColumn(name = "pId")
	@Column(name = "quantity")
	
	private Map<Integer, Integer> productQuantityMap;
	
	
	public Order() {
		super();

	}


	public Order(Integer bookingOrderId, @FutureOrPresent(message = "Order date cannot be past") LocalDate orderDate,
			double totalCost, int orderStatus, Customer customer, User user, Map<Integer, Integer> productQuantityMap) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		//this.customer = customer;
		this.user = user;
		this.productQuantityMap = productQuantityMap;
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


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public int getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}


	/*
	 * public Customer getCustomer() { return customer; }
	 * 
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Map<Integer, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}


	public void setProductQuantityMap(Map<Integer, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingOrderId == null) ? 0 : bookingOrderId.hashCode());
		//result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderStatus;
		result = prime * result + ((productQuantityMap == null) ? 0 : productQuantityMap.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (bookingOrderId == null) {
			if (other.bookingOrderId != null)
				return false;
		} else if (!bookingOrderId.equals(other.bookingOrderId))
			return false;
		/*
		 * if (customer == null) { if (other.customer != null) return false; } else if
		 * (!customer.equals(other.customer)) return false;
		 */
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (productQuantityMap == null) {
			if (other.productQuantityMap != null)
				return false;
		} else if (!productQuantityMap.equals(other.productQuantityMap))
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", totalCost=" + totalCost
				+ ", orderStatus=" + orderStatus + ", user=" + user + ", productQuantityMap=" + productQuantityMap
				+ "]";
	}


	


	
	
}