package com.sy.mealKit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sy.function.MealkitDAO;

@WebServlet("/Mk_MenuInfoC")
public class Mk_MenuInfoC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MealkitDAO.viewmealkit(request);
		MealkitDAO.getMealkit(request);
		MealkitDAO.viewReviewMealkit(request);
		MealkitDAO.viewQnAMealkit(request);
		request.setAttribute("mealkitPage", "mk_info.jsp");
		request.getRequestDispatcher("mealKit/mk_M.jsp").forward(request, response);
	
	
		
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
	
	
	}

}
