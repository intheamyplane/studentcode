package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {
		Department department = null;
		String sql = "SELECT department_id, name\n" +
				"FROM department\n" +
				"WHERE department_id = ?;";

		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		if (result.next()) {
			department = mapRowToDepartment(result);

		}

		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = "SELECT department_id, name\n" +
				"FROM department;\n";


		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		while(result.next()){
			Department department = mapRowToDepartment(result);
			departments.add(department);
		}
		return departments;

	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department\n" +
				"SET name = ?\n" +
				"WHERE department_id = ?;";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());


	}



	private Department mapRowToDepartment(SqlRowSet result) {
		Department department = new Department();
		department.setId(result.getInt("department_id"));
		department.setName(result.getString("name"));

		return department;
	}
}
