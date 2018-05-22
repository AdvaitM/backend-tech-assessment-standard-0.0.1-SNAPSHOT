package com.intuit.cg.backendtechassessment.buyer.srv.entity;

import com.intuit.cg.backendtechassessment.actor.srv.entity.Actor;

/**
 * The database representation of a Buyer.
 * 
 * @author Advait Moghe
 *
 */
public class Buyer extends Actor {

	/**
	 * Constructor to be used when creating a new instance for when retrieving data
	 * from the database.
	 * 
	 * @param id
	 *            the id of the buyer
	 * @param description
	 *            the description of the buyer
	 * @param email
	 *            the email address of the buyer
	 */
	public Buyer(Long id, String description, String email) {
		super(id, description, email);
	}

	/**
	 * Constructor to be used when creating a new instance for adding an buyer to
	 * the database. We omit the id here as the id is auto-generated.
	 * 
	 * @param description
	 *            the description of the buyer
	 * @param email
	 *            the email address of the buyer
	 */
	public Buyer(String description, String email) {
		super(description, email);
	}
}
