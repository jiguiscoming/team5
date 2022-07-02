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
			// 선엽씨 이거 제가 home화면에 검색창 기능 활성화 하려고 만든 컨트롤러 입니다.(지수)
		
			RecipeDAO.getMkdao().getRecipe(request);
			UserDAO.getMkdao().loginCheck(request);
			request.setAttribute("contentPage", "recipe/recipe_jsp/food_recipe.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
