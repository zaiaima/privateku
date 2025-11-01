package com.oracel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpServlet() {
        super();
    }
    EmpService empService = new EmpServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setAttribute("empList", empService.quertAll());
		
		//接收参数，当前页
		String pageStr = request.getParameter("page");
		PageInfo<Emp> pageInfo = new PageInfo<>();
		if (pageStr != null && !"".equals(pageStr)) {
			pageInfo.setCrtPage(Integer.parseInt(pageStr));
		}
		pageInfo.setPageCnt(4);
		request.setAttribute("pageinfo", empService.getPage(pageInfo));
		
		//请求转发
		request.getRequestDispatcher("/List.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Emp> list = empService.quertAll();
		//序列
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		
		out.print(result);
		out.close();
	}

}













