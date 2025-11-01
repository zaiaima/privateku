package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.NewsUsers;

public class NewsUsersDao extends BaseDao{

	/**
	 * 登录
	 * @param uname 用户名
	 * @param upwd 用户密码
	 * @return 登录用户
	 * @throws Exception 
	 */
	public NewsUsers login(String uname,String upwd) throws Exception{
		NewsUsers users=null; //给newsusers定义为users
		String sql="select * from news_users where uname=? and upwd=?"; //数据库查询
		Object[] params={uname,upwd}; //创建数组
		ResultSet rs=this.executeQuery(sql, params);//result结果集
		if (rs.next()) { //遍历结果集
			users=new NewsUsers();
			users.setUid(rs.getInt("uid"));
			users.setUname(rs.getString("uname"));
			users.setUpwd(rs.getString("upwd"));
		}
		return users;
	}
	
	/**
	 * 判断用户是否存在
	 * @param uname
	 * @return 返回true表示用户存在，否则表示用户不存在
	 * @throws Exception
	 */
	public boolean isUnameExist(String uname) throws Exception{
		String sql="SELECT * FROM news_users where uname = ?";
		Object[] params={uname};
		ResultSet rs=this.executeQuery(sql, params); //rs记录集
		if (rs.next()) {
			return true; //当前用户存在
		}
		return false; //当前用户不存在
	}
	
	/**
	 * 注册
	 * @param uname 用户名
	 * @param upwd 用户密码
	 * @throws Exception 
	 */
	public void register(String uname,String upwd) throws Exception{
		String sql="insert into news_users(uname,upwd) values(?,?)";
		Object[] params={uname,upwd};
		this.executeUpdate(sql, params);
	}
	
	/**
	 * 密码修改
	 * @param uname 用户名
	 * @param upwd 用户密码
	 * @throws Exception 
	 */
	public void changePwd(String uname,String upwd) throws Exception{
		String sql="update news_users set upwd=? where uname=?";
		Object[] params={upwd,uname};
		this.executeUpdate(sql,params);
	}
	
	/**
	 * 查重
	 * @param uname
	 * @param upwd
	 * @throws Exception
	 */
	public void select(String uname,String upwd) throws Exception{
		String sql="select * fron news_users where uname=1";
		Object[] params={uname,upwd};
		this.executeQuery(sql, params);
	}
}
