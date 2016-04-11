package com.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.entity.Product;

public class FileUpload {
	
	String fileName = null;
	String uploadRootPath = null;
    File uploadRootDir = null;
    
    public void addFile(MultipartFile file, HttpServletRequest request, Product product, ProductServiceImpl productServiceImpl){
    
    	uploadRootPath = request.getServletContext().getRealPath(
                "resources");
    	uploadRootDir = new File(uploadRootPath +File.separator + product.getId());
    	
    	if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
    	if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = 
                        new BufferedOutputStream(new FileOutputStream(new File(uploadRootDir+"/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                
                String tmpUrl ="resources"+"/"+product.getId()+"/" + fileName;
                productServiceImpl.addUrlFile(product.getId(), tmpUrl);
            } catch (Exception e) {
                System.out.println("You failed to upload " + fileName + ": " + e.getMessage());
            }
        } else {
            System.out.println("File is empty");
        }
    	
    	
    }
	

}
