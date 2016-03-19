package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Product;
import com.entity.Size;
import com.entity.pidCategory;
import com.repository.ProductRepository;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;



	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Product getByArticle(String articul) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product editProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	public void save( String articul,String productName, double price, Size size, pidCategory pidCategory) {
		Product product = new Product();
		product.setArticul(articul);
		product.setProductName(productName);
		product.setPrice(price);
		product.setSize(size);
		product.setPidCategory(pidCategory);
		productRepository.save(product);
	}


}
