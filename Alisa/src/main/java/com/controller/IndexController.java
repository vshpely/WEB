package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.impl.CategoryProductServiceImpl;

@Controller
public class IndexController {
	
	@Autowired
	private CategoryProductServiceImpl categoryProductServiceImpl;

	@RequestMapping("/")
	public String indexView(Model model) {
		model.addAttribute("categoryProducts", categoryProductServiceImpl.getAll());
		return "index";
	}

}
