package com.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity

public class pidCategory {
	@Id
	//вказує яким генератором скористатись при генерації поля нижче
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	private String namePidkategory;
	
	@ManyToOne
	private CategoryProduct categoryProduct;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pidCategory")
	private List<Product> products;

	public pidCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePidkategory() {
		return namePidkategory;
	}

	public void setNamePidkategory(String namePidkategory) {
		this.namePidkategory = namePidkategory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public CategoryProduct getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoryProduct categoryProduct) {
		this.categoryProduct = categoryProduct;
	}
	
	

}
