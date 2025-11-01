package com.oracel.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class ConnUtil {
	private static ThreadLocal<Connection> crtConn = new ThreadLocal<>();
	private static DataSource ds = null;
	
	static{
		//初始化连接池
		Properties pro = new Properties();
		try {
			pro.load(ConnUtil.class.getResourceAsStream("/mysql.properties"));
			ds = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//维护 connection 对象的 获取 、 释放
	public static Connection getConn(){
		Connection conn = crtConn.get();
		
		if (conn == null) {
			try {
				conn = ds.getConnection();
				crtConn.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
