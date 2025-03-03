package com.sql.learning.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sql.learning.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static Statement stmt =null;
	//static final String SQL="INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES (5,'Sameer','Male',78000)";
	static final String Insert_Query="INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES (%d,'%s','%s',%d)";
	static final String Update_Query="Update employee set name = '%s',gender='%s',salary =%d where id =%d";
	static final String Delete_Query="Delete from employee where id=%d";
	static final String Select_Query="Select* from employee";
	static final String Select_By_Id_Query="Select* from employee where id=%d";
	static {
		try {
			stmt=DriverManager.getConnection("jdbc:mysql://localhost:3306/shivang","root","root").createStatement()	;	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}

	@Override
	public void saveEmployee(Employee e) throws SQLException {
		//stmt.executeUpdate("INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES ("+e.getId()+",'"+e.getName()+"','"+e.getGender()+"',"+e.getSalary()+")");
		stmt.executeUpdate(String.format(Insert_Query,e.getId(),e.getName(),e.getGender(),e.getSalary()));
		//System.out.println("INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES");
		System.out.println(String.format(Insert_Query,e.getId(),e.getName(),e.getGender(),e.getSalary()));
		System.out.println(".EmployeeDao.saveEmployee()");
		
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException {
//stmt.executeUpdate("update employee set name ='"+e.getName()+"',gender ='"+e.getGender()+"',salary="+e.getSalary()+"where id= "+e.getId()+"");
		stmt.executeUpdate(String.format(Update_Query,e.getName(),e.getGender(),e.getSalary(),e.getId()));
		//System.out.println("\"Update employee set name ='\"+e.getName()+\"',gender ='\"+e.getGender()+\"',salary=\"+e.getSalary()+\"where id= \"+e.getId()+\"");
		System.out.println(String.format(Update_Query,e.getName(),e.getGender(),e.getSalary(),e.getId()));
	}

	@Override
	public void deleteEmployeeById(int id)throws SQLException {
stmt.executeUpdate(String.format(Delete_Query, id));
		System.out.println(String.format(Delete_Query, id));
	}

	@Override
	public void getAllEmployees() throws SQLException {
	ResultSet rs=stmt.executeQuery(Select_Query);
	while(rs.next()) {
		System.out.println("ID ="+rs.getInt(1)+"  Name = "+rs.getString(2)+"  Gender = "+rs.getString(3)+"  Salary = "+rs.getInt(4));
		System.out.println(stmt.executeQuery(Select_Query));
	}
		
	}

	@Override
	public void getEmployeeById(int id) throws SQLException {
		ResultSet rs=stmt.executeQuery(String.format(Select_By_Id_Query, id));
		while(rs.next()) {
			System.out.println("ID ="+rs.getInt(1)+"  Name = "+rs.getString(2)+"  Gender = "+rs.getString(3)+"  Salary = "+rs.getInt(4));
			System.out.println(String.format(Select_By_Id_Query, id));
		}
		
	}

}
