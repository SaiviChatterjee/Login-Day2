package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(User user) {
		int row = jdbcTemplate.update("INSERT INTO user(u_name,u_contact,u_company,u_gender,u_country,u_state,u_city) VALUES(?, ?, ?, ?, ?, ?, ?)", user.getName(), user.getContact(), user.getCompany(), user.getGender(), user.getCountry(), user.getState(), user.getCity());
		if(row>0) {
			return true;
		}
		return false;
	}

}
