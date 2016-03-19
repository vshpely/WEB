package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.entity.Size;
import com.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.login like %?1")
	  List<User> findByFirstnameEndsWith(String login);
	
	@Query("select u from User u where u.login like ?1%")
	List<User> findByFirstnameStartingWith(String login);
	
	Long countByLogin(String login);
	
	User findByLogin(String login);
}
