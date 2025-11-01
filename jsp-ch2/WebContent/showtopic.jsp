<%@page import="entity.Topic"%>
<%@page import="dao.TopicDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/bootstrap.css">
</head>
<body>
	<%
		TopicDao dao = new TopicDao();
		List<Topic> topics = dao.selectAll();
		//页面范围内
		pageContext.setAttribute("topics", topics);
	%>
	<input type="text" name="搜索">
	<a href="doaddtopic" class="btn btn-primary">新增</a>
	<a href="doaddtopic" class="btn btn-warning" onclick="return confirm('是否退出')">退出</a>
	<table class="table table-striped table-boredered table-hover">
		<tr>
			<td>主题编号</td>
			<td>主题名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${topics}" var="topic">
			<tr>
				<td>${topic.tid}</td>
				<td>${topic.tname}</td>
				<td><a href="dodeletetopic?tid=${topic.tid}" onclick="return confirm('确认是否删除当前行')" class="btn btn-danger">删除</a>
				<a href="doupdatetopic?tid=${topic.tid}" class="btn btn-default">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>