package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.*;

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

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.entity.Seed;
import com.ec.onlineplantnursery.repository.ISeedRepository;
import com.ec.onlineplantnursery.service.ISeedServiceImpl;

@SpringBootTest
class SeedServiceImplTest {

	ISeedRepository seedRepo;
	private static ISeedServiceImpl seedService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		seedRepo = mock(ISeedRepository.class); // test through approach 2
		seedService = new ISeedServiceImpl(seedRepo); // Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("Test-Save Seed")
	void testSaveSeed() {
		Seed input = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		Seed output = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		when(seedRepo.save(input)).thenReturn(output);
		Seed result = seedService.addSeed(input);
		verify(seedRepo).save(input);
		assertEquals(output, result);
	}

	@Test
	@DisplayName("Test-Get All Seeds")
	void testGetAllSeeds() {

		Seed s1 = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		Seed s2 = new Seed(2,"Papaya", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		List<Seed> seedList1 = new ArrayList<>();
		seedList1.add(s1);
		seedList1.add(s2);

		when(seedRepo.findAll()).thenReturn(seedList1);
		List<Seed> seedListOutput = seedService.viewAllSeeds();
		verify(seedRepo).findAll();
		assertIterableEquals(seedList1, seedListOutput);

	}

	@Test
	@DisplayName("Test-Get Seed by Id")
	void testViewSeedById() throws SeedIdNotFoundException {
		Seed s = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		Optional<Seed> s1 = Optional.of(s);
		when(seedRepo.findById(1)).thenReturn(s1);
		Seed s2 = seedService.viewSeed(1);
		verify(seedRepo).findById(1);
		assertEquals(s2, s);

	}

	@Test
	@DisplayName("Test-Get Seed by Id using invalid entry")
	void testViewSeedByIdNotExisting() throws SeedIdNotFoundException {
		Seed s = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		Optional<Seed> s1 = Optional.of(s);

		when(seedRepo.findById(1)).thenReturn(s1);
		Executable executable = () -> seedService.viewSeed(2);
		assertThrows(SeedIdNotFoundException.class, executable);
	}

	@Test
	@DisplayName("Test-Get Seed by common Name ")
	void testViewSeedByName() throws ResourceNotFoundException {
		Seed s = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		String commonName = "Mango";
		when(seedRepo.getSeedByCommonName(commonName)).thenReturn(s);
		Seed s1 = seedService.viewSeed(commonName);
		verify(seedRepo).getSeedByCommonName(commonName);
		assertEquals(s1, s);
	}

	@Test
	@DisplayName("Test-Resource not found exception by common name ")
	void testExceptionViewSeedByName() {
		Seed input = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		String commonName = "abc";
		try {
			when(seedRepo.getSeedByCommonName(commonName)).thenReturn(input);
			Seed output = seedService.viewSeed(commonName);
			verify(seedRepo).getSeedByCommonName(commonName);
			assertNotNull(output);
		} catch (ResourceNotFoundException e) {

		}
	}

	@Test
	@DisplayName("Test-Get Seed by type of seed ")
	void testViewSeedByTypeOfSeed() throws ResourceNotFoundException {
		Seed s1 = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		Seed s2 = new Seed(2,"Papaya", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(s1);
		seedList.add(s2);
		String typeOfSeed = "Monocotyledonous";
		when(seedRepo.getSeedsByTypeOfSeed(typeOfSeed)).thenReturn(seedList);
		List<Seed> seedListOutput = seedService.viewAllSeeds(typeOfSeed);
		verify(seedRepo).getSeedsByTypeOfSeed(typeOfSeed);
		assertIterableEquals(seedList, seedListOutput);
	}

	@Test
	@DisplayName("Test-Get Seed by type of seed ")
	void testExceptionViewSeedByTypeOfSeed() throws ResourceNotFoundException {

		Seed s1 = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		Seed s2 = new Seed(2,"Papaya", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 200, 300, 2000);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(s1);
		seedList.add(s2);
		String typeOfSeed = "Dicotylendonous";
		try {
			when(seedRepo.getSeedsByTypeOfSeed(typeOfSeed)).thenReturn(seedList);
			List<Seed> seedListOutput = seedService.viewAllSeeds(typeOfSeed);
			verify(seedRepo).getSeedsByTypeOfSeed(typeOfSeed);
			assertNotNull(seedListOutput);
		} catch (ResourceNotFoundException e) {
		}

	}

	@Test
	@DisplayName("Test-Delete seed")
	void testDeleteSeed() throws SeedIdNotFoundException {

		Seed input = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 250, 300, 2000);
		when(seedRepo.findById(input.getpId())).thenReturn(Optional.of(input));
		Seed output = seedService.deleteSeed(input);
		verify(seedRepo).delete(input);
		assertEquals(input, output);
	}

	

	@Test
	@DisplayName("Test-Update seed")
	void testUpdateSeed() throws SeedIdNotFoundException {
		Seed input = new Seed(1,"Mango", "Morning", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 250, 300, 2000);
		Seed savedInput = new Seed(1,"Mango", "Evening", "Twice a day", "easy", "25ºC", "Monocotyledonous",
				"This seed is a small embryonic plant", 250, 300, 2000);

		when(seedRepo.findById(input.getpId())).thenReturn(Optional.of(input));
		when(seedRepo.save(savedInput)).thenReturn(savedInput);
		Seed output = seedService.updateSeed(savedInput);
		assertEquals(savedInput, output);
	}

	
	
}//end
