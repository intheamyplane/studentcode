package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;
import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
				"FROM employee;";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		while(rowSet.next()){
			employees.add(mapRowToEmployee(rowSet));
		}

		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT DISTINCT employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
				"FROM employee\n" +
				"WHERE first_name LIKE ? AND last_name LIKE ?;";
		firstNameSearch = "%" + lastNameSearch + "%";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, firstNameSearch, lastNameSearch);
		while(rowSet.next()){
			employees.add(mapRowToEmployee(rowSet));
		}

		return employees;
	}


	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
				"FROM employee\n" +
				"\tJOIN project_employee ON employee.employee_id = project_employee.employee_id\n" +
				"WHERE project_id = ?;";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, projectId);
		while (rowSet.next()){
			employees.add(mapRowToEmployee(rowSet));
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id)\n" +
				"VALUES (?, ?);";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String sql = "DELETE FROM project_employee\n" +
				"WHERE employee_id = ?;";
		jdbcTemplate.update(sql, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {



		return new ArrayList<>();
	}



	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getInt("Employee_id"));
		employee.setDepartmentId(result.getInt("Department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDate(result.getDate("birth_date").toLocalDate());
		employee.setHireDate(result.getDate("hire_date").toLocalDate());

		return employee;
	}





}
