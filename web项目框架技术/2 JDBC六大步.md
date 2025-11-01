JDBC六大步


BC 六大步】

1、加载驱动

2、获取连接对象 Connection

3、获取操作对象 statement

4、执行操作，得到结果

5、处理结果

6、释放资源

```java
	String url="jdbc:mysql://127.0.0.1:3306/emp?useUnicode=true&characterEncoding=utf8";
	
	Connection conn=DriverManager.getConnection(url, "root", "root");
	
	PreparedStatement ps=conn.prepareStatement("select * from emp");
	
	ResultSet rs=ps.executeQuery();
	
	while (rs.next()) {
		System.out.println(rs.getInt("empno")+"=="+rs.getString("ename"));
	}
	
	rs.close();ps.close();conn.close();
```