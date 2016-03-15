package com.service;

import java.util.List;

import com.entity.Product;


public interface ProductService {
	
	void save(Product product);
	void delete(Integer id);
	Product getByArticle(String articul);
	Product editProduct(Product product);
	List<Product> getAll();

}
