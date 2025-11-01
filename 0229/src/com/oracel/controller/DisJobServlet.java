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
import com.oracel.service.EmpService;
import com.oracel.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class DisJobServlet
 */
@WebServlet("/DisJobServlet")
public class DisJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisJobServlet() {
        super();
    }
    EmpService empService = new EmpServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		获取数据
		List<String> list = empService.disJob();
		//序列
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		
		out.print(result);
		out.close();
	}

}
