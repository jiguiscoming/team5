package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;


@WebServlet("/account_informationUpdateC")
public class account_informationUpdateC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAO.getMkdao().loginCheck(request);
		UserDAO.information(request);
		
		request.setAttribute("contentPage", "myPage/account_information.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
	}

}
