package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public boolean validate(User user) {
		if(userDao.validate(user)) {
			return true;
		}else {
			return false;
		}
	}

}
