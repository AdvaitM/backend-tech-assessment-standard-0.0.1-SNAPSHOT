package com.intuit.cg.backendtechassessment.actor.srv.entity;

/**
 * The database representation of an Actor.
 * 
 * @author Advait Moghe
 *
 */
public abstract class Actor {

	protected Long id;
	protected final String description;
	protected final String email;

	/**
	 * Constructor to be used when creating a new instance for when retrieving data
	 * from the database.
	 * 
	 * @param id
	 *            the id of the actor
	 * @param description
	 *            the description of the actor
	 * @param email
	 *            the email address of the actor
	 */
	public Actor(Long id, String description, String email) {
		this(description, email);
		this.id = id;
	}

	/**
	 * Constructor to be used when creating a new instance for adding an actor to
	 * the database. We omit the id here as the id is auto-generated.
	 * 
	 * @param description
	 *            the description of the actor
	 * @param email
	 *            the email address of the actor
	 */
	public Actor(String description, String email) {
		this.description = description;
		this.email = email;
	}

	/**
	 * Retrieves the id.
	 * 
	 * @return the actor's id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Retrieves the actor's description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Retrieves the actor's email address.
	 * 
	 * @return the actor's email address
	 */
	public String getEmail() {
		return email;
	}

}
