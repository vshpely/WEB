package com.service;



import com.entity.CategoryProduct;
import com.entity.pidCategory;


public interface pidCategoryService {
	
	void save(String namePidkategory, CategoryProduct categoryProduct);
	void delete(Integer id);
	pidCategory getByName(String namePidkategory);
	pidCategory editpidCategory(pidCategory pidCategory);
	Iterable<pidCategory> getAll();

}
