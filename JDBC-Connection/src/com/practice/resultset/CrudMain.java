package com.practice.resultset;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CrudMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseOperations databaseOperations = new DatabaseOperations();
		//creating connection
		Connection connection = databaseOperations.getConnection();
		//creating statement
		Statement statement = databaseOperations.createStatement(connection);

		// insert to table employee
		for (int i = 0; i < 4; i++) {
			databaseOperations.insertToEmployee(statement);
		}

		// fetch all employee records
		List<Employee> empoloyeeList = databaseOperations.fetchAllEmployees(statement);
		

		// update employee
		databaseOperations.updateEmployee(statement);

		// delete employee
		databaseOperations.deleteEmployee(statement);
		//close the connection
		databaseOperations.closeConnection(connection);
	}

}
