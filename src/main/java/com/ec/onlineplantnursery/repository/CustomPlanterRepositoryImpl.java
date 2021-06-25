package com.ec.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.entity.Planter;


public class CustomPlanterRepositoryImpl implements CustomPlanterRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Planter> viewPlanter(String shape) {

		Query q = entityManager.createQuery("from Planter where planterShape=:abc");
		q.setParameter("abc", shape);
		return q.getResultList();

	}

	@Override
	public List<Planter> getPlantersByRange(double minCost, double maxCost) {

		Query q = entityManager.createQuery("from Planter pl where pl.planterCost >=:minCost and pl.planterCost <=: maxCost");
		q.setParameter("minCost", minCost);
		q.setParameter("maxCost", maxCost);
		return q.getResultList();

	}

}
