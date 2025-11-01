package com.oracle.bank.view;

import java.util.Scanner;

import com.oracle.bank.biz.BankBiz;
import com.oracle.bank.biz.impl.BankBizImpl;
import com.oracle.bank.entity.BankAccount;

public class BankSystem {
	static BankBiz bankBiz = new BankBizImpl();
	
	static void openAcc(){
		System.out.println("请输入您的名字：");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		if ("".equals(name)) {
			System.out.println("姓名不能为空，请重新输入。");
			return;
		}
		
		BankAccount ba = new BankAccount(0, name, 0, null);
		int result = bankBiz.add(ba);
		
		if (result > 0) {
			System.out.println("恭喜，开户成功！！");
		}else{
			System.out.println("开户失败，请稍后再试。。。");
		}
	}
	
	//存款
	static void deposit(){
		System.out.println("请输入您要存的账号：");
		Scanner scan = new Scanner(System.in);
		int accNo = scan.nextInt();
		System.out.println("请输入您要存的金额：");
		double amt = scan.nextDouble();
		
		int result = bankBiz.deposit(accNo, amt);
		
		if (result > 0) {
			System.out.println("恭喜，存款成功！！");
		}else{
			System.out.println("存款失败，请稍后再试。。。");
		}
	}
	

	//转账
	static void transfer(){
		//接收用户的3个值：转出/入账号，转账金额
		
		//分别校验 3个值
		
		//调用业务层方法 进行转账
		
		//打印结果
	}
	
	

	public static void main(String[] args) {
		System.out.println("-----------------欢迎来到XX银行系统------------------");		
		boolean isGoon = true;
		
		while (isGoon) {
			Scanner scan = new Scanner(System.in);

			System.out.println("请选择您的操作：");
			System.out.println("1、开户");
			System.out.println("2、存款");
			System.out.println("3、取款");
			System.out.println("4、转账");
			System.out.println("5、退出系统");
			
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					openAcc();
					break;
				case 2:
					deposit();
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					isGoon = false;
					System.out.println("感谢使用，欢迎下次光临！！");
					break;
	
				default:
					break;
			}
			
			
		}		

	}
	
	
	

}
