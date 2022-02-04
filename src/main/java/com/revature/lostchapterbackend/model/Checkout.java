package com.revature.lostchapterbackend.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Checkout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@OneToOne
	@JoinColumn(name="order_id")
	private Order orderNumber;
	private double totalPrice;
	@ElementCollection
	private List<String> previousOrder;
	private LocalDateTime transactionDate;

	public Checkout() {
		super();
	}

	public Checkout(String orderNumber, double totalPrice, List<String> previousOrder,
			LocalDateTime transactionDate) {
		super();
		this.orderNumber = new Order();
		this.totalPrice = totalPrice;
		this.previousOrder = previousOrder;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Order getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<String> getPreviousOrder() {
		return previousOrder;
	}

	public void setPreviousOrder(List<String> previousOrder) {
		this.previousOrder = previousOrder;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNumber, previousOrder, totalPrice, transactionDate, transactionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkout other = (Checkout) obj;
		return Objects.equals(orderNumber, other.orderNumber) && Objects.equals(previousOrder, other.previousOrder)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(transactionDate, other.transactionDate) && transactionId == other.transactionId;
	}

	@Override
	public String toString() {
		return "TransactionKeeper [transactionId=" + transactionId + ", orderNumber=" + orderNumber + ", totalPrice="
				+ totalPrice + ", previousOrder=" + previousOrder + ", transactionDate=" + transactionDate + "]";
	}

}
