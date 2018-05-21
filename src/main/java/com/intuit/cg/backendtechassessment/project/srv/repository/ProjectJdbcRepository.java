package com.intuit.cg.backendtechassessment.project.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.exception.EntityNotFoundException;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;

/**
 * The repository used for accessing project data.
 * 
 * @author Advait Moghe
 *
 */
@Repository
public class ProjectJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * A <code>RowMapper</code> to map the attributes on the project table to the
	 * {@link Project} object.
	 * 
	 * @author Advait Moghe
	 *
	 */
	class ProjectRowMapper implements RowMapper<Project> {

		@Override
		public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Project project = new Project(resultSet.getLong("id"), resultSet.getString("description"),
					resultSet.getDouble("budget"), resultSet.getDate("closing"), resultSet.getLong("seller_id"));
			return project;
		}
	}

	/**
	 * Inserts the given {@link Project} into the project table.
	 * 
	 * @param project
	 *            the {@link Project} to insert. Cannot be <code>null</code>.
	 * @return the number of rows affected
	 */
	public int insertProject(Project project) {
		return jdbcTemplate.update(
				"insert into project (budget, closing, description, seller_id) " + "values(?, ?, ?, ?)",
				new Object[] { project.getMaximumBudget(), project.getBidClosingDateTime(), project.getDescription(),
						project.getSellerId() });
	}

	/**
	 * Retrieves the id of last inserted project in the table.
	 * 
	 * @return the id of the most recently inserted project.
	 */
	public Long getLastInsertedProjectId() {
		// This is done so that the newest added project id can be returned to the user
		// adding the project for their reference
		List<Project> project = jdbcTemplate.query("select * from project", new ProjectRowMapper());
		return project.get(project.size() - 1).getId();
	}

	/**
	 * Retrieves a project by its id.
	 * 
	 * @param projectId
	 *            the id of the {@link Project} to retrieve. Cannot be zero or
	 *            negative.
	 * @return the {@link Project}. Will never be <code>null</code>.
	 */
	public Project getProjectById(Long projectId) {
		return jdbcTemplate.queryForObject("select * from project where id=?", new Object[] { projectId },
				new ProjectRowMapper());
	}
}
