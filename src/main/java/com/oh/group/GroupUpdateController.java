package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/GroupUpdateController")
public class GroupUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비번 확인 페이지 이동
		request.setAttribute("contentPage", "group/group_pwOK.jsp");
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 패스워드 체크 후 수정 페이지 가기
		if(request.getParameter("pwCheck") != null) {
			// 게시글 정보 가져오기
			GroupDAO.getGroup(request);
			// 수정 페이지 가기
			request.setAttribute("contentPage", "group/group_update.jsp");
		} 
			// 수정페이지에서 수정버튼 누른 후 작동
			else {
				// 수정하기
				GroupDAO.groupUpdate(request);
				GroupDAO.groupPaging(request, 1);
				// 페이지 이동버튼 만들기 (a태그)
				GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),1);
				request.setAttribute("pageNum", 1);
				request.setAttribute("contentPage", "group/group_purchase.jsp");
			}
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
