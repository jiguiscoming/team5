package com.oh.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinusConfirmC")
public class joinusConfirmC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		 UserDAO.fileUpload(request); 
				//	UserDAO.confirmJoin(request);
				
		
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "account/joinusconfirmUpdate.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
	}

}
