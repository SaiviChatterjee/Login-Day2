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
		String sql = "SELECT * FROM user WHERE username = ? and password= ?";

		try {
			User retUser=jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName(),user.getPassword()}, (rs, rowNum) ->
	        new User(
	                rs.getInt("userid"),
	                rs.getString("username"),
	                rs.getString("password")
	        ));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
