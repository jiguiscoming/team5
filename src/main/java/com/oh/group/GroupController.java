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
	
		// 현재 페이지
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		request.setAttribute("pageNum", pageNum);
		
		// 공구 메뉴 || 전국 : 게시글 다 받기
		if (request.getParameter("region").equals("전국") || request.getParameter("region").equals("")) {
			// 페이징한 게시글 정보 받기
			GroupDAO.groupPaging(request,pageNum);
		}else {
			if(request.getParameter("search").equals("")) {
			// 지역 : 파라미터로 지역 값 넘겨서 게시글 골라 받기 (select where) + 페이징 적용
			GroupDAO.getRegionGroups(request);
			}
		}
		if(!request.getParameter("search").equals("")) {
			// 검색 : 파라미터로 검색 값 넘겨서 게시글 골라받기 +  페이징
			GroupDAO.getGroupSearch(request);
		} 
		// 페이지 이동버튼 만들기 (a태그)
		GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),pageNum);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
