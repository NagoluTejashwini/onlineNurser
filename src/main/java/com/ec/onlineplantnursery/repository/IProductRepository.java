package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ec.onlineplantnursery.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{
	Product findBypId(int pId);

}