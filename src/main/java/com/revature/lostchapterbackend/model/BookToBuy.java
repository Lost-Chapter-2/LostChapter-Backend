package com.revature.lostchapterbackend.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="book_to_buy")
public class BookToBuy {

	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	@ManyToOne
	@JoinColumn(name="quantity_to_buy")
	private int quantityToBuy;

	

	public BookToBuy() {
		bookId = 0;
		quantityToBuy = 0;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public int getQuantityToBuy() {
		return quantityToBuy;
	}



	public void setQuantityToBuy(int quantityToBuy) {
		this.quantityToBuy = quantityToBuy;
	}



	@Override
	public int hashCode() {
		return Objects.hash(bookId, quantityToBuy);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookToBuy other = (BookToBuy) obj;
		return bookId == other.bookId && quantityToBuy == other.quantityToBuy;
	}



	@Override
	public String toString() {
		return "BookToBuy [bookId=" + bookId + ", quantityToBuy=" + quantityToBuy + "]";
	}

}
