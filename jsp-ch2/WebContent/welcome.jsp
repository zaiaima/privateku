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
	String userName = (String)session.getAttribute("userName");
	if(userName==null){  // 没有登录
		session.setAttribute("errMsg", "没有登录是不能访问欢迎页");
		response.sendRedirect("login.jsp");
		return;   // 方法结束
	}
%>
欢迎<%=userName %>光临！！！！
</body>
</html>