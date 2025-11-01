package com.oracel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oracel.dao.DeptDao;
import com.oracel.entity.Dept;
import com.oracel.entity.Emp;
import com.oracel.util.ConnUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public Dept queryByNo(int deptno) throws Exception {
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from dept where deptno = ?");
		ps.setInt(1,deptno);
		ResultSet rs = ps.executeQuery();
		Dept dept = null;
		while (rs.next()) {
			dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
		}
		return dept;
	}

}
