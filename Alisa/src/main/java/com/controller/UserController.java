package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/login")
	public String showLogin(Model model){
		return "login";
	}
	
	@RequestMapping("/registration")
	public String showRegistration(Model model){
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@RequestParam String login, String password, String email, String phone){
		userServiceImpl.save(login, password, email, phone);
		return "redirect:/registration";
	}
	
	
	
}
