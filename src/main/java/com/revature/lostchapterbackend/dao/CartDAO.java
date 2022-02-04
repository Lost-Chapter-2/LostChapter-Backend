package com.revature.lostchapterbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.lostchapterbackend.model.Cart;


public interface CartDAO extends JpaRepository<Cart, Integer>{

}
