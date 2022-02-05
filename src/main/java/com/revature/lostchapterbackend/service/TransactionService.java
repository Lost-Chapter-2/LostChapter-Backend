package com.revature.lostchapterbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.lostchapterbackend.model.Order;
import com.revature.lostchapterbackend.model.Transaction;
import com.revature.lostchapterbackend.model.User;


@Service
public interface TransactionService {
	public Order getCurrentOrder(Order currentOrderNumber);
	public List<Order> getListOfOrders(User user);
	public Transaction getTransactionById(int transactionId);
	public Transaction getTransactionByUser(User user);
	public Transaction getTransactionByOrder(Order order);
	 
}
