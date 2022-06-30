package com.oh.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 밀키트 new
		HomeDAO.getMealkits(request);
		
		// 레시피 랜덤 5개
//		HomeDAO.getRecipes(request);
		// 공구 지역에 맞게 최신 5개
		HomeDAO.getGroups(request);
		UserDAO.loginCheck(request);
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

