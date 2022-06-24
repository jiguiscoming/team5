package com.oh.account;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UserDAO {

	
	public static void fileUpload(HttpServletRequest request) throws IOException
	{ String path = request.getSession().getServletContext().getRealPath("account/img");
	System.out.println(path); MultipartRequest mr = new MultipartRequest(request,
			path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	String join_profile = mr.getFilesystemName("join_profile");
	System.out.println(join_profile); request.setAttribute("join_profile", join_profile);
	
	String join_name = mr.getParameter("join_name");
	String join_nick = mr.getParameter("join_nick");
	String join_id = mr.getParameter("join_id");
	String join_age = mr.getParameter("join_age");
	String join_gender = mr.getParameter("join_gender");
	String join_birth = mr.getParameter("join_birth");
	String join_pw = mr.getParameter("join_pw");
	String join_pw2 = mr.getParameter("join_pw2");
	String join_pwquestion = mr.getParameter("join_pwquestion");
	String join_pwquestiona = mr.getParameter("join_pwquestiona");
	String join_email = mr.getParameter("join_email");
	String join_phone = mr.getParameter("join_phone");
	String join_addr = mr.getParameter("join_addr");
	String join_agree1 = mr.getParameter("agree1");
	String join_agree2 = mr.getParameter("agree2");
	String join_agree3 = mr.getParameter("agree3");
	String join_agree4 = mr.getParameter("agree4");
	
	
	

	request.setAttribute("join_name", join_name);
	request.setAttribute("join_id", join_id);
	request.setAttribute("join_age", join_age);
	request.setAttribute("join_gender", join_gender);
	request.setAttribute("join_birth", join_birth);
	request.setAttribute("join_pw", join_pw);
	request.setAttribute("join_pw2", join_pw2);
	request.setAttribute("join_pwquestion", join_pwquestion);
	request.setAttribute("join_pwquestiona", join_pwquestiona);
	request.setAttribute("join_email", join_email);
	request.setAttribute("join_phone", join_phone);
	request.setAttribute("join_addr", join_addr);
	request.setAttribute("join_agree1", join_agree1);
	request.setAttribute("join_agree2", join_agree2);
	request.setAttribute("join_agree3", join_agree3);
	request.setAttribute("join_agree4", join_agree4);
	
	System.out.println(join_name);
	
	
	
	
	}

	public static void agree(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}


	
	

public static void createAccount(HttpServletRequest request) {
	// TODO Auto-generated method stub

	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		request.setCharacterEncoding("utf-8");
		String sql = "insert into oh_account values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		con = DBManager_account.connect();
		pstmt = con.prepareStatement(sql);
		
		String join_name=request.getParameter("join_name");
		String join_nick=request.getParameter("join_nick");
		String join_id=request.getParameter("join_id");
		String join_pw=request.getParameter("join_pw");
		String join_gender=request.getParameter("join_gender");
		String join_birth=request.getParameter("join_birth");
		String join_addr=request.getParameter("join_addr");
		String join_age=request.getParameter("join_age");
		String join_pwquestion=request.getParameter("join_pwquestion");
		String join_pwquestiona=request.getParameter("join_pwquestiona");
		String join_email=request.getParameter("join_email");
		String join_profile=request.getParameter("join_profile");
		String join_phone=request.getParameter("join_phone");
		String agree1=request.getParameter("agree1");
		String agree2=request.getParameter("agree2");
		String agree3=request.getParameter("agree3");
		String agree4=request.getParameter("agree4");

		
		
		pstmt.setString(1, join_name);
		pstmt.setString(2, join_nick);
		pstmt.setString(3, join_id);
		pstmt.setString(4, join_pw);
		pstmt.setString(5, join_gender);
		pstmt.setString(6, join_birth);
		pstmt.setString(7, join_addr);
		pstmt.setString(8, join_age);
		pstmt.setString(9, join_phone);
		pstmt.setString(10, join_pwquestion);
		pstmt.setString(11, join_pwquestiona);
		pstmt.setString(12, join_email);
		pstmt.setString(13, join_profile);
		pstmt.setString(14, agree1);
		pstmt.setString(15, agree2);
		pstmt.setString(16, agree3);
		pstmt.setString(1, agree4);
		
		
		
		
		if (pstmt.executeUpdate() == 1) {
			request.setAttribute("r", "님, 환영합니다!");
			
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("r", "서버 오류..");
	
	}finally {
		DBManager_account.close(con, pstmt, null);
	}
	
		
	
	
	
	
	
	
}

	

	
	
	
	



public static void confirmJoin(HttpServletRequest request)  {
	
//		String join_name = request.getParameter("join_name");
//		String join_id = request.getParameter("join_id");
//		String join_age = request.getParameter("join_age");
//		String join_gender = request.getParameter("join_gender");
//		String join_birth = request.getParameter("join_birth");
//		String join_pw = request.getParameter("join_pw");
//		String join_pw2 = request.getParameter("join_pw2");
//		String join_pwquestion = request.getParameter("join_pwquestion");
//		String join_pwquestiona = request.getParameter("join_pwquestiona");
//		String join_email = request.getParameter("join_email");
//		String join_phone = request.getParameter("join_phone");
//		String join_addr = request.getParameter("join_addr");
//		
//		
//		
//		
//	
//		request.setAttribute("join_name", join_name);
//		request.setAttribute("join_id", join_id);
//		request.setAttribute("join_age", join_age);
//		request.setAttribute("join_gender", join_gender);
//		request.setAttribute("join_birth", join_birth);
//		request.setAttribute("join_pw", join_pw);
//		request.setAttribute("join_pw2", join_pw2);
//		request.setAttribute("join_pwquestion", join_pwquestion);
//		request.setAttribute("join_pwquestiona", join_pwquestiona);
//		request.setAttribute("join_email", join_email);
//		request.setAttribute("join_phone", join_phone);
//		request.setAttribute("join_addr", join_addr);
//		System.out.println(join_name);
	
}

public static void login(HttpServletRequest request) {

	String userId= request.getParameter("id");
	String userPw = request.getParameter("pw");
	
	
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "select * from oh_account where account_id= ?";
		con = DBManager_account.connect();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();
		
		
		if (rs.next()) {
			if (userPw.equals(rs.getString("account_pw"))) {
				request.setAttribute("r", "어서 오세요!");
				
				accountB a = new accountB();
				
				a.setaccount_id(rs.getString("account_id"));
				a.setaccount_pw(rs.getString("account_pw"));
				a.setaccount_name(rs.getString("account_name"));
				
				HttpSession hs = request.getSession();
				hs.setAttribute("accountInfo", a);
				hs.setMaxInactiveInterval(600);
				
			}else {
				request.setAttribute("r", "패스워드를 확인해 주세요!");
			}
		} else {
			request.setAttribute("r", "가입하지 않은 회원입니다!");  
		}
	
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBManager_account.close(con, pstmt, rs);
	}
	
	
}

public static void logout(HttpServletRequest request) {
	// TODO Auto-generated method stub
	
	HttpSession hs = request.getSession();
	hs.invalidate();
	
	
}

// 세션 유지를 위해 모든 컨트롤러에 넣어 주세요.!

public static void loginCheck(HttpServletRequest request) {
	// TODO Auto-generated method stub
	
	HttpSession hs = request.getSession();
	accountB acc = (accountB) hs.getAttribute("accountInfo");
	
	if (acc == null) {
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		} else {
			request.setAttribute("loginPage", "account/loginOK.jsp");
			
		}
		

	
	
}

 // id 중복체크
public int idCheck(String id) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int value = 0;
	
	try {
	    String sql = "select account_id from oh_account where account_id = ?";
	    
		con = DBManager_account.connect();
		pstmt = con.prepareStatement(sql);
	    pstmt.setString(1,  id);
	    rs = pstmt.executeQuery();
	    
	    if(rs.next()) value = 1;
	    
	}catch (Exception e) {
	    e.printStackTrace();

	} finally {
		DBManager_account.close(con, pstmt, rs);
	}
	return value;
   }



}