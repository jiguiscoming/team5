package com.oh.foodrecipe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/RecipeCookingProcessC")
public class RecipeCookingProcessC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO.getMkdao().loginCheck(request);
		RecipeDAO.getMkdao().getRecipe(request);
		RecipeDAO.getMkdao().getingredients(request);
		RecipeDAO.getMkdao().getrecipeprocessinformation(request);
		
		request.setAttribute("contentPage", "recipe/recipe_jsp/recipe_cooking_process.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
