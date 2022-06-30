package com.sy.mealKit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;
import com.sy.function.MealkitDAO;

@WebServlet("/Mk_MenuC")
public class Mk_MenuC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		 MealkitDAO.getMkdao().viewmealkit(request); 
		 MealkitDAO.getMkdao().viewKorMealkit(request);
		 MealkitDAO.getMkdao().viewAmeMealkit(request);
		 MealkitDAO.getMkdao().viewJpnMealkit(request);
		 MealkitDAO.getMkdao().viewChnMealkit(request);
		 MealkitDAO.getMkdao().viewSalMealkit(request);
		 UserDAO.getMkdao().loginCheck(request);
		 request.setAttribute("mealkitPage", "./mk_Menulist.jsp");
		 request.setAttribute("contentPage", "mealKit/mk_M.jsp");
		 request.getRequestDispatcher("index.jsp").forward(request, response);
		 
		 
		 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	
	}

}
