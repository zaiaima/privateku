package com.oracle.bank.biz;

import com.oracle.bank.entity.BankAccount;
import com.oracle.bank.entity.BankStatement;

public interface BankBiz {
	/**
	 * 开户
	 * @param ba
	 * @return
	 */
	public int add(BankAccount ba);
	
	/**
	 * 存款
	 * @param accNo
	 * @param amt
	 * @return
	 */
	public int deposit(int accNo, double amt);
	
	/**
	 * 根据账号获取账户对象
	 * @param accNo
	 * @return
	 * @throws Exception
	 */
	public BankAccount queryByAccno(int accNo) throws Exception;
	
	public int transfer(BankStatement bs) throws Exception;
}
