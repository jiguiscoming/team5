<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야너두 레시피</title>
</head>
<body>
<table id="homeTbl" border="1">
	<tr>
		<td >
			<div class="home_img1">
				<img src="img/omurice.jpg">
				<span class="home_img_txt1">오늘 저녁 뭐 먹을지 고민이신가요?</span>
 					<input name="search" placeholder="레시피를 검색해보세요">
					<button>검색</button>
			</div>
			<div class="home_img2">
				<img src="img/mate.jpg">
				<span class="home_img_txt2">혼자 사기에는 부담인가요?</span>
				<span class="home_img_txt3">혼자 사기에는 양이 너무 많나요?</span>
				<span class="home_img_txt4">우리동네 공구 메이트를 만들어 봐요</span>
				<button onclick="location.href='GroupController?region=전국&pageNum=1&search='">공구 메이트 만나러 가기</button>
			</div>
		</td>
	</tr>
	<tr>
		<td class="homeTd">
			<h2>새로 들어온 밀키트</h2>
			<c:forEach var="mealkit" items="${mealkits}">
			<div class="home_mealkit">
			<a href="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'">
				<div class="home_mealkit_img"><img src="${mealkit.mealkit_img }"></div>
				<div>${mealkit.mealkit_name}</div>
				<div>${mealkit.mealkit_price }</div>
			</a>	
			</div>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td class="homeTd">
			<h2>오늘의 레시피</h2>
			<c:forEach var="recipe" items="${recipes}">
				<div class="home_recipe">
				<a href="#">
				<div class="home_recipe_img"><img src="${recipe.recipe_img_url }"></div>
				<div>${recipe.recipe_nm_ko}</div>
				</div>
			</a>	
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td class="homeTd">
			<h2>우리 동네 공구메이트</h2>
			<c:forEach var="group" items="${groups }">
			<div class="home_group">
			<a href="GroupDetailController?no=${group.no}">
				<div class="home_group_img"><img src="group_imgFolder/${group.img }"></div>
				<div class="home_group_title">[${group.area }]${group.title}</div>
				<div>${group.nickname }</div>
			</a>	
			</div>
			</c:forEach>
		</td>
	</tr>
</table>
</body>
</html>