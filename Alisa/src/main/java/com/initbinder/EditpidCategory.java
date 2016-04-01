package com.initbinder;

import java.beans.PropertyEditorSupport;

import com.service.impl.pidCategoryServiceImpl;

public class EditpidCategory extends PropertyEditorSupport{
	private final pidCategoryServiceImpl pidCategoryServiceImpl;
 	
 	public EditpidCategory (pidCategoryServiceImpl pidCategoryServiceImpl){
 		this.pidCategoryServiceImpl = pidCategoryServiceImpl;
 	}
 	
 	public void setAsText(String text) throws IllegalArgumentException{
 		setValue(pidCategoryServiceImpl.findById(Integer.parseInt(text)));
 	}

}
