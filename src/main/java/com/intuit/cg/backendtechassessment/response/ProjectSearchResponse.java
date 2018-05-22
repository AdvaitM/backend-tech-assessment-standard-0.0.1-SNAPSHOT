package com.intuit.cg.backendtechassessment.response;

/**
 * The response to send back for a successful project search request.
 * 
 * @author Advait Moghe
 *
 */
public class ProjectSearchResponse {
	private final Long projectId;
	private final Long buyerId;
	private final double lowestBid;

	/**
	 * Constructor for the class.
	 * 
	 * @param projectId
	 *            the id of the project
	 * @param buyerId
	 *            the id of the buyer
	 * @param lowestBid
	 *            the lowest bid on the project
	 */
	public ProjectSearchResponse(long projectId, Long buyerId, double lowestBid) {
		this.projectId = projectId;
		this.buyerId = buyerId;
		this.lowestBid = lowestBid;
	}

	/**
	 * Returns the id of the project.
	 * 
	 * @return the id of the project
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * Returns the id of the buyer.
	 * 
	 * @return the id of the buyer
	 */
	public Long getBuyerId() {
		return buyerId;
	}

	/**
	 * Returns the lowest bid on the project.
	 * 
	 * @return the lowest bid on the project
	 */
	public double getLowestBid() {
		return lowestBid;
	}

}
