package com.projectone.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class EnvironmentConnectionUtil {
	private String url = System.getenv("url");
	private String username = System.getenv("username");
	private String password = System.getenv("password");
	
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static EnvironmentConnectionUtil instance;

	private EnvironmentConnectionUtil() {

	}
	public static EnvironmentConnectionUtil getInstance() {
		if(instance == null) {
			instance = new EnvironmentConnectionUtil();
		}
		return instance;
	}

	public Connection getConnection()throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
