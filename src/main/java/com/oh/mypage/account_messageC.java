package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;
import com.oh.group.GroupDAO;


@WebServlet("/account_messageC")
public class account_messageC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAO.getMkdao().loginCheck(request);
		GroupDAO.getMkdao().getMessages(request);
		request.setAttribute("contentPage", "myPage/account_message.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
	}

}
