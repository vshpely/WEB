package com.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CategoryProduct;
import com.entity.pidCategory;
import com.repository.pidCategoryRepository;
import com.service.pidCategoryService;

@Service
public class pidCategoryServiceImpl implements pidCategoryService {
	@Autowired
	private pidCategoryRepository pidCategoryRepository;
	
	public void save(String namePidkategory, CategoryProduct categoryProduct) {
		pidCategory pidCategory = new pidCategory();
		pidCategory.setNamePidkategory(namePidkategory);
		pidCategory.setCategoryProduct(categoryProduct);
		pidCategoryRepository.save(pidCategory);
	}

	public void delete(Integer id) {
		pidCategoryRepository.delete(id);
	}

	public pidCategory getByName(String namePidkategory) {
		
		return pidCategoryRepository.findByNamePidkategory(namePidkategory);
	}

	public pidCategory editpidCategory(pidCategory pidCategory) {
		pidCategory spPidCategory = pidCategoryRepository.save(pidCategory);
		return spPidCategory;
	}

	public Iterable<pidCategory> getAll() {
		return pidCategoryRepository.findAll();
	}
	public pidCategory findById(int id){
		return pidCategoryRepository.findOne(id);
	}

}
