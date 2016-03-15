package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
