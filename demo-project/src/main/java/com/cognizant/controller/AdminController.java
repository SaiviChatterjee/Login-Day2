package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.model.Admin;
import com.cognizant.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		return "login";
	}
	@PostMapping("/login")
	public String welcome(@ModelAttribute("user") Admin admin,Model model) {
		if(adminService.validate(admin)) {
			return "welcome";
		}else {
			model.addAttribute("admin",admin);
			model.addAttribute("msg", "Invalid username or password");
			return "login";
		}
	}
	
}
