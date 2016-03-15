package com.service;


import com.entity.*;

public interface CategoryProductService {
	
	void save(String nameCategory);
	void delete(Integer id);
	CategoryProduct getByName(String nameCategory);
	CategoryProduct editCategoryProduct(CategoryProduct categoryProduct);
	Iterable<CategoryProduct> getAll();

}
