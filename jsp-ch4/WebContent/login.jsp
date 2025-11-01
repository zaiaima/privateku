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
	String errMsg=(String)session.getAttribute("errMsg");
%>
<form action="dologin" method="post">
		<tr>
			<td>用户名: <td/>
			<td>
			<input type="text" name="uname" />
			<%if(errMsg!=null){ %>
			<span style="color:red"><%=errMsg%><span/>
			<%session.removeAttribute("errMsg");} %>
			<td/>
		<tr/><br>
		<tr>
			<td>密码: <td/>
			<td><input type="text" name="upwd" /><td/>
		<tr/><br>
		<tr>
			<td>&nbsp;<td/>
			<td><input type="submit" value="登录" /><td/>
		<tr/>
	</form>
</body>
</html>