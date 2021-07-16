package com.ec.onlineplantnursery.web;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
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
import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.User;
import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.requestDto.OrderRequestDTO;
import com.ec.onlineplantnursery.responseDto.OrderResponseDto;
import com.ec.onlineplantnursery.responseDto.PlanterResponseDto;
import com.ec.onlineplantnursery.service.IOrderServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("/onlinenursery/order")


@Api(value = "Online Nursery Application")
public class OrderRestController {
	Logger log = org.slf4j.LoggerFactory.getLogger(OrderRestController.class);

	@Autowired
	private IOrderServiceImpl ordService;
	@Autowired
	private ModelMapper modelMapper;
	

	/*
	 * Method Name:insertProduct 
	 * Parameters:Order 
	 * ReturnType:OrderDTO 
	 * AuthorName:Suhana 
	 * Created Date: 23/05/2021
	 */

	@ApiOperation(value = "Order Post mapping to add order", response = Order.class)
	@PostMapping("/add")
	public ResponseEntity<OrderResponseDto> insertOrder(@RequestBody @Valid OrderRequestDTO orderdto)throws ResourceNotFoundException {

		Order orderRequest = modelMapper.map(orderdto, Order.class);
		Order order = ordService.addOrder(orderRequest);
		OrderResponseDto orderResponse = modelMapper.map(order, OrderResponseDto.class);
		/*
		 * User user = order.getUser(); Customer c = (Customer) user;
		 * orderResponse.setCustomerName(c.getCustomerName());
		 * orderResponse.setAddress(c.getAddress());
		 */
		orderResponse.setEmail(order.getUser().getEmail());
		
		orderResponse.setProductIds(order.getProductQuantityMap());
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
	}
	

	/*
	 * Method Name:viewAllOrders 
	 * Parameters:No Parameters 
	 * ReturnType:List<OrderDTO>
	 * Author Name:Suhana 
	 * Created Date: 23/05/2021
	 */

	@ApiOperation(value = "Order Get mapping to fetch all orders", response = List.class)
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponseDto>> viewAllOrders() throws ResourceNotFoundException{
		
		log.info("Get all Orders");
		List<Order> orders = ordService.viewAllOrders();
		List<OrderResponseDto> orderResponsesList = new ArrayList<>();
		for (Order order : orders) {
			OrderResponseDto orderResponse = modelMapper.map(order, OrderResponseDto.class);
			/*
			 * User user = order.getUser(); Customer c = (Customer) user;
			 * orderResponse.setCustomerName(c.getCustomerName());
			 * orderResponse.setAddress(c.getAddress());
			 */
			orderResponse.setEmail(order.getUser().getEmail());
			orderResponse.setProductIds(order.getProductQuantityMap());
			orderResponsesList.add(orderResponse);
		}
		return new ResponseEntity<>(orderResponsesList, HttpStatus.OK);
		
		

	}

	/*
	 * Method Name:viewPlantersListByOrderId 
	 * Parameters:id 
	 * ReturnType:List<PlanterResponseDTO>
	 * Author Name:Suhana 
	 * Created Date: 23/05/2021
	 */

	@ApiOperation(value = "Order Get mapping to fetch list of planters by order id")
	@GetMapping("/planter/{id}")
	public List<PlanterResponseDto> viewPlantersListByOrderId(@PathVariable int id) throws ResourceNotFoundException {
		
		log.info("Inside finding planters using order id");
		return ordService.viewPlanterByOrderId(id).stream().map(planter -> modelMapper.map(planter, PlanterResponseDto.class))
				.collect(Collectors.toList());
	}

	/*
	 * Method Name:updateByOrder 
	 * Parameters:Order 
	 * ReturnType:Order Author
	 * Name:Suhana
	 * Created Date: 23/05/2021
	 */

	@ApiOperation(value = "Order Put mapping to fetch and update order", response = List.class)
	@PutMapping("/update")
	public ResponseEntity<OrderResponseDto> updateByOrder(@RequestBody OrderRequestDTO o)
			throws ResourceNotFoundException {
		log.info("Update order");
		
		Order orderRequest = modelMapper.map(o, Order.class);
		Order order = ordService.updateOrder(orderRequest);
		OrderResponseDto orderResponse = modelMapper.map(order, OrderResponseDto.class);
		/*
		 * User user = order.getUser(); Customer c = (Customer) user;
		 * orderResponse.setCustomerName(c.getCustomerName());
		 * orderResponse.setAddress(c.getAddress());
		 */
		orderResponse.setEmail(order.getUser().getEmail());
		orderResponse.setProductIds(order.getProductQuantityMap());
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
			
	}

	/*
	 * Method Name:deleteOrder 
	 * Parameters:oid 
	 * ReturnType:Order 
	 * Author Name:Supriya
	 * Created Date: 23/05/2021
	 */

	@ApiOperation(value = "Order Delete mapping to delete order", response = Order.class)
	@DeleteMapping("/delete/{oid}")
	public ResponseEntity<OrderResponseDto> deleteOrder(@PathVariable int oid) throws ResourceNotFoundException {
		
		log.info("Delete order");
		Order order = this.ordService.deleteOrder(oid);
		OrderResponseDto orderResponse = modelMapper.map(order, OrderResponseDto.class);
		/*
		 * User user = order.getUser(); Customer c = (Customer) user;
		 * orderResponse.setCustomerName(c.getCustomerName());
		 * orderResponse.setAddress(c.getAddress());
		 */
		orderResponse.setEmail(order.getUser().getEmail());
		orderResponse.setProductIds(order.getProductQuantityMap());
		OrderResponseDto deletedOrder = modelMapper.map(orderResponse, OrderResponseDto.class);
		return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
	}

	/*
	 * Method Name:viewOrderById 
	 * Parameters:id 
	 * ReturnType:OrderDTO Author
	 * Name:Supriya 
	 * Created Date: 23/05/2021
	 */

	
	@ApiOperation(value = "Order Get mapping to fetch order by order id", response = Order.class)
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDto> viewOrderById(@PathVariable int id) throws OrderIdNotFoundException{
		
		log.info("Inside view order using orderid");
		Order order = this.ordService.viewOrder(id);
		OrderResponseDto orderResponse = modelMapper.map(order, OrderResponseDto.class);
		/*
		 * User user = order.getUser(); Customer c = (Customer) user;
		 * orderResponse.setCustomerName(c.getCustomerName());
		 * orderResponse.setAddress(c.getAddress());
		 */
		orderResponse.setEmail(order.getUser().getEmail());
		orderResponse.setProductIds(order.getProductQuantityMap());

		return new ResponseEntity<>(orderResponse, HttpStatus.OK);

	}

}