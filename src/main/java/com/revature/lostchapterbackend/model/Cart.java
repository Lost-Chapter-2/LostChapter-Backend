package com.revature.lostchapterbackend.model;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany
	@JoinColumn(name="book_to_buy_id")
	private Book book;

	public Cart() {
		cartId = 0;
		user = new User();
		book = new Book();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBooksToBuyID() {
		return book;
	}

	public void setBooksToBuy(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, cartId, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return book == other.book && cartId == other.cartId && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", Book=" + book + "]";
	}
	
}