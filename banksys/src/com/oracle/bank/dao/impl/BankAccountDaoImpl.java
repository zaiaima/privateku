package com.oracle.bank.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.bank.dao.BankAccountDao;
import com.oracle.bank.entity.BankAccount;
import com.oracle.bank.util.ConnUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public int add(BankAccount bankAccount) throws Exception {
		int result = 0;
		PreparedStatement ps = null;

		Connection conn = ConnUtil.getConn();
		ps = conn.prepareStatement("Insert into bankacct(acc_name,balance) values(?,?)");		
		ps.setString(1, bankAccount.getAccName());
		ps.setDouble(2, bankAccount.getBalance());		
		result = ps.executeUpdate();
		ConnUtil.close(ps, null);
		
		return result;
	}

	@Override
	public int updateBalance(int accno, double amt) throws Exception {
		int result = 0;
		PreparedStatement ps = null;
		Connection conn = ConnUtil.getConn();
		ps = conn.prepareStatement("update bankacct set balance = balance + ? where accno = ?");
		ps.setDouble(1, amt);
		ps.setInt(2, accno);
		result = ps.executeUpdate();
		ConnUtil.close(ps, null);
		
		return result;
	}

	@Override
	public BankAccount queryByAccno(int accNo) throws Exception {
		BankAccount ba = null;
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from bankacct where accno=?");
		ps.setInt(1, accNo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ba = new BankAccount(accNo, rs.getString("acc_name"), rs.getDouble("balance"), rs.getDate("create_time"));
		}
		ConnUtil.close(ps, rs);
		
		return ba;
	}

}
