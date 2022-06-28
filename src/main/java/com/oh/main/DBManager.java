package com.oh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB관련 작업을 매번 연결코드를 쓴 이후 직업챙용 
// 그거 AOP 하자
public class DBManager {

	// db 작업시엔 어쨌든 연결 해야됨

	public static Connection connect() throws SQLException {
		// 상영
		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/Users/soldesk/Downloads/Wallet_DB202204301707";
		
		// 지구
//		String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C:/JS/Wallet_DB202204301707";


		return DriverManager.getConnection(url, "SYP", "YJ802soldesk");
		

	
	
		
	}

	// 닫을게 많은데 한번에 닫기

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
