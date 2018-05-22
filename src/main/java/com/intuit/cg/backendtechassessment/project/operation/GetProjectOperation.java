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

	/**
	 * Constructor for the class.
	 * 
	 * @param projectRepository
	 *            the {@link ProjectJdbcRepository}. Cannot be <code>null</code>.
	 */
	public GetProjectOperation(ProjectJdbcRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	/**
	 * Retrieves the project by the project id
	 * 
	 * @param projectId
	 *            the id of the project to retrieve
	 * @return the {@link Project}. Will never be <code>null</code>
	 * @throws EntityNotFoundException
	 *             if the project with the given id does not exist
	 */
	public Project getProjectById(long projectId) {
		try {
			return projectRepository.getProjectById(projectId);
		} catch (EmptyResultDataAccessException exception) {
			throw new EntityNotFoundException("No projects with project id [" + projectId + "] were found.");
		}
	}
}
