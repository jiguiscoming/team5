package com.oh.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oh.account.UserDAO;
import com.oh.foodrecipe.recipe;
import com.oh.group.Group;
import com.sy.function.Mealkit;

public class HomeDAO {
	//--------------------------------코드추가부분//
			private Connection con;

			private static final HomeDAO HMDAO = new HomeDAO(DBManager.getDbm().connect());

			private HomeDAO() {
				// TODO Auto-generated constructor stub
			}

			private HomeDAO(Connection con) {
				super();
				this.con = con;
			}

			public static HomeDAO getMkdao() {
				return HMDAO;
			}

			//--------------------------------코드추가부분//
			//CONNECTION con = null; <다 지우기
			// 메서드 STATIC 다 지우기
			// FINALLY 밑 블락에 DBManager.getDbm().close(null, pstmt, null); 로 바꿔주기
			// DBManager. 뒤에 DBManager.getDbm().로 바꿔주기
	
	
	public void getMealkits(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum as num, a.* from (select * from mealkit_test order by MEALKIT_DATE desc)a) where num between 1 and 5";		
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Mealkit> mealkits = new ArrayList<Mealkit>();
			Mealkit mealkit = null;
			while(rs.next()) {
				int no = rs.getInt("mealkit_no");
				String name = rs.getString("mealkit_name");
				int price = rs.getInt("mealkit_price");
				String type = rs.getString("mealkit_type");
				String img = rs.getString("mealkit_img");
				String txt = rs.getString("mealkit_txt");
				Date date = rs.getDate("mealkit_date");
				
				mealkit = new Mealkit(no, name, price, type, img, txt, date);
				mealkits.add(mealkit);
			}
			
			request.setAttribute("mealkits", mealkits);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void getRecipes(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select * from RecipeBasicCourse order by DBMS_RANDOM.RANDOM) where rownum < 6";		
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<recipe> recipes = new ArrayList<recipe>();
			recipe recipe = null;
			while(rs.next()) {
				int no = rs.getInt("RECIPE_BASIC_NO");
				String id = rs.getString("RECIPE_BASIC_ID");
				String nm_ko = rs.getString("RECIPE_NM_KO");
				String sumry = rs.getString("RECIPE_SUMRY");
				String nation_code = rs.getString("RECIPE_NATION_CODE");
				String nation_nm = rs.getString("RECIPE_NATION_NM");
				String ty_code = rs.getString("RECIPE_TY_CODE");
				String ty_nm = rs.getString("RECIPE_TY_NM");
				String time = rs.getString("RECIPE_COOKING_TIME");
				String calorie = rs.getString("RECIPE_CALORIE");
				String qnt = rs.getString("RECIPE_QNT");
				String level = rs.getString("RECIPE_LEVEL_NM");
				String irdnt_code = rs.getString("RECIPE_IRDNT_CODE");
				String pc_nm = rs.getString("RECIPE_PC_NM");
				String img = rs.getString("RECIPE_IMG_URL");
				String det = rs.getString("RECIPE_DET_URL");
				
				recipe = new recipe(no, id, nm_ko, sumry, nation_code, nation_nm, ty_code, ty_nm, time, calorie, qnt, level, irdnt_code, pc_nm, img, det, id, qnt, pc_nm, irdnt_code, ty_code, ty_nm, id, irdnt_code, pc_nm, img, det);
				recipes.add(recipe);
			}
			
			request.setAttribute("recipes", recipes);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		
	}

	public void getGroups(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum as num, a.* from (select * from group_purchase where group_purchase.group_area='서울' order by group_date desc)a) where num between 1 and 5";		
		
		//원래는 지역 가지고 와야함
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;
			while(rs.next()) {
				int no = rs.getInt("group_no");
				String id = rs.getString("group_id");
				String title = rs.getString("group_title");
				String txt = rs.getString("group_txt");
				Date date = rs.getDate("group_date");
				String area = rs.getString("group_area");
				int like = rs.getInt("group_like");
				int hits = rs.getInt("group_hits");
				String nickname = rs.getString("group_nickname");
				String img = rs.getString("group_img");
				
				group = new Group(no, id, title, txt, date, area, like, hits, nickname, img);
				groups.add(group);
			}
			
			request.setAttribute("groups", groups);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		
	}
	
	

}
