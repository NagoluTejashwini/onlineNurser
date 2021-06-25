package com.ec.onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "seed")
@DiscriminatorValue("seed")
public class Seed extends Product{
	
	@ApiModelProperty(name = "SeedName", value = "Hold the min 3 char seed name", required = true)
	@NotEmpty(message = "Seed Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Seed Name, Seed Name should have minimum 3 and maximum 15 characters")
	@Column(unique = true)
	private String commonName;

	@ApiModelProperty(name = "Bloom Time", value = "Hold the min 3 char bloom time", required = true)
	@NotEmpty(message = "bloom time cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters")
	private String bloomTime;

	@ApiModelProperty(name = "Watering", value = "Should not be null", required = true)
	@NotEmpty(message = "watering cannot be left blank or null")
	private String watering;

	@ApiModelProperty(name = "Difficulty Level", value = "Should not be null", required = true)
	@NotEmpty(message = "difficulty level cannot be left blank or null")
	private String difficultyLevel;

	@ApiModelProperty(name = "Temperature", value = "Should not be null", required = true)
	@NotEmpty(message = "Temperature cannot be left blank or null")
	private String temparature;

	@ApiModelProperty(name = "Type of Seeds", value = "Should not be null", required = true)
	@NotEmpty(message = "Type of seeds cannot be left blank or null")
	private String typeOfSeeds;

	@ApiModelProperty(name = "Seeds Description", value = "Should not be null", required = true)
	@NotEmpty(message = "seeds description cannot be left blank or null")
	private String seedsDescription;

	@ApiModelProperty(name = "SeedStock", value = "Holds only positive value")
	@Positive(message = "Stock should be positive")
	private Integer seedsStock;

	@ApiModelProperty(name = "SeedCost", value = "Holds only positive value")
	@Positive(message = "Cost should be positive")
	private double seedsCost;

	@ApiModelProperty(name = "SeedsPerPacket", value = "Holds only positive value")
	@Positive(message = "SeedsPerPacket should be positive")
	private Integer seedsPerPacket;

	public Seed() {
		super();

	}

	public Seed(int pId,
			@NotEmpty(message = "Seed Name cannot be left blank or null") @Size(min = 3, max = 15, message = "Invalid Seed Name, Seed Name should have minimum 3 and maximum 15 characters") String commonName,
			@NotEmpty(message = "bloom time cannot be left blank or null") @Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters") String bloomTime,
			@NotEmpty(message = "watering cannot be left blank or null") String watering,
			@NotEmpty(message = "difficulty level cannot be left blank or null") String difficultyLevel,
			@NotEmpty(message = "Temperature cannot be left blank or null") String temparature,
			@NotEmpty(message = "Type of seeds cannot be left blank or null") String typeOfSeeds,
			@NotEmpty(message = "seeds description cannot be left blank or null") String seedsDescription,
			@Positive(message = "Stock should be positive") Integer seedsStock,
			@Positive(message = "Cost should be positive") double seedsCost,
			@Positive(message = "SeedsPerPacket should be positive") Integer seedsPerPacket) {
		super(pId);
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
	}

	

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemparature() {
		return temparature;
	}

	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}

	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}

	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}

	public String getSeedsDescription() {
		return seedsDescription;
	}

	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}

	public Integer getSeedsStock() {
		return seedsStock;
	}

	public void setSeedsStock(Integer seedsStock) {
		this.seedsStock = seedsStock;
	}

	public double getSeedsCost() {
		return seedsCost;
	}

	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}

	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloomTime == null) ? 0 : bloomTime.hashCode());
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		result = prime * result + ((difficultyLevel == null) ? 0 : difficultyLevel.hashCode());
	
		long temp;
		temp = Double.doubleToLongBits(seedsCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seedsDescription == null) ? 0 : seedsDescription.hashCode());
		result = prime * result + ((seedsPerPacket == null) ? 0 : seedsPerPacket.hashCode());
		result = prime * result + ((seedsStock == null) ? 0 : seedsStock.hashCode());
		result = prime * result + ((temparature == null) ? 0 : temparature.hashCode());
		result = prime * result + ((typeOfSeeds == null) ? 0 : typeOfSeeds.hashCode());
		result = prime * result + ((watering == null) ? 0 : watering.hashCode());
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
		Seed other = (Seed) obj;
		if (bloomTime == null) {
			if (other.bloomTime != null)
				return false;
		} else if (!bloomTime.equals(other.bloomTime))
			return false;
		if (commonName == null) {
			if (other.commonName != null)
				return false;
		} else if (!commonName.equals(other.commonName))
			return false;
		if (difficultyLevel == null) {
			if (other.difficultyLevel != null)
				return false;
		} else if (!difficultyLevel.equals(other.difficultyLevel))
			return false;
		
		if (Double.doubleToLongBits(seedsCost) != Double.doubleToLongBits(other.seedsCost))
			return false;
		if (seedsDescription == null) {
			if (other.seedsDescription != null)
				return false;
		} else if (!seedsDescription.equals(other.seedsDescription))
			return false;
		if (seedsPerPacket == null) {
			if (other.seedsPerPacket != null)
				return false;
		} else if (!seedsPerPacket.equals(other.seedsPerPacket))
			return false;
		if (seedsStock == null) {
			if (other.seedsStock != null)
				return false;
		} else if (!seedsStock.equals(other.seedsStock))
			return false;
		if (temparature == null) {
			if (other.temparature != null)
				return false;
		} else if (!temparature.equals(other.temparature))
			return false;
		if (typeOfSeeds == null) {
			if (other.typeOfSeeds != null)
				return false;
		} else if (!typeOfSeeds.equals(other.typeOfSeeds))
			return false;
		if (watering == null) {
			if (other.watering != null)
				return false;
		} else if (!watering.equals(other.watering))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seed [ commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering="
				+ watering + ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfSeeds="
				+ typeOfSeeds + ", seedsDescription=" + seedsDescription + ", seedsStock=" + seedsStock + ", seedsCost="
				+ seedsCost + ", seedsPerPacket=" + seedsPerPacket + "]";
	}

}
