package com.oracle.bank.entity;

import java.util.Date;

public class BankStatement {
	private int id;
	private String action;
	private Date txDate;
	private double amount;
	private int fromAccno;
	private int toAccno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getFromAccno() {
		return fromAccno;
	}
	public void setFromAccno(int fromAccno) {
		this.fromAccno = fromAccno;
	}
	public int getToAccno() {
		return toAccno;
	}
	public void setToAccno(int toAccno) {
		this.toAccno = toAccno;
	}
	public BankStatement(int id, String action, Date txDate, double amount, int fromAccno, int toAccno) {
		super();
		this.id = id;
		this.action = action;
		this.txDate = txDate;
		this.amount = amount;
		this.fromAccno = fromAccno;
		this.toAccno = toAccno;
	}
	
	public BankStatement() {
		// TODO Auto-generated constructor stub
	}
}
