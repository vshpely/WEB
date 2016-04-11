package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>  {
	
	Product findByArticul(String articul);

}
