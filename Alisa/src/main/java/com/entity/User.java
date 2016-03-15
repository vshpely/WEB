package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Об'єкти цього класу повинні відображатись в базі даних
@Entity

// Задає ім'я таблиці в базі даних
// якщо дана анотація не буде прописана то назва таблиці буде така сама як назва
// класу
@Table(name = "UserDB")

public class User {
	// Вказує що поле буде виконувати роль стовпця id
	@Id
	// вказує яким генератором скористатись при генерації поля нижче
	//
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserOrder> orders;

	public User() {

		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<UserOrder> orders) {
		this.orders = orders;
	}

}
