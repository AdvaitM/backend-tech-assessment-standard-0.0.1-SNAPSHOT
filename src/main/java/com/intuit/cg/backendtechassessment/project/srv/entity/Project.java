package com.intuit.cg.backendtechassessment.project.srv.entity;

import java.util.Date;

/**
 * The database representation of an Project.
 * 
 * @author Advait Moghe
 *
 */
public class Project {

	private Long id;
	private final String description;
	private final double maximumBudget;
	private final Date bidClosingDateTime;
	private final Long sellerId;

	/**
	 * Constructor to be used when creating a new instance for when retrieving data
	 * from the database.
	 * 
	 * @param id
	 *            the id of the project
	 * @param description
	 *            the description of the project. Cannot be <code>null</code>, empty
	 *            or blank.
	 * @param maximumBudget
	 *            the maximum budget for the project
	 * @param bidClosingDateTime
	 *            the {@link Date} the bidding closes. Cannot be <code>null</code>.
	 * @param sellerId
	 *            the id of the seller selling
	 */
	public Project(Long id, String description, double maximumBudget, Date bidClosingDateTime, Long sellerId) {
		this(description, maximumBudget, bidClosingDateTime, sellerId);
		this.id = id;
	}

	/**
	 * 
	 * Constructor to be used when creating a new instance for adding an project to
	 * the database. We omit the id here as the id is auto-generated.
	 * 
	 * @param description
	 *            the description of the project. Cannot be <code>null</code>, empty
	 *            or blank.
	 * @param maximumBudget
	 *            the maximum budget for the project
	 * @param bidClosingDateTime
	 *            the {@link Date} the bidding closes. Cannot be <code>null</code>.
	 * @param sellerId
	 *            the id of the seller selling
	 */
	public Project(String description, double maximumBudget, Date bidClosingDateTime, Long sellerId) {
		this.description = description;
		this.maximumBudget = maximumBudget;
		this.bidClosingDateTime = bidClosingDateTime;
		this.sellerId = sellerId;
	}

	/**
	 * Returns the id of the project.
	 * 
	 * @return the project id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the project description.
	 * 
	 * @return the project description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the maximum budget.
	 * 
	 * @return the maximum budget
	 */
	public double getMaximumBudget() {
		return maximumBudget;
	}

	/**
	 * Returns the date/time for closing the bidding.
	 * 
	 * @return the date/time for closing the bidding
	 */
	public Date getBidClosingDateTime() {
		return bidClosingDateTime;
	}

	/**
	 * Returns the id of the seller.
	 * 
	 * @return the id of the seller
	 */
	public Long getSellerId() {
		return sellerId;
	}

}
