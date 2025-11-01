<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<style type="text/css">
	#container{
		width:800px;
		margin: 0px auto;
	}
	
	#container h2{
		text-align: center;
	}
	
	#container table{ 
		width: 800px
	}

</style>

</head>
<body>

	<div id="container">
		<h2>员工列表</h2>
	
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>职位</th>
				<th>薪资</th>
				<th>部门</th>
			</tr>
			
			<c:forEach items="${pageinfo.pageData }" var="emp">				
				<tr>
					<td>${emp.empNo }</td>
					<td>${emp.eName }</td>
					<td>${emp.job }</td>
					<td>${emp.sal }</td>
					<td>${emp.deptNo }</td>
				</tr>
			</c:forEach>
			
		</table>	
		<div>
			<c:forEach begin="1" end="${pageinfo.totalPage }" var="i">
				<a href="EmpServlet?page=${i }">${i }</a>
			</c:forEach>
		</div>
	
	</div>

</body>
</html>