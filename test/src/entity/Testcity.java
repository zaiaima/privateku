package entity;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orcal.Util.MybatisUtil;
import com.orcal.dao.CityMapper;

public class Testcity {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testselectAll() {
		try (SqlSession session =MybatisUtil.getsession()) {
			CityMapper empMapper=session.getMapper(CityMapper.class);
			PageHelper.startPage(2, 10);
			List<City> list=empMapper.selectAll();
//			list.get(0).getDept();
			Page<City> page=(Page<City>) list;
//			System.out.println(empMapper.selectAll());
			System.out.println("=="+page.getTotal());
		}
	}

}
