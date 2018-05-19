package com.intuit.cg.backendtechassessment.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.srv.entity.Project;

@Repository
public class ProjectJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class ProjectRowMapper implements RowMapper<Project> {

		@Override
		public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Project project = new Project(resultSet.getLong("id"), resultSet.getString("description"),
					resultSet.getDouble("budget"), resultSet.getDate("closing"), resultSet.getLong("seller_id"));
			return project;
		}
	}

	public int insertProject(Project project) {
		return jdbcTemplate.update(
				"insert into project (budget, closing, description, seller_id) " + "values(?, ?, ?, ?)",
				new Object[] { project.getMaximumBudget(), project.getBidClosingDateTime(), project.getDescription(),
						project.getSellerId() });
	}

	public Long getLastInsertedRow() {
		List<Project> project = jdbcTemplate.query("select * from project", new ProjectRowMapper());
		return project.get(project.size() - 1).getId();
	}

}
