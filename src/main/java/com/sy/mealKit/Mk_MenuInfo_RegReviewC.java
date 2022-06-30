package com.sy.mealKit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sy.function.MealkitDAO;

@WebServlet("/Mk_MenuInfo_RegReviewC")
public class Mk_MenuInfo_RegReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 * MealkitDAO.viewmealkit(request); MealkitDAO.getMealkit(request);
		 * MealkitDAO.regReviewMealkit(request); MealkitDAO.viewReviewMealkit(request);
		 * request.setAttribute("mealkitPage", "mk_info.jsp");
		 * request.getRequestDispatcher("mealKit/mk_M.jsp").forward(request, response);
		 */
		
		MealkitDAO.getMkdao().regReviewMealkit(request);
		MealkitDAO.getMkdao().viewReviewMealkit(request);	
		request.getRequestDispatcher("mealKit/mk_test.jsp").forward(request, response);
	}

}
