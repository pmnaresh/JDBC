package com.practice.preparestatement;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Operations operations=new Operations();
		//create connection
		Connection connection =operations.getConnection();
		//insertion with prepare statement
		operations.insertByPrepareStatement(connection);
		//updating with prepare statement
		operations.updateByPrepareStatement(connection);
		//delete by prepare statement
		operations.deleteByPrepareStatement(connection);
		//closing the connection
		operations.closeConnection(connection);

	}

}
