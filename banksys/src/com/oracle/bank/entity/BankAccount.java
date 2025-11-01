package com.oracle.bank.entity;

import java.util.Date;

public class BankAccount {
	private int accNo;
	private String accName;
	private double balance;
	private Date createTime;
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public BankAccount(int accNo, String accName, double balance, Date createTime) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.balance = balance;
		this.createTime = createTime;
	}
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

}
