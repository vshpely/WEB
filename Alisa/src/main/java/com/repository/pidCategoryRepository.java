package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.pidCategory;

public interface pidCategoryRepository extends CrudRepository<pidCategory, Integer> {
	pidCategory findByNamePidkategory(String namePidkategory);
}
