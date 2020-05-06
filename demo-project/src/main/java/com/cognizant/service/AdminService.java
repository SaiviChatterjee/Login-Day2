package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.AdminDao;
import com.cognizant.model.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public boolean validate(Admin admin) {
		if(adminDao.validate(admin)) {
			return true;
		}else {
			return false;
		}
	}
}
