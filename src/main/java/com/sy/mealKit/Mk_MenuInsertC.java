package com.sy.mealKit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sy.function.MealkitDAO;

@WebServlet("/Mk_MenuInsertC")
public class Mk_MenuInsertC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
		
		
		
		  request.setAttribute("mealkitPage", "mk_insertM.jsp");
		  request.getRequestDispatcher("mealKit/mk_M.jsp").forward(request, response);
		
		
	
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MealkitDAO.getMkdao().viewmealkit(request);
		MealkitDAO.getMkdao().regmealkit(request);
		request.getRequestDispatcher("mealKit/mk_M.jsp").forward(request, response);
		
		
		
	
	}

	
	
}
