package com.ec.onlineplantnursery.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.entity.Product;
import com.ec.onlineplantnursery.repository.ProductRepo;
import com.ec.onlineplantnursery.requestDto.SeedRequestDto;
import com.ec.onlineplantnursery.responseDto.SeedResponseDto;
import com.ec.onlineplantnursery.entity.Seed;
import com.ec.onlineplantnursery.repository.ISeedRepository;

@Service
public class ISeedServiceImpl implements ISeedService {

	@Autowired
	ISeedRepository seedRepo;

	@Autowired
	ProductRepo proRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public ISeedServiceImpl(ISeedRepository seedRepo) {
		super();
		this.seedRepo = seedRepo;
	}

	/*
	 * Method Name:addSeed 
	 * Parameters:Seed 
	 * ReturnType:Seed 
	 * Author Name:Nagolu Tejashwini
	 *  Created Date: 21/05/2021
	 */

	@Override
	@Transactional
	public Seed addSeed(Seed seed) {

		
		seedRepo.save(seed);
		//int id = seed.getpId();
		//proRepo.save(seed);
		System.out.println("---> seed Service "+ seed);
		return seed;
	}

	/*
	 * Method Name:updateSeed 
	 * Parameters:Seed 
	 * ReturnType:Seed 
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@Override
	public Seed updateSeed(Seed seed) throws SeedIdNotFoundException {
		//System.out.println("---> Inside Seed Service"+seed.getpId());
		
		Optional<Seed> seed1 = seedRepo.findById(seed.getpId());
		//Seed updateSeed = modelMapper.map(seed, Seed.class);
		//System.err.println("---> inside seed service seed details"+seed1);
		if (seed1.isPresent()) {
			
			return seedRepo.save(seed);

		} else {
			throw new SeedIdNotFoundException(seed.getpId());
			
		}

	}

	/*
	 * Method Name:deleteSeed 
	 * Parameters:Seed 
	 * ReturnType:Seed 
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@Override
	@Transactional
	public Seed deleteSeed(Seed input) throws SeedIdNotFoundException {

		Optional<Seed> s = seedRepo.findById(input.getpId());
		if (s.isPresent()) {
			seedRepo.delete(input);
			return s.get();
		} else {
			throw new SeedIdNotFoundException(input.getpId());
		}

	}

	/*
	 * Method Name:viewSeed 
	 * Parameters:seedId 
	 * ReturnType:Seed 
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 21/05/2021
	 */

	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException {
		Optional<Seed> s = seedRepo.findById(seedId);
		if (s.isPresent()) {
			return s.get();

		} else {
			throw new SeedIdNotFoundException(seedId);
		}

	}

	/*
	 * Method Name:viewSeed 
	 * Parameters:commonName 
	 * Author Name:Nagolu Tejashwini
	 * ReturnType:Seed
	 * Created Date: 24/05/2021
	 */

	@Override
	public Seed viewSeed(String commonName) throws ResourceNotFoundException {
		Seed s1 = seedRepo.getSeedByCommonName(commonName);

		if (s1 != null) {

			return s1;
		} else {
			throw new ResourceNotFoundException(commonName);
		}
	}

	/*
	 * Method Name:viewAllSeeds
	 * Parameters:No Parameters
	 * ReturnType:List<Seed> 
	 * Author Name:Nagolu Tejashwini 
	 * Created Date:
	 * 21/05/2021
	 */


	@Override
	public List<Seed> viewAllSeed(String sort) {

		List<Seed> seedList = seedRepo.findAll();
		if(sort.equals("LowToHighCost")) {
			 Collections.sort(seedList, new ProductLowToHighCost());
			 return seedList;
		}
		else if(sort.equals("HighToLowCost")) {
			 Collections.sort(seedList, new ProductHighToLowCost());
			 return seedList;
		}
		else {
			return seedList;
		}
		
	}

	/*
	 * Method Name:viewAllSeeds 
	 * Parameters:Seed 
	 * ReturnType:Seed 
	 * Author Name:Nagolu Tejashwini 
	 * Created Date: 24/05/2021
	 */

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws ResourceNotFoundException {
		List<Seed> sList = seedRepo.getSeedsByTypeOfSeed(typeOfSeed);
		if (sList.isEmpty()) {
			
			throw new ResourceNotFoundException(typeOfSeed);

		} else {
			return sList;
		}

	}


	@Override
	public List<Seed> viewAllSeeds() {
		
		return seedRepo.findAll();
	}
	
	
	
}
