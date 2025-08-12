package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	public void getConnection(String url, String username, String password) throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {}
	}
	public void getConnection() throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		}
		catch(Exception e) {}
	}
	public ResultSet executeQuery(String query) throws SQLException
	{
		ResultSet result = null;
		try {
		Statement state=con.createStatement();
		result=state.executeQuery(query);
		}
		catch(Exception e) {}
		return result;
	}
	public int executeUpdate(String query) throws SQLException
	{
		int result = 0;
		try {
		Statement state=con.createStatement();
		result=state.executeUpdate(query);
		}
		catch(Exception e) {}
		return result;
	}
	public void closeConnection() throws SQLException
	{
		try {
		con.close();
		}
		catch(Exception e) {}
	}
}
