package com.oh.foodrecipe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/RecipePageC")
public class RecipePageC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int p = Integer.parseInt(request.getParameter("p"));
		
		UserDAO.getMkdao().loginCheck(request);
		RecipeDAO.getMkdao().getAllRecipe(request);
		RecipeDAO.paging(p, request);
		
		
		request.setAttribute("contentPage", "recipe/recipe_jsp/food_recipe.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
