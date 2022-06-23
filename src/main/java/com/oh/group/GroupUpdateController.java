package com.oh.group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupUpdateController")
public class GroupUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��� Ȯ�� ������ �̵�
		request.setAttribute("contentPage", "group/group_pwOK.jsp");
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("pwCheck") != null) {
			// �Խñ� ���� ��������
			GroupDAO.getGroup(request);
			// ���� ������ ����
			request.setAttribute("contentPage", "group/group_update.jsp");
		} else {
			// �����ϱ�
			GroupDAO.groupUpdate(request);
			// ���� �޴� || ���� : �Խñ� �� �ޱ�
			if (request.getParameter("region").equals("����")) {
				// ����¡�� �Խñ� ���� �ޱ�
				GroupDAO.groupPaging(request);
//				System.out.println("����");
			}else {
				if(request.getParameter("search").equals("")) {
				// ���� : �Ķ���ͷ� ���� �� �Ѱܼ� �Խñ� ��� �ޱ� (select where) + ����¡ ����
				GroupDAO.getRegionGroups(request);
//				System.out.println("����");
				}
			}
			if(!request.getParameter("search").equals("")) {
				// �˻� : �Ķ���ͷ� �˻� �� �Ѱܼ� �Խñ� ���ޱ� +  ����¡
				GroupDAO.getGroupSearch(request);
//				System.out.println("�˻�");
			} 
			// ������ �̵���ư ����� (a�±�)
			GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"));
			request.setAttribute("contentPage", "group/group_purchase.jsp");
		}
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
