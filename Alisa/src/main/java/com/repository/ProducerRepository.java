package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Producer;



public interface ProducerRepository extends CrudRepository<Producer, Integer> {
	
	Producer findByProducerName(String producerName);
}
