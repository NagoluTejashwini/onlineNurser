package com.ec.onlineplantnursery.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.service.IPlantService;
import com.ec.onlineplantnursery.requestDto.PlantRequestDto;

import com.ec.onlineplantnursery.responseDto.PlantResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/onlinenursery/plant")
@Api(value = "My Plant Nursery")
@CrossOrigin(origins = {"http://localhost:9093", "http://localhost:4200"}, allowedHeaders="*")
public class PlantRestController {

	Logger log = LoggerFactory.getLogger(PlantRestController.class);

	@Autowired
	private IPlantService plantService;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * Method Name:addPlant 
	 * Parameters:PlantRequestDto
	 * ReturnType:Plant 
	 * Author Name:Ambidi Swathi 
	 * Created Date: 22/05/2021
	 */

	@ApiOperation(value = "Add Plant", response = PlantResponseDto.class)
	@PostMapping("/add")
	public ResponseEntity<PlantResponseDto> addPlant(@Valid @RequestBody PlantRequestDto plantDto) {

		log.info("Inside insert Plant");
		Plant p1 = modelMapper.map(plantDto, Plant.class);
		Plant p2 = plantService.addPlant(p1);
		PlantResponseDto plantResponse = modelMapper.map(p2, PlantResponseDto.class);

		return new ResponseEntity<>(plantResponse, HttpStatus.CREATED);
	}

	/*
	 * Method Name:updatePlant 
	 * Parameters:PlantRequestDto
	 * ReturnType:PlantResponseDto 
	 * Author Name:Ambidi Swathi 
	 * Created Date: 22/05/2021
	 */

	@ApiOperation(value = "Updating a plant", response = PlantResponseDto.class)
	@PutMapping("/update")
	public ResponseEntity<PlantResponseDto> updatePlant(@RequestBody PlantRequestDto plantDto) {

		log.info("Inside Update Plant");
		Plant plant1 = modelMapper.map(plantDto, Plant.class);
		Plant plant2 = plantService.addPlant(plant1);
		PlantResponseDto plantResponse = modelMapper.map(plant2, PlantResponseDto.class);

		return new ResponseEntity<>(plantResponse, HttpStatus.OK);
	}

	/*
	 * Method Name:deletePlant 
	 * Parameters:PlantRequestDto
	 * ReturnType:PlantResponseDto
	 * Author Name:Ambidi Swathi 
	 * Created Date: 25/05/2021
	 */

	@ApiOperation(value = "Delete Plant", response = PlantResponseDto.class)
	@DeleteMapping("/delete")
	public ResponseEntity<PlantResponseDto> deletePlant(@RequestBody PlantRequestDto plantDto) throws PlantIdNotFoundException {

		log.info("Inside Delete Plant");
		Plant plant = modelMapper.map(plantDto, Plant.class);
		Plant deletePlant = plantService.deletePlant(plant);
		PlantResponseDto plantResponseDto = modelMapper.map(deletePlant, PlantResponseDto.class);
		
		return new ResponseEntity<>(plantResponseDto, HttpStatus.OK);
	}

	/*
	 * Method Name:viewAllPlants 
	 * Parameters: No Parameters 
	 * ReturnType:List<PlantResponseDto>
	 * Author Name:Ambidi Swathi C
	 * reated Date: 24/05/2021
	 */

	@ApiOperation(value = "view All Plants", response = PlantResponseDto.class)
	@GetMapping("/plants")
	public List<PlantResponseDto> viewAllPlants() {

		log.info("Inside view Plants");
		
		return plantService.viewAllPlants().stream().map(plant -> modelMapper.map(plant, PlantResponseDto.class))
				.collect(Collectors.toList());

	}

	/*
	 * Method Name:viewAllPlants 
	 * Parameters:typeOfPlant 
	 * ReturnType:List<PlantResponseDto>
	 * Author Name:Ambidi Swathi 
	 * Created Date: 24/05/2021
	 */

	@ApiOperation(value = "view All Plants by type of Plant", response = List.class)
	@GetMapping("/type/{typeOfPlant}")
	public List<PlantResponseDto> viewAllPlants(@PathVariable String typeOfPlant) throws ResourceNotFoundException {
		
		log.info("Inside View Plants by type of Plant");
		
		return plantService.viewAllPlants(typeOfPlant).stream()
				.map(plant -> modelMapper.map(plant, PlantResponseDto.class)).collect(Collectors.toList());

	}

	/*
	 * Method Name:viewPlant 
	 * Parameters:PlantId 
	 * ReturnType:PlantResponseDto
	 * Author Name:Ambidi Swathi 
	 * Created Date: 23/05/2021
	 */

	@ApiOperation(value = "view Plant", response = PlantResponseDto.class)
	@GetMapping("/{plantId}")
	public ResponseEntity<PlantResponseDto> viewPlant(@PathVariable int plantId) throws PlantIdNotFoundException {
		
		log.info("Inside View Plant by Id");
		Plant plant = plantService.viewPlant(plantId);
		PlantResponseDto plantResponse = modelMapper.map(plant, PlantResponseDto.class);
		
		return new ResponseEntity<>(plantResponse, HttpStatus.OK);

	}

	/*
	 * Method Name:viewPlant 
	 * Parameters:commonName 
	 * ReturnType:PlantResponseDto
	 * Author Name:Ambidi Swathi 
	 * Created Date: 24/05/2021
	 */

	@ApiOperation(value = "view Plant by Name", response = PlantResponseDto.class)
	@GetMapping("/commonName/{commonName}")
	public ResponseEntity<PlantResponseDto> viewPlant(@PathVariable String commonName) throws ResourceNotFoundException {

		log.info("Inside View Plant by common Name");
		
		Plant plant = plantService.viewPlant(commonName);
		PlantResponseDto plantResponse = modelMapper.map(plant, PlantResponseDto.class);
		return new ResponseEntity<>(plantResponse, HttpStatus.OK);

	}

}