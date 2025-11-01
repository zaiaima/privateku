package com.oracel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracel.dao.EmpDao;
import com.oracel.dao.impl.EmpDaoImpl;
import com.oracel.entity.Emp;
import com.oracel.service.EmpService;

/**
 * Servlet implementation class FenyeServlet
 */
@WebServlet("/FenyeServlet")
public class FenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FenyeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入第几页:");
		int n=scan.nextInt();
		System.out.println("请输入几条:");
		int c=scan.nextInt();
		
		//序列
		ObjectMapper mapper = new ObjectMapper();
		/*String result = mapper.writeValueAsString(list);*/
		/*
		out.print(result);*/
		out.close();
	}

}
