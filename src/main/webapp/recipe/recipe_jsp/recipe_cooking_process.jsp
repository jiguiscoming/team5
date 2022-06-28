<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<td> ${recipe.recipe_cooking_time } </td>
			<td> ${recipe.recipe_level_nm }</td>
			<td> ${recipe.recipe_qnt }</td>
		</tr>
	</table>
	
	<!-- 
		조리순서
	 -->
	
	<table>
	
	<c:forEach items="${recipeingredients }" var="s">
		<tr>
			<td> ${s.recipe_irdnt_nm }</td>
			<td> ${s.recipe_irdnt_cpcty }</td>
		</tr>
	</c:forEach>
	</table>
	
	
	
	<table>
	
	<tr>
		<td>조리설명</td>
		<td>조리사진</td>
	</tr>
	
	</table>
	
	
	
	
	
	
	
	
	</form>
</body>
</html>