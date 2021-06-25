package com.ec.onlineplantnursery.repository;

import java.util.List;

import com.ec.onlineplantnursery.entity.Customer;

public interface CustomCustomerRepository {

	public List<Customer> findByUserName(String username);
}
