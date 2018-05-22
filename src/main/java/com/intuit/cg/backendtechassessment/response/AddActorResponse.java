package com.intuit.cg.backendtechassessment.response;

/**
 * The response to send back for a successful add buyer or seller request.
 * 
 * @author Advait Moghe
 */
public class AddActorResponse {
	private final Long id;

	/**
	 * Constructor for the class.
	 * 
	 * @param id
	 *            the id of the added actor
	 */
	public AddActorResponse(Long id) {
		this.id = id;
	}

	/**
	 * Returns the id of the actor.
	 * 
	 * @return the id of the actor
	 */
	public long getId() {
		return id;
	}
}
