package com.oh.foodrecipe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/RecipeSearchC")
public class RecipeSearchC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RecipeDAO.getMkdao().searchRecipe(request);
			UserDAO.getMkdao().loginCheck(request);
			request.setAttribute("contentPage", "recipe/recipe_jsp/food_recipe.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
