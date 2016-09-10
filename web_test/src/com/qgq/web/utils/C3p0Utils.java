package com.qgq.web.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static ComboPooledDataSource cpds=new ComboPooledDataSource();
	public static Connection getcConnection() throws SQLException{
		Connection conn=cpds.getConnection();
		return conn;
	}
	public static ComboPooledDataSource getDataSource(){
		return cpds;
	}
}
