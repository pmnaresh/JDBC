package com.practice.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseOperations {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		System.out.println("fecthing connection");
		// load oracle driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// creating connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-2GU83B7:1521:xe", "SYSTEM",
				"system");
		System.out.println("connection is -->" + connection);
		return connection;

	}

	public Statement createStatement(Connection connection) throws SQLException {
		System.out.println("fetching statement");
		// creating statement
		Statement statement = connection.createStatement();
		System.out.println("statement is->" + statement);

		return statement;
	}

	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("closing connection");
		connection.close();
		System.out.println("closed connection succesfully");
	}

	public void insertToEmployee(Statement statement) throws SQLException {
		System.out.println("Entering employee details");
		Employee employee = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		employee.seteId(sc.nextInt());
		System.out.println("Enter Employee Name ");
		employee.seteName(sc.next());
		System.out.println("Enter employee salary ");
		employee.seteSalary(sc.nextFloat());
		System.out.println("Enter employee contact number ");
		employee.seteContact(sc.nextLong());

		// insert into employee values(12,'Naresh',56789,9090909090)
		String insertQuery = "Insert into employee values(" + employee.geteId() + ",'" + employee.geteName() + "',"
				+ employee.geteSalary() + "," + employee.geteContact() + ")";
		System.out.println(insertQuery);

		// executing the insert query
		statement.execute(insertQuery);

	}

	public List<Employee> fetchAllEmployees(Statement statement) throws SQLException {
		System.out.println("fetching all from employee table");

		String getEmployeesQuery = "select * from employee";
		ResultSet resulutset = statement.executeQuery(getEmployeesQuery);
		
		List<Employee> employeeList = new ArrayList<Employee>();

		while (resulutset.next()) {
			Employee emp = new Employee();
			emp.seteId(resulutset.getInt(1));
			emp.seteName(resulutset.getString(2));
			emp.seteSalary(resulutset.getFloat(3));
			emp.seteContact(resulutset.getLong(4));
			employeeList.add(emp);
		}
		System.out.println("employee list is -->" + employeeList);
		return employeeList;

	}

	public void updateEmployee(Statement statement) throws SQLException {
		System.out.println("Updating employee object ");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee Id to update salary");
		int id = sc.nextInt();
		System.out.println("Enter updated salary");
		float salary = sc.nextFloat();
		// String updateQuery = "UPDATE employees SET salary = ? WHERE id = ?"

		String updateQuery = "update employee set esalary = " + salary + " where eid = " + id;

		System.out.println("updated query is --> " + updateQuery);

		statement.execute(updateQuery);

	}

	public void deleteEmployee(Statement statement) throws SQLException {
		System.out.println("Deleting employee from table");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employeeid to delete ");

		int id = sc.nextInt();

		String deleteQuery = "DELETE FROM employee WHERE eid= " + id;
		System.out.println("delete query is --> " + deleteQuery);
		statement.execute(deleteQuery);

		System.out.println("successfully deleted employee");

	}

}
