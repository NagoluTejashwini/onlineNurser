package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.onlineplantnursery.entity.Planter;

public interface IPlanterRepository extends JpaRepository<Planter, Integer>, CustomPlanterRepository {
	
}
