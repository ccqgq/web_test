package com.qgq.user.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 工具类 提供数据库连接池 和数据库连接
 * @author 啦啦啦
 *
 */
public class JDBCUtils {
	private static ComboPooledDataSource cpds=new ComboPooledDataSource();
	/**
	 * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn=cpds.getConnection();
		return conn;
	}
	public static ComboPooledDataSource getComboPooledDataSource(){
		return cpds;
	}
}
