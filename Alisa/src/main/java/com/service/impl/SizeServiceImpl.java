package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Size;
import com.repository.SizeRepository;
import com.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {
	
	@Autowired
	private SizeRepository sizeRepository;
	
	public void save(String sizeName, String ukrSize){
		Size size = new Size();
		size.setSizeName(sizeName);
		size.setUkrSize(ukrSize);
		sizeRepository.save(size);
	}

	public void delete(Integer id) {
		sizeRepository.delete(id);
	}

	public Size getByName(String sizeName) {
		return sizeRepository.findBysizeName(sizeName);
	}

	public Size editSize(Size size) {
		Size sSize = sizeRepository.save(size);
		return sSize;
	}

	public Iterable<Size> getAll() {
		return sizeRepository.findAll();
	}
	
	public Size findById(int id){
		return sizeRepository.findOne(id);
	}

}
