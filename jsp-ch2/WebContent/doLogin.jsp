<%@page import="entity.NewsUsers"%>
<%@page import="dao.NewsUsersDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
  // 1.设置请求字符集
  request.setCharacterEncoding("utf-8");
  // 2.获得表单书据
  String uname=request.getParameter("uname");  
  String upwd=request.getParameter("upwd");  
  // 3. 跳转页面
  NewsUsersDao dao=new NewsUsersDao();
  NewsUsers users=dao.login(uname, upwd);
  
  if(users!=null){
	  session.setAttribute("users", users);
      response.sendRedirect("index.jsp");
  }else{
      session.setAttribute("errMsg", "用户名或密码错误");
      response.sendRedirect("login.jsp");
  }
%>
