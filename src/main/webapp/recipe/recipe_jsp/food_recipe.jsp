<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="recipe/recipe_css/recipe.css">
<script type="text/javascript"  src="jquery.js"></script>

<body>
	
	<div style="width: 1400px; margin: 0 auto;">	
	<div>
		<table class="rcp_cate">
			<tr>
				<th class="cate_lists">
					<span>나라별</span><br>
					<span>난이도별</span><br>
					<span>재료별</span><br>
					<span>조리시간별</span><br>
				</th>
				<td>
					<div class="cate_list">
						<a>전체</a>
						<a>동남아시아</a>
						<a>서양</a>
						<a>이탈리아</a>
						<a>일본</a>
						<a>중국</a>
						<a>퓨전</a>
						<a>한식</a>
					</div>
					<div class="cate_list">
						<a>전체</a>
						<a>초보환영</a>
						<a>보통</a>
						<a>어려움</a>
					</div>
					<div class="cate_list">
						<a>전체</a>
					</div>
					<div class="cate_list">
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
				
				<span>총 <b>${recipesData}</b> 레시피가 있습니다</span>
				
			<div class="sort_area">
				<select class="sort-selector" name="sort">
					<option value="rct">최신순 정렬</option>
					<option value="rlv">정확도순 정렬</option>
				</select>
			</div>
		</div>
		
	
		<ul class="list_recipes">
			<c:forEach items="${recipes }" var="r">
				<li class="list_recipe">
					<div>
						<div id="list_recipe_img">
							<a href="RecipeCookingProcessC?recipeSummary=${r.recipe_basic_no }"><img src="${r.recipe_img_url }"></a>
						</div>					
						<div id="list_recipe_sumry">
							<a href="RecipeCookingProcessC?recipeSummary=${r.recipe_basic_no}">${r.recipe_sumry }</a>
						</div>
						<div id="list_cooking">
							<div>${r.recipe_cooking_time }</div>
							<div>${r.recipe_level_nm }</div>
						</div>
					</div>					
				</li>
					</c:forEach>
						
				<li style="text-align: center; ">
					<div style="display: inline-block; margin-top: 100px;">
						<c:if test="${curPageNo > 1 }">
							<a href="RecipePageC?p=${curPageNo >= -1 }">[이전]</a>
						</c:if>
							<c:forEach var="i" begin="1" end="${pageCount }">
								<a href="RecipePageC?p=${i }">[${i }] </a>
							</c:forEach>
						<c:if test="${curPageNo != pageCount }">	
							<a href="RecipePageC?p=${curPageNo + 1 }">[다음]</a>
						</c:if>
					</div>	
				</li>
				</ul>		
		</div>
	</div>
	</div>


</body>
</html>