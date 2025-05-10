package com.smartmart.app.services;

import java.util.List;

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
	public List<Stock> showAllProduct(){
		return productRepository.showAllProduct();
	}
	
	public List<Stock> showAllProductByCategory(String category){
		return productRepository.showAllProductByCategory(category);
	}
	
	public boolean isdeleteProduct(int id) {
		return productRepository.isdeleteProduct(id);
	}
	
	public boolean isUpdateProduct(Stock stock) {
		return productRepository.isUpdateProduct(stock);
	}
}
