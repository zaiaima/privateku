package com.orcal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import entity.Dept;
import entity.Emp;

public interface EmpMapper {
	
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from emp where empno = #{empno}")
	@Results(id = "empMap", value = {
			@Result(property = "dept", column = "deptno", javaType = Dept.class, one = @One(select = "com.orcal.dao.DeptMapper.selectById"))
			})
	public Emp selectById(int empno);
	
	@Select("select * from emp where ename = #{ename}")
	public Emp selectByname(String ename);

	/**
	 * 查询表的全部内容
	 * 
	 * @return
	 */
	@Select("select * from emp")
	@ResultMap("empMap")
	public List<Emp> selectAll();
	
	@SelectProvider(type=EmpSqlBuilder.class,method="buildEmpSearch")
	public List<Emp> search(Emp emp);

	/**
	 * 根据id删除表中记录
	 * 
	 * @param id
	 * @return 
	 */
	@Delete("delete from emp where empno = #{id}")
	public int delete(int empno);

	/**
	 * 增加
	 * 
	 * @param emp
	 * @return
	 */
	@Insert("insert into emp values(#{empno},#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{dept.deptno})")
	public int add(Emp emp);

	/**
	 * 更新
	 * 
	 * @param emp
	 * @return
	 */
	@Update("update emp set ename=#{ename},job=#{job},mgr=#{mgr},hiredate=#{hiredate},sal=#{sal},comm=#{comm} where empno=#{empno}")
	public int update(Emp emp);
	
	class EmpSqlBuilder{
		public static String buildEmpSearch(final Emp emp) {
			return new SQL(){
				{
					SELECT("*");
					FROM("emp");
					if (emp.getEname() != null) {
						WHERE("ename like concat('%',#{ename},'%')");
					}
					if (emp.getSal() > 0) {
						WHERE("sal >= #{sal}");
					}
					if (emp.getDept().getDeptno() > 0) {
						WHERE("deptno >= #{dept.deptno}");
					}
					ORDER_BY("sal");
				}
			}.toString();
		}
	
}
}