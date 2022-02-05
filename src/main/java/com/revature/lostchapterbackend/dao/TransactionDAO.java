package com.revature.lostchapterbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.lostchapterbackend.model.Order;
import com.revature.lostchapterbackend.model.Transaction;
import com.revature.lostchapterbackend.model.User;
@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer>{

	public List<Order> getOrdersCart(User user);
	public Transaction getTransactionByOrderCartUser(User user);
	public Transaction getTransactionByOrder(Order order);
}