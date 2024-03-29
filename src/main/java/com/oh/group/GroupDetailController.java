package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/GroupDetailController")
public class GroupDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//조회수 up
		GroupDAO.getMkdao().hitsUp(request);
		// 댓글 다 가져오기
		GroupDAO.getMkdao().getComments(request);
		GroupDAO.getMkdao().getCommentsTotal(request);
		// 게시글 하나 가져오기
		GroupDAO.getMkdao().getGroup(request);
		UserDAO.getMkdao().loginCheck(request);
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 조회수 up
		GroupDAO.getMkdao().hitsUp(request);
		// 댓글
		GroupDAO.getMkdao().getComments(request);
		GroupDAO.getMkdao().getCommentsTotal(request);
		//게시글 하나 가져오기
		GroupDAO.getMkdao().getGroup(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

}
