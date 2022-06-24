package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;


@WebServlet("/account_secessionC")
public class account_secessionC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		UserDAO.loginCheck_S(request);
	
	
		request.setAttribute("contentPage", "secession_result.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDAO.loginCheck(request);
	
		UserDAO.secession(request);
		
		UserDAO.loginCheck_S(request);
		
		
		
		request.setAttribute("contentPage", "myPage/secession.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	
	}

}
