package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CategoryProduct;
import com.repository.CategoryProductRepository;
import com.service.CategoryProductService;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
	
	@Autowired
	private CategoryProductRepository categoryProductRepository;
	
	public void save(String nameCategory) {
		CategoryProduct categoryProduct = new CategoryProduct();
		categoryProduct.setNameCategory(nameCategory);
		categoryProductRepository.save(categoryProduct);
	}

	public void delete(Integer id) {
		categoryProductRepository.delete(id);
		
	}

	public CategoryProduct getByName(String nameCategory) {
		return categoryProductRepository.findByNameCategory(nameCategory);
	}

	public CategoryProduct editCategoryProduct(CategoryProduct categoryProduct) {
		CategoryProduct sCategoryProduct = categoryProductRepository.save(categoryProduct);
		return categoryProductRepository.save(sCategoryProduct);
	}

	public Iterable<CategoryProduct> getAll() {
		return categoryProductRepository.findAll();
	}
	
	public CategoryProduct findByid(int id){
		return categoryProductRepository.findOne(id);
	}
	

}
