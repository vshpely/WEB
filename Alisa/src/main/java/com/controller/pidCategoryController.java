package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.impl.CategoryProductServiceImpl;
import com.service.impl.pidCategoryServiceImpl;

@Controller
public class pidCategoryController {
	@Autowired
	private pidCategoryServiceImpl pidCategoryServiceImpl;
	@Autowired
	private CategoryProductServiceImpl categoryProductServiceImpl;
	
	@RequestMapping("/category")
	public String show(Model model){
		model.addAttribute("categorys", pidCategoryServiceImpl.getAll());
		model.addAttribute("categoryproducts", categoryProductServiceImpl.getAll());
		return "category";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String save(@RequestParam String namePidkategory, int categoryProduct_id){		
		pidCategoryServiceImpl.save(namePidkategory, categoryProductServiceImpl.findByid(categoryProduct_id));
		return "redirect:/category";
	}
	@RequestMapping("/category/{id}")
	public String delete(@PathVariable int id){
		pidCategoryServiceImpl.delete(id);
		return "redirect:/category";
	}
	
}
