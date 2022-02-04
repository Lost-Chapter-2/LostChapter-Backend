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
	private int cartId;

	public Order(int orderId, int ccInfoId, int cartId) {

		this.orderId = orderId;
		this.ccInfoId = ccInfoId;
		this.cartId = cartId;
	}

	public Order() {
		// TODO Auto-generated constructor stub
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

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ccInfoId=" + ccInfoId + ", cartId=" + cartId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId, ccInfoId, orderId);
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
		return cartId == other.cartId && ccInfoId == other.ccInfoId && orderId == other.orderId;
	}
	
	


}
