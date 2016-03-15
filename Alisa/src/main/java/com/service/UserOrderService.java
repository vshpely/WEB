package com.service;

import java.util.List;

import com.entity.*;

public interface UserOrderService {
	
	void save(User user);
	void delete(Integer id);
	UserOrder getByUser(User user);
	UserOrder editUserOrder(UserOrder userOrder);
	List<UserOrder> getAll();

}
