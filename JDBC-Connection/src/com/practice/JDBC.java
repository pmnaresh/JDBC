package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		try {
			// loading oracle class loader
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//creating connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-2GU83B7:1521:xe", "SYSTEM", "system");
			System.out.println(con);
			//create statement
			Statement stmt  =con.createStatement();
			//preparing insert query
			String query = "INSERT INTO student (rollno, name) VALUES (15,'suresh')";
			System.out.println(query);
			//execute query 
			stmt.execute(query);
			
			//close the connection
			con.close();
			
			System.out.println("succesfully added to  table");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}