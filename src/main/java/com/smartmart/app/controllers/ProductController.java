package com.smartmart.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartmart.app.models.Stock;
import com.smartmart.app.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
	
}
