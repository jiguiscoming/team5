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
			recipe r = null;
			while (rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_basic_no(rs.getInt("RECIPE_BASIC_NO"));
				r.setRecipe_basic_id(rs.getString("RECIPE_ID"));
				r.setRecipe_nm_ko(rs.getString("RECIPE_NM_KO"));
				r.setRecipe_sumry(rs.getString("SUMRY"));
				r.setRecipe_nation_code(rs.getString("NATION_CODE"));
				r.setRecipe_nation_nm(rs.getString("NATION_NM"));
				r.setRecipe_ty_code(rs.getString("TY_CODE"));
				r.setRecipe_ty_nm(rs.getString("TY_NM"));
				r.setRecipe_cooking_time(rs.getString("COOKING_TIME"));
				r.setRecipe_calorie(rs.getString("CALORIE"));
				r.setRecipe_qnt(rs.getString("QNT"));
				r.setRecipe_level_nm(rs.getString("LEVEL_NM"));
				r.setRecipe_irdnt_code(rs.getString("IRDNT_CODE"));
				r.setRecipe_pc_nm(rs.getString("PC_NM"));
				r.setRecipe_img_url(rs.getString("IMG_URL"));
				r.setRecipe_det_url(rs.getString("DET_URL"));
		
				
				recipes.add(r);
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
