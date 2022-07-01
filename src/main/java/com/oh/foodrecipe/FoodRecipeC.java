package com.oh.foodrecipe;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/FoodRecipeC")
public class FoodRecipeC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecipeDAO.getAllRecipe(request);
		RecipeDAO.paging(1, request);
		
		
		request.setAttribute("loginPage", "account/loginBtn_recipe.jsp");
		request.setAttribute("contentPage", "recipe/recipe_jsp/food_recipe.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	
	}

}
