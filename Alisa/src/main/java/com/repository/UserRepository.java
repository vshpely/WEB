package com.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.entity.Size;
import com.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByLogin(String login);
	
	User findById(int id);
	
	User findByEmail(String email);
}
