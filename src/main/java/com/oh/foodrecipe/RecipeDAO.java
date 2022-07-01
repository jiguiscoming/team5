package com.oh.foodrecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oh.main.DBManager;
import com.oh.main.HomeDAO;





public class RecipeDAO {
	
	//--------------------------------코드추가부분//
	private Connection con;

	private static final RecipeDAO RPDAO = new RecipeDAO(DBManager.getDbm().connect());

	private RecipeDAO() {
		// TODO Auto-generated constructor stub
	}

	private RecipeDAO(Connection con) {
		super();
		this.con = con;
	}

	public static RecipeDAO getMkdao() {
		return RPDAO;
	}

	//--------------------------------코드추가부분//
	//CONNECTION con = null; <다 지우기
	// 메서드 STATIC 다 지우기
	// FINALLY 밑 블락에 DBManager.getDbm().close(null, pstmt, null); 로 바꿔주기
	// DBManager. 뒤에 DBManager.getDbm().로 바꿔주기
	

	private static ArrayList<recipe> recipes;
	
	
	public void getAllRecipe(HttpServletRequest request) {

		// ��ü ��ȸ ��. crud - r
		
		// ������
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from RecipeBasicCourse";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			recipes = new ArrayList<recipe>();
			recipe r = null;
			
			
			while (rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_basic_no(rs.getInt("RECIPE_BASIC_NO"));
				r.setRecipe_basic_id(rs.getString("RECIPE_BASIC_ID"));
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
			DBManager.getDbm().close(null, pstmt, rs);
		}
	}
	
	
	public void getRecipe(HttpServletRequest request) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from RecipeBasicCourse where RECIPE_BASIC_NO=?";
			pstmt = con.prepareStatement(sql);
			int recipeSummary = Integer.parseInt(request.getParameter("recipeSummary"));
			pstmt.setInt(1, recipeSummary);
			
			
			rs = pstmt.executeQuery();
			recipe r = null;
			
			
			if(rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_basic_no(rs.getInt("RECIPE_BASIC_NO"));
				r.setRecipe_basic_id(rs.getString("RECIPE_BASIC_ID"));
				r.setRecipe_img_url(rs.getString("RECIPE_IMG_URL"));
				r.setRecipe_sumry(rs.getString("RECIPE_SUMRY"));
				r.setRecipe_qnt(rs.getString("RECIPE_QNT"));
				r.setRecipe_cooking_time(rs.getString("RECIPE_COOKING_TIME"));
				r.setRecipe_level_nm(rs.getString("RECIPE_LEVEL_NM"));
				
				
				request.setAttribute("recipe", r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.getDbm().close(null, pstmt, rs);
		}
		
		
		
		
	}


	public void getingredients(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select RECIPE_IRDNT_NM, RECIPE_IRDNT_CPCTY\r\n"
					+ "from RecipeBasicCourse, RecipeIngredients\r\n"
					+ "where RECIPE_BASIC_NO(+) = RECIPE_IN_ID\r\n"
					+ "and RECIPE_BASIC_NO=?";
			pstmt = con.prepareStatement(sql);
			int recipeSummary = Integer.parseInt(request.getParameter("recipeSummary"));
			pstmt.setInt(1, recipeSummary);
			
			ArrayList<recipeingredient> ingredients = new ArrayList<recipeingredient>();
			
			rs = pstmt.executeQuery();
			recipeingredient ingredient = null;
			
			
			while(rs.next()) {
				// bean
				ingredient = new recipeingredient();
				
				ingredient.setRecipe_irdnt_nm(rs.getString("RECIPE_IRDNT_NM"));  
				ingredient.setRecipe_irdnt_cpcty(rs.getString("RECIPE_IRDNT_CPCTY"));
				
				
				
				ingredients.add(ingredient);
			
			}
			request.setAttribute("recipeingredients", ingredients);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.getDbm().close(null, pstmt, rs);
		}
		
		
		
	}
	public void getrecipeprocessinformation(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select RECIPE_COOKING_DC, RECIPE_STRE_STEP_IMAGE_URL\r\n"
					+ "from RecipeBasicCourse, Recipeprocessinformation\r\n"
					+ "where RECIPE_BASIC_NO = RECIPE_PRO_ID\r\n"
					+ "and RECIPE_BASIC_NO=?";
			pstmt = con.prepareStatement(sql);
			int recipeSummary = Integer.parseInt(request.getParameter("recipeSummary"));
			pstmt.setInt(1, recipeSummary);
			
			ArrayList<recipeprocessinformation> processinformations = new ArrayList<recipeprocessinformation>();
			
			rs = pstmt.executeQuery();
			recipeprocessinformation processinformation = null;
			
			
			while(rs.next()) {
				// bean
				processinformation = new recipeprocessinformation();
				
				processinformation.setRecipe_cooking_dc(rs.getString("RECIPE_COOKING_DC"));  
				
				
				
				processinformations.add(processinformation);
			
			}
			request.setAttribute("recipeprocessinformation", processinformations);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.getDbm().close(null, pstmt, rs);
		}
		
	}
	
	
	
	public static void paging(int page, HttpServletRequest req) {
		
		req.setAttribute("curPageNo", page);
		
		int cnt = 20;		
		int total = recipes.size();		
		int pageCount = (int) Math.ceil((double)total / cnt);
		req.setAttribute("recipesData", total);
		req.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page -1));
		int end = (page == pageCount)? -1 : start - (cnt + 1);
		
		ArrayList<recipe> items = new ArrayList<recipe>(); 
		for (int i = start - 1; i > end; i--) {
			items.add(recipes.get(i));
		}
		req.setAttribute("recipes", items);
	
		
	}

	// 이것도 홈화면 검색기능으로 만듭니다.(지수)
	public void searchRecipe(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String recipeSearch = request.getParameter("search");
			
			String sql = "select * from RecipeBasicCourse where recipe_nm_ko like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + recipeSearch + "%");
			
			rs = pstmt.executeQuery();
			recipes = new ArrayList<recipe>();
			recipe r = null;
			
			
			while (rs.next()) {
				// bean
				r = new recipe();
				r.setRecipe_basic_no(rs.getInt("RECIPE_BASIC_NO"));
				r.setRecipe_basic_id(rs.getString("RECIPE_BASIC_ID"));
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
			DBManager.getDbm().close(null, pstmt, null);
		}
		
	}









}

