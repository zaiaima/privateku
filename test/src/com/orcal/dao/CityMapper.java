package com.orcal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.PageInfo;

import entity.City;

public interface CityMapper {
	
	/**
	 * 查询表的全部内容
	 * 
	 * @return
	 */
	@Select("select * from city")
	public List<City> selectAll();
	

	
}