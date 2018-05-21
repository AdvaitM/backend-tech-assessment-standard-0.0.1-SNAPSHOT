package com.intuit.cg.backendtechassessment.response;

public class AddProjectResponse {
	private final long projectId;

	public AddProjectResponse(long projectId) {
		this.projectId = projectId;
	}

	public long getProjectId() {
		return projectId;
	}
}
