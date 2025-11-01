package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 基础数据访问对象
 */
public class BaseDao {
	String driver = "com.mysql.cj.jdbc.Driver";   // 数据库驱动字符串
	String url = "jdbc:mysql://localhost:3306/news?serverTimezone=GMT-8";   // 连接URL字符串
	String user = "root";     // 数据库用户名
	String password = "root"; // 用户密码

	/**
	 * 获取数据库连接对象
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		// 获取连接并捕获异常
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		return conn; // 返回连接对象
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		// 若结果集对象不为空,则关闭
		if (rs != null) {
			rs.close();
		}
		// 若Statement对象不为空,则关闭
		if (stmt != null) {
			stmt.close();
		}
		// 若数据库连接对象不为空,则关闭
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * 增加、删除、修改的操作
	 */
	public int executeUpdate(String sql, Object[] params) throws Exception {
		PreparedStatement pstmt = null;
		int num = 0;
		Connection conn = getConnection();

		pstmt = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
//				 为预编译sql设置参数
				pstmt.setObject(i + 1, params[i]);
			}
		}
		num = pstmt.executeUpdate();

		closeAll(conn, pstmt, null);

		return num;
	}
	
	/**
	 * 查询的操作
	 */
	public ResultSet executeQuery(String sql, Object[] params) throws Exception {
		Connection conn = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
	
	
	
	
	
	
	
}
