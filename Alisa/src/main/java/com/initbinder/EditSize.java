package com.initbinder;

import java.beans.PropertyEditorSupport;

import com.service.impl.ProductServiceImpl;
import com.service.impl.SizeServiceImpl;

public class EditSize extends PropertyEditorSupport  {
	
	private final SizeServiceImpl sizeServiceImpl;
	 	
	 	public EditSize (SizeServiceImpl sizeServiceImpl){
	 		this.sizeServiceImpl = sizeServiceImpl;
	 	}
	 	
	 	public void setAsText(String text) throws IllegalArgumentException{
	 		setValue(sizeServiceImpl.findById(Integer.parseInt(text)));
	 	}
	 

}
