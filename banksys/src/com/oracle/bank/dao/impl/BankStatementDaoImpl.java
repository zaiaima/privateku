package com.oracle.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.oracle.bank.dao.BankStatementDao;
import com.oracle.bank.entity.BankStatement;
import com.oracle.bank.util.ConnUtil;

public class BankStatementDaoImpl implements BankStatementDao {

	@Override
	public int add(BankStatement bs) throws Exception {
		PreparedStatement ps = null;
		Connection conn = ConnUtil.getConn();
		ps = conn.prepareStatement("Insert into bankstatement(action,amount,from_accno,to_accno) values(?,?,?,?)");			
		ps.setString(1, bs.getAction());			
		ps.setDouble(2, bs.getAmount());
		ps.setInt(3, bs.getFromAccno());
		ps.setInt(4, bs.getToAccno());			
		int result = ps.executeUpdate();
		ConnUtil.close(ps, null);
		
		return result;
	}

}
