package com.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Product;
import com.entity.Size;
import com.entity.pidCategory;
import com.repository.ProductRepository;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;



	public void delete(Integer id) {
		productRepository.delete(id);
		
	}
	public Product findById(int id){
		return productRepository.findOne(id);
	}

	public Product getByArticle(String articul) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product editProduct(Product product) {
		Product nProduct = productRepository.save(product);
		return nProduct;
	}

	public Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	public void save( String articul,String productName, double price, Size size, pidCategory pidCategory) {
		Product product = new Product();
		product.setArticul(articul);
		product.setProductName(productName);
		product.setPrice(price);
		product.setSize(size);
		product.setPidCategory(pidCategory);
		productRepository.save(product);
	}


}
