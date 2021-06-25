package com.ec.onlineplantnursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.onlineplantnursery.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>, CustomCustomerRepository{
	@Query("select c from Customer c where c.username =:username")
	List<Customer> findByUserName(@Param("username") String username);
	
}
