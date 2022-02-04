package com.revature.lostchapterbackend.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordr")
public class Order {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="cc_info_id")
	private int ccInfoId;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;

	public Order(int orderId, int ccInfoId, int cartId) {

		this.orderId = orderId;
		this.ccInfoId = ccInfoId;
		this.cart = new Cart();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCcInfoId() {
		return ccInfoId;
	}

	public void setCcInfoId(int ccInfoId) {
		this.ccInfoId = ccInfoId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cart, ccInfoId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(cart, other.cart) && ccInfoId == other.ccInfoId && orderId == other.orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ccInfoId=" + ccInfoId + ", cart=" + cart + "]";
	}

	
	


}
