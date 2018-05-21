package com.intuit.cg.backendtechassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An exception to be used when returning a bad request response.
 * 
 * @author Advait Moghe
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 5983337178075745072L;

	/**
	 * constructor for the class
	 * 
	 * @param message
	 *            the error message
	 */
	public BadRequestException(String message) {
		super(message);
	}

}
