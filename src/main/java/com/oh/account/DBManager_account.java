package com.oh.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB관련 작업을 할 때 매번 연결코드를 쓴 이후 작업 해옴

// 그거 AOP 하자
public class DBManager_account {

	// db작업시엔 어쨋든 연결 해야됨
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/yoon/Wallet_DB202204301707"; //여기더봐
		
			return DriverManager.getConnection(url, "DB_JY", "LMJSoldesk802");
	 
	}
		
	
	// 닫을 게 많은데 한번에 닫기
	
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
