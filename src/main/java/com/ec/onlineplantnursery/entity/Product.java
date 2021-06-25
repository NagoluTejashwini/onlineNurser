package com.ec.onlineplantnursery.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Product_Type",discriminatorType = DiscriminatorType.STRING)
public class Product implements Comparable<Product>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int pId;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(int pId) {
		super();
		this.pId = pId;
	}



	public int getpId() {
		return pId;
	}



	public void setpId(int pId) {
		this.pId = pId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (pId != other.pId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Product [pId=" + pId + "]";
	}



	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}



