package com.oracel.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.oracel.dao.DeptDao;
import com.oracel.dao.EmpDao;
import com.oracel.dao.impl.DeptDaoImpl;
import com.oracel.dao.impl.EmpDaoImpl;
import com.oracel.entity.Dept;
import com.oracel.entity.Emp;
import com.oracel.entity.PageInfo;
import com.oracel.service.EmpService;

public class EmpServiceImpl implements EmpService {

	EmpDao empDao = new EmpDaoImpl();
	DeptDao deptDao = new DeptDaoImpl();

	@Override
	public List<Emp> quertAll() {
		List<Emp> empList = null;
		try {
			empList = empDao.quertAll();
			Dept dept = null;
			for (Emp e : empList) {
				dept = deptDao.queryByNo(e.getDept().getDeptno());
				e.setDept(dept == null ? new Dept() : dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public PageInfo<Emp> empsearch(PageInfo<Emp> pageInfo,Emp emp) {
		try {
			pageInfo = empDao.queryByCondition(pageInfo, emp);
			Dept dept = null;
			for (Emp e : pageInfo.getPageData()) {
				dept = deptDao.queryByNo(e.getDept().getDeptno());
				e.setDept(dept == null ? new Dept() : dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	@Override
	public List<String> disJob() {
		List<String> disjob = null;
		try {
			disjob = empDao.disJobs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return disjob;
	}

	@Override
	public PageInfo<Emp> getPage(PageInfo<Emp> pageinfo) {
		try {
			pageinfo = empDao.getPage(pageinfo);
			Dept dept = null;
			for(Emp e : pageinfo.getPageData()){
				dept = deptDao.queryByNo(e.getDept().getDeptno());
				e.setDept(dept == null ? new Dept() : dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return pageinfo;
	}

	

}
