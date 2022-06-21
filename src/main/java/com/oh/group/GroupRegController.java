package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupRegController")
public class GroupRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		����ϱ�
		GroupDAO.groupReg(request);
		// ���� �޴� || ���� : �Խñ� �� �ޱ�
		if (request.getParameter("region").equals("����")) {
			// ����¡�� �Խñ� ���� �ޱ�
			GroupDAO.groupPaging(request);
//			System.out.println("����");
		}else {
			if(request.getParameter("search").equals("")) {
			// ���� : �Ķ���ͷ� ���� �� �Ѱܼ� �Խñ� ��� �ޱ� (select where) + ����¡ ����
			GroupDAO.getRegionGroups(request);
//			System.out.println("����");
			}
		}
		if(!request.getParameter("search").equals("")) {
			// �˻� : �Ķ���ͷ� �˻� �� �Ѱܼ� �Խñ� ���ޱ� +  ����¡
			GroupDAO.getGroupResearch(request);
//			System.out.println("�˻�");
		} 
		// ������ �̵���ư ����� (a�±�)
		GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"));
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.setAttribute("contentPage", "group/group_purchase.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
