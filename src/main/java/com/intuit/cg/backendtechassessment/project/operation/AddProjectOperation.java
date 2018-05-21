package com.intuit.cg.backendtechassessment.project.operation;

import com.intuit.cg.backendtechassessment.project.srv.entity.Project;
import com.intuit.cg.backendtechassessment.project.srv.repository.ProjectJdbcRepository;
import com.intuit.cg.backendtechassessment.request.AddProjectRequest;
import com.intuit.cg.backendtechassessment.response.AddProjectResponse;

public class AddProjectOperation {

	private final ProjectJdbcRepository projectRepository;

	public AddProjectOperation(ProjectJdbcRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public AddProjectResponse addProject(AddProjectRequest addProjectRequest) {
		Project project = new Project(addProjectRequest.getProjectDescription(), addProjectRequest.getMaximumBudget(),
				addProjectRequest.getBidClosingDateTime(), addProjectRequest.getSellerId());
		projectRepository.insertProject(project);

		return new AddProjectResponse(projectRepository.getLastInsertedProjectId());
	}

}
