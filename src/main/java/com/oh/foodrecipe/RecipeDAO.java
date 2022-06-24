package com.oh.foodrecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;



public class RecipeDAO {

	private static ArrayList<recipe> recipes;
	
	
	public static void getAllRecipe(HttpServletRequest request) {

		// 전체 조회 일. crud - r
		
		// 껍데기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from RecipeBasicCourse";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			recipes = new ArrayList<recipe>();
			recipe r = null;
			
			
			while (rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_basic_no(rs.getInt("RECIPE_BASIC_NO"));
				r.setRecipe_id(rs.getString("RECIPE_BASIC_ID"));
				r.setRecipe_nm_ko(rs.getString("RECIPE_NM_KO"));
				r.setRecipe_sumry(rs.getString("RECIPE_SUMRY"));
				r.setRecipe_nation_code(rs.getString("RECIPE_NATION_CODE"));
				r.setRecipe_nation_nm(rs.getString("RECIPE_NATION_NM"));
				r.setRecipe_ty_code(rs.getString("RECIPE_TY_CODE"));
				r.setRecipe_ty_nm(rs.getString("RECIPE_TY_NM"));
				r.setRecipe_cooking_time(rs.getString("RECIPE_COOKING_TIME"));
				r.setRecipe_calorie(rs.getString("RECIPE_CALORIE"));
				r.setRecipe_qnt(rs.getString("RECIPE_QNT"));
				r.setRecipe_level_nm(rs.getString("RECIPE_LEVEL_NM"));
				r.setRecipe_irdnt_code(rs.getString("RECIPE_IRDNT_CODE"));
				r.setRecipe_pc_nm(rs.getString("RECIPE_PC_NM"));
				r.setRecipe_img_url(rs.getString("RECIPE_IMG_URL"));
				r.setRecipe_det_url(rs.getString("RECIPE_DET_URL"));
		
				
				
				recipes.add(r);
			}
			request.setAttribute("recipes", recipes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	
	public static void getRecipe(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from RecipeInformation where RECIPE_BASIC_NO=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			int recipeMaterial = Integer.parseInt(request.getParameter("recipeMaterial"));
			pstmt.setInt(1, recipeMaterial);
			
			
			rs = pstmt.executeQuery();
			recipe r = null;
			
			
			if(rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_basic_no(rs.getInt("RECIPE_BASIC_NO"));
				r.setRecipe_sumry(rs.getString("RECIPE_SUMRY"));
				r.setRecipe_inrdnt_nm("RECIPE_IRDNT_NM");
				r.setRecipe_inrdnt_cpcty("RECIPE_IRDNT_CPCTY");
				r.setRecipe_cooking_dc("RECIPE_COOKING_DC");
				r.setRecipe_stre_step_image_url("RECIPE_STRE_STEP_IMAGE_URL");
				
				request.setAttribute("recipe", r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
		
	}


	
	
	
	public static void paging(int page, HttpServletRequest req) {
		
		req.setAttribute("curPageNo", page);
		
		int cnt = 12;		// 한 페이지당 보여줄 개수
		int total = recipes.size();		// 총 데이터 개수
		int pageCount = (int) Math.ceil((double)total / cnt);
		req.setAttribute("recipesData", total);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("totalData", total);
		int start = total - (cnt * (page -1));
		int end = (page == pageCount)? -1 : start - (cnt + 1);
		
		ArrayList<recipe> items = new ArrayList<recipe>(); 
		for (int i = start-1; i > end; i--) {
			items.add(recipes.get(i));
		}
		req.setAttribute("recipes", items);
	
		
	
	}





}

