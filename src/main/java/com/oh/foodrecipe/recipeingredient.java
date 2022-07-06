package com.oh.foodrecipe;

public class recipeingredient {
	
	private int recipe_in_no;
	private String recipe_in_id;
	private String recipe_irdnt_sn;
	private String recipe_irdnt_nm;
	private String recipe_irdnt_cpcty;
	private String recipe_irdnt_ty_code;
	private String recipe_ty_nm;
	
	public recipeingredient() {
		// TODO Auto-generated constructor stub
	}

	public recipeingredient(int recipe_in_no, String recipe_in_id, String recipe_irdnt_sn, String recipe_irdnt_nm,
			String recipe_irdnt_cpcty, String recipe_irdnt_ty_code, String recipe_ty_nm) {
		super();
		this.recipe_in_no = recipe_in_no;
		this.recipe_in_id = recipe_in_id;
		this.recipe_irdnt_sn = recipe_irdnt_sn;
		this.recipe_irdnt_nm = recipe_irdnt_nm;
		this.recipe_irdnt_cpcty = recipe_irdnt_cpcty;
		this.recipe_irdnt_ty_code = recipe_irdnt_ty_code;
		this.recipe_ty_nm = recipe_ty_nm;
	}

	public int getRecipe_in_no() {
		return recipe_in_no;
	}

	public void setRecipe_in_no(int recipe_in_no) {
		this.recipe_in_no = recipe_in_no;
	}

	public String getRecipe_in_id() {
		return recipe_in_id;
	}

	public void setRecipe_in_id(String recipe_in_id) {
		this.recipe_in_id = recipe_in_id;
	}

	public String getRecipe_irdnt_sn() {
		return recipe_irdnt_sn;
	}

	public void setRecipe_irdnt_sn(String recipe_irdnt_sn) {
		this.recipe_irdnt_sn = recipe_irdnt_sn;
	}

	public String getRecipe_irdnt_nm() {
		return recipe_irdnt_nm;
	}

	public void setRecipe_irdnt_nm(String recipe_irdnt_nm) {
		this.recipe_irdnt_nm = recipe_irdnt_nm;
	}

	public String getRecipe_irdnt_cpcty() {
		return recipe_irdnt_cpcty;
	}

	public void setRecipe_irdnt_cpcty(String recipe_irdnt_cpcty) {
		this.recipe_irdnt_cpcty = recipe_irdnt_cpcty;
	}

	public String getRecipe_irdnt_ty_code() {
		return recipe_irdnt_ty_code;
	}

	public void setRecipe_irdnt_ty_code(String recipe_irdnt_ty_code) {
		this.recipe_irdnt_ty_code = recipe_irdnt_ty_code;
	}

	public String getRecipe_ty_nm() {
		return recipe_ty_nm;
	}

	public void setRecipe_ty_nm(String recipe_ty_nm) {
		this.recipe_ty_nm = recipe_ty_nm;
	}
}