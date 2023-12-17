package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataSourceTest {
	
	@Test
	void connect() throws SQLException, ClassNotFoundException {
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mariadb://192.168.0.9:3306/practice",
				"user",
				"user");
		
		Assertions.assertNotNull(connection);
		
		connection.close();
	
	}
	
}
