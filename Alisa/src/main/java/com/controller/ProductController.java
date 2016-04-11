package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Product;
import com.entity.Size;
import com.entity.pidCategory;
import com.initbinder.EditSize;
import com.initbinder.EditpidCategory;
import com.service.impl.CategoryProductServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.service.impl.SizeServiceImpl;
import com.service.impl.pidCategoryServiceImpl;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private SizeServiceImpl sizeService;
	@Autowired
	private CategoryProductServiceImpl categoryProductServiceImpl;
	@Autowired
	private pidCategoryServiceImpl pidCategoryServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Size.class, new EditSize(sizeService));
		binder.registerCustomEditor(pidCategory.class, new EditpidCategory(pidCategoryServiceImpl));
	}

	@RequestMapping("/product")
	public String showProduct(Model model) {
		Product product = new Product();
		model.addAttribute("sizes", sizeService.getAll());
		model.addAttribute("categoryProducts", categoryProductServiceImpl.getAll());
		model.addAttribute("pidCategorys", pidCategoryServiceImpl.getAll());
		model.addAttribute("product", product);
		return "product";
	}

	@RequestMapping(value = {"/product","/admin/edit/{id}"}, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute Product product, BindingResult br, HttpServletRequest request ,Model model, @RequestParam("file") MultipartFile file) {
		if(br.hasErrors()){
			model.addAttribute("sizes", sizeService.getAll());
			model.addAttribute("pidCategorys", pidCategoryServiceImpl.getAll());
			return "product";
		}
		productServiceImpl.editProduct(product);

		String uploadRootPath = request.getServletContext().getRealPath(
                "resources");
        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath +File.separator + product.getId());
        System.out.println(uploadRootDir);

        // Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		String fileName = null;
		if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = 
                        new BufferedOutputStream(new FileOutputStream(new File(uploadRootDir+"/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                
                String tmpUrl ="resources"+"/"+product.getId()+"/" + fileName;
                System.out.println(tmpUrl);
                productServiceImpl.addUrlFile(product.getId(), tmpUrl);
                return "redirect:/admin";
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "redirect:/admin";
        }
		
	}
}
