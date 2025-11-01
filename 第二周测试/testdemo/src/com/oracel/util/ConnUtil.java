package com.oracel.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


//import org.apache.commons.dbcp.BasicDataSourceFactory;


public class ConnUtil {
	private static ThreadLocal<Connection> crtConn = new ThreadLocal<>();
	private static DataSource ds = null;
	
	static{
		Properties pro = new Properties();
		try {
			pro.load(ConnUtil.class.getResourceAsStream("/mysql.properties"));
			ds = DruidDataSourceFactory.createDataSource(pro);
//			ds = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static Connection getConn(){
		Connection conn = crtConn.get();
		
		if (conn == null) {
			try {
				conn = ds.getConnection();
				crtConn.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void close(Connection conn){
		try {
			if(conn!=null) {
				conn.close();
				crtConn.remove();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement st, ResultSet rs){
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
