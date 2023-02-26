package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		Project project = null;
		String sql= "SELECT project_id, name, from_date, to_date\n" +
				"FROM project\n" +
				"WHERE project_id = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, projectId);
		if(result.next()){
			project = mapRowToProject(result);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
	List<Project> projects = new ArrayList<>();
	String sql = "SELECT project_id, name, from_date, to_date\n" +
			"FROM project;";

	SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
	while(result.next()) {
		projects.add(mapRowToProject(result));
	}

		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date)\n" +
				"VALUES (?, ?, ?)\n" +
				"RETURNING project_id;";

		Integer project= jdbcTemplate.queryForObject(sql, Integer.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());



		return getProject(project);
	}




	@Override
	public void deleteProject(int projectId) {


			String sql = "DELETE FROM project_employee WHERE project_id = ?;" +
					"DELETE FROM project WHERE project_id = ?;";
			jdbcTemplate.update(sql, projectId, projectId);


	}
	private Project mapRowToProject(SqlRowSet result) {
		Project project = new Project();
		project.setId(result.getInt("project_id"));
		project.setName(result.getString("name"));

		if(result.getDate("from_date") != null)
		project.setFromDate(result.getDate("from_date").toLocalDate());

		if(result.getDate("to_date") != null)
			project.setToDate(result.getDate("to_date").toLocalDate());

		return project;
	}
	

}
