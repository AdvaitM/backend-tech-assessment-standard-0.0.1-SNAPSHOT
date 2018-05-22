package com.intuit.cg.backendtechassessment.response;

/**
 * The response to send back for a successful add project request.
 * 
 * @author Advait Moghe
 */
public class AddProjectResponse {
	private final long projectId;

	/**
	 * Constructor for the class.
	 * 
	 * @param projectId
	 *            the id of the project
	 */
	public AddProjectResponse(long projectId) {
		this.projectId = projectId;
	}

	/**
	 * Returns the id of the project.
	 * 
	 * @return the id of the project
	 */
	public long getProjectId() {
		return projectId;
	}
}
