package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupDetailController")
public class GroupDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 조회수 up
		GroupDAO.hitsUp(request);
		
		// 댓글 들고옴
		GroupDAO.getComments(request);
		// 게시글 하나 정보 들고옴
		GroupDAO.getGroup(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 게시글 좋아요 up
		GroupDAO.likeUp(request);
		// 해당 아이디 좋아요 up
		// 조회수 up
		GroupDAO.hitsUp(request);
		// 댓글 들고옴
		GroupDAO.getComments(request);
		// 게시글 하나 정보 들고옴
		GroupDAO.getGroup(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

}
