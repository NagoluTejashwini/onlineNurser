package com.ec.onlineplantnursery.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.onlineplantnursery.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer>, CustomOrderRepository {
	/*@Query("select p.plantCost from Plant p where p.plantId in(Select pl.plant.plantId from Planter pl where pl.planterId =:planterId)")
	 double findPlantCostByPlanterId(@Param("planterId") Integer planterId);
	
	@Query("select s.seedsCost from Seed s where s.seedId in(Select pl.seed.seedId from Planter pl where pl.planterId =:planterId)")
	double findSeedCostByPlanterId(@Param("planterId") Integer planterId);
	
	@Query("Select pl.planterCost from Planter pl where planterId =:planterId")
	double findCostByPlanterId(@Param("planterId") Integer planterId);*/
	

}
