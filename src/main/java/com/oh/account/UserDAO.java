package com.oh.account;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UserDAO {

	
	public static void fileUpload(HttpServletRequest request) throws IOException
	{ String path = request.getSession().getServletContext().getRealPath("account/img");
	System.out.println(path); MultipartRequest mr = new MultipartRequest(request,
			path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	String j_profile = mr.getFilesystemName("j_profile");
	System.out.println(j_profile); request.setAttribute("j_profile", j_profile);
	
	String j_name = mr.getParameter("j_name");
	String j_nick = mr.getParameter("j_nick");
	String j_id = mr.getParameter("j_id");
	String j_age = mr.getParameter("j_age");
	String j_gender = mr.getParameter("j_gender");
	String j_birth = mr.getParameter("j_birth");
	String j_pw = mr.getParameter("j_pw");
	String j_pw2 = mr.getParameter("j_pw2");
	String j_pwquestion = mr.getParameter("j_pwquestion");
	String j_pwquestiona = mr.getParameter("j_pwquestiona");
	String j_email = mr.getParameter("j_email");
	String j_phone = mr.getParameter("j_phone");
	String j_addr = mr.getParameter("j_addr");
	String j_agree1 = mr.getParameter("agree1");
	String j_agree2 = mr.getParameter("agree2");
	String j_agree3 = mr.getParameter("agree3");
	String j_agree4 = mr.getParameter("agree4");
	
	
	

	request.setAttribute("j_name", j_name);
	request.setAttribute("j_id", j_id);
	request.setAttribute("j_age", j_age);
	request.setAttribute("j_gender", j_gender);
	request.setAttribute("j_birth", j_birth);
	request.setAttribute("j_pw", j_pw);
	request.setAttribute("j_pw2", j_pw2);
	request.setAttribute("j_pwquestion", j_pwquestion);
	request.setAttribute("j_pwquestiona", j_pwquestiona);
	request.setAttribute("j_email", j_email);
	request.setAttribute("j_phone", j_phone);
	request.setAttribute("j_addr", j_addr);
	request.setAttribute("j_agree1", j_agree1);
	request.setAttribute("j_agree2", j_agree2);
	request.setAttribute("j_agree3", j_agree3);
	request.setAttribute("j_agree4", j_agree4);
	
	System.out.println(j_name);
	
	
	
	
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
		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);
		
		String j_name=request.getParameter("j_name");
		String j_nick=request.getParameter("j_nick");
		String j_id=request.getParameter("j_id");
		String j_pw=request.getParameter("j_pw");
		String j_gender=request.getParameter("j_gender");
		String j_birth=request.getParameter("j_birth");
		String j_addr=request.getParameter("j_addr");
		String j_age=request.getParameter("j_age");
		String j_pwquestion=request.getParameter("j_pwquestion");
		String j_pwquestiona=request.getParameter("j_pwquestiona");
		String j_email=request.getParameter("j_email");
		String j_profile=request.getParameter("j_profile");
		String j_phone=request.getParameter("j_phone");
		String agree1=request.getParameter("agree1");
		String agree2=request.getParameter("agree2");
		String agree3=request.getParameter("agree3");
		String agree4=request.getParameter("agree4");

		
		
		pstmt.setString(1, j_name);
		pstmt.setString(2, j_nick);
		pstmt.setString(3, j_id);
		pstmt.setString(4, j_pw);
		pstmt.setString(5, j_gender);
		pstmt.setString(6, j_birth);
		pstmt.setString(7, j_addr);
		pstmt.setString(8, j_age);
		pstmt.setString(9, j_phone);
		pstmt.setString(10, j_pwquestion);
		pstmt.setString(11, j_pwquestiona);
		pstmt.setString(12, j_email);
		pstmt.setString(13, j_profile);
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
		DBManager.close(con, pstmt, null);
	}
	
		
	
	
	
	
	
	
}



public static void confirmJoin(HttpServletRequest request)  {
	
//		String j_name = request.getParameter("j_name");
//		String j_id = request.getParameter("j_id");
//		String j_age = request.getParameter("j_age");
//		String j_gender = request.getParameter("j_gender");
//		String j_birth = request.getParameter("j_birth");
//		String j_pw = request.getParameter("j_pw");
//		String j_pw2 = request.getParameter("j_pw2");
//		String j_pwquestion = request.getParameter("j_pwquestion");
//		String j_pwquestiona = request.getParameter("j_pwquestiona");
//		String j_email = request.getParameter("j_email");
//		String j_phone = request.getParameter("j_phone");
//		String j_addr = request.getParameter("j_addr");
//		
//		
//		
//		
//	
//		request.setAttribute("j_name", j_name);
//		request.setAttribute("j_id", j_id);
//		request.setAttribute("j_age", j_age);
//		request.setAttribute("j_gender", j_gender);
//		request.setAttribute("j_birth", j_birth);
//		request.setAttribute("j_pw", j_pw);
//		request.setAttribute("j_pw2", j_pw2);
//		request.setAttribute("j_pwquestion", j_pwquestion);
//		request.setAttribute("j_pwquestiona", j_pwquestiona);
//		request.setAttribute("j_email", j_email);
//		request.setAttribute("j_phone", j_phone);
//		request.setAttribute("j_addr", j_addr);
//		System.out.println(j_name);
	
}
}