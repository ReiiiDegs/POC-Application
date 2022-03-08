package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.product.model.LoggerProduct;
import com.product.repository.LoggerRepository;

@Service
public class ServiceLoggerImpl implements ServiceLogger{

	@Autowired
	LoggerRepository loggerRepository;
	
	@Override
	@KafkaListener(topics = "Products", groupId = "loggerId")
	public void consumes(String data) {

		LoggerProduct loggerProduct = new LoggerProduct();
		loggerProduct.setData(data);
		loggerRepository.save(loggerProduct);
	}

}
