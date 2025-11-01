package com.oracel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oracel.dao.EmpDao;
import com.oracel.entity.Dept;
import com.oracel.entity.Emp;
import com.oracel.entity.PageInfo;
import com.oracel.util.ConnUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> quertAll() throws Exception {
		List<Emp> emplist = new ArrayList<Emp>();
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from emp");
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		while (rs.next()) {
			emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
					rs.getDate("hiredate"), rs.getInt("sal"), rs.getInt("comm"), new Dept(rs.getInt("deptno")));
			emplist.add(emp);
		}
		return emplist;
	}

	@Override
	public PageInfo<Emp> queryByCondition(PageInfo<Emp> pageInfo, Emp param) throws Exception {
		List<Emp> emplist = new ArrayList<Emp>();
		Connection conn = ConnUtil.getConn();
		
		String sql = "select SQL_CALC_FOUND_ROWS * from emp where 1=1 ";
		if (param.getEname() != null && !"".equals(param.getEname())) {
			sql += "and ename like ? ";
		}

		if (param.getJob() != null && !"".equals(param.getJob())) {
			sql += "and job=? ";
		}
		PreparedStatement ps = conn.prepareStatement(sql + " limit ?,?");
		
		int i = 1;
		if (param.getEname() != null && !"".equals(param.getEname())) {
			ps.setString(i++, "%" + param.getEname() + "%");
		}

		if (param.getJob() != null && !"".equals(param.getJob())) {
			ps.setString(i++, param.getJob());
		}
		ps.setInt(i++, (pageInfo.getCrtPage() - 1) * pageInfo.getPageCnt());
		ps.setInt(i,pageInfo.getPageCnt() );
		
		ResultSet rs = ps.executeQuery();
		Emp e;
		while (rs.next()) {
			e = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
					rs.getDate("hiredate"), rs.getInt("sal"), rs.getInt("comm"), new Dept(rs.getInt("deptno")));
			emplist.add(e);
		}
		ConnUtil.close(ps,rs);
		pageInfo.setPageData(emplist);
		//获取总记录数
		ps = conn.prepareStatement("select FOUND_ROWS()");
		rs = ps.executeQuery();
		if (rs.next()) {
			pageInfo.setTotalCnt(rs.getInt(1));
		}
		ConnUtil.close(ps,rs);
		return pageInfo;
	}

	@Override
	public List<String> disJobs() throws Exception {
		List<String> disjobs = new ArrayList<>();
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select distinct job from emp");
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		while (rs.next()) {
			disjobs.add(rs.getString("job"));
		}
		return disjobs;
	}

	@Override
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo) throws Exception {
		List<Emp> emplist = new ArrayList<>();

		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select SQL_CALC_FOUND_ROWS * from emp limit ?,?");
		ps.setInt(1, (pageInfo.getCrtPage() - 1) * pageInfo.getPageCnt());
		ps.setInt(2,pageInfo.getPageCnt() );
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		while (rs.next()) {
			emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
					rs.getDate("hiredate"), rs.getInt("sal"), rs.getInt("comm"), new Dept(rs.getInt("deptno")));
			emplist.add(emp);
		}
		pageInfo.setPageData(emplist);
		
		ps = conn.prepareStatement("select FOUND_ROWS()");
		rs = ps.executeQuery();
		if (rs.next()) {
			pageInfo.setTotalCnt(rs.getInt(1));
		}
		ConnUtil.close(ps,rs);
		return pageInfo;
	}

	

	

}
