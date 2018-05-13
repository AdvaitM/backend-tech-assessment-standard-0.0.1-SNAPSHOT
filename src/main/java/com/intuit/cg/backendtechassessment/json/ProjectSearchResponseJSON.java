package com.intuit.cg.backendtechassessment.json;

/**
 * JSON representation of the projects created by sellers.
 * 
 * @author Advait Moghe
 *
 */
public class ProjectSearchResponseJSON {
	private final long projectId;
	private final String description;
	private final double lowestBid;

	public ProjectSearchResponseJSON(long projectId, String description, double lowestBid) {
		this.projectId = projectId;
		this.description = description;
		this.lowestBid = lowestBid;
	}

	public long getProjectId() {
		return projectId;
	}

	public String getDescription() {
		return description;
	}

	public double getLowestBid() {
		return lowestBid;
	}

}
