package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupCommentController")
public class GroupCommentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//댓글이 db에 저장
		GroupDAO.commentReg(request);
		//댓글 불러오기
		GroupDAO.getComments(request);
		// 디테일 정보 들고 오기(게시글 하나)
		GroupDAO.getGroup(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
