package com.orcal.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orcal.Util.MybatisUtil;
import com.orcal.dao.EmpMapper;

import entity.Dept;
import entity.Emp;

public class EmpTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSelectOne() {
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper=session.getMapper(EmpMapper.class);
			Emp e=empMapper.selectById(7369);
			e.getDept();
		}
	}
	
	@Test
	public void testselectAll() {
		try (SqlSession session =MybatisUtil.getsession()) {
			EmpMapper empMapper=session.getMapper(EmpMapper.class);
			PageHelper.startPage(2, 10);
			List<Emp> list=empMapper.selectAll();
//			list.get(0).getDept();
			Page<Emp> page=(Page<Emp>) list;
//			System.out.println(empMapper.selectAll());
			System.out.println("=="+page.getTotal());
		}
	}
	
	@Test
	public void search() {
		try (SqlSession session =MybatisUtil.getsession()) {
			EmpMapper empMapper=session.getMapper(EmpMapper.class);
			Emp e=new Emp();
			e.setDept(new Dept(20));
			e.setEname("t");
			e.setSal(2000);
			empMapper.search(e);
		}
	}
	
	@Test
	public void testdelete() {
		try (SqlSession session =MybatisUtil.getsession()) {
			EmpMapper empMapper=session.getMapper(EmpMapper.class);
			System.out.println(empMapper.delete(7379));
			session.commit();
		}
	}
	@Test
	public void testadd() {
		try (SqlSession session = MybatisUtil.getsession()) {
			 EmpMapper empMapper=session.getMapper(EmpMapper.class);
             Emp e=empMapper.selectById(7839);
             e.setEmpno(10);
             e.setEname("Ð¡ÇÇ");
             e.setJob("·¨Ê¦");
             empMapper.add(e);             
             session.commit();
		}
	}
	@Test
	public void testupdate() {
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper=session.getMapper(EmpMapper.class);
			Emp e=empMapper.selectById(7521);
			e.setEname("À²À²À²");
			e.setJob("ÂÔÂÔÂÔ");
			e.setSal(10000);
			e.setComm(30000);
			e.setDept(new Dept(20));
			empMapper.update(e);
			session.commit();
		}
		testselectAll();
	}
	
}
