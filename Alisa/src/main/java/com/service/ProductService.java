package com.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entity.Product;
import com.entity.Size;
import com.entity.pidCategory;


public interface ProductService {
	
	void save(String articul, String productName,double price, Size size, pidCategory pidCategory);
	void delete(Integer id);
	Product getByArticle(String articul);
	Product editProduct(Product product);
	Iterable<Product> getAll();
	public Page<Product>  findAllByPage(Pageable pageable);

}
