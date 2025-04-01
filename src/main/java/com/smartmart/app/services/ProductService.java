package com.smartmart.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartmart.app.models.Stock;
import com.smartmart.app.repositories.ProductRepository;

@Service
public class ProductService {

   
	@Autowired
	private ProductRepository productRepository;

   
	public boolean storeData(Stock stock) {
		return productRepository.storeData(stock);
	}
}
