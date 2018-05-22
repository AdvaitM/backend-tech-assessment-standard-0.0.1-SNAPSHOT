package com.intuit.cg.backendtechassessment.project.operation;

import com.intuit.cg.backendtechassessment.project.srv.entity.Project;
import com.intuit.cg.backendtechassessment.project.srv.repository.ProjectJdbcRepository;
import com.intuit.cg.backendtechassessment.request.AddProjectRequest;
import com.intuit.cg.backendtechassessment.response.AddProjectResponse;

/**
 * The operation for adding a new project
 * 
 * @author Advait Moghe
 *
 */
public class AddProjectOperation {

	private final ProjectJdbcRepository projectRepository;

	/**
	 * Constructor for the class.
	 * 
	 * @param projectRepository
	 *            the {@link ProjectJdbcRepository}
	 */
	public AddProjectOperation(ProjectJdbcRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	/**
	 * Adds a new project.
	 * 
	 * @param addProjectRequest
	 *            the {@link AddProjectRequest} containing the project data to add
	 * @return the {@link AddProjectResponse}. Will never be <code>null</code>.
	 */
	public AddProjectResponse addProject(AddProjectRequest addProjectRequest) {
		Project project = new Project(addProjectRequest.getProjectDescription(), addProjectRequest.getMaximumBudget(),
				addProjectRequest.getBidClosingDateTime(), addProjectRequest.getSellerId());
		projectRepository.insertProject(project);

		return new AddProjectResponse(projectRepository.getLastInsertedProjectId());
	}

}
