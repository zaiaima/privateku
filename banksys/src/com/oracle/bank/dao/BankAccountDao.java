package com.oracle.bank.dao;

import com.oracle.bank.entity.BankAccount;

public interface BankAccountDao {
	
	/**
	 * 根据账号获取账户对象
	 * @param accNo
	 * @return
	 * @throws Exception
	 */
	public BankAccount queryByAccno(int accNo) throws Exception;
	
	//添加账户
	public int add(BankAccount bankAccount) throws Exception;
	
	//修改账户余额
	public int updateBalance(int accno, double amt) throws Exception;

}
