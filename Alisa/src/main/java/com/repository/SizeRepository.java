package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Size;

public interface SizeRepository extends CrudRepository<Size, Integer> {
	
	Size findBysizeName(String sizeName);

}
