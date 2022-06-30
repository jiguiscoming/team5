<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="recipe/recipe_css/recipe.css">

</head>
<body>
	
	
	<form action="RecipeCookingProcessC">
	
	<table>
		<tr>
			<td> <img src="${recipe.recipe_img_url }"></td>
		</tr>
		<tr>
			<td>${recipe.recipe_sumry}</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td> ${recipe.recipe_qnt }</td>
			<td> ${recipe.recipe_cooking_time } </td>
			<td> ${recipe.recipe_level_nm }</td>
		</tr>
	</table>
	
	<!-- 재료 -->	
	<table>
	
	<c:forEach items="${recipeingredients }" var="r">
		<tr>
			<td> ${r.recipe_irdnt_nm }</td>
			<td> ${r.recipe_irdnt_cpcty }</td>
		</tr>
	</c:forEach>
	</table>
	
	
	<!-- 
		조리순서
	 -->
	
	<table>
	<c:forEach items="${recipeprocessinformation }" var="r">
	<tr>
		<td>${r.recipe_cooking_dc }</td>
	</tr>
	</c:forEach>
	</table>
	
	
	
	
	
	
	
	
	</form>
</body>
</html>