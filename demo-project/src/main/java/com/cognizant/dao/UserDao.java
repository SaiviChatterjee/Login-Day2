package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean validate(User user) {
		String sql = "SELECT * FROM user WHERE u_name = ? and u_password= ?";

		try {
			User retUser=jdbcTemplate.queryForObject(sql, new Object[]{user.getName(),user.getPassword()}, (rs, rowNum) ->
	        new User(
	                rs.getInt("u_id"),
	                rs.getString("u_name"),
	                rs.getString("u_password"),
	        		rs.getString("u_contact"),
	        		rs.getString("u_company"), 
	        		rs.getString("u_gender"),
	        		rs.getString("u_country"),
	        		rs.getString("u_state"),
	        		rs.getString("u_city")
	        ));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean insert(User user) {
		int row = jdbcTemplate.update("INSERT INTO user(u_name,u_password,u_contact,u_company,u_gender,u_country,u_state,u_city) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", user.getName(), user.getPassword(), user.getContact(), user.getCompany(), user.getGender(), user.getCountry(), user.getState(), user.getCity());
		if(row>0) {
			return true;
		}
		return false;
	}

}
