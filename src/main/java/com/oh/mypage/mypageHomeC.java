package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/mypageHomeC")
public class mypageHomeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAO.loginCheck(request);
		
		
		request.setAttribute("contentPage", "myPage/myPageHome.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//				request.setAttribute("loginPage", "account/loginBtn.jsp");
//				request.setAttribute("contentPage", "account/joinusconfirm.jsp");
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//				
		
		
		
	}

}
