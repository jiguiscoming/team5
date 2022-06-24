package com.oh.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinusC")
public class joinusC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "account/joinus.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		 UserDAO.fileUpload(request); 
				//	UserDAO.confirmJoin(request);
				
				request.setAttribute("loginPage", "account/loginBtn.jsp");
				request.setAttribute("contentPage", "account/joinusconfirm.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
		
		
		
	}

}
