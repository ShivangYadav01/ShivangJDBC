package com.sql.learning.dao;
import java.sql.SQLException;

import com.sql.learning.entity.Employee;

public interface EmployeeDao {
	
	public void saveEmployee(Employee e) throws SQLException;
	
	public void updateEmployee(Employee e) throws SQLException;
	
	public void deleteeEmployeeById(int id)  throws SQLException;
	
	public void getAllEmployees()  throws SQLException;
	
	public void getEmployeeById(int id)  throws SQLException;
}
