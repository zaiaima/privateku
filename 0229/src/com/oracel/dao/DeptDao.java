package com.oracel.dao;

import com.oracel.entity.Dept;

public interface DeptDao {
	
	public Dept queryByNo(int deptno) throws Exception;

}
