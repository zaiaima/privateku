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
//1.设置请求字符集
    request.setCharacterEncoding("utf-8");
//2.表单数据
    String userName=request.getParameter("userName");
    String pwd=request.getParameter("pwd");
    
    if("sa".equals(userName) && "sa".equals(pwd)){
    	session.setAttribute("userName",userName);
        response.sendRedirect("welcome.jsp");
    }else{
        response.sendRedirect("denglu.jsp");
    }
%>
</body>
</html>