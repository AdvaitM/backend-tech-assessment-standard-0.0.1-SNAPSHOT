package com.intuit.cg.backendtechassessment.bid.srv.entity;

import java.util.Date;

/**
 * The database representation of bid.
 * 
 * @author Advait Moghe
 *
 */
public class Bid {
	private Long id;
	private final Long buyerId;
	private final Long projectId;
	private final double bidAmount;
	private final Date bidPlacedDateTime;

	/**
	 * Constructor to be used when creating a new instance for retrieving data from
	 * the database
	 * 
	 * @param id
	 *            the id of the bid
	 * @param buyerId
	 *            the id of the buyer placing the bid
	 * @param projectId
	 *            the id of the project for which the bid is being placed
	 * @param bidAmount
	 *            the bid amount
	 * @param bidPlacedDateTime
	 *            the time at which the bid was placed
	 */
	public Bid(Long id, Long buyerId, Long projectId, double bidAmount, Date bidPlacedDateTime) {
		this(buyerId, projectId, bidAmount, bidPlacedDateTime);
		this.id = id;

	}

	/**
	 * Constructor to be used when creating a new instance for adding an actor to
	 * the database. We omit the id here as the id is auto-generated.
	 * 
	 * @param buyerId
	 *            the id of the buyer placing the bid
	 * @param projectId
	 *            the id of the project for which the bid is being placed
	 * @param bidAmount
	 *            the bid amount
	 * @param bidPlacedDateTime
	 *            the time at which the bid was placed
	 */
	public Bid(Long buyerId, Long projectId, double bidAmount, Date bidPlacedDateTime) {
		this.buyerId = buyerId;
		this.projectId = projectId;
		this.bidAmount = bidAmount;
		this.bidPlacedDateTime = bidPlacedDateTime;
	}

	/**
	 * Returns the id of the bid.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the id of the buyer
	 * 
	 * @return the id of the buyer
	 */
	public Long getBuyerId() {
		return buyerId;
	}

	/**
	 * Returns the id of the project
	 * 
	 * @return the id of the project
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * Returns the bid amount.
	 * 
	 * @return the bud amount
	 */
	public double getBidAmount() {
		return bidAmount;
	}

	/**
	 * Returns the bid placed date time.
	 * 
	 * @return the bid placed date time
	 */
	public Date getBidPlacedDateTime() {
		return bidPlacedDateTime;
	}

}
