package com.oh.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB���� �۾��� �� �� �Ź� �����ڵ带 �� ���� �۾� �ؿ�

// �װ� AOP ����
public class DBManager_account {

	// db�۾��ÿ� ��¶�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/yoon/Wallet_DB202204301707"; //�������
		
			return DriverManager.getConnection(url, "DB_JY", "LMJSoldesk802");
	 
	}
		
	
	// ���� �� ������ �ѹ��� �ݱ�
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
	try {
		if (rs != null) {
			rs.close();
		}
		
		pstmt.close();
		con.close();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	}
	
	
	
	
}
