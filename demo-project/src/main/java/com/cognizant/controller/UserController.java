package com.cognizant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.model.User;
import com.cognizant.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@PostMapping("/login")
	public String welcome(@ModelAttribute("user") User user,Model model) {
		if(userService.validate(user)) {
			return "welcome";
		}else {
			model.addAttribute("user",user);
			model.addAttribute("msg", "Invalid username or password");
			return "login";
		}
	}
}
