package com.ec.onlineplantnursery.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.entity.Planter;

import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.repository.IOrderRepository;
import com.ec.onlineplantnursery.repository.IProductRepository;


@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRep;
	
	@Autowired
	IProductRepository productRepository;
	
	

	public IOrderServiceImpl() {
		super();
	}

	
	public IOrderServiceImpl(IOrderRepository orderRep) {
		super();
		this.orderRep = orderRep;
	}

	/*
	 * Method Name:addOrder Parameters:Order ReturnType:Optional<Order> Author
	 * Name:Suhana Created Date: 21/05/2021
	 */
	@Override
	public Order addOrder(Order order) throws ResourceNotFoundException {
		
			double totalCost = 0;
			double unitCost = 0;
			double cost = 0;
			
			HashMap<Integer, Integer> products = (HashMap<Integer, Integer>) order.getProductQuantityMap();
			System.out.println("Products"+products);
			for(Entry<Integer, Integer> i : products.entrySet()) {
				
				unitCost = (productRepository.findBypId(i.getKey()).getCost());
				cost = i.getValue()*unitCost;
				totalCost += cost;
				
			}
			order.setTotalCost(totalCost);
			orderRep.save(order);
			return order;
	
		
	}

	/*
	 * Method Name:updateOrder
	 * Parameters:Order 
	 * ReturnType:Order 
	 * Author Name:Suhana
	 * Created Date: 21/05/2021
	 */

	
	
	@Override
	@Transactional
	public Order updateOrder(Order order) throws ResourceNotFoundException {
		System.out.println(order.getBookingOrderId());
		Optional<Order> existingOrder = orderRep.findById(order.getBookingOrderId());
		System.out.println(existingOrder);
		System.out.println(order.getBookingOrderId());
		if(existingOrder.isPresent()) {
			double totalCost = 0;
			double unitCost = 0;
			double cost = 0;
			
			HashMap<Integer, Integer> products = (HashMap<Integer, Integer>) order.getProductQuantityMap();
			System.out.println("Products"+products);
			for(Entry<Integer, Integer> i : products.entrySet()) {
				
				unitCost = (productRepository.findBypId(i.getKey()).getCost());
				cost = i.getValue()*unitCost;
				totalCost += cost;
				
			}
			order.setTotalCost(totalCost);
			orderRep.save(order);
			return order;
		}
		else {
			throw new ResourceNotFoundException();
		}
	}

	/*
	 * Method Name:deleteOrder Parameters:orderId ReturnType:Order Author
	 * Name:Suhana Created Date: 21/05/2021
	 */

	@Override
	public Order deleteOrder(int orderId) throws ResourceNotFoundException {

		Optional<Order> o = orderRep.findById(orderId);
		if (o.isPresent()) {

			orderRep.deleteById(orderId);
			System.out.println(o.get());
			return o.get();
		} else {
			throw new ResourceNotFoundException();
		}

	}

	/*
	 * Method Name:viewOrder Parameters:orderId ReturnType:Optional<Order> Author
	 * Name:Suhana Created Date: 21/05/2021
	 */

	@Override
	@Transactional
	public Order viewOrder(int orderId) throws OrderIdNotFoundException {

		Optional<Order> op = orderRep.findById(orderId);

		if (op.isPresent()) {
			/**List<Product> productList = op.get().getProducts();
			System.out.println(productList);
			int index = 0;
			for(int i: op.get().getQuantity()) {
				System.out.println("Product = "+productList.get(index).getpId()+" Quantity = "+i);
				index += 1;
			}**/
			
			return op.get();
		} else {
			throw new OrderIdNotFoundException(orderId);
		}

	}

	/*
	 * Method Name:viewAllOrder Parameters:No parameters ReturnType:List<Order>
	 * Author Name:Suhana Created Date: 21/05/2021
	 */

	@Override
	public List<Order> viewAllOrders() {
		

		return orderRep.findAll();
	}

	/*
	 * Method Name:viewPlanterByOrderId Parameters:Order ReturnType:List<Planter>
	 * Author Name:Suhana Created Date: 21/05/2021
	 */

	@Override
	public List<Planter> viewPlanterByOrderId(int orderId) throws ResourceNotFoundException {

		
		List<Planter> planters = orderRep.getPlanterByOrderId(orderId);
		if(planters.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		else {
			return planters;
		}
	}

}