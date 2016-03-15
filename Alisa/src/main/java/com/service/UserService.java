package com.service;

import java.util.List;

import com.entity.*;

public interface UserService {
	
	void save(String login);
	void delete(Integer id);
	User getByLogin(String login);
	User editUser(User user);
	List<User> getAll();

}
