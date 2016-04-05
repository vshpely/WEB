package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.impl.SizeServiceImpl;

@Controller
public class SizeController {
	
	@Autowired
	private SizeServiceImpl sizeService;
	
	@RequestMapping("/size")
	public String show(Model model, Principal principal){
		if (principal != null){
		model.addAttribute("sizes", sizeService.getAll());
		return "size";
		}else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/size", method=RequestMethod.POST)
	public String save(@RequestParam String sizeName, String ukrSize){
		sizeService.save(sizeName, ukrSize);
		return "redirect:/size";
	}
	@RequestMapping("/size/{id}")
	public String delete(@PathVariable int id){
		sizeService.delete(id);
		return "redirect:/size";
	}
}
