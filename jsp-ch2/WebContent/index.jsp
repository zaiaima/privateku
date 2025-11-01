<%@page import="entity.NewsUsers"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%--
<%
	NewsUsers users=(NewsUsers)session.getAttribute("users");
%>

	<%if( users != null ){%>
		欢迎<%=users.getUname()%><br>
		<a href="change.jsp">修改密码</a>
	<%}else{ %>
	<a href="login.jsp">立即登录</a>
	<a href="register.jsp">立即注册</a>
	<%}%>
 --%>
<c:choose>
	<c:when test="${not empty users}">
		欢迎${users.uname}&nbsp;&nbsp;
		<a href="change.jsp">修改密码</a>
	</c:when>
	<c:otherwise>
		<a href="login.jsp">立即登录</a>
		<a href="register.jsp">立即注册</a>
	</c:otherwise>
</c:choose>
</body>
</html>