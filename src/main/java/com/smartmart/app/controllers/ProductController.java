package com.smartmart.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartmart.app.models.Stock;
import com.smartmart.app.services.ProductService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/add")
	public String addProduct(@RequestBody Stock stock) {
		if (productService.storeData(stock)) {
			return "product is added";
		} else {

			return "product is not added";
		}
	}
	
	@GetMapping("/showAll")
	public List<Stock> showAllProduct(){
		return productService.showAllProduct();
	}
	
	@GetMapping("/showProductByCategory")
	public List<Stock> showAllProductByCategory(@RequestParam String category){
		return productService.showAllProductByCategory(category);
	}
	
	@DeleteMapping("/delete")
	public String deletProduct(@RequestParam int id) {
		if (productService.isdeleteProduct(id)) {
			return "the product was deleted";
		} else {
			return "product was not deleted";
		}
	
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Stock stock) {
		if (productService.isUpdateProduct(stock)) {
			return "the product was Updated";
		} else {
			return "product was not Updated";
		}
	}
	
	
}
