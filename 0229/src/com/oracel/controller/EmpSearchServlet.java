package com.oracel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracel.entity.Emp;
import com.oracel.entity.PageInfo;
import com.oracel.service.EmpService;
import com.oracel.service.impl.EmpServiceImpl;

@WebServlet("/EmpSearchServlet")
public class EmpSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSearchServlet() {
        super();
    }
    EmpService empService = new EmpServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		PageInfo<Emp> pageInfo = new PageInfo<>();
		
//		获取参数
		String name=request.getParameter("name");
		String job=request.getParameter("job");
		//当前页
		String pageStr = request.getParameter("page");
		if (pageStr != null && !"".equals(pageStr)) {
			pageInfo.setCrtPage(Integer.parseInt(pageStr));
		}
		Emp param=new Emp();
		param.setEname(name);
		param.setJob(job);
//		获取数据
		 pageInfo = empService.empsearch(pageInfo,param);
		//序列化
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(pageInfo);
		
		out.print(result);
		out.close();
	}

}
