package com.orcal.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.orcal.Util.MybatisUtil;
import com.orcal.dao.DeptMapper;

import entity.Dept;

public class DeptTest {

	@Test
	public void testSelectOne() {
		try (SqlSession session = MybatisUtil.getsession()) {
			DeptMapper deptMapper=session.getMapper(DeptMapper.class);
			System.out.println(deptMapper.selectById(20));
		}
	}
	
	@Test
	public void testselectAll() {
		try (SqlSession session = MybatisUtil.getsession()) {
			DeptMapper deptMapper=session.getMapper(DeptMapper.class);
			System.out.println(deptMapper.selectAll());
		}
	}
	@Test
	public void testadd() {
		try (SqlSession session = MybatisUtil.getsession()) {
			DeptMapper deptMapper=session.getMapper(DeptMapper.class);
			Dept d=deptMapper.selectById(10);
			d.setDeptno(7);
			d.setDname("¾ÅÑô");
			d.setLoc("niuyue");
			System.out.println(deptMapper.add(d));
			session.commit();
		}
	}
	@Test
	public void testupdate() {
		try (SqlSession session = MybatisUtil.getsession()) {
			DeptMapper deptMapper=session.getMapper(DeptMapper.class);
			Dept d=deptMapper.selectById(8);
			d.setDeptno(8);
			d.setDname("¾ÅÑô½´");
			d.setLoc("ŒÅË¿");
			System.out.println(deptMapper.update(d));
			session.commit();
		}
		testselectAll();
	}
}
