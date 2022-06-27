<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야너두 레시피</title>
</head>
<body>
<table id="homeTbl" border="1">
	<tr>
		<td>
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
		<td>
			<h2>밀키트 best5</h2>
			<div class="home_mealkit_best"></div>
			<div class="home_mealkit_best"></div>
			<div class="home_mealkit_best"></div>
			<div class="home_mealkit_best"></div>
		</td>
	</tr>
	<tr>
		<td>
			<h2>추천 레시피</h2>
			<div class="home_recommend"></div>
			<div class="home_recommend"></div>
			<div class="home_recommend"></div>
			<div class="home_recommend"></div>
		</td>
	</tr>
	<tr>
		<td>
			<h2>오늘의 레시피</h2>
			<div class="home_recipe"></div>
			<div class="home_recipe"></div>
			<div class="home_recipe"></div>
			<div class="home_recipe"></div>
		</td>
	</tr>
</table>
</body>
</html>