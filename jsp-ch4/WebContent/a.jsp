<%@page import="ch4.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("uname", "18");

	User user=new User();
	user.setName("李久洋");
	user.setAge(18);
	user.setVip(true);
	
	session.setAttribute("u", user);
	
%>
<%=session.getAttribute("uname")%>
<br>
${name}
<br>
${u.name }&nbsp;&nbsp;${u.age }&nbsp;&nbsp;${u.vip }
</body>
</html>