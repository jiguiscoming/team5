package com.oh.foodrecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;



public class RecipeDAO {

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
			ArrayList<recipe> recipes = new ArrayList<recipe>();
			recipe r = null;
			
			
			while (rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_id(rs.getString("RECIPE_ID"));
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
	
	
}
