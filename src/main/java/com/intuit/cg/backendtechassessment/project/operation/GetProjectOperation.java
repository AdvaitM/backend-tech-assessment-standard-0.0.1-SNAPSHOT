package com.intuit.cg.backendtechassessment.project.operation;

import org.springframework.dao.EmptyResultDataAccessException;

import com.intuit.cg.backendtechassessment.exception.EntityNotFoundException;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;
import com.intuit.cg.backendtechassessment.project.srv.repository.ProjectJdbcRepository;

/**
 * The operation responsible for retrieving a {@link Project}.
 * 
 * @author Advait Moghe
 *
 */
public class GetProjectOperation {

	private final ProjectJdbcRepository projectRepository;

	public GetProjectOperation(ProjectJdbcRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project getProjectById(long projectId) {
		try {
			return projectRepository.getProjectById(projectId);
		} catch (EmptyResultDataAccessException exception) {
			throw new EntityNotFoundException("No projects with project id [" + projectId + "] were found.");
		}
	}
}
