package com.ec.onlineplantnursery.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;



import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "plant")
//@DiscriminatorValue("plant")
public class Plant extends Product{
	

	@Positive(message = "Height of plant should be positive")
	private Integer plantHeight;

	@NotEmpty(message = "Plant spread cannot be blank")
	@Size(min = 3, max = 15, message = "Invalid Plant spread")
	private String plantSpread;


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


	public Plant() {
		super();

	}

	public Plant(int pId, double cost,String commonName) {
		super(pId, cost,commonName);
		// TODO Auto-generated constructor stub
	}

	public Plant(@Positive(message = "Height of plant should be positive") Integer plantHeight,
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
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantsStock = plantsStock;
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bloomTime == null) ? 0 : bloomTime.hashCode());
		result = prime * result + ((difficultyLevel == null) ? 0 : difficultyLevel.hashCode());
		result = prime * result + ((medicinalOrCulinaryUse == null) ? 0 : medicinalOrCulinaryUse.hashCode());
		result = prime * result + ((plantDescription == null) ? 0 : plantDescription.hashCode());
		result = prime * result + ((plantHeight == null) ? 0 : plantHeight.hashCode());
		result = prime * result + ((plantSpread == null) ? 0 : plantSpread.hashCode());
		result = prime * result + ((plantsStock == null) ? 0 : plantsStock.hashCode());
		result = prime * result + ((temparature == null) ? 0 : temparature.hashCode());
		result = prime * result + ((typeOfPlant == null) ? 0 : typeOfPlant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plant other = (Plant) obj;
		if (bloomTime == null) {
			if (other.bloomTime != null)
				return false;
		} else if (!bloomTime.equals(other.bloomTime))
			return false;
		if (difficultyLevel == null) {
			if (other.difficultyLevel != null)
				return false;
		} else if (!difficultyLevel.equals(other.difficultyLevel))
			return false;
		if (medicinalOrCulinaryUse == null) {
			if (other.medicinalOrCulinaryUse != null)
				return false;
		} else if (!medicinalOrCulinaryUse.equals(other.medicinalOrCulinaryUse))
			return false;
		if (plantDescription == null) {
			if (other.plantDescription != null)
				return false;
		} else if (!plantDescription.equals(other.plantDescription))
			return false;
		if (plantHeight == null) {
			if (other.plantHeight != null)
				return false;
		} else if (!plantHeight.equals(other.plantHeight))
			return false;
		if (plantSpread == null) {
			if (other.plantSpread != null)
				return false;
		} else if (!plantSpread.equals(other.plantSpread))
			return false;
		if (plantsStock == null) {
			if (other.plantsStock != null)
				return false;
		} else if (!plantsStock.equals(other.plantsStock))
			return false;
		if (temparature == null) {
			if (other.temparature != null)
				return false;
		} else if (!temparature.equals(other.temparature))
			return false;
		if (typeOfPlant == null) {
			if (other.typeOfPlant != null)
				return false;
		} else if (!typeOfPlant.equals(other.typeOfPlant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plant [plantHeight=" + plantHeight + ", plantSpread=" + plantSpread + ", commonName=" + getCommonName()
				+ ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse=" + medicinalOrCulinaryUse
				+ ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfPlant="
				+ typeOfPlant + ", plantDescription=" + plantDescription + ", plantsStock=" + plantsStock + "]";
	}

	

	

}