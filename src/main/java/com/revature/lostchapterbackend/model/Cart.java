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
	private int booksToBuyID;

	public Cart() {
		cartId = 0;
		user = new User();
		booksToBuyID = 0;
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

	public int getBooksToBuyID() {
		return booksToBuyID;
	}

	public void setBooksToBuyID(int booksToBuyID) {
		this.booksToBuyID = booksToBuyID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booksToBuyID, cartId, user);
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
		return booksToBuyID == other.booksToBuyID && cartId == other.cartId && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", booksToBuyID=" + booksToBuyID + "]";
	}
	
}