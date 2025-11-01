<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 1.请求的字符集
	request.setCharacterEncoding("utf-8");

	// 2.获得表单的数据
	String userName = request.getParameter("userName");
	String userPwd = request.getParameter("userPwd");
	
	if("sa".equals(userName) && "sa".equals(userPwd)){
		session.setAttribute("userName", userName);
		response.sendRedirect("welcome.jsp");
	}
	else{
		// error 错误     message 信息
		session.setAttribute("errMsg", "用户名或者密码错误");
		response.sendRedirect("login.jsp");
	}
	
%>