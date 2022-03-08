package com.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.product.model.LoggerProduct;

@Repository
public interface LoggerRepository extends MongoRepository<LoggerProduct, String>{

	
}
