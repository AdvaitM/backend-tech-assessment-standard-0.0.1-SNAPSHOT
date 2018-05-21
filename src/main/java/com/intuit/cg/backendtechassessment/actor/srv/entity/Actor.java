package com.intuit.cg.backendtechassessment.actor.srv.entity;

public abstract class Actor {

	protected Long id;
	protected final String description;
	protected final String email;

	public Actor(Long id, String description, String email) {
		this(description, email);
		this.id = id;
	}

	public Actor(String description, String email) {
		this.description = description;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getEmail() {
		return email;
	}

}
