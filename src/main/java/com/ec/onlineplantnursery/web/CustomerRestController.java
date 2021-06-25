package com.ec.onlineplantnursery.web;



import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.requestDto.CustomerRequestDto;
import com.ec.onlineplantnursery.responseDto.CustomerResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/onlinenursery/customer")
@Api(value = "Online Nursery Application")
public class CustomerRestController {
	
	Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired
	private ICustomerServiceImpl custService;

	@Autowired
	private ModelMapper modelMapper;

	
	public CustomerRestController() {
		log.info("NurseryRestController -- constructor ");
	}
	
	/*Method Name:viewCustomer
	 *Parameters:cid
	 *ReturnType:CustomerResponseDto
	 *Author Name:sri vidya
	 *Created Date: 24/05/2021 */
	
	@GetMapping("/{cid}")
	@ApiOperation(value = "Customer Get mapping to fetch customer by id" , response = CustomerResponseDto.class)
	public ResponseEntity<CustomerResponseDto> viewCustomer(@PathVariable int cid) throws ResourceNotFoundException {
		
		log.info("Get customer with Id");
		Customer customer = custService.viewCustomer(cid);
		CustomerResponseDto customerResponse = modelMapper.map(customer, CustomerResponseDto.class);
		
		return new ResponseEntity<>(customerResponse, HttpStatus.OK);
		
	}
	
	/*Method Name:addCustomer
	 *Parameters:CustomerRequestDto
	 *ReturnType:CustomerResponseDto
	 *Author Name:sri vidya
	 *Created Date: 24/05/2021 */
	
	@PostMapping("/add")
	@ApiOperation(value = "customer post mapping" , response = CustomerResponseDto.class)
	public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody @Valid CustomerRequestDto customerdto) {
		
		log.info("postmapping insert customer");
		Customer customer = modelMapper.map(customerdto, Customer.class);
		Customer cust = custService.addCustomer(customer);
		CustomerResponseDto customerResponse = modelMapper.map(cust, CustomerResponseDto.class);
		
		return new ResponseEntity(customerResponse, HttpStatus.CREATED);
	}
	
	
	/*Method Name:viewAllCustomers
	 *Parameters:No parameters
	 *ReturnType:List<CustomerResponseDto>
	 *Author Name:sri vidya
	 *Created Date: 24/05/2021 */
	
	@GetMapping("/viewall")
	@ApiOperation(value = "Customer Get mapping to fetch all customer" , response = CustomerResponseDto.class)
	public List<CustomerResponseDto> viewAllCustomers() {
		
		log.info("Get all Customers");
		
		return custService.viewAllCustomers().stream().map(customer-> modelMapper.map(customer, CustomerResponseDto.class)).collect(Collectors.toList());
		

	}
	
	
	/*Method Name:updateCustomer
	 *Parameters:CustomerRequestDto
	 *ReturnType:CustomerResponseDto
	 *Author Name:sri vidya
	 *Created Date: 24/05/2021 */
	@PutMapping("/update")
	@ApiOperation(value = "Customer Put mapping to update Customer" , response = CustomerResponseDto.class)
	public ResponseEntity<CustomerResponseDto> updateCustomer(@RequestBody @Valid CustomerRequestDto c) throws ResourceNotFoundException
	{
		log.info("put mapping update customer");
		Customer updateCustomer = modelMapper.map(c, Customer.class);
		Customer customer = this.custService.updateCustomer(updateCustomer);
		CustomerResponseDto customerResponse = modelMapper.map(customer, CustomerResponseDto.class);
	
		return new ResponseEntity<>(customerResponse, HttpStatus.OK);
	
	}

	/*Method Name:deleteCustomer
	 *Parameters:CustomerRequestDto
	 *ReturnType:CustomerResponseDto
	 *Author Name:sri vidya
	 *Created Date: 24/05/2021 */
	
 	@DeleteMapping("/delete")
	@ApiOperation(value = "Customer Post mapping to delete Customer" , response = CustomerResponseDto.class)
	public ResponseEntity<CustomerResponseDto> deleteCustomer(@RequestBody @Valid CustomerRequestDto customerDto) throws ResourceNotFoundException {
		
 		log.info("post mapping delete customer");
		Customer customer = modelMapper.map(customerDto, Customer.class);
		Customer deleteCustomer = custService.deleteCustomer(customer);
		CustomerResponseDto customerResponseDto = modelMapper.map(deleteCustomer, CustomerResponseDto.class);
		
		
		return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
		
	}
	

	/*Method Name:validateCustomer
	 *Parameters:username, password
	 *ReturnType:boolean
	 *Author Name:sri vidya
	 *Created Date: 24/05/2021 */
 	
	@GetMapping("/validate/{uname}/{pass}")
	@ApiOperation(value = "Customer Get mapping to customer username and password" , response = Customer.class)
	public boolean validateCustomer(@PathVariable String uname, @PathVariable String pass) {
		log.info("get validation for username and password");
		return custService.validateCustomer(uname, pass);
	}
}