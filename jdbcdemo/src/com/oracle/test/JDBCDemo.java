package com.oracle.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.util.ConnUtil;

public class JDBCDemo {
	
	/*
	 * 
	 * JDBC API 和  驱动
	 * 
	 * 【JDBC 六大步】
	 * 1、加载驱动
	 * 
	 * 2、获取连接对象 Connection
	 * 
	 * 3、获取操作对象 Statement
	 * 
	 * 4、执行操作，得到结果
	 * 
	 * 5、处理结果
	 * 
	 * 6、释放资源
	 * 
	 */
	

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/emp?useUnicode=true&characterEncoding=utf8";
		
		Connection conn = DriverManager.getConnection(url, "root", "root");
		
//		Connection conn = ConnUtil.getConn();
		
		PreparedStatement ps = conn.prepareStatement("select * from emp");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt("empno") + "==" + rs.getString("ename"));
		}

		rs.close();
		ps.close();
		conn.close();
	}

}
