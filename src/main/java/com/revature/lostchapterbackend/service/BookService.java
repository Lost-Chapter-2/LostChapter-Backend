package com.revature.lostchapterbackend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.revature.lostchapterbackend.model.Book;


@Service
public interface BookService {
	public List<Book> getAllBooks();
	public Book getBookById(int bookId);
	public int addBook(Book newBook);
	public Book updateBook(Book bookToUpdate);
	public List<Book> getBookByGenre(int Id);
	public List<Book> getByISBN(String ISBN);
}
