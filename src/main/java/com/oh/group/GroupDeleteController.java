package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/GroupDeleteController")
public class GroupDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//게시글 삭제
		GroupDAO.getMkdao().groupDelete(request);
		// 페이징
		GroupDAO.getMkdao().groupPaging(request,1);
		request.setAttribute("pageNum", 1);
		//페이지 버튼
		GroupDAO.getMkdao().groupPageMove(request,(String)request.getAttribute("sql"),1);
		UserDAO.getMkdao().loginCheck(request);
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
