package com.smartmart.app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartmart.app.models.Stock;

@Repository
public class ProductRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public boolean storeData(Stock stock) {
		String sql = "CALL AddProductWithStock(?, ?, ?, ?, ?, ?)";
        int value =jdbcTemplate.update(sql, (ps)->{
        	ps.setInt(1, stock.getCategory_id());
        	ps.setString(2, stock.getName());
        	ps.setInt(3, stock.getPrice());
        	ps.setString(4, stock.getDescription());
        	ps.setString(5, stock.getProduct_image_url());
        	ps.setInt(6, stock.getQuantity());
        }
        
           
        );
        return value>0?true:false;
	}
	
}
