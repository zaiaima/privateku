<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	// 返回true，表示闰年
	boolean findYear(int year){
		if( year%4==0 && year%100!=0 || year%400==0 ){
			return true;
		}
		return false;
	}
%>

<%
	int count = 0;
	for(int i=2000;i<=2013;i++){
		if( findYear(i) ){
			count++;
		}
	}
	
	
%>
闰年的个数:<%=count %>
</body>
</html>