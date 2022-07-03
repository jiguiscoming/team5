package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;


@WebServlet("/account_secessionpwC")
public class account_secessionpwC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
	UserDAO.getMkdao().loginCheck(request);
		
		
		
		request.setAttribute("contentPage", "myPage/account_secession_pw.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
	
	
		
		
		UserDAO.getMkdao().loginCheck(request);
		UserDAO.getMkdao().confirmPW_S(request);
		
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
	 
	
	}

}
