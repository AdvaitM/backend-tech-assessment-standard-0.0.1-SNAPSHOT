package com.intuit.cg.backendtechassessment.json;

public class AddProjectResponseJSON {
	private final long projectId;

	public AddProjectResponseJSON(long projectId) {
		this.projectId = projectId;
	}

	public long getProjectId() {
		return projectId;
	}
}
