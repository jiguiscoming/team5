package com.oh.foodrecipe;

public class recipeprocessinformation {
	
	private int recipe_pro_no;
	private String recipe_pro_id;
	private String recipe_cooking_no;
	private String recipe_cooking_dc;
	private String recipe_stre_step_image_url;
	private String recipe_step_tip;
	
	public recipeprocessinformation() {
		// TODO Auto-generated constructor stub
	}

	public recipeprocessinformation(int recipe_pro_no, String recipe_pro_id, String recipe_cooking_no,
			String recipe_cooking_dc, String recipe_stre_step_image_url, String recipe_step_tip) {
		super();
		this.recipe_pro_no = recipe_pro_no;
		this.recipe_pro_id = recipe_pro_id;
		this.recipe_cooking_no = recipe_cooking_no;
		this.recipe_cooking_dc = recipe_cooking_dc;
		this.recipe_stre_step_image_url = recipe_stre_step_image_url;
		this.recipe_step_tip = recipe_step_tip;
	}

	public int getRecipe_pro_no() {
		return recipe_pro_no;
	}

	public void setRecipe_pro_no(int recipe_pro_no) {
		this.recipe_pro_no = recipe_pro_no;
	}

	public String getRecipe_pro_id() {
		return recipe_pro_id;
	}

	public void setRecipe_pro_id(String recipe_pro_id) {
		this.recipe_pro_id = recipe_pro_id;
	}

	public String getRecipe_cooking_no() {
		return recipe_cooking_no;
	}

	public void setRecipe_cooking_no(String recipe_cooking_no) {
		this.recipe_cooking_no = recipe_cooking_no;
	}

	public String getRecipe_cooking_dc() {
		return recipe_cooking_dc;
	}

	public void setRecipe_cooking_dc(String recipe_cooking_dc) {
		this.recipe_cooking_dc = recipe_cooking_dc;
	}

	public String getRecipe_stre_step_image_url() {
		return recipe_stre_step_image_url;
	}

	public void setRecipe_stre_step_image_url(String recipe_stre_step_image_url) {
		this.recipe_stre_step_image_url = recipe_stre_step_image_url;
	}

	public String getRecipe_step_tip() {
		return recipe_step_tip;
	}

	public void setRecipe_step_tip(String recipe_step_tip) {
		this.recipe_step_tip = recipe_step_tip;
	}
	
}
