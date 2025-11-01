package com.oracel.service;

import java.util.List;

import com.oracel.entity.Emp;
import com.oracel.entity.PageInfo;

public interface EmpService {

	/**
	 * 查询emp表所有值
	 * @return
	 */
	public List<Emp> quertAll();
	/**
	 * 根据条件搜索emp表
	 * @param emp
	 * @return
	 */
	public PageInfo<Emp> empsearch(PageInfo<Emp> pageinfo,Emp emp);
/**
 * 排除重复的职位
 * @return
 */
	public List<String> disJob();
	
	/**
	 * 分页查询
	 */
	public PageInfo<Emp> getPage(PageInfo<Emp> pageinfo);
}





