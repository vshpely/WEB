package com.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public void save(String login, String password, String email, String phone) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		userRepository.save(user);
		
	}

	public void delete(Integer id) {
		userRepository.delete(id);
		
	}

	public User getByLogin(String login) {
		
		return userRepository.findByLogin(login);
	}

	public User editUser(User user) {
		User editUser = userRepository.save(user);
		return editUser;
	}

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}
	
	
}