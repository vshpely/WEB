package com.service.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.repository.ProductRepository;

public class productValid implements ConstraintValidator<ProductAnotation, String> {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void initialize(ProductAnotation arg0) {
		
	}

	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if(productRepository == null){
			return true;
		}
		return productRepository.findByArticul(arg0)==null;
	}

}
