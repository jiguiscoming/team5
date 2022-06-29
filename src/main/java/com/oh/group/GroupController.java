package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupController")
public class GroupController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 현재 페이지 가져오기
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		request.setAttribute("pageNum", pageNum);
		
		// 전국
		if (request.getParameter("region").equals("전국") || request.getParameter("region").equals("")) {
			// 전국 페이징 게시글
			GroupDAO.groupPaging(request,pageNum);
		}else {
			if(request.getParameter("search").equals("")) {
			// 지역
			GroupDAO.getRegionGroups(request);
			}
		}
		if(!request.getParameter("search").equals("")) {
			// 검색
			GroupDAO.getGroupSearch(request);
		} 
		// 밑에 페이지 이동버튼
		GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),pageNum);
//		UserDAO.loginCheck(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
