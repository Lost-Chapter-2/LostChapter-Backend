package com.revature.lostchapterbackend.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	@Column(nullable = false)
	private int bookId;
	
	@Column(nullable = false)
	private int usersId;
	
	private String reviewTitle;
	private String reviewText;
	//rating names to be set on the front end based on book genre
	//For Fiction, ratingOne is Plot
	//For Non-Fiction, ratingOne is ???
	@Column(nullable = false)
	private int ratingOne;
	
	//For Fiction, ratingTwo is Pacing
	//For Non-Fiction, ratingTwo is ???
	@Column(nullable = false)
	private int ratingTwo;
	
	//For Fiction, ratingThree is Prose
	//For Non-Fiction, ratingThree is ???
	@Column(nullable = false)
	private int ratingThree;

	public double getOverallRating() {
		return (ratingOne + ratingTwo + ratingThree)/3;
	}
	
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getRatingOne() {
		return ratingOne;
	}

	public void setRatingOne(int ratingOne) {
		this.ratingOne = ratingOne;
	}

	public int getRatingTwo() {
		return ratingTwo;
	}

	public void setRatingTwo(int ratingTwo) {
		this.ratingTwo = ratingTwo;
	}

	public int getRatingThree() {
		return ratingThree;
	}

	public void setRatingThree(int ratingThree) {
		this.ratingThree = ratingThree;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, ratingOne, ratingThree, ratingTwo, reviewId, reviewText, reviewTitle, usersId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return bookId == other.bookId && ratingOne == other.ratingOne && ratingThree == other.ratingThree
				&& ratingTwo == other.ratingTwo && reviewId == other.reviewId
				&& Objects.equals(reviewText, other.reviewText) && Objects.equals(reviewTitle, other.reviewTitle)
				&& usersId == other.usersId;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", bookId=" + bookId + ", usersId=" + usersId + ", reviewTitle="
				+ reviewTitle + ", reviewText=" + reviewText + ", ratingOne=" + ratingOne + ", ratingTwo=" + ratingTwo
				+ ", ratingThree=" + ratingThree + "]";
	}
	
	
}
