package com.ec.onlineplantnursery.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Transaction;
import com.ec.onlineplantnursery.repository.IOrderRepository;
import com.ec.onlineplantnursery.repository.ITransactionRepository;


@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	ITransactionRepository transactionRepository;
	
	@Autowired
	IOrderRepository orderRepository;

	@Transactional
	@Override
	public Transaction makeTransaction(Transaction t) {
		
		Optional<Transaction> transaction = transactionRepository.findById(t.getTransactionId());
		if(transaction.isEmpty()) {
			transactionRepository.save(t);
			Order order = t.getOrder();
			order.setOrderStatus(1);
			orderRepository.save(order);
			
			
		}
		
		return t;
	}

	

}