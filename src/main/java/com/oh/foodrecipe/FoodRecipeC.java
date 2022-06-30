package com.oh.foodrecipe;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;



@WebServlet("/FoodRecipeC")
public class FoodRecipeC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecipeDAO.getMkdao().getAllRecipe(request); // getMkda().객체안에 있는 con를 쓰는 기능만 
		RecipeDAO.paging(1, request);
		
		request.setAttribute("loginPage", "account/loginBtn_recipe.jsp");
		request.setAttribute("contentPage", "recipe/recipe_jsp/food_recipe.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	
	}

}
