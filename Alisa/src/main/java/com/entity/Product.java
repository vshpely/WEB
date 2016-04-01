package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@javax.validation.constraints.Size(min = 6, max = 20, message = "імя ")
	private String articul;
	
	/*@NotNull
    @Min(value=1, message="please enter productName")
	@Max(value=25)*/
	private String productName;

	@ManyToOne
	private Size size;

	@ManyToOne
	private pidCategory pidCategory;

	private double price;

	@ManyToOne
	private Producer producer;

	@ManyToOne
	private UserOrder order;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getArticul() {
		return articul;
	}

	public void setArticul(String articul) {
		this.articul = articul;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public pidCategory getPidCategory() {
		return pidCategory;
	}

	public void setPidCategory(pidCategory pidCategory) {
		this.pidCategory = pidCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public UserOrder getOrder() {
		return order;
	}

	public void setOrder(UserOrder order) {
		this.order = order;
	}


	
	

}
