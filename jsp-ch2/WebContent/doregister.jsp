<%@page import="entity.NewsUsers"%>
<%@page import="dao.NewsUsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//1.设置请求字符集
	request.setCharacterEncoding("utf-8");
	// 2.获得表单书据
	String uname = request.getParameter("uname");
	String upwd = request.getParameter("upwd");
	String reupwd = request.getParameter("reupwd");
	NewsUsersDao dao = new NewsUsersDao();
	
	boolean b=dao.isUnameExist(uname);
	
	if(b){
		session.setAttribute("errMsgUname","用户名存在请从新输入");
		response.sendRedirect("register.jsp");
		return;
	}
	
	if (!upwd.equals(reupwd)) {
		session.setAttribute("errMsgUpwd", "两次密码不一致");
		response.sendRedirect("register.jsp");
		return;
	}%>
	<%// 3. 注册完成,跳转页面
	
	dao.register(uname, upwd);
	response.sendRedirect("login.jsp");
	
	
%>