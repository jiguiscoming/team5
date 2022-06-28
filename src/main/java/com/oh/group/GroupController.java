package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupController")
public class GroupController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ���� ������
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		request.setAttribute("pageNum", pageNum);
		
		// ���� �޴� || ���� : �Խñ� �� �ޱ�
		if (request.getParameter("region").equals("����") || request.getParameter("region").equals("")) {
			// ����¡�� �Խñ� ���� �ޱ�
			GroupDAO.groupPaging(request,pageNum);
		}else {
			if(request.getParameter("search").equals("")) {
			// ���� : �Ķ���ͷ� ���� �� �Ѱܼ� �Խñ� ��� �ޱ� (select where) + ����¡ ����
			GroupDAO.getRegionGroups(request);
			}
		}
		if(!request.getParameter("search").equals("")) {
			// �˻� : �Ķ���ͷ� �˻� �� �Ѱܼ� �Խñ� ���ޱ� +  ����¡
			GroupDAO.getGroupSearch(request);
		} 
		// ������ �̵���ư ����� (a�±�)
		GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),pageNum);
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
