package com.ec.onlineplantnursery.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int imageId;

	private String imageName;
	
	private String imageType;
	
	@Column(name = "picByte", length = Integer.MAX_VALUE)
	private byte[] picByte;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;

	
	
	
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String imageName, String imageType, byte[] picByte) {
		super();
		this.imageName = imageName;
		this.imageType = imageType;
		this.picByte = picByte;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + imageId;
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageType == null) ? 0 : imageType.hashCode());
		result = prime * result + Arrays.hashCode(picByte);
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Image other = (Image) obj;
		if (imageId != other.imageId)
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (imageType == null) {
			if (other.imageType != null)
				return false;
		} else if (!imageType.equals(other.imageType))
			return false;
		if (!Arrays.equals(picByte, other.picByte))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imageName=" + imageName + ", imageType=" + imageType + ", picByte="
				+ Arrays.toString(picByte) + ", product=" + product + "]";
	}
	
	
	

}
