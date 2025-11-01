package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Topic;

public class TopicDao extends BaseDao{

	public void add(String tname) throws Exception{
		String sql="insert into topic(tname) values (?)";
		Object[] params={tname};
		this.executeUpdate(sql, params);
	}
	public void delete(int tid) throws Exception{
		String sql="delete from topic where tid=?";
		Object[] params={tid};
		this.executeUpdate(sql, params);
	}
	public void update(String tname,int tid) throws Exception{
		String sql="update topic set tname = ? where tid = ?";
		Object[] params={tname,tid};
		this.executeUpdate(sql, params);
	}
	public List<Topic> selectAll() throws Exception{
		String sql="select * from topic";
		Object[] params={};
		ResultSet rs=this.executeQuery(sql, params);
		
		List<Topic> topics=new ArrayList<Topic>();
		while (rs.next()) {
			Topic topic=new Topic();
			topic.setTid(rs.getInt("tid"));
			topic.setTname(rs.getString("tname"));
			topics.add(topic);
		}
		return topics;
	}
}
