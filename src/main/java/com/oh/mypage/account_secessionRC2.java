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


@WebServlet("/account_secessionRC2")
public class account_secessionRC2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Ż�� ���� ���������
		

		
			request.setAttribute("r", "감사합니다!");
			request.setAttribute("loginPage", "account/loginOK.jsp");
		
	
		request.setAttribute("contentPage", "account/secession_result.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
		
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	
	
	}

}
