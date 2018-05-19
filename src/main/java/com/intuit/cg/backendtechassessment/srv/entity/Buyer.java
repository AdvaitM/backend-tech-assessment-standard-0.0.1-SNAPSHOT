package com.intuit.cg.backendtechassessment.srv.entity;

public class Buyer extends Actor {

	public Buyer(Long id, String description, String email) {
		super(id, description, email);
	}

	public Buyer(String description, String email) {
		super(description, email);
	}
}
