package com.intuit.cg.backendtechassessment.buyer.srv.entity;

import com.intuit.cg.backendtechassessment.actor.srv.entity.Actor;

public class Buyer extends Actor {

	public Buyer(Long id, String description, String email) {
		super(id, description, email);
	}

	public Buyer(String description, String email) {
		super(description, email);
	}
}
