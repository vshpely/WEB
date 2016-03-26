package com.service;


import com.entity.*;

public interface UserService {
	
	void save(String login, String password, String email, String phone);
	void delete(Integer id);
	User getByLogin(String login);
	User findById(int id);
	User editUser(User user);
	Iterable<User> getAll();

}
