package com.smartmart.app.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartmart.app.models.UserProfile;

@Repository

public class ResgistrationRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean isSaveData(UserProfile userProfile) {
		int value=jdbcTemplate.update("insert into users(user_id, first_name, last_name, email, phone_number,username,password,role) values(0,?,?,?,?,?,?,'user')",(ps)->{
			ps.setString(1, userProfile.getFirst_name());
			ps.setString(2,userProfile.getLast_name());
			ps.setString(3, userProfile.getEmail());
			ps.setString(4, userProfile.getPhone_number());
			ps.setString(5, userProfile.getUsername());
			ps.setString(6, userProfile.getPassword());
		});
		return value>0?true:false;
	}
	
	public String isGetRole(String username,String password) {
		List<String> role=jdbcTemplate.query("select role from users where username=? and password=?", (ps)->{ps.setString(1, username);
		ps.setString(2, password);
		},(rs,row)->{
			return rs.getString(1) ;
		});
		return role.get(0);
	}
}
