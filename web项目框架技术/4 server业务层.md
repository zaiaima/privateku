# 4 server业务层

## 【Service业务层】

​     主要处理：异常、事务的处理、日志、相关的业务逻辑。

![1](G:\大二下\typora笔记\Photo\1.png)

## EmpService业务接口类

```java
package com.orcal.services;

import java.util.List;

import com.orcal.entity.Emp;

public interface EmpService {

	public List<Emp> getAll();

```

## EmpServiceImpl接口实现类

```java
package com.orcal.service.impl;

import java.util.List;

import com.orcal.dao.EmpDao;
import com.orcal.dao.impl.EmpDaoImpl;
import com.orcal.entity.Emp;
import com.orcal.services.EmpService;

public class EmpServiceImpl implements EmpService{

	EmpDao empdao=new EmpDaoImpl();
	@Override
	public List<Emp> getAll() {
		List<Emp> list=null;
		try {
			list=empdao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

```

## EmpTest测试类

```java
package com.orcal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.orcal.dao.EmpDao;
import com.orcal.dao.impl.EmpDaoImpl;
import com.orcal.service.impl.EmpServiceImpl;
import com.orcal.services.EmpService;

public class EmpTest {

	@Test
	public void test() throws Exception {
		EmpService empservice =new EmpServiceImpl();
		System.out.println(empservice.getAll());
	}

}

```

## EmpServlet类

> // 使用pageContext将属性设置在request范围中
> 	pageContext.getAttribute("");
> //		请求转发
> 		request.getRequestDispatcher("/Emp.jsp").forward(request, response);
> //		重定向
> 		response.sendRedirect("");

### servlet作用：

处理请求，相应数据

```java
package com.orcal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orcal.entity.Emp;
import com.orcal.service.impl.EmpServiceImpl;
import com.orcal.services.EmpService;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		EmpService empservice=new EmpServiceImpl();
		request.setAttribute("emplist",empservice.getAll());
//		请求转发
		request.getRequestDispatcher("/Emp.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

```

### **四大作用域总结：**

**pageContext,request,session,application**

**对应的类：PageContext,HttpServletRequest,HttpSession,ServletContext**

**如果一个数据只在当前jsp页面使用，可以使用pageContext域存储**

**如果一个数据，除了在当前Servlet中使用，还要再请求转发时i带到其他Servlet处理或jsp中显示，这时使用request域**

**如果一个数据，除了现在我自己要用，过一会我自己还要用，存在session域**

**如果一个数据，除了现在我自己要用过一会其他人也要用，存在ServletContext域中**

## Emp.jsp页面



```jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	${emplist }	
</body>
</html>
```

