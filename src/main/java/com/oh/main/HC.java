 package com.oh.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oh.account.UserDAO;

@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* 정연씨가 만든 로그인체크 기능 모든 컨트롤러에 넣어주세요! */
		/* 첨에 있던 loginBtn은 빼주시고요 */
		

		// 밀키트 new
		HomeDAO.getMkdao().getMealkits(request); 
		
		// 레시피 랜덤 5개
//		HomeDAO.getMkdao().getRecipes(request);
		// 공구 지역에 맞게 최신 5개
		HomeDAO.getMkdao().getGroups(request);
		UserDAO.getMkdao().loginCheck(request);
		
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
