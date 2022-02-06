package com.revature.lostchapterbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.lostchapterbackend.model.Cart;
import com.revature.lostchapterbackend.model.Transaction;


@Service
public interface TransactionService {
	public Cart getPurchacedCart(int currentOrderId);
	public Transaction getTransactionById(int transactionId);
	public List<Transaction> getTransactionByUser(int userId);
	public Transaction getTransactionByOrderId(int orderId);
	 
}
