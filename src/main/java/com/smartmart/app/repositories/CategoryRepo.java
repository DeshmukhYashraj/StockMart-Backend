package com.smartmart.app.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartmart.app.models.Category;

@Repository
public class CategoryRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public boolean isAddNewCategory(Category category) {
		int value =jdbcTemplate.update("INSERT INTO categories (category_id,category_name, image_url) values('0',?,?)",(ps)->{
			ps.setString(1, category.getCategory_name());
			ps.setString(2, category.getImage_url());
		});
		return value>0?true:false;
	}
	
	public List<Category> showAllData(){
		List<Category> al=jdbcTemplate.query("SELECT category_id, category_name, image_url, created_at FROM categories;", (rs,row)->{
			Category c=new Category();
			c.setCategory_id(rs.getInt(1));
			c.setCategory_name(rs.getString(2));
			c.setImage_url(rs.getString(3));
			return c;
		});
		return al;
	}
	
	public boolean isDeleteCategory(int id ) {
		int value=jdbcTemplate.update("delete from categories where category_id=? ",(ps)->{ps.setInt(1, id);});
		return value>0?true:false;
	}
	
	public boolean isUpdate(Category category) {
		int value=jdbcTemplate.update("UPDATE categories SET category_name = ?, image_url = ? WHERE category_id = ?",(ps)->{
			ps.setString(1, category.getCategory_name());
			ps.setString(2, category.getImage_url());
			ps.setInt(3, category.getCategory_id());
		});
		return value>0?true:false;
	}
}
