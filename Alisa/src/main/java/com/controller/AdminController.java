package com.controller;


import java.io.File;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.User;
import com.service.impl.ProductServiceImpl;
import com.service.impl.SizeServiceImpl;
import com.service.impl.UserServiceImpl;
import com.service.impl.pidCategoryServiceImpl;


@Controller
public class AdminController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private SizeServiceImpl sizeServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private pidCategoryServiceImpl pidCategoryServiceImpl;
	
/*	@RequestMapping("/admin")
	public String showAdmin(Model model){
		model.addAttribute("products", productServiceImpl.getAll());
		return "admin";
	}*/
	
	@RequestMapping(value="/admin/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request ){
		productServiceImpl.delete(id);
		//видаляємо папку для зображень товару
		String deleteFolderImage = request.getServletContext().getRealPath(
                "resources");
		File deleteDir = new File(deleteFolderImage +File.separator + id);
		if (deleteDir.isDirectory()) {
			deleteDir.delete();
		}
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/admin/edit/{id}")
	public String edit(@PathVariable int id, Model model){
		model.addAttribute("product", productServiceImpl.findById(id));
		model.addAttribute("sizes", sizeServiceImpl.getAll());
		model.addAttribute("pidCategorys", pidCategoryServiceImpl.getAll());
		return "product";
	}

	@RequestMapping(value = "/admin")
	public String showAdmin(Model model, Principal principal){
		if(principal != null){
			User user = userService.findById(Integer.parseInt(principal.getName()));
			model.addAttribute("user", user);
			model.addAttribute("products", productServiceImpl.getAll());
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

