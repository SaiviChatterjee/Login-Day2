package com.cognizant.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.model.User;
import com.cognizant.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public ModelAndView registerPage(@RequestParam(value = "msg", required = false) String msg) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		if (msg != null) {
			modelAndView.addObject("msg", msg);
		}
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@PostMapping(value = "/register")
	public String insert(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		Boolean result = userService.insert(user);
		if (result) {
			return "welcome";
		} else {
			redirectAttributes.addAttribute("msg", "Failure");
			return "redirect:register";
		}
	}
	@ModelAttribute("gender")
	public List<String> getGender() {
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		return gender;
   	}	
}
