package com.intuit.cg.backendtechassessment.seller.srv.entity;

import com.intuit.cg.backendtechassessment.actor.srv.entity.Actor;

public class Seller extends Actor {

	public Seller(Long id, String description, String email) {
		super(id, description, email);
	}

	public Seller(String description, String email) {
		super(description, email);
	}
}
