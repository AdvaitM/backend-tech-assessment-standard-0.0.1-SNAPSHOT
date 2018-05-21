package com.intuit.cg.backendtechassessment.bid.srv.entity;

import java.util.Date;

public class Bid {
	private Long id;
	private final Long buyerId;
	private final Long projectId;
	private final double bidAmount;
	private final Date bidPlacedDateTime;

	public Bid(Long id, Long buyerId, Long projectId, double bidAmount, Date bidPlacedDateTime) {
		this(buyerId, projectId, bidAmount, bidPlacedDateTime);
		this.id = id;

	}

	public Bid(Long buyerId, Long projectId, double bidAmount, Date bidPlacedDateTime) {
		this.buyerId = buyerId;
		this.projectId = projectId;
		this.bidAmount = bidAmount;
		this.bidPlacedDateTime = bidPlacedDateTime;
	}

	public Long getId() {
		return id;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public Date getBidPlacedDateTime() {
		return bidPlacedDateTime;
	}

}
