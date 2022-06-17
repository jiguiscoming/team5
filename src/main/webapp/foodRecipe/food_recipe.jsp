<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../recipe_css/recipe.css">
<body>
	
	
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
					<img src="${r.RECIPE_IMG_URL }">
				</div>
				<div>
					<div>${r.RECIPE_SUMRY }</div>
				</div>
			</li>
			
		</ul>
		
		
		</div>
		</div>

		

</body>
</html>