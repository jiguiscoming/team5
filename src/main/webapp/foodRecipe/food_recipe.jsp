<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../recipe_css/recipe.css">
<body>
	
	<form action="FoodRecipeC" method="get">
	<div>
		<table border="1">
			<tr>
				<th>
					<span>나라별</span><br>
					<span>난이도별</span><br>
					<span>재료별</span><br>
					<span>조리시간별</span><br>
				</th>
				<td>
					<div>
						<a>전체</a>
						<a>동남아시아</a>
						<a>서양</a>
						<a>이탈리아</a>
						<a>일본</a>
						<a>중국</a>
						<a>퓨전</a>
						<a>한식</a>
					</div>
					<div>
						<a>전체</a>
						<a>초보환영</a>
						<a>보통</a>
						<a>어려움</a>
					</div>
					<div>
						<a>전체</a>
					</div>
					<div>
						<a>전체</a>
						<a>30분이하</a>
						<a>1시간미만</a>
						<a>1시간이상</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="recipes">
		<div class="innerResult">
			<div class="tit_area">
				<h2>
					총 <b>???</b> 레시피가 있습니다
				</h2>
			<div class="sort_area">
				<select class="sort-selector" name="sort">
					<option value="rct">최신순 정렬</option>
					<option value="rlv">정확도순 정렬</option>
				</select>
			</div>
		</div>
		
		<ul class="list_recipe">
			<li>
				<div>
					<img src="http://file.okdab.com/UserFiles/searching/recipe/000200.jpg">
				</div>
				<div>
					<div>육수로 지은 밥에 야채를 듬뿍 넣은 영양만점 나물비빔밥!</div>
				</div>
			</li>
			<li>
				<div>
					<img src="http://file.okdab.com/UserFiles/searching/recipe/000300.jpg">
				</div>
				<div>
					<div>정월대보름에 먹던 오곡밥! 영양을 한그릇에 담았습니다.</div>
				</div>
			</li>
			<li>
				<div>
					<img src="http://file.okdab.com/UserFiles/searching/recipe/000400.jpg">
				</div>
				<div>
					<div>잡채밥 한 그릇이면 오늘 저녁 끝! 입 맛 없을 때 먹으면 그만이지요~</div>
				</div>
			</li>
			<li>
				<div>
					<img src="http://file.okdab.com/UserFiles/searching/recipe/000600.jpg">
				</div>
				<div>
					<div>다이어트에 으뜸인 콩나물밥. 밥 물 넣을때 평소보다 적게 넣는거 잊지마세요!</div>
				</div>
			</li>
			<li> <button> <a href="recipe_update.jsp">레시피 등록하기</a> </button> </li>
		
		</ul>
		
		
		</div>
		</div>
	</form>
		

</body>
</html>