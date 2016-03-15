package com.service;


import com.entity.Size;

public interface SizeService  {

	void save(String sizeName, String ukrSize);
	void delete(Integer id);
	Size getByName(String sizeName);
	Size editSize(Size size);
	Iterable<Size> getAll();

}
