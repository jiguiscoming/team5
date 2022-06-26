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
		// ��� Ȯ�� ������ �̵�
		request.setAttribute("contentPage", "group/group_pwOK.jsp");
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �н����� üũ �� ���� ������ ����
		if(request.getParameter("pwCheck") != null) {
			// �Խñ� ���� ��������
			GroupDAO.getGroup(request);
			// ���� ������ ����
			request.setAttribute("contentPage", "group/group_update.jsp");
		} 
			// �������������� ������ư ���� �� �۵�
			else {
				// �����ϱ�
				GroupDAO.groupUpdate(request);
				GroupDAO.groupPaging(request, 1);
				// ������ �̵���ư ����� (a�±�)
				GroupDAO.groupPageMove(request,(String)request.getAttribute("sql"),1);
				request.setAttribute("pageNum", 1);
				request.setAttribute("contentPage", "group/group_purchase.jsp");
			}
		request.setAttribute("loginPage", "account/loginBtn.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
