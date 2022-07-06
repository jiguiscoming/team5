package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oh.account.UserDAO;
import com.oh.account.accountB;


@WebServlet("/account_secessionRC")
public class account_secessionRC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Ż�� �Ϸ� ���������
		
		UserDAO.getMkdao().secession(request);
		
	
		request.setAttribute("contentPage", "account/secession_result.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
		/*
		 * UserDAO.loginCheck_S(request);
		 * 
		 * 
		 * request.setAttribute("contentPage", "myPage/secession_result.jsp");
		 * request.getRequestDispatcher("index.jsp").forward(request, response);
		 */
		
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	
	
	}

}
