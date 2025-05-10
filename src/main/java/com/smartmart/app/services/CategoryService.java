package com.smartmart.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartmart.app.models.Category;
import com.smartmart.app.repositories.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	public boolean isAddNewCategory(Category category) {
		return categoryRepo.isAddNewCategory(category);
	}
	
	public List<Category> showAllData(){
		return categoryRepo.showAllData();
	}
	
	public boolean isDeleteCategory(int id ) {
		return categoryRepo.isDeleteCategory(id);
	}
	
	public boolean isUpdate(Category category) {
		return categoryRepo.isUpdate(category);
	}
}
