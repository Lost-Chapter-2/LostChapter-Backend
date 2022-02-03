package com.revature.lostchapterbackend.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.lostchapterbackend.model.Book;
import com.revature.lostchapterbackend.model.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer> {
	public List<Review> findByBookOrderBySentAtDesc(Book book);
}
