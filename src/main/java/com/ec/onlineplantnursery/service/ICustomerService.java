package com.ec.onlineplantnursery.service;

import java.util.List;


import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer tenant) throws ResourceNotFoundException;

	Customer deleteCustomer(Customer tenant) throws ResourceNotFoundException;

	Customer viewCustomer(int customerId) throws ResourceNotFoundException;

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
}
