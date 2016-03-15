package com.service;

import com.entity.Producer;


public interface ProducerService {
	
	void save(String producerName);
	void delete(Integer id);
	Producer getByName(String producerName);
	Producer editProducer(Producer producer);
	Iterable<Producer> getAll();

}
