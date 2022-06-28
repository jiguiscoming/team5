package com.sy.mealKit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sy.function.MealkitDAO;

@WebServlet("/Mk_MenuC")
public class Mk_MenuC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		 MealkitDAO.viewmealkit(request); 
		 MealkitDAO.viewKorMealkit(request);
		 MealkitDAO.viewAmeMealkit(request);
		 MealkitDAO.viewJpnMealkit(request);
		 MealkitDAO.viewChnMealkit(request);
		 MealkitDAO.viewSalMealkit(request);
		 request.setAttribute("mealkitPage", "mk_Menulist.jsp");
		 request.getRequestDispatcher("mealKit/mk_M.jsp").forward(request, response);
		 
		 
		 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	
	}

}
