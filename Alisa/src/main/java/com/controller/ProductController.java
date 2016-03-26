package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.service.impl.CategoryProductServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.service.impl.SizeServiceImpl;
import com.service.impl.pidCategoryServiceImpl;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private SizeServiceImpl sizeService;
	@Autowired
	private CategoryProductServiceImpl categoryProductServiceImpl;
	
	@Autowired
	private pidCategoryServiceImpl pidCategoryServiceImpl;
	
	@RequestMapping("/product")
	public String showProduct(Model model){
		model.addAttribute("products", productServiceImpl.getAll());
		model.addAttribute("sizes", sizeService.getAll());
		model.addAttribute("categoryProducts", categoryProductServiceImpl.getAll());
		model.addAttribute("pidCategorys", pidCategoryServiceImpl.getAll());
		return "product";
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String save(@RequestParam String articul, String productName, double price, int size_id, int pidCategory_id, MultipartFile file){		
		productServiceImpl.save(articul, productName, price, sizeService.findById(size_id), pidCategoryServiceImpl.findById(pidCategory_id));
	
		return "redirect:/product";
	}

}
