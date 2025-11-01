package com.oracel.test;

import com.oracel.dao.EmpDao;
import com.oracel.dao.impl.EmpDaoImpl;
import com.oracel.entity.Emp;

public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		//加载驱动
//		String url = "jdbc:mysql://127.0.0.1:3306/world?useUnicode=true&characterEncoding=utf8";
		//建立连接
//		Connection conn = DriverManager.getConnection(url,"root","root");
		//建立连接					
//		Connection conn = ConnUtil.getConn();	
		//获得sql语句
//		PreparedStatement ps = conn.prepareStatement("select * from emp");	
		//查询结果集
//		ResultSet rs = ps.executeQuery();			
		//获得结果集									
//		while (rs.next()) {					
//			System.out.println(rs.getInt("empno") + "==" + rs.getString("ename"));
//		}										
		//释放资源								
//		rs.close(); ps.close(); conn.close();
	System.out.println("hello");						
//		EmpDao empDao = new EmpDaoImpl();
//		Emp e=new Emp();
//		e.setEname("soc");
//		System.out.println(empDao.quertbycondition(e));											
	}
    
}
