package com.ec.onlineplantnursery.repository;

import java.util.List;

import com.ec.onlineplantnursery.entity.Plant;

public interface CustomPlantRepository {
	Plant viewPlant(String commonName);

	List<Plant> viewAllPlants(String typeOfPlant);

}
