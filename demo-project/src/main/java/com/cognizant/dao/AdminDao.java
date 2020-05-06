package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Admin;

@Repository
public class AdminDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean validate(Admin admin) {
		String sql = "SELECT * FROM admin WHERE a_name = ? and a_password= ?";

		try {
			Admin retAdmin=jdbcTemplate.queryForObject(sql, new Object[]{admin.getName(),admin.getPassword()}, (rs, rowNum) ->
	        new Admin(
	                rs.getInt("a_id"),
	                rs.getString("a_name"),
	        		rs.getString("a_password")
	        ));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
