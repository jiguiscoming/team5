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
	
	
	<form action="RecipeCookingProcessC">
	
	<div class="rcp_detail">
	
	<table class="rcp_area1">
		<tr class="rcp_pic">
			<td> <img src="${recipe.recipe_img_url }"></td>
		</tr>
		<tr class="rcp_sumry">
			<td>${recipe.recipe_sumry}</td>
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
			<td>재료</td>
		</tr>
	
	<c:forEach items="${recipeingredients }" var="r">
		<tr class="rcp_ingredients">
			<td> ${r.recipe_irdnt_nm }</td>
			<td> ${r.recipe_irdnt_cpcty }</td>
		</tr>
	</c:forEach>
	</table>
	
	
	<!-- 
		조리순서
	 -->
	
	<table class="rcp_area4">
	<c:forEach items="${recipeprocessinformation }" var="r">
	<tr class="rcp_cooking_order">
		<td>${r.recipe_cooking_dc }</td>
	</tr>
	</c:forEach>
	</table>
	
	
	</div>
		
	</form>
	
	
</body>
</html>