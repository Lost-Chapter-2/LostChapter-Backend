package com.revature.lostchapterbackend.exceptions;

public class ReviewNotFoundException extends Exception {
	
	
	public ReviewNotFoundException() {
		super();
	}
	public ReviewNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ReviewNotFoundException(String message, Throwable cause) {
		super(message, cause);

		// TODO Auto-generated constructor stub

	}

	public ReviewNotFoundException(String message) {
		super(message);

	}

	public ReviewNotFoundException(Throwable cause) {
		super(cause);

	}

}
