package com.smartmart.app.repositories;

import java.util.List;

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
	
	public List<Stock> showAllProduct(){
		String data="select p.product_id,p.name,p.price,p.description,p. product_image_url,s.quantity from products p inner join stock s on p.product_id=s.product_id;";
		List<Stock> li=jdbcTemplate.query(data,(rs,row)->{
			Stock s=new Stock();
			s.setProduct_id(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPrice(rs.getInt(3));
			s.setDescription(rs.getString(4));
			s.setProduct_image_url(rs.getString(5));
			s.setQuantity(rs.getInt(6));
			
			return s;
		});
		return li;
	}
	
	public List<Stock> showAllProductByCategory(String category){
		String data=" select p.product_id,p.name,p.price,p.description,p. product_image_url,s.quantity from products p inner join stock s on p.product_id=s.product_id inner join categories c on c.category_id=p.category_id where c.category_name=?";
		List<Stock> li=jdbcTemplate.query(data,(ps)->ps.setString(1, category),(rs,row)->{
			Stock s=new Stock();
			s.setProduct_id(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPrice(rs.getInt(3));
			s.setDescription(rs.getString(4));
			s.setProduct_image_url(rs.getString(5));
			s.setQuantity(rs.getInt(6));
			
			return s;
		});
		return li;
	}
	
	public boolean isdeleteProduct(int id) {
		int value=jdbcTemplate.update("delete from products where product_id=?",(ps)->{ps.setInt(1, id);});
		return value>0?true:false;
	}
	
	public boolean isUpdateProduct(Stock stock) {
		String sql = "CALL UpdateProductAndStock(?, ?, ?, ?, ?, ?,?)";
		 int value =jdbcTemplate.update(sql, (ps)->{
	        	ps.setInt(1, stock.getProduct_id());
	        	ps.setString(2, stock.getName());
	        	ps.setString(3, stock.getCategory_name());
	        	ps.setInt(4, stock.getPrice());
	        	ps.setString(5, stock.getDescription());
	        	ps.setString(6, stock.getProduct_image_url());
	        	ps.setInt(7, stock.getQuantity());
		 } 
	        );
	        return value>0?true:false;
	}
	
}
