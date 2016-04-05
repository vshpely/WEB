package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.impl.CategoryProductServiceImpl;
import com.service.impl.ProductServiceImpl;

@Controller
public class IndexController {
	
	@Autowired
	private CategoryProductServiceImpl categoryProductServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping("/")
	public String indexView(Model model) {
		model.addAttribute("categoryProducts", categoryProductServiceImpl.getAll());
		model.addAttribute("Products", productServiceImpl.getAll());
		return "index";
	}

}
