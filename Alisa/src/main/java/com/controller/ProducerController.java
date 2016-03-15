package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.impl.ProducerServiceImpl;

@Controller
public class ProducerController {
	
	@Autowired
	private ProducerServiceImpl producerServiceImpl;
	
	@RequestMapping("/producer")
	public String show(Model model){
		model.addAttribute("producers", producerServiceImpl.getAll());
		return "producer";
	}
	
	@RequestMapping(value="/producer", method=RequestMethod.POST)
	public String save(@RequestParam String producerName){
		producerServiceImpl.save(producerName);
		return "redirect:/producer";
	}
	@RequestMapping("/producer/{id}")
	public String delete(@PathVariable int id){
		producerServiceImpl.delete(id);
		return "redirect:/producer";
	}
	
	
}
