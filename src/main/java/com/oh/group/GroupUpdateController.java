package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/GroupUpdateController")
public class GroupUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비번 확인
		request.setAttribute("contentPage", "group/group_pwOK.jsp");
		UserDAO.loginCheck(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 비번 체크 후
		if(request.getParameter("pwCheck") != null) {
			// 게시글 내용 가져오기
			GroupDAO.getGroup(request);
			// 게시글 수정 페이지 이동
			request.setAttribute("contentPage", "group/group_update.jsp");
		} 
			// 등록 후
			else {
				// 수정하기
				GroupDAO.groupUpdate(request);
				GroupDAO.groupPaging(request, 1);
				// 페이지 이동버튼
				GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),1);
				request.setAttribute("pageNum", 1);
				request.setAttribute("contentPage", "group/group_purchase.jsp");
			}
		UserDAO.loginCheck(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
