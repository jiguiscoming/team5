package com.oh.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;
import com.oh.group.GroupDAO;


@WebServlet("/account_messageDetailC")
public class account_messageDetailC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAO.getMkdao().loginCheck(request);
		GroupDAO.getMkdao().getMessage(request);
		GroupDAO.getMkdao().getNick(request);
		
		request.setAttribute("contentPage", "myPage/account_message_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
	}

}
