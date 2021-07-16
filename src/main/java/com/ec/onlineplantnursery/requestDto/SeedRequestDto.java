package com.ec.onlineplantnursery.requestDto;

import java.util.Arrays;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.ec.onlineplantnursery.entity.Product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeedRequestDto {

	private int pId;
	
	
	
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

	
	private double cost;

	@ApiModelProperty(name = "SeedsPerPacket", value = "Holds only positive value")
	@Positive(message = "SeedsPerPacket should be positive")
	private Integer seedsPerPacket;

	
	public SeedRequestDto() {
		super();

	}

	public SeedRequestDto(int pId,
			String commonName,
			@NotEmpty(message = "bloom time cannot be left blank or null") @Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters") String bloomTime,
			@NotEmpty(message = "watering cannot be left blank or null") String watering,
			@NotEmpty(message = "difficulty level cannot be left blank or null") String difficultyLevel,
			@NotEmpty(message = "Temperature cannot be left blank or null") String temparature,
			@NotEmpty(message = "Type of seeds cannot be left blank or null") String typeOfSeeds,
			@NotEmpty(message = "seeds description cannot be left blank or null") String seedsDescription,
			@Positive(message = "Stock should be positive") Integer seedsStock,
			 double cost,
			@Positive(message = "SeedsPerPacket should be positive") Integer seedsPerPacket) {
		this.pId=pId;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.cost = cost;
		this.seedsPerPacket = seedsPerPacket;
		
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
		return "SeedRequestDto [pId=" + pId + ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering="
				+ watering + ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfSeeds="
				+ typeOfSeeds + ", seedsDescription=" + seedsDescription + ", seedsStock=" + seedsStock + ", seedsCost="
				+ cost + ", seedsPerPacket=" + seedsPerPacket +  "]";
	}

	

	
}
