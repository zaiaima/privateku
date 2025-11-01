package com.oracel.test;


import org.junit.Test;

import com.oracel.dao.EmpDao;
import com.oracel.dao.impl.EmpDaoImpl;
import com.oracel.entity.Emp;
import com.oracel.entity.PageInfo;
import com.oracel.service.EmpService;
import com.oracel.service.impl.EmpServiceImpl;

public class EmpTest {

	@Test
	public void testQueryALL() throws Exception {
		EmpService empService = new EmpServiceImpl();
		EmpDao empDao = new EmpDaoImpl();									
//		System.out.println(empService.AddAll(9527, "String", "¥Ú”°", 1800));
	}
	@Test
	public void testSearch() throws Exception {
		EmpDao empDao = new EmpDaoImpl();
		PageInfo<Emp> pageInfo = new PageInfo<>();
		pageInfo.setPageCnt(4);
		pageInfo.setCrtPage(1);
		Emp e=new Emp();
		e.setEname("ll");

//		e.setJob("pr");
		System.out.println(empDao.queryByCondition(pageInfo, e));
		System.out.println(pageInfo.getTotalCnt());
		System.out.println(pageInfo.getTotalPage());
		System.out.println(pageInfo.getPageData());
	}
	@Test
	public void testGetPage() throws Exception {
		EmpDao empDao = new EmpDaoImpl();
		PageInfo<Emp> pageInfo=new PageInfo<>();
		pageInfo.setPageCnt(4);
		pageInfo.setCrtPage(2);
		
		pageInfo = empDao.getPage(pageInfo);
		System.out.println(pageInfo.getPageData());
		System.out.println(pageInfo.getTotalCnt());
	}

}
















