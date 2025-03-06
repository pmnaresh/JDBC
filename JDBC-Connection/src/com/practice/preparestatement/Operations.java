package com.practice.preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.practice.resultset.Employee;

public class Operations {

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

	public void closeConnection(Connection connection) throws SQLException {
		System.out.println("closing connection");
		connection.close();
		System.out.println("closed connection succesfully");
	}

	public void insertByPrepareStatement(Connection connection) throws SQLException {
		System.out.println("using prepare statement to insert");

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
		PreparedStatement psmt = connection.prepareStatement("insert into employee values(?,?,?,?)");
		psmt.setInt(1, employee.geteId());
		psmt.setString(2, employee.geteName());
		psmt.setFloat(3, employee.geteSalary());
		psmt.setLong(4, employee.geteContact());
		psmt.execute();
		System.out.println("succesfully inserted");

	}

	public void updateByPrepareStatement(Connection connection) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		System.out.println("Enter employee salary ");
		float salary = sc.nextFloat();
		System.out.println("Enter employee contact number ");
		long contact = sc.nextLong();
		PreparedStatement psmt = connection
				.prepareStatement("update employee set esalary =?, econtact =? where eid =?");
		psmt.setFloat(1, salary);
		psmt.setLong(2, contact);
		psmt.setInt(3, id);
		psmt.execute();
		System.out.println("successfully updated ");

	}

	public void deleteByPrepareStatement(Connection connection) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		PreparedStatement psmt = connection.prepareStatement("delete from employee where eid=?");
		psmt.setInt(1, id);
		psmt.execute();
		System.out.println("succesfully deleted");
	}

}
