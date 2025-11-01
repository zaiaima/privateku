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
	<%
		String errMsgOldupwd = (String) session.getAttribute("errMsgOldupwd");
		String errMsgUpwd = (String) session.getAttribute("errMsgUpwd");
		NewsUsers users = (NewsUsers) session.getAttribute("users");
	%>
	<form action="dochange.pwd" method="post">
		<table>
		<tr>
			<td>用户名:<td/>
			<td> <%=users.getUname() %><td/>
		<tr/>
		
		<tr>
			<td>请输入原来的密码:<td/>
			<td><input type="password" name="Oldupwd" />
			<c:if test="${errMsgOldupwd != null}">
				<span style="color: red"><%=errMsgOldupwd%></span>
				<c:remove var="errMsgOldupwd" scope="session"/>
			</c:if>
			<td/>
		<tr/>
		<tr>
			<td>请输入新密码:<td/>
			<td><input type="password" name="upwd" /><td/>
		<tr/>
		<tr>
			<td>确认新密码:<td/>
			<td><input type="password" name="reupwd" />
			<c:if test="${errMsgUpwd != null}">
				<span style="color: red"><%=errMsgUpwd%></span>
				<c:remove var="errMsgUpwd " scope="session"/>
			</c:if>
			<td/>
		<tr/>
		<tr>
			<td>&nbsp;<td/>
			<td><input type="submit" value="立即修改"><td/>
		<tr/>
		
		</table>
		
	</form>
	<%--
		<%
		String errMsgOldupwd = (String) session.getAttribute("errMsgOldupwd");
		String errMsgUpwd = (String) session.getAttribute("errMsgUpwd");
		NewsUsers users = (NewsUsers) session.getAttribute("users");
	%>
	<form action="doChange.jsp" method="post">
		<table>
		<tr>
			<td>用户名:<td/>
			<td><%=users.getUname()%><td/>
		<tr/>
		
		<tr>
			<td>请输入原来的密码:<td/>
			<td><input type="password" name="Oldupwd" />
			<td/>
		<tr/>
		<tr>
			<td>请输入新密码:<td/>
			<td><input type="password" name="upwd" />
			<% if (errMsgOldupwd != null) { %>
				<span style="color: red"><%=errMsgOldupwd%></span>
		<%
			session.removeAttribute("errMsgOldupwd");
			}
		%>			
		<td/>
		<tr/>
		<tr>
			<td>确认新密码:<td/>
			<td><input type="password" name="reupwd" />
			<% if (errMsgUpwd != null) { %>
			<span style="color: red"><%=errMsgUpwd%></span>
		<%
			session.removeAttribute("errMsgUpwd");
			}
		%>
			<td/>
		<tr/>
		<tr>
			<td>&nbsp;<td/>
			<td><input type="submit" value="立即修改"><td/>
		<tr/>
		</table>
	</form>
	 --%>
</body>
</html>