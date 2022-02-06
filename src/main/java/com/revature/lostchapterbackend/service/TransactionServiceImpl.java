package com.revature.lostchapterbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.lostchapterbackend.dao.TransactionDAO;
import com.revature.lostchapterbackend.model.Cart;
import com.revature.lostchapterbackend.model.Transaction;

public class TransactionServiceImpl implements TransactionService {
	
	private TransactionDAO transactiondao;
	
	@Autowired
	public TransactionServiceImpl(TransactionDAO transactiondao) {
		this.transactiondao = transactiondao;
	}

	@Override
	@Transactional
	public Cart getPurchacedCart(int currentOrderId) {
		Cart theCart = transactiondao.findByOrderCart(currentOrderId);
		return theCart;
	}

	@Override
	@Transactional
	public Transaction getTransactionById(int transactionId) {
		Transaction transaction = transactiondao.getById(transactionId);
		return transaction;
	}

	@Override
	@Transactional
	public List<Transaction> getTransactionByUser(int userId) {
		List<Transaction> transactions = transactiondao.findByOrderCartUser(userId);
		return transactions;
	}

	@Override
	@Transactional
	public Transaction getTransactionByOrderId(int orderId) {
		Transaction transaction = transactiondao.findByOrder(orderId);
		return transaction;
	}

}
