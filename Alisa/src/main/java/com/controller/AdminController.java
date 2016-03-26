package com.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.User;

import com.service.impl.UserServiceImpl;


@Controller
public class AdminController {
	
	@Autowired
	private UserServiceImpl userService;
	
/*	@RequestMapping("/admin")
	public String showAdmin(Model model){
		model.addAttribute("products", productServiceImpl.getAll());
		return "admin";
	}*/
	
	
	
/*	@RequestMapping("/admin/{id}")
	public String delete(@PathVariable int id){
		productServiceImpl.delete(id);
		return "redirect:/admin";
	}*/

	@RequestMapping(value = "/admin")
	public String showAdmin(Model model, Principal principal){
		if(principal != null){
			User user = userService.findById(Integer.parseInt(principal.getName()));
			model.addAttribute("user", user);
			return "admin";
		}else{
			return "redirect:/";
		}
	}
	@RequestMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	
}

