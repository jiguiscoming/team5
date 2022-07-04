<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야너두 레시피</title>
</head>
<body>
<!-- 시간 계산을 위한 변수 설정 -->
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="HHmm" var="now" />
	<fmt:parseDate var="morning_time" value="1100"  pattern="HHmm"/>
	<fmt:parseDate var="lunch_time" value="1700"  pattern="HHmm"/>
	<fmt:parseDate var="dinner_time" value="2100"  pattern="HHmm"/>
	<fmt:parseDate var="late_night_time" value="0200"  pattern="HHmm"/>
	
	<fmt:formatDate value="${morning_time}" pattern="HHmm" var="morning"/>
	<fmt:formatDate value="${lunch_time}" pattern="HHmm" var="lunch"/>
	<fmt:formatDate value="${dinner_time}" pattern="HHmm" var="dinner"/>
	<fmt:formatDate value="${late_night_time}" pattern="HHmm" var="late_night"/>
	
	
<table id="homeTbl">
	<tr>
		<td >
			<div class="home_img1">
				<img src="img/omurice.jpg">
				<c:choose>
					<c:when test="${late_night < now || now < morning}">
						<span class="home_img_txt1">오늘 아침 뭐 먹을지 고민이신가요?</span>
					</c:when>
					<c:when test="${now < lunch}">
						<span class="home_img_txt1">오늘 점심 뭐 먹을지 고민이신가요?</span>
					</c:when>
					<c:when test="${now < dinner}">
						<span class="home_img_txt1">오늘 저녁 뭐 먹을지 고민이신가요?</span>
					</c:when>
					<c:when test="${dinner < now || now < late_night}">
						<span class="home_img_txt1">오늘 야식 뭐 먹을지 고민이신가요?</span>
					</c:when>
				</c:choose>
 					<form action="RecipeSearchC">
 					<input class="home_img1_input" name="search" placeholder="레시피를 검색해보세요">
					<button class="home_img1_btn">검색</button>
 					</form>
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
			<a href="Mk_MenuInfoC?no=${mealkit.mealkit_no}">
				<div class="home_mealkit_img"><img src="mk_img/${mealkit.mealkit_img }"></div>
				<div class="home_info">${mealkit.mealkit_name}</div>
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
			<a href="RecipeCookingProcessC?recipeSummary=${recipe.recipe_basic_no }">
				<div class="home_recipe_img"><img src="${recipe.recipe_img_url}"></div>
				<div class="home_info">${recipe.recipe_nm_ko}</div>
			</a>	
			</div>
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
				<div class="home_info">[${group.area }]${group.title}</div>
				<div>${group.nickname }</div>
			</a>	
			</div>
			</c:forEach>
		</td>
	</tr>
</table>

</body>
</html>