package com.revature.lostchapterbackend.dto;

import java.util.Objects;

import com.revature.lostchapterbackend.model.Genre;

public class AddBookDTO {

	private String ISBN;
	private String bookName;
	private String synopsis;
	private String author;
	private int genre;
	private int quantity;
	private int year;
	private String edition;
	private String publisher;
	private String bindingType;
	private boolean saleIsActive;
	private double saleDiscountRate;
	private String condition;
	private double bookPrice;
	private String bookImage;

	public AddBookDTO() {
		super();
	}

	public AddBookDTO(String ISBN, String bookName, String synopsis, String author, int genre, int quantity,
			int year, String edition, String publisher, String bindingType, boolean saleIsActive,
			double saleDiscountRate, String condition, double bookPrice, String bookImage) {
		super();
		this.ISBN = ISBN;
		this.bookName = bookName;
		this.synopsis = synopsis;
		this.author = author;
		this.genre = genre;
		this.quantity = quantity;
		this.year = year;
		this.edition = edition;
		this.publisher = publisher;
		this.bindingType = bindingType;
		this.saleIsActive = saleIsActive;
		this.saleDiscountRate = saleDiscountRate;
		this.condition = condition;
		this.bookPrice = bookPrice;
		this.bookImage = bookImage;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBindingType() {
		return bindingType;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	public boolean isSaleIsActive() {
		return saleIsActive;
	}

	public void setSaleIsActive(boolean saleIsActive) {
		this.saleIsActive = saleIsActive;
	}

	public double getSaleDiscountRate() {
		return saleDiscountRate;
	}

	public void setSaleDiscountRate(double saleDiscountRate) {
		this.saleDiscountRate = saleDiscountRate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, author, bindingType, bookImage, bookName, bookPrice, condition, edition, genre,
				publisher, quantity, saleDiscountRate, saleIsActive, synopsis, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddBookDTO other = (AddBookDTO) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author)
				&& Objects.equals(bindingType, other.bindingType) && Objects.equals(bookImage, other.bookImage)
				&& Objects.equals(bookName, other.bookName)
				&& Double.doubleToLongBits(bookPrice) == Double.doubleToLongBits(other.bookPrice)
				&& Objects.equals(condition, other.condition) && Objects.equals(edition, other.edition)
				&& Objects.equals(genre, other.genre) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(quantity, other.quantity)
				&& Double.doubleToLongBits(saleDiscountRate) == Double.doubleToLongBits(other.saleDiscountRate)
				&& saleIsActive == other.saleIsActive && Objects.equals(synopsis, other.synopsis) && year == other.year;
	}

	@Override
	public String toString() {
		return "AddBookDTO [ISBN=" + ISBN + ", bookName=" + bookName + ", synopsis=" + synopsis + ", author=" + author
				+ ", genre=" + genre + ", quantity=" + quantity + ", year=" + year + ", edition=" + edition
				+ ", publisher=" + publisher + ", bindingType=" + bindingType + ", saleIsActive=" + saleIsActive
				+ ", saleDiscountRate=" + saleDiscountRate + ", condition=" + condition + ", bookPrice=" + bookPrice
				+ ", bookImage=" + bookImage + "]";
	}

}