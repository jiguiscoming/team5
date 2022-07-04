<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap" rel="stylesheet">

<link rel="stylesheet" href="recipe/recipe_css/recipe_detailpage.css">

</head>
<body>
	
	<div class="rcp_detail">
	
	<form action="RecipeCookingProcessC">
	
		<table class="rcp_area1">
			<tr class="rcp_pic">
				<td valign="top"><img src="${recipe.recipe_img_url }"></td>
			</tr>
			<tr class="rcp_sumry">
				<td valign="top">${recipe.recipe_sumry}</td>
			</tr>
		</table>
		
		<table class="rcp_area2">
			<tr class="rcp_summary_info">
				<td> ${recipe.recipe_qnt }</td>
				<td> ${recipe.recipe_cooking_time } </td>
				<td> ${recipe.recipe_level_nm }</td>
			</tr>
		</table>
	
	<!-- 재료 -->	

		<table class="rcp_area3">
			<tr>
				<td valign="top" style="font-weight: bold; font-size: 50pt; ">재료</td>
			</tr>
			<c:forEach items="${recipeingredients }" var="r">
				<tr class="rcp_ingredients">
					<td> ${r.recipe_irdnt_nm}</td>
					<td> ${r.recipe_irdnt_cpcty}</td>
				</tr>
			</c:forEach>
		</table>
	
	
	<!-- 
		조리순서
	 -->
	
		<table class="rcp_area4">
			<tr>
				<td style="font-weight: bold; font-size: 35pt;">조리순서</td>
			</tr>
		
			<c:forEach items="${recipeprocessinformation }" var="r">
				<tr class="rcp_cooking_order">
					<td>${r.recipe_cooking_no }</td>
					<td>${r.recipe_cooking_dc }</td>
					<td> <img src="${r.recipe_stre_step_image_url }" alt=""> </td>
				</tr>
			</c:forEach>
		</table>
	
	
	</form>
	
	</div>
</body>
</html>