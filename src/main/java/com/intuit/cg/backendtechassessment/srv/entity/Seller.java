package com.intuit.cg.backendtechassessment.srv.entity;

public class Seller extends Actor {

	public Seller(Long id, String description, String email) {
		super(id, description, email);
	}

	public Seller(String description, String email) {
		super(description, email);
	}
}
