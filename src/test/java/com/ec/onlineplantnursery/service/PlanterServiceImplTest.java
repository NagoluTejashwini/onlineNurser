package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.repository.IPlantRepository;

import com.ec.onlineplantnursery.service.IPlantServiceImpl;
import com.ec.onlineplantnursery.entity.Planter;

import com.ec.onlineplantnursery.repository.IPlanterRepository;
import com.ec.onlineplantnursery.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.entity.Seed;
import com.ec.onlineplantnursery.repository.ISeedRepository;

import com.ec.onlineplantnursery.service.ISeedServiceImpl;

@SpringBootTest
public class PlanterServiceImplTest {

	IPlanterRepository planterRepo;
	IPlantRepository plantRepo;
	ISeedRepository seedRepo;
	private static IPlanterServiceImpl planterService;
	private static IPlantServiceImpl plantService;
	private static ISeedServiceImpl seedService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit()
	{
		planterRepo = mock(IPlanterRepository.class); // test through approach 2
		planterService = new  IPlanterServiceImpl(planterRepo); 	// Approach 2
		plantRepo = mock(IPlantRepository.class);
		plantService = new IPlantServiceImpl(plantRepo);
		seedRepo = mock(ISeedRepository.class);
		seedService = new ISeedServiceImpl(seedRepo);
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}

	


	@Test
	@DisplayName("Test-Get All Planters , Args:- No Args to pass")
	void testGetAllPlanters() {


		List<Planter> pList = mock(List.class); 
		when(planterRepo.findAll()).thenReturn(pList);
		List<Planter> outputOrderList = planterService.viewAllPlanters();
		verify(planterRepo).findAll();
		assertEquals(pList, outputOrderList);

	}

	@Test
	@DisplayName("Test-Get Planter by Id , Args:- Passing PlanterId")
	void testViewPlanterById() throws ResourceNotFoundException{

		int input = 52;
		Planter planter = mock(Planter.class);
		Optional<Planter> optional = Optional.of(planter);
		when(planterRepo.findById(input)).thenReturn(optional);
		Optional<Planter> output = Optional.of(planterService.viewPlanter(input));
		verify(planterRepo).findById(input);
		assertEquals(optional, output);

	}
	
	@Test
	@DisplayName("Test-Exception for Get Planter by range")
	public void testViewPlanterByIdException() {
		
		int input = 20;
		when(planterRepo.findById(input)).thenReturn(Optional.ofNullable(null));
		Executable executable = ()->planterService.viewPlanter(input);
		assertThrows(ResourceNotFoundException.class, executable);
	}

	@Test
	@DisplayName("Test-Get Planter by Planter Shape , Args:- Passing planterShape")
	void testViewPlanterByShape() throws ResourceNotFoundException {


		String planterShape = "square";
		
		Plant plant = new Plant(1, 4, 13, "Rose", "Once a week", "medicinal", "easy", "20 C", "Succulent", "This is a stemless or very short-stemmed plant", "wide", 200);
	    Seed seed = new Seed(1,"Money", "One week", "Once a day", "easy", "20ºC", "Monocotyledonous", "This seed is a small embryonic plant", 20, 100.0, 1000);
	    
	    Planter planter = new Planter(102, 11, 2, 2, 2, "square", 5, 110);
		List<Planter> pList = new ArrayList<>();
		pList.add(planter);
		when(planterRepo.viewPlanter(planterShape)).thenReturn(pList);
		List<Planter> outputOrderList = planterService.viewPlanter(planterShape);
		verify(planterRepo).viewPlanter(planterShape);
		assertEquals(pList, outputOrderList);

	}
	

	@Test
	@DisplayName("Test-Get Planter by range , Args:- minCost, maxCost")
	void testViewPlanterByRange() throws ResourceNotFoundException {


		double minCost = 100;
		double maxCost = 150;
		
		Plant plant = new Plant(1, 4, 13, "Rose", "Once a week", "medicinal", "easy", "20 C", "Succulent", "This is a stemless or very short-stemmed plant", "wide", 200);
	    Seed seed = new Seed(1,"Money", "One week", "Once a day", "easy", "20ºC", "Monocotyledonous", "This seed is a small embryonic plant", 20, 100.0, 1000);
		
		Planter planter = new Planter(102, 11, 2, 2, 2, "square", 5, 110);
		List<Planter> pList = new ArrayList<>();
		pList.add(planter);
		when(planterRepo.getPlantersByRange(minCost,maxCost)).thenReturn(pList);;	
		List<Planter> outputOrderList = planterService.viewAllPlanters(minCost, maxCost);
		verify(planterRepo).getPlantersByRange(minCost,maxCost);
		assertEquals(pList, outputOrderList);
		
	}
	

	@Test
	@DisplayName("Test-Delete Planter , Args:- planter")
	void testDeletePlanter() throws ResourceNotFoundException {

		Seed sinput = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		Planter input = new Planter(1,12,3,2,23,"Round",45,30);
		
		when(planterRepo.findById(input.getpId())).thenReturn(Optional.of(input));
		Planter testPlanter = planterService.deletePlanter(input);
		assertEquals(input,testPlanter);
		
	}
	
	
	@Test
	@DisplayName("Test-Delete Planter , Args:- pass planter")
	public void testDeletePlanterException() {
		
		Planter input = mock(Planter.class);
		
		when(planterRepo.findById(123)).thenReturn(Optional.of(input));
		Executable executable = ()->planterService.deletePlanter(input);
		assertThrows(ResourceNotFoundException.class, executable);
	}

	@Test
	@DisplayName("Test-Update Planter , Args:- No Args to pass")
	void testUpdatePlanter() throws ResourceNotFoundException {
		Seed sinput = new Seed(1,"Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		Planter input = new Planter(1,12,3,2,23,"Round",45,30);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Square",45,30);

		
		when(planterRepo.findById(1)).thenReturn(Optional.of(input));
		
		when(planterRepo.save(savedPlanter)).thenReturn(savedPlanter);
		Planter testPlanter =   planterService.updatePlanter(savedPlanter);
		assertEquals(savedPlanter, testPlanter);
	}
	
	@Test
	@DisplayName("Test-Exception for Update Planter , Args:- No Args to pass")
	public void testUpdatePlanterException() {
		
		Planter input = mock(Planter.class);
		
		when(planterRepo.findById(123)).thenReturn(Optional.of(input));
		Executable executable = ()->planterService.updatePlanter(input);
		assertThrows(ResourceNotFoundException.class, executable);
	}

}