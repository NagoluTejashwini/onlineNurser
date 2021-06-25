package com.ec.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.ec.onlineplantnursery.entity.Address;
import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.repository.ICustomerRepository;
import com.ec.onlineplantnursery.service.ICustomerServiceImpl;

import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.repository.IOrderRepository;
import com.ec.onlineplantnursery.service.IOrderServiceImpl;

import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.repository.IPlanterRepository;
import com.ec.onlineplantnursery.service.IPlanterServiceImpl;

@SpringBootTest
class OrderServiceImplTest {

	IOrderRepository orderRepo;
	ICustomerRepository custRepo;
	IPlanterRepository planterRepo;
	@InjectMocks
	private static IOrderServiceImpl orderService;
	private static ICustomerServiceImpl customerService;
	private static IPlanterServiceImpl planterService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		orderRepo = mock(IOrderRepository.class);
		custRepo = mock(ICustomerRepository.class);
		planterRepo = mock(IPlanterRepository.class);
		customerService = new ICustomerServiceImpl(custRepo);
		planterService = new IPlanterServiceImpl(planterRepo);
		ac = MockitoAnnotations.openMocks(this);

	}

	@AfterEach
	public void doEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("Test-save order")
	void testSaveOrder() throws ResourceNotFoundException {
		List<Integer> planterIds = Arrays.asList(1, 2);
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", (long) 500045);
		Customer cust = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25);
		Planter p2 = new Planter(1, 5.3f, 2, 2, 1, "square", 20, 30);
		List<Planter> pList = Arrays.asList(p1, p2);
		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, cust, pList);

		when(orderRepo.save(input)).thenReturn(input);
		Order orderTest = orderService.addOrder(input);
		verify(orderRepo).save(input);
		assertEquals(input, orderTest);

	}

	@Test
	@DisplayName("Test-Exception for save order")
	void testSaveOrderException() {
		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, null, null);

		when(orderRepo.save(input)).thenReturn(null);
		Executable executable = () -> orderService.addOrder(input);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Exception for planter id")
	void testExceptionbyId() {
		List<Integer> planterIds = Arrays.asList(1, 2);
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", (long) 500045);
		Customer cust = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25);
		Planter p2 = new Planter(1, 5.3f, 2, 2, 1, "square", 20, 30);
		List<Planter> pList = Arrays.asList(p1, p2);
		LocalDate date = LocalDate.now();
		Optional<Order> input = Optional.of(new Order(101, date, "online", 1, 20.00, cust, pList));

		Optional<Order> outputOrder = Optional.empty();
		when(orderRepo.findById(101)).thenReturn(input);
		Executable executable = () -> orderService.viewOrder(105);
		assertThrows(OrderIdNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-get order by id")
	void testGetOrderById() throws OrderIdNotFoundException {
		int input = 101;
		Order order = mock(Order.class);
		Optional<Order> optional = Optional.of(order);
		when(orderRepo.findById(input)).thenReturn(optional);
		Optional<Order> output = Optional.of(orderService.viewOrder(input));
		verify(orderRepo).findById(input);
		assertEquals(optional, output);
	}

	@Test
	@DisplayName("Test-Get All Orders, Args:- No Args to pass")
	void testGetAllOrders() {
		List<Order> orderList = mock(List.class);
		when(orderRepo.findAll()).thenReturn(orderList);
		List<Order> outputOrderList = orderService.viewAllOrders();
		verify(orderRepo).findAll();
		assertEquals(orderList, outputOrderList);
	}

	@Test
	@DisplayName("Test-Delete Order , Args:- No Args to pass")
	void testDeleteOrder() throws ResourceNotFoundException {

		List<Integer> planterIds = Arrays.asList(1, 2);
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", (long) 500045);
		Customer cust = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25);
		Planter p2 = new Planter(1, 5.3f, 2, 2, 1, "square", 20, 30);
		List<Planter> pList = Arrays.asList(p1, p2);
		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, cust, pList);
		Order savedOrder = new Order(101, date, "online", 1, 20.00, cust, pList);
		Optional<Order> optionalOrder = Optional.of(input);
		when(orderRepo.findById(101)).thenReturn(optionalOrder);

		doNothing().when(orderRepo).deleteById(101);

		Order test_Order = orderService.deleteOrder(input.getBookingOrderId());

		verify(orderRepo).deleteById(input.getBookingOrderId());
		assertEquals(input, savedOrder);

	}

	@Test
	@DisplayName("Test-Update order")
	void testUpdateOrder() throws ResourceNotFoundException {
		List<Integer> planterIds = Arrays.asList(1, 2);
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", (long) 500045);
		Customer cust = new Customer(1, "Suhana", "suhana123@gmail.com", "suhana2268", "123456", address);
		Planter p1 = new Planter(1, 2.3f, 4, 3, 1, "round", 46, 25);
		Planter p2 = new Planter(1, 5.3f, 2, 2, 1, "square", 20, 30);
		List<Planter> pList = Arrays.asList(p1, p2);
		LocalDate date = LocalDate.now();
		Order input = new Order(101, date, "online", 1, 20.00, cust, pList);
		Optional<Order> optional_order = Optional.of(input);
		Order savedOrder = new Order(101, date, "offline", 1, 20.00, cust, pList);
		when(orderRepo.findById(101)).thenReturn(optional_order);
		when(orderRepo.save(savedOrder)).thenReturn(savedOrder);
		Order outputOrder = orderService.updateOrder(savedOrder);
		assertEquals(savedOrder, outputOrder);
	}


}
