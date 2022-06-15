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
	
		//�����ϱ�
		GroupDAO.groupDelete(request);
		//��ϰ��� : ��ü �� ��������
		GroupDAO.getGroups(request);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}