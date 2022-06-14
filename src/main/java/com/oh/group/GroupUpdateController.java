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
			// 목록가기 : 목록 불러오기
			GroupDAO.getGroups(request);
			request.setAttribute("contentPage", "group/group_purchase.jsp");
		}
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
