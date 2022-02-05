package com.revature.lostchapterbackend.service;

import org.springframework.stereotype.Service;

import com.revature.lostchapterbackend.model.Order;
import com.revature.lostchapterbackend.model.User;

@Service
public interface OrderService {
	
	public Order getOrderById(int orderId);
	public Order getOrderByCartId(int cartId);
	public Order getAllOrdersByUser(User user);
	public int addOrder(Order order);
//	public Order getOrderByBook(Book book);  stretch goal

}
