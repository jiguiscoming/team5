package com.oh.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginC")
public class loginC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		UserDAO.logout(request);
		UserDAO.loginCheck(request);
		
		// 로그아웃에 사용
		
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "account/loginResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAO.login(request);
		
	
		// if 문 처리 해줘야함!
	
		request.setAttribute("loginPage", "account/loginOK.jsp");
		request.setAttribute("contentPage", "account/loginResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	}

}
