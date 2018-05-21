package com.intuit.cg.backendtechassessment.response;

/**
 * JSON representation of the projects created by sellers.
 * 
 * @author Advait Moghe
 *
 */
public class ProjectSearchResponse {
	private final Long projectId;
	private final Long buyerId;
	private final double lowestBid;

	public ProjectSearchResponse(long projectId, Long buyerId, double lowestBid) {
		this.projectId = projectId;
		this.buyerId = buyerId;
		this.lowestBid = lowestBid;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public double getLowestBid() {
		return lowestBid;
	}

}
