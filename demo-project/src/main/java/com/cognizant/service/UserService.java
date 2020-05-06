package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public Boolean insert(User user) {
		if(userDao.insert(user)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void update(User user) {
		userDao.update(user);
	}
	
	public void delete(int id) {
		userDao.delete(id);
	}
	
	public User get(int id) {
		return userDao.get(id);
	}
	
	public List<User> getAll(){
		return userDao.getAll();

	}
}
