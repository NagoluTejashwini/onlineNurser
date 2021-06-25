package com.ec.onlineplantnursery.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.entity.Plant;

public class CustomPlantRepositoryImpl implements CustomPlantRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public Plant viewPlant(String commonName) {

		Query q = entityManager.createQuery("from Plant where commonName=:commonName");
		q.setParameter("commonName", commonName);
		return (Plant) q.getSingleResult();
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {

		Query q = entityManager.createQuery("from Plant where typeOfPlant=:typeOfPlant");
		q.setParameter("typeOfPlant", typeOfPlant);
		return q.getResultList();
	}

}
