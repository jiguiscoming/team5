package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupResearchController")
public class GroupResearchController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 전국 : 게시글 다 받기
		if(request.getParameter("region").equals("전국")) {
			GroupDAO.getGroups(request);
		} else {
			// 지역 : 파라미터로 값 넘겨서 게시글 골라 받기 (select where)
			GroupDAO.getRegionGroups(request);
		}
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 값 골라 받기
		GroupDAO.getGroupResearch(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
