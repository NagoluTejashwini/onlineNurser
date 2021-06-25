package com.ec.onlineplantnursery.repository;

import java.util.List;


import com.ec.onlineplantnursery.entity.Seed;

public interface CustomSeedRepository {

	Seed getSeedByCommonName(String commonName);

	List<Seed> getSeedsByTypeOfSeed(String typeOfSeed);


}
