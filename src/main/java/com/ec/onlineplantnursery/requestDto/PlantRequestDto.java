package com.ec.onlineplantnursery.requestDto;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlantRequestDto {

	private int pId;
	
	@Positive(message = "Height of plant should be positive")
	private Integer plantHeight;

	@NotEmpty(message = "Plant spread cannot be blank")
	@Size(min = 3, max = 15, message = "Invalid Plant spread")
	private String plantSpread;

	@Column(unique = true)
	@NotEmpty(message = "Plant Name cannot be blank")
	@Size(min = 3, max = 15, message = "Invalid Plant Name")
	private String commonName;

	@ApiModelProperty(name = "Bloom Time", value = "Hold the min 3 char bloom time", required = true)
	@NotEmpty(message = "bloom time cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters")
	private String bloomTime;

	private String medicinalOrCulinaryUse;

	@ApiModelProperty(name = "Difficulty Level", value = "Should not be null", required = true)
	@NotEmpty(message = "difficulty level cannot be left blank or null")
	private String difficultyLevel;

	@ApiModelProperty(name = "Temperature", value = "Should not be null", required = true)
	@NotEmpty(message = "Temperature cannot be left blank or null")
	private String temparature;

	@NotNull
	// @Size(min=3, max=15, message="Invalid Plant type")
	private String typeOfPlant;

	@ApiModelProperty(name = "Plant Description", value = "Should not be null", required = true)
	@NotEmpty(message = "plant description cannot be left blank or null")
	private String plantDescription;

	@ApiModelProperty(name = "PlantStock", value = "Holds only positive value")
	@Positive(message = "Stock should be positive")
	private Integer plantsStock;

	@Positive(message = "Enter valid cost")
	private double plantCost;

	
	

	public PlantRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlantRequestDto(int pId, @Positive(message = "Height of plant should be positive") Integer plantHeight,
			@NotEmpty(message = "Plant spread cannot be blank") @Size(min = 3, max = 15, message = "Invalid Plant spread") String plantSpread,
			@NotEmpty(message = "Plant Name cannot be blank") @Size(min = 3, max = 15, message = "Invalid Plant Name") String commonName,
			@NotEmpty(message = "bloom time cannot be left blank or null") @Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters") String bloomTime,
			String medicinalOrCulinaryUse,
			@NotEmpty(message = "difficulty level cannot be left blank or null") String difficultyLevel,
			@NotEmpty(message = "Temperature cannot be left blank or null") String temparature,
			@NotNull String typeOfPlant,
			@NotEmpty(message = "plant description cannot be left blank or null") String plantDescription,
			@Positive(message = "Stock should be positive") Integer plantsStock,
			@Positive(message = "Enter valid cost") double plantCost) {
		super();
		this.pId = pId;
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantsStock = plantsStock;
		this.plantCost = plantCost;
	}

	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public Integer getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getPlantSpread() {
		return plantSpread;
	}

	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
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

	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}

	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
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

	public String getTypeOfPlant() {
		return typeOfPlant;
	}

	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public Integer getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}

	public double getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}

	@Override
	public String toString() {
		return "PlantRequestDto [pId=" + pId + ", plantHeight=" + plantHeight + ", plantSpread=" + plantSpread
				+ ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse="
				+ medicinalOrCulinaryUse + ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature
				+ ", typeOfPlant=" + typeOfPlant + ", plantDescription=" + plantDescription + ", plantsStock="
				+ plantsStock + ", plantCost=" + plantCost + "]";
	}

	
}
