<%@page import="entity.NewsUsers"%>
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
<c:set var="city1" value="湖南" scope="session"></c:set>
<c:set var="city2" value="可南" scope="session"></c:set>
<c:remove var="city2" scope="session"/>
${city1 }<br>
${city2 }
<% 
	NewsUsers user=new NewsUsers();
	user.setUname("admin");
	session.setAttribute("user", user);
	
	session.setAttribute("username","张三");
%>
<c:if test="${user.uname=='admin' }">
	我是管理员
</c:if><br>
<c:choose>
	<c:when test="${not empty username }">
		你好${username }
	</c:when>
	<c:otherwise>
		没有登录，请先登录
	</c:otherwise>
</c:choose>

<c:forEach items="" var="" begin="" end="" step="2">
	<%--- 循环体代码 --%>
</c:forEach>
</body>
</html>