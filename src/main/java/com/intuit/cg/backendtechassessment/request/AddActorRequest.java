package com.intuit.cg.backendtechassessment.request;

/**
 * Representation of the actor.
 * 
 * @author Advait Moghe
 *
 */
public class AddActorRequest {
	private final String description;
	private final String emailId;

	/**
	 * Constructor for the class.
	 * 
	 * @param description
	 *            the description of the actor. Cannot be <code>null</code>, empty
	 *            or blank.
	 * @param emailId
	 *            the email id of the actor. Cannot be <code>null</code>, empty or
	 *            blank.
	 */
	public AddActorRequest(String description, String emailId) {
		this.description = description;
		this.emailId = emailId;
	}

	/**
	 * Returns the actor's description.
	 * 
	 * @return the actor's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the actor's email id.
	 * 
	 * @return the actor's email id
	 */
	public String getEmailId() {
		return emailId;
	}
}
