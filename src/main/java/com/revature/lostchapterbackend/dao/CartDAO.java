package com.revature.lostchapterbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.lostchapterbackend.model.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{
	public Cart findByuser(int Id);
}