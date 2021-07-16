package com.ec.onlineplantnursery.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ec.onlineplantnursery.entity.Transaction;
import com.ec.onlineplantnursery.service.TransactionServiceImpl;

import io.swagger.annotations.Api;

@RestController
@Validated
@RequestMapping("/onlinenursery/transaction")


@Api(value = "Online Nursery Application")

public class TransactionRestController {
	
	@Autowired
	TransactionServiceImpl transactionService;
	
	
	@PostMapping("/add")
	public Transaction makeTransaction(@RequestBody Transaction t) {
		return transactionService.makeTransaction(t);
	}

}