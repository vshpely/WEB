package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.User;
import com.service.impl.UserServiceImpl;
import com.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/login")
	public String showLogin(Model model){
		return "login";
	}
	
/*	@RequestMapping("/registration" )
	public String showRegistration(Model model){
		model.addAttribute("user", new User());
		return "registration";
	}*/
	
/*	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@RequestParam String login, String password, String email, String phone){
		userServiceImpl.save( login, password, email, phone);
		return "redirect:/registration";
	}*/
	@RequestMapping(value="/registration")
	public String dosave(Model model){
	        User user = new User();
	        model.addAttribute("user", user);
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute User user, Errors errors){
		if(errors.hasErrors()){
			return "registration";
		}
		userServiceImpl.editUser(user);
		return "redirect:/";
	}
/*	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@RequestParam String login, String password, String email, String phone){
		userServiceImpl.save(login,password,email, phone);
		return "redirect:/registration";
	}*/
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new UserValidator());
	}
	
	
}
