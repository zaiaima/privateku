package com.orcal.test;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.orcal.Util.MybatisUtil;
import com.orcal.dao.BonusMapper;

import entity.Bonus;

public class BonusTest {

	@Test
	public void selectByname() {
		try (SqlSession session = MybatisUtil.getsession()) {
			BonusMapper Mapper=session.getMapper(BonusMapper.class);
			Bonus b=Mapper.selectByname("king");
			b.getBonemp();
		}
	}
	@Test
	public void selectAll() {
		try (SqlSession session = MybatisUtil.getsession()) {
			BonusMapper Mapper=session.getMapper(BonusMapper.class);
			List<Bonus> b=Mapper.selectAll();
			b.get(0).getBonemp();
		}
	}
}
