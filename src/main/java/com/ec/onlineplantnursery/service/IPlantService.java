package com.ec.onlineplantnursery.service;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant) throws PlantIdNotFoundException;

	Plant deletePlant(Plant plant) throws PlantIdNotFoundException;

	Plant viewPlant(int plantId) throws PlantIdNotFoundException ;

	Plant viewPlant(String commonName) throws ResourceNotFoundException;

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlants(String typeOfPlant) throws ResourceNotFoundException;
}
