package com.oracle.bank.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.oracle.bank.biz.BankBiz;
import com.oracle.bank.dao.BankAccountDao;
import com.oracle.bank.dao.BankStatementDao;
import com.oracle.bank.dao.impl.BankAccountDaoImpl;
import com.oracle.bank.dao.impl.BankStatementDaoImpl;
import com.oracle.bank.entity.BankAccount;
import com.oracle.bank.entity.BankStatement;
import com.oracle.bank.util.ConnUtil;

public class BankBizImpl implements BankBiz {
	BankAccountDao baDao = new BankAccountDaoImpl();
	BankStatementDao bsDao = new BankStatementDaoImpl();

	@Override
	public int add(BankAccount ba) {		
		int result = 0;		
		try {			
			result = baDao.add(ba);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return result;
	}

	@Override
	public int deposit(int accNo, double amt) {
		int result = 0;
		Connection conn = ConnUtil.getConn();
		try {
			conn.setAutoCommit(false);			
			//修改账户余额
			result = baDao.updateBalance(accNo, amt);				
//			int a = 10/0;
			//添加操作记录
			result += bsDao.add(new BankStatement(0, "存款", null, amt, accNo, accNo));				
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn);
		}
		
		return result;
	}

	@Override
	public BankAccount queryByAccno(int accNo) throws Exception {
		BankAccount ba = null;
		try {			
			ba = baDao.queryByAccno(accNo);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return ba;
	}

	@Override
	public int transfer(BankStatement bs) throws Exception {

		//将转出账户的余额 减少 amt
		
		//将转入账户的余额 增加 amt
		
		//添加操作记录，并 加入事务
		
		return 0;
	}

}
