package com.oracel.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.oracel.util.ConnUtil;

public class stutest {

	public static void main(String[] args) throws Exception {
		System.out.println("****************welcome**********************");

		boolean iscon = true;
		while (iscon) {
			System.out.println("输入功能:");
			System.out.println("1、添加学生");
			System.out.println("2、按照id删除学生");
			System.out.println("3、显示学生");
			System.out.println("4、退出系统");
			Scanner scan = new Scanner(System.in);
			int i = scan.nextInt();
			switch (i) {
			case 1:
				System.out.println("请输入学生name");
				String name = scan.next();

				System.out.println("请输入学生sex");
				String sex = scan.next();

				System.out.println("请输入学生age");
				int age = scan.nextInt();
				add(name, sex, age);
				break;
			case 2:
				System.out.println("删除的id:");
				int id = scan.nextInt();
				delete(id);
				break;
			case 3:
				System.out.println("******学生信息列表******");
				selectAll();
				break;
			case 4:
				iscon = false;
				System.out.println("退出成功！");
				break;
			default:
				break;
			}
		}
	}

	// 新增方法，根据id,name,sex,age新增学生信息
	private static void add(String name, String sex, int age) throws Exception {
		// 链接数据库
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO student (name,sex,age) VALUES (?, ?, ?)");
		// 封装 将获得的新增信息放入ps里
		ps.setString(1, name);
		ps.setString(2, sex);
		ps.setInt(3, age);
		// 增加方法用update
		int i = ps.executeUpdate();
		// 释放资源
	}

	// 根据id删除学生信息方法，删除
	private static void delete(int id) throws Exception {
		// 链接数据库
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("delete from student where id =?");
		// 把要输入的条件放进去
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		// 释放资源
		System.out.println("删除完成!");
	}

	// 查询全部学生信息，查询方法
	private static void selectAll() throws Exception {
		// 链接数据库
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("id:" + rs.getInt("id") + "名字:" + rs.getString("name") + "性别:" + rs.getString("sex")
					+ "年龄:" + rs.getInt("age"));
		}
		System.out.println("查询完成!!!");
	}
}
