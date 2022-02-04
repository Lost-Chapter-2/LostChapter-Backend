package com.revature.lostchapterbackend.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.lostchapterbackend.model.Book;
import com.revature.lostchapterbackend.model.Review;
import com.revature.lostchapterbackend.dao.BookDAO;
import com.revature.lostchapterbackend.dao.ReviewDAO;
import com.revature.lostchapterbackend.dto.AddOrUpdateBookDTO;
import com.revature.lostchapterbackend.exceptions.BookNotFoundException;
import com.revature.lostchapterbackend.exceptions.ReviewNotFoundException;

@Service
public class ReviewService {
	private Logger logger = LoggerFactory.getLogger(ReviewService.class);

	@Autowired
	private ReviewDAO revDao;
	@Autowired
	private BookDAO bookDao;

	public ReviewService(ReviewDAO revDao, BookDAO bookDao) {
		// For mocking
		// For Unit Testing
		this.revDao = revDao;
		this.bookDao = bookDao;
	}

	public List<Review> getAllReviews() {
		logger.info("ReviewService.getAllReviews() invoked.");

		return revDao.findAll();
	}

	public Review getReviewById(String id) throws ReviewNotFoundException {
		logger.info("ReviewService.getReviewById() invoked.");

		try {
			int reviewId = Integer.parseInt(id);
			if (!revDao.findById(reviewId).isPresent()) {
				throw new ReviewNotFoundException("Review doesn't exist");
			}
			return revDao.findById(reviewId).get();
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("The Id entered must be an int.");

		}

	}

	public Review addReview(Review newReview) throws InvalidParameterException {
		logger.info("ReviewService.addReview() invoked.");

		// int newId = revDao.save(newReview).getReviewId();
		// newReview.setReviewId(newId);
		// return newReview;

		return revDao.saveAndFlush(newReview);

	}

	public Review updateReview(Review reviewToUpdate, String id)
			throws ReviewNotFoundException, InvalidParameterException {

		logger.info("ReviewService.updateReview() invoked.");

		try {
			int reviewId = Integer.parseInt(id);

			if (!revDao.findById(reviewId).isPresent()) {

				throw new ReviewNotFoundException("Review doesn't exist");
			}

			logger.debug("revDao.findById(reviewId).get() {}", revDao.findById(reviewId).get());

			return revDao.saveAndFlush(reviewToUpdate);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("Id must be in Int format");
		}
	}

	public List<Review> getReviewsByBook(Book book) throws BookNotFoundException {
		if (!bookDao.findById(book.getBookId()).isPresent()) {
			throw new BookNotFoundException("Book doesn't exist");
		}
		return revDao.findByBookOrderBySentAtDesc(book);
	}

}
