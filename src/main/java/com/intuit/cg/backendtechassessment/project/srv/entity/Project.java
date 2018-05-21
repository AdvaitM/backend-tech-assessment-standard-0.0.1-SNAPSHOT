package com.intuit.cg.backendtechassessment.project.srv.entity;

import java.util.Date;

public class Project {

	private Long id;
	private final String description;
	private final double maximumBudget;
	private final Date bidClosingDateTime;
	private final Long sellerId;

	public Project(Long id, String description, double maximumBudget, Date bidClosingDateTime, Long sellerId) {
		this(description, maximumBudget, bidClosingDateTime, sellerId);
		this.id = id;
	}

	public Project(String description, double maximumBudget, Date bidClosingDateTime, Long sellerId) {
		this.description = description;
		this.maximumBudget = maximumBudget;
		this.bidClosingDateTime = bidClosingDateTime;
		this.sellerId = sellerId;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getMaximumBudget() {
		return maximumBudget;
	}

	public Date getBidClosingDateTime() {
		return bidClosingDateTime;
	}

	public Long getSellerId() {
		return sellerId;
	}

}
