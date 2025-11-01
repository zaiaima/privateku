package com.oracel.dao;

import java.util.List;

import com.oracel.entity.Emp;
import com.oracel.entity.PageInfo;

public interface EmpDao {
	public List<Emp> quertAll() throws Exception;
	
	/**
	 * 排除相同的职位
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Emp> queryByCondition(PageInfo<Emp> pageInfo, Emp emp) throws Exception;
	/**
	 * 分页的方法
	 * @param <T>
	 * @throws Exception 
	 */
	public PageInfo<Emp> getPage(PageInfo<Emp> pageinfo) throws Exception;

	public List<String> disJobs() throws Exception;
}
