package com.ec.onlineplantnursery.responseDto;

import java.util.Arrays;

import com.ec.onlineplantnursery.entity.Product;

public class SeedResponseDto {

	private int pId;
	private String commonName;
	private String bloomTime;
	private String watering;
	private String difficultyLevel;
	private String temparature;
	private String typeOfSeeds;
	private String seedsDescription;
	private Integer seedsStock;
	private double cost;
	private Integer seedsPerPacket;
	
	
	public SeedResponseDto() {
		super();

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

	
	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}


	

	@Override
	public String toString() {
		return "SeedResponseDto [pId=" + pId + ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering="
				+ watering + ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfSeeds="
				+ typeOfSeeds + ", seedsDescription=" + seedsDescription + ", seedsStock=" + seedsStock + ", seedsCost="
				+ cost + ", seedsPerPacket=" + seedsPerPacket + "]";
	}





	
	

}
