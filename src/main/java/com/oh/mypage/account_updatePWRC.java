package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;


@WebServlet("/account_updatePWRC")
public class account_updatePWRC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		UserDAO.loginCheck(request);
		UserDAO.updatePW(request);
		

		request.setAttribute("contentPage", "myPage/account_updatePW.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	
	 
	
	}

}
