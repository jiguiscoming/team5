package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupDeleteController")
public class GroupDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//삭제하기
		GroupDAO.groupDelete(request);
		// 공구 메뉴 || 전국 : 게시글 다 받기
		GroupDAO.groupPaging(request,1);
		// 페이지 이동버튼 만들기 (a태그)
		request.setAttribute("pageNum", 1);
		GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),1);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
