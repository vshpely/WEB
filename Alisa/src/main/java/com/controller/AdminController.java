package com.controller;


import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Product;
import com.entity.User;
import com.google.common.collect.Lists;
import com.service.impl.ProductServiceImpl;
import com.service.impl.SizeServiceImpl;
import com.service.impl.UserServiceImpl;
import com.service.impl.pidCategoryServiceImpl;

import grid.ProductGrid;


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
	
/*	//Контроллер jqgrid
	@RequestMapping(value="/list", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ProductGrid listGrid(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sortBy,
			@RequestParam(value = "sord", required = false) String order){
		
		//Поле по якому буде сортування	по ціні	
		Sort sort = null;
		String orderBy = sortBy;
		if(orderBy != null && orderBy.equals("price"))
			orderBy = "price";
		if(orderBy != null && order != null){
			if(order.equals("desc")){
				sort = new Sort(Sort.Direction.DESC, orderBy);
			}else{
				sort = new Sort(Sort.Direction.ASC, orderBy);
			}	
		}
		//Сторінковий запит для поточної сторінки
		PageRequest pageRequest = null;
		if(sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		}else{
			pageRequest = new PageRequest(page - 1, rows);
		}
		Page<Product> productPage = productServiceImpl.findAllByPage(pageRequest);
		
		//Сітка яка поверне дані в форматі JSON
		ProductGrid productGrid = new ProductGrid();
		productGrid.setCurrentPage(productPage.getNumber() + 1);
		productGrid.setTotalPages(productPage.getTotalPages());
		productGrid.setTotalRecords(productPage.getTotalElements());
		productGrid.setProductData(Lists.newArrayList(productPage.iterator()));
		return productGrid;
		
	}*/
	@RequestMapping(value="/list")
	public String showListProduct(Model model){
		model.addAttribute("products", productServiceImpl.getAll());
		return "list";
	}
	@RequestMapping(value="/admin/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request ) throws IOException{
		productServiceImpl.delete(id);
		//видаляємо папку для зображень товару
		
		String deleteFolderImage = request.getServletContext().getRealPath(
                "resources");
		File deleteDir = new File(deleteFolderImage +File.separator + id);
		if (deleteDir.isDirectory()) {
			try
			{
			FileUtils.cleanDirectory(deleteDir);
			deleteDir.delete();
			}catch(Exception e){
				System.out.println("Папка з фото не видалилась");
			}
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

