package com.shop.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.shop.dao.CategoriesMapper;
import com.shop.entity.Categories;
import com.shop.util.MybatisUtil;

public class CategoriesTest {


	@Test
	public void testselectAll() {
		try (SqlSession session =MybatisUtil.getsession()) {
			CategoriesMapper cateMapper=session.getMapper(CategoriesMapper.class);
			System.out.println(cateMapper.selectAll());
			
			
		}
	}
	@Test
	public void testselectOne() {
		try (SqlSession session =MybatisUtil.getsession()) {
			CategoriesMapper cateMapper=session.getMapper(CategoriesMapper.class);
			Categories c=
			System.out.println(cateMapper.selectone(2));
			
			
		}
	}
	
}
