package com.smartmart.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartmart.app.models.Category;
import com.smartmart.app.services.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {

    
	@Autowired
	private CategoryService categoryService;

   
	@PostMapping("/add")
	public String addCategory(@RequestBody Category category) {
		if (categoryService.isAddNewCategory(category)) {
			return "category is added";
		} else {
			return "category is not added";
		}
	}
	
	@GetMapping("/showAll")
	public List<Category> showData(){
		return categoryService.showAllData();
	}
	
	@DeleteMapping("/delete")
	public String isDelete(@RequestParam int id) {
		if (categoryService.isDeleteCategory(id)) {
			return "category is deleted";
		} else {
			return "category is not deleted";
		}
	}
	
	@PutMapping("/update")
	public String isUpdate(@RequestBody Category category){
		if (categoryService.isUpdate(category)) {
			return "category is updates";
		} else {
			return "category is not updated";
		}
		
	}
	
	
}
