package com.revature.lostchapterbackend.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_keeper")
public class Transaction {

	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private int orderNumber;
	private double totalPrice;
	private int previousOrder;
	private LocalDateTime transactionDate;
	
	public Transaction() {
		super();
		this.transactionId = 0;
		this.orderNumber = 000;
		this.totalPrice = 0.0;
		this.previousOrder = 000;
		this.transactionDate = null;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPreviousOrder() {
		return previousOrder;
	}

	public void setPreviousOrder(int previousOrder) {
		this.previousOrder = previousOrder;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "TransactionKeeper [transactionId=" + transactionId + ", orderNumber=" + orderNumber + ", totalPrice="
				+ totalPrice + ", previousOrder=" + previousOrder + ", transactionDate=" + transactionDate + "]";
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
		Transaction other = (Transaction) obj;
		return orderNumber == other.orderNumber && previousOrder == other.previousOrder
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(transactionDate, other.transactionDate) && transactionId == other.transactionId;
	}

	
}
