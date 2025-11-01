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
	int sum = 0;   // 和
	for(int i=1;i<=100;i++){
		boolean b = true; 
		for(int j=2;j<i;j++){  // 2...,i-1
			if(i%j==0){   // 不是素数
				b = false;  // 不是素数
				break;
			}
		}
		if(b){
			sum += i;
		}
	}
%>
和等于<%=sum-1 %>
</body>
</html>