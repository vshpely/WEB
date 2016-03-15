package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Producer;
import com.repository.ProducerRepository;
import com.service.ProducerService;
@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	private ProducerRepository producerRepository;
	
	public void save(String producerName) {
		Producer producer = new Producer();
		producer.setProducerName(producerName);
		producerRepository.save(producer);
	}

	public void delete(Integer id) {
		producerRepository.delete(id);
	}

	public Producer getByName(String producerName) {
		return producerRepository.findByProducerName(producerName);
	}

	public Producer editProducer(Producer producer) {
		Producer sProducer = producerRepository.save(producer);
		return sProducer;
	}

	public Iterable<Producer> getAll() {
		return producerRepository.findAll();
	}

}
