package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.entity.Plant;

public interface IPlantRepository extends JpaRepository<Plant, Integer>, CustomPlantRepository {

}
