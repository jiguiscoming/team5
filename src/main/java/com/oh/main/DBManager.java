package com.oh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB���� �۾��� �Ź� �����ڵ带 �� ���� ����ì�� 
// �װ� AOP ����
public class DBManager {

	// db 작업시엔 어쨌든 연결 해야됨
	private static final DBManager DBM = new DBManager();
	private DBManager() {
		// TODO Auto-generated constructor stub
	}
	public static DBManager getDbm() {
		return DBM;
	}

	public Connection connect() {
		// 상영
		//String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/Users/soldesk/Downloads/Wallet_DB202204301707";
		
		// 지구
		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/JS/Wallet_DB202204301707";
		
		// 선엽
//		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/ksy/Wallet_DB202204301707";

		// 정연 
//		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/yoon/Wallet_DB202204301707"; //�������
		
		try {
			return DriverManager.getConnection(url, "SYP", "YJ802soldesk");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//		정연
		//return DriverManager.getConnection(url, "DB_JY", "LMJSoldesk802");
		return null;
		}

		//정연
		// return DriverManager.getConnection(url, "DB_JY", "LMJSoldesk802");
		 
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
	try {
		if (rs != null) {
			rs.close();
		}
		
		pstmt.close();
		
		if (con != null) {
			
			con.close();
		}
		
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	}
	
		
	}

