package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shop.entity.Categories;

public interface CategoriesMapper {

	@Select("select * from categories")
	public List<Categories> selectAll();
	
	@Select("select * from categories where id = #{id}")
	public List<Categories> selectone(int id);	
}
