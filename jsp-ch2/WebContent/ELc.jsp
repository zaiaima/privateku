<%@page import="entity.NewsUsers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	List<NewsUsers> list=new ArrayList<NewsUsers>();
	list.add(new NewsUsers(1,"admin","admin"));
	list.add(new NewsUsers(2,"wangwei","admin"));
	list.add(new NewsUsers(3,"litoa","admin"));
	list.add(new NewsUsers(4,"jiuyang","admin"));
	list.add(new NewsUsers(5,"lijaing","admin"));
	list.add(new NewsUsers(6,"qiaosang","admin"));
	session.setAttribute("list", list);
%>
<table border="1" width="80%">
	<c:forEach items="${list}" var="users" >
		<tr>
			<th>${users.uid}<th/>
			<th>${users.uname}<th/>
			<th>${users.upwd}<th/>
		<tr/>
	</c:forEach>
	
</table><br>
	<c:forEach begin="1" end="10" step="3">
		<c:out value="*"></c:out><br>
	</c:forEach>
</body>
</html>