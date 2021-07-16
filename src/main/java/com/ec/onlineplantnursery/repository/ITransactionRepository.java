package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.entity.Transaction;


public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

}