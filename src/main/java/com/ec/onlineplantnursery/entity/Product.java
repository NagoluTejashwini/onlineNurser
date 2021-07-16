package com.ec.onlineplantnursery.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "Product_Type",discriminatorType = DiscriminatorType.STRING)
public class Product implements Comparable<Product>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int pId;
	
	@ApiModelProperty(name = "SeedName", value = "Hold the min 3 char seed name", required = true)
	@NotEmpty(message = "Seed Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Seed Name, Seed Name should have minimum 3 and maximum 15 characters")
	private String commonName;

	private double cost;

	public Product() {
		super();
		
	}

	public Product(int pId, double cost,String commonName) {
		super();
		this.pId = pId;
		this.cost = cost;
		this.commonName=commonName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
	

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pId;
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
		Product other = (Product) obj;
		if (commonName == null) {
			if (other.commonName != null)
				return false;
		} else if (!commonName.equals(other.commonName))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (pId != other.pId)
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", commonName=" + commonName + ", cost=" + cost + "]";
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}