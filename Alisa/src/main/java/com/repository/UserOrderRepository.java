package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.UserOrder;

public interface UserOrderRepository extends CrudRepository<UserOrder, Integer> {

}
