package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@GetMapping(value = "/viewAll")
	public ModelAndView getAll() {
		List<User> users=userService.getAll();
		System.out.println(users);
		return new ModelAndView("users-list", "users", userService.getAll());
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam("id") int id) {
		User user = userService.get(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit-user");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.POST)
	public String update(@ModelAttribute User user) {
		userService.update(user);
		return "redirect:viewAll";
	}
	
	@RequestMapping(value = "delete-user", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {
		userService.delete(id);
		return "redirect:viewAll";
	}
	
	@ModelAttribute("gender")
	public List<String> getGender() {
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		return gender;
	}
}
