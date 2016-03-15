package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.CategoryProduct;


public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Integer> {
	
	CategoryProduct findByNameCategory(String nameCategory);
}
