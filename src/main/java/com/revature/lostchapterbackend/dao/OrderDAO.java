package com.revature.lostchapterbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.lostchapterbackend.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{

	

}
