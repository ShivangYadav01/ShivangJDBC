package com.sql.learning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.sql.learning.dao.EmployeeDao;
import com.sql.learning.dao.EmployeeDaoImpl;
import com.sql.learning.entity.Employee;

public class Client {
	static final String SQL="INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES (5,'Sameer','Male',78000)";
	
public static void main(String[] args)throws SQLException {
	//Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/shivang","root","root");
	
//DriverManager.getConnection("jdbc:mysql://localhost:3306/shivang","root","root").createStatement().executeUpdate("INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES (8,'Ayush','Male',76700)");
//Statement statement=connection.createStatement();

//connection.createStatement().executeUpdate("INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY)VALUES (7,'Rohit','Male',79230)");


//statement.executeUpdate(SQL);->It is used for call above declared Variable..
	
	Employee shiv =new Employee(9,"Shiv","Male",65300);
	Employee vinay =new Employee(10,"Vinay","Male",66300);
	Employee dhurv =new Employee(11,"Dhurv","Male",67000);
	Employee vipin=new Employee(12,"Vipin kumar 2","Male",67300);
	Employee sukoon=new Employee(12,"Sukoon kumar 2","Male",67340);
	
	EmployeeDao edao=new EmployeeDaoImpl();
	
//	edao.saveEmployee(shiv);
//	edao.saveEmployee(vinay);
//	edao.saveEmployee(dhurv);
//	edao.saveEmployee(vipin);

	edao.updateEmployee(sukoon);
	
	//edao.saveEmployee(sukoon);
System.out.println("Transaction Successfull....");

}
}