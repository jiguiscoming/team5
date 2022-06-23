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

		// ��ȸ�� up
		GroupDAO.hitsUp(request);
		
		// ��� ����
		GroupDAO.getComments(request);
		// �Խñ� �ϳ� ���� ����
		GroupDAO.getGroup(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// �Խñ� ���ƿ� up
		GroupDAO.likeUp(request);
		// �ش� ���̵� ���ƿ� up
		// ��ȸ�� up
		GroupDAO.hitsUp(request);
		// ��� ����
		GroupDAO.getComments(request);
		// �Խñ� �ϳ� ���� ����
		GroupDAO.getGroup(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

}
