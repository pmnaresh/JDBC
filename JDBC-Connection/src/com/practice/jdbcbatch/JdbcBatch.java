package com.practice.jdbcbatch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.practice.resultset.DatabaseOperations;

public class JdbcBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DatabaseOperations databaseOperations = new DatabaseOperations();
		// creating connection
		Connection connection = databaseOperations.getConnection();
		// creating statement
		Statement statement = databaseOperations.createStatement(connection);
		
		String insertQuery ="insert into employee values(1021,'Nareshkumar',898,99999)";
		String updateQuery ="update employee set esalary =90 where eid=14";	
		String deleteQuery ="delete from employee where eid=12";
		
		statement.addBatch(deleteQuery);
		statement.addBatch(updateQuery);
		statement.addBatch(insertQuery);
		
	int[] i=	statement.executeBatch();
	System.out.println("success ran the batch "+i.toString());
	
	databaseOperations.closeConnection(connection);
		
	}
}
