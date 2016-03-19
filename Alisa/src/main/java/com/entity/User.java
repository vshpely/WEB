package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

public class User {
	// Вказує що поле буде виконувати роль стовпця id
	@Id
	// вказує яким генератором скористатись при генерації поля нижче
	// GenerationType.IDENTITY - не працює в mysql server
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String login;

	private String password;

	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	private String email;
	private String phone;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
