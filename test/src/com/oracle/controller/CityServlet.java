package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orcal.Util.MybatisUtil;
import com.orcal.dao.CityMapper;

import entity.City;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		初始化数据
		PageInfo<City> pageInfo = new PageInfo<>();
		PrintWriter out = response.getWriter();
		
//		获得请求数据
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null && !"".equals(pageNum)) {
			pageInfo.setPageNum(Integer.parseInt(pageNum));
		}
		
		try (SqlSession sqlSession = MybatisUtil.getsession()) {
			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			try {
				pageInfo = PageHelper.startPage(pageInfo.getPageNum(), 10).doSelectPageInfo(() -> cityMapper.selectAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		转为json格式String(序列化)
		ObjectMapper mapper = new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		String result = mapper.writeValueAsString(pageInfo);
//		返回结果并释放资源
		System.out.println(result);
		out.write(result);
		out.close();

	}

}