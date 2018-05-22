package com.intuit.cg.backendtechassessment.seller.srv.entity;

import com.intuit.cg.backendtechassessment.actor.srv.entity.Actor;

/**
 * The database representation of the Seller
 * 
 * @author Advait Moghe
 *
 */
public class Seller extends Actor {

	/**
	 * Constructor to be used when creating a new instance for when retrieving data
	 * from the database.
	 * 
	 * @param id
	 *            the id of the seller
	 * @param description
	 *            the description of the seller
	 * @param email
	 *            the email address of the seller
	 */
	public Seller(Long id, String description, String email) {
		super(id, description, email);
	}

	/**
	 * Constructor to be used when creating a new instance for adding an seller to
	 * the database. We omit the id here as the id is auto-generated.
	 * 
	 * @param description
	 *            the description of the seller
	 * @param email
	 *            the email address of the seller
	 */
	public Seller(String description, String email) {
		super(description, email);
	}
}
