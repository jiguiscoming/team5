package com.oh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB���� �۾��� �Ź� �����ڵ带 �� ���� ����ì�� 
// �װ� AOP ����
public class DBManager {

	// db �۾��ÿ� ��·�� ���� �ؾߵ�

	public static Connection connect() throws SQLException {
		// ��
//		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/Users/soldesk/Downloads/Wallet_DB202204301707";
		
		// ����
		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/JS/Wallet_DB202204301707";


		return DriverManager.getConnection(url, "SYP", "YJ802soldesk");
		

	
	
		
	}

	// ������ ������ �ѹ��� �ݱ�

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
