package com.revature.lostchapterbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.lostchapterbackend.dao.BookToBuyDAO;
import com.revature.lostchapterbackend.dao.CartDAO;
import com.revature.lostchapterbackend.exceptions.BookNotFoundException;
import com.revature.lostchapterbackend.model.Book;
import com.revature.lostchapterbackend.model.BookToBuy;
import com.revature.lostchapterbackend.model.Cart;

public class CartServiceImpl implements CartService{

	public CartDAO cartDao;
	public BookToBuyDAO bookToBuyDao;
	@Autowired
	public CartServiceImpl(CartDAO cartDao,BookToBuyDAO bookToBuyDao) {
		this.cartDao=cartDao;
		this.bookToBuyDao=bookToBuyDao;
	}
	
	@Override
	public Cart getCartById(int id) {
		Optional<Cart> cart = cartDao.findById(id);
		if (cart.isPresent())
			return cart.get();
		else return null;
	}

	@Override
	public void addBooksToCart(Book newbook, int userId) {
		Cart currentCart= cartDao.findByuser(userId);
		List<Book> booksInCart= currentCart.getBooks();
		booksInCart.add(newbook);
		currentCart.setBooks(booksInCart);
		cartDao.save(currentCart);
	}

	@Override
	public boolean checkBookInTheCart(Book book, int userId) {
		Cart currentCart= cartDao.findByuser(userId);
		List<Book> booksInCart= currentCart.getBooks();
		for(Book b:booksInCart) {
			if(book.equals(b))
				return true;
		}
		return false;
	}

	@Override
	public Cart deleteBookInCart(Book book, int userId) throws BookNotFoundException {
		Cart currentCart= cartDao.findByuser(userId);
		List<Book> booksInCart= currentCart.getBooks();
		booksInCart.remove(book);
		currentCart.setBooks(booksInCart);
		cartDao.save(currentCart);
		return currentCart;
	}

	@Override
	public Cart deleteAllBooksInCart(int userId) {
		Cart currentCart= cartDao.findByuser(userId);
		List<Book> booksInCart= currentCart.getBooks();
		booksInCart.clear();
		currentCart.setBooks(booksInCart);
		cartDao.save(currentCart);
		return currentCart;
	}

	@Override
	public void addBooksToCartNoUser(Book newbook, Cart currentCart) {
		List<Book> booksInCart= currentCart.getBooks();
		booksInCart.add(newbook);
		currentCart.setBooks(booksInCart);
		cartDao.save(currentCart);
		
	}

	@Override
	public boolean checkBookInTheCartNoUser(Book book, Cart currentCart) {
	
		List<Book> booksInCart= currentCart.getBooks();
		for(Book b:booksInCart) {
			if(book.equals(b))
				return true;
		}
		return false;
	}

	@Override
	public Cart deleteBookInCartNoUser(Book book, Cart currentCart) throws BookNotFoundException {
		List<Book> booksInCart= currentCart.getBooks();
		booksInCart.remove(book);
		currentCart.setBooks(booksInCart);
		cartDao.save(currentCart);
		return currentCart;
	}

	@Override
	public Cart deleteAllBooksInCartNoUser(Cart currentCart) {
		List<Book> booksInCart= currentCart.getBooks();
		booksInCart.clear();
		currentCart.setBooks(booksInCart);
		cartDao.save(currentCart);
		return currentCart;
	}




	
	
}
