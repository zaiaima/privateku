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
	String errMsgUpwd=(String)session.getAttribute("errMsgUpwd");
	String errMsgUname=(String)session.getAttribute("errMsgUname");	
%>

<form action="doregister" method="post"> 
		用户名: <input type="text" name="uname" /><br>
<%--	<%if(errMsgUname != null){ %>
		<span style="color:red"><%= errMsgUname %></span>
		<%
		session.removeAttribute("errMsgUname");
		} %><br>  --%>
		<c:if test="${errMsgUname != null }">
			<span style="color: red"> ${errMsgUname} </span>
			<c:remove var="errMsgUname" scope="session"/>
		</c:if>	
		密码: <input type="text" name="upwd" /><br>
		确认密码: <input type="text" name="reupwd" /><br>
		
		<%--
		<%if (errMsgUpwd != null) {%>
		<span style="color: red"> <%=errMsgUpwd%></span>
		<%
			session.removeAttribute("errMsgUpwd");
			}%><br>
		 --%>	
			
		<c:if test="${errMsgUpwd != null }">
			<span style="color: red"> ${errMsgUpwd} </span>
			<c:remove var="errMsgUpwd" scope="session"/>
		</c:if>	
		<input type="submit" value="注册" />
	</form>
	<%--注释掉源代码
	<form action="doregister.jsp" method="post"> 
		用户名: <input type="text" name="uname" /><br>
		<%if(errMsgUname != null){ %>
		<span style="color:red"><%= errMsgUname %></span>
		<%
		session.removeAttribute("errMsgUname");
		} %><br> 
		密码: <input type="text" name="upwd" /><br>
		确认密码: <input type="text" name="reupwd" /><br>
		
		<%if (errMsgUpwd != null) {%>
		<span style="color: red"> <%=errMsgUpwd%></span>
		<%
			session.removeAttribute("errMsgUpwd");
			}%><br>
		<input type="submit" value="注册" />
	</form>
	 --%>
</body>
</html>