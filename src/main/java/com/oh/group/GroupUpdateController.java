package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupUpdateController")
public class GroupUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비번 확인 페이지 이동
		request.setAttribute("contentPage", "group/group_pwOK.jsp");
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("pwCheck") != null) {
			// 게시글 정보 가져오기
			GroupDAO.getGroup(request);
			// 수정 페이지 가기
			request.setAttribute("contentPage", "group/group_update.jsp");
		} else {
			// 수정하기
			GroupDAO.groupUpdate(request);
			// 공구 메뉴 || 전국 : 게시글 다 받기
			if (request.getParameter("region").equals("전국")) {
				// 페이징한 게시글 정보 받기
				GroupDAO.groupPaging(request);
//				System.out.println("전국");
			}else {
				if(request.getParameter("search").equals("")) {
				// 지역 : 파라미터로 지역 값 넘겨서 게시글 골라 받기 (select where) + 페이징 적용
				GroupDAO.getRegionGroups(request);
//				System.out.println("지역");
				}
			}
			if(!request.getParameter("search").equals("")) {
				// 검색 : 파라미터로 검색 값 넘겨서 게시글 골라받기 +  페이징
				GroupDAO.getGroupSearch(request);
//				System.out.println("검색");
			} 
			// 페이지 이동버튼 만들기 (a태그)
			GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"));
			request.setAttribute("contentPage", "group/group_purchase.jsp");
		}
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
