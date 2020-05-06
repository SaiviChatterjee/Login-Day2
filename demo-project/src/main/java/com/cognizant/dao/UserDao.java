package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(User user) {
		String sql="INSERT INTO user(u_name,u_contact,u_company,u_gender,u_country,u_state,u_city) VALUES(?, ?, ?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(sql, user.getName(), user.getContact(), user.getCompany(), user.getGender(), user.getCountry(), user.getState(), user.getCity());
		if(row>0) {
			return true;
		}
		return false;
	}
	
	public User get(int id) {
		String sql = "SELECT * FROM user WHERE u_id= ?";
		User retUser=jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
        new User(
                rs.getInt("u_id"),
                rs.getString("u_name"),
        		rs.getString("u_contact"),
                rs.getString("u_company"),
        		rs.getString("u_gender"),
                rs.getString("u_country"),
        		rs.getString("u_state"),
                rs.getString("u_city")
        ));
		return retUser;
	}
	
	public List<User> getAll() {
		String sql = "SELECT * FROM user";
		List<User> retUser=jdbcTemplate.query(sql, (rs, rowNum) ->
        new User(
                rs.getInt("u_id"),
                rs.getString("u_name"),
        		rs.getString("u_contact"),
                rs.getString("u_company"),
        		rs.getString("u_gender"),
                rs.getString("u_country"),
        		rs.getString("u_state"),
                rs.getString("u_city")
        ));
		return retUser;
	}
	
	public void update(User user) {
		String sql="UPDATE user SET u_name=?, u_contact=?, u_company=?, u_gender=?, u_country=?, u_state=?, u_city=? WHERE u_id=?";
		jdbcTemplate.update(sql,
				user.getName(),user.getContact(),user.getCompany(),user.getGender(),user.getCountry(),user.getState(),user.getCity(),user.getId());
	}
	
	public void delete(int id) {
		String sql="DELETE FROM user where u_id=?";
		jdbcTemplate.update(sql,id);
	}
}
