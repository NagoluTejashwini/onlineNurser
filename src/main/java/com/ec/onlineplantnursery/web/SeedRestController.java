package com.ec.onlineplantnursery.web;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.requestDto.SeedRequestDto;
import com.ec.onlineplantnursery.responseDto.SeedResponseDto;
import com.ec.onlineplantnursery.entity.Seed;
import com.ec.onlineplantnursery.service.ISeedServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/onlinenursery/seed")
@Api(value = "Online Nursery Application")
@CrossOrigin(origins = {"http://localhost:9093", "http://localhost:4200"}, allowedHeaders="*")
public class SeedRestController {

	Logger log = LoggerFactory.getLogger(SeedRestController.class);
	@Autowired
	ISeedServiceImpl seedService;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * Method Name:insertSeed 
	 * Parameters:SeedRequestDto
	 * ReturnType:SeedResponseDto
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 21/05/2021
	 */

	@ApiOperation(value = "seed post mapping", response = SeedResponseDto.class)
	@PostMapping("/add")
	public ResponseEntity<SeedResponseDto> insertSeed(@RequestBody @Valid SeedRequestDto seedDto) {

		log.info("insert seed");
		Seed seed = modelMapper.map(seedDto, Seed.class);
		Seed seed1 = seedService.addSeed(seed);
		SeedResponseDto seedResponse = modelMapper.map(seed1, SeedResponseDto.class);

		return new ResponseEntity<>(seedResponse, HttpStatus.CREATED);
	}

	/*
	 * Method Name:getAllSeeds 
	 * Parameters:No parameter 
	 * ReturnType:List<SeedResponseDto> 
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 21/05/2021
	 */

	/*@ApiOperation(value = "Seed Get mapping to fetch all seeds", response = List.class)
	@GetMapping("/seeds")
	public List<SeedResponseDto> getAllSeeds(@RequestParam  String sort) {
		
		log.info("inside Get all seeds information");
		
		return seedService.viewAllSeed(sort).stream().map(seed -> modelMapper.map(seed, SeedResponseDto.class))
				.collect(Collectors.toList());
	}*/
	
	@ApiOperation(value = "Seed Get mapping to fetch all seeds", response = List.class)
	@GetMapping("/seeds")
	public List<SeedResponseDto> getAllSeeds() {
		
		log.info("inside Get all seeds information");
		
		return seedService.viewAllSeeds().stream().map(seed -> modelMapper.map(seed, SeedResponseDto.class))
				.collect(Collectors.toList());
	}
	/*
	 * Method Name:getSeedById 
	 * Parameters:seedId 
	 * ReturnType:SeedResponseDto
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 21/05/2021
	 */

	@ApiOperation(value = "Seed Get mapping to fetch seed by id", response = SeedResponseDto.class)
	@GetMapping("/{id}")
	public ResponseEntity<SeedResponseDto> getSeedById(@PathVariable int id) throws SeedIdNotFoundException {
		
		log.info("inside Get seed information by id");
		Seed seed = seedService.viewSeed(id);
		SeedResponseDto seedResponse = modelMapper.map(seed, SeedResponseDto.class);
		
		return new ResponseEntity<>(seedResponse, HttpStatus.OK);

	}

	/*
	 * Method Name:deleteSeed 
	 * Parameters:SeedRequestDto
	 * ReturnType:SeedResponseDto
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@ApiOperation(value = "Seed Post mapping to delete seed", response = SeedResponseDto.class)
	@DeleteMapping("/delete")
	public ResponseEntity<SeedResponseDto> deleteSeed(@RequestBody SeedRequestDto seedRequestDto) throws SeedIdNotFoundException {
		
		log.info("inside delete seed");
		Seed seed = modelMapper.map(seedRequestDto, Seed.class);
		Seed deleteSeed = seedService.deleteSeed(seed);
		SeedResponseDto seedResponseDto = modelMapper.map(deleteSeed, SeedResponseDto.class);

		return new ResponseEntity<>(seedResponseDto, HttpStatus.OK);

	}

	/*
	 * Method Name:updateSeed 
	 * Parameters:SeedRequestDto
	 * ReturnType:SeedResponseDto
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@ApiOperation(value = "Seed Put mapping to update seed", response = SeedResponseDto.class)
	@PutMapping("/update")
	public ResponseEntity<SeedResponseDto> updateSeed(@RequestBody SeedRequestDto seedRequest) throws SeedIdNotFoundException {
		
		log.info("inside update seed"+seedRequest);
		System.out.println("->  inside update seed"+seedRequest);
		Seed seed = modelMapper.map(seedRequest, Seed.class);
		//System.out.println("->  inside update seed"+seed);
		Seed updatedSeed = seedService.updateSeed(seed);
		SeedResponseDto responseSeed = modelMapper.map(updatedSeed, SeedResponseDto.class);
		
		return new ResponseEntity<>(responseSeed, HttpStatus.OK);

	}

	/*
	 * Method Name:getSeedByCommonName 
	 * Parameters:commonName 
	 * ReturnType:SeedResponseDto
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@ApiOperation(value = "Seed Get mapping to fetch details of seed by commonName", response = SeedResponseDto.class)
	@GetMapping("/commonName/{commonName}")
	public ResponseEntity<SeedResponseDto> getSeedByCommonName(@PathVariable String commonName) throws ResourceNotFoundException {
		
		log.info("inside get seed by common name");
		Seed seed = seedService.viewSeed(commonName);
		SeedResponseDto seedResponse = modelMapper.map(seed, SeedResponseDto.class);
		
		return new ResponseEntity<>(seedResponse, HttpStatus.OK);
	}

	/*
	 * Method Name:getSeedsByTypeOfSeed 
	 * Parameters:typeOfSeed 
	 * ReturnType:List<SeedResponseDto>
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@ApiOperation(value = "Seed Get mapping to fetch all seeds by type of seed", response = List.class)
	@GetMapping("/type/{typeOfSeed}")
	public List<SeedResponseDto> getSeedsByTypeOfSeed(@PathVariable String typeOfSeed) throws ResourceNotFoundException {
		
		log.info("inside get seed by type of seed");
		return seedService.viewAllSeeds(typeOfSeed).stream().map(seed -> modelMapper.map(seed, SeedResponseDto.class))
				.collect(Collectors.toList());

	}
	

	

	
	
}
