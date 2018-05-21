package com.intuit.cg.backendtechassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An exception to be used when the requested entity is not found.
 * 
 * @author Advait Moghe
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2390626738146902729L;

	/**
	 * constructor for the class
	 * 
	 * @param message
	 *            the error message
	 */
	public EntityNotFoundException(String message) {
		super(message);
	}

}
