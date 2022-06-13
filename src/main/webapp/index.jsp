<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- loginPage , contentPage 컨트롤러 생성시 꼭 넣어주세요! -->
<!-- href="#"는 이동 안 되게 넣어뒀습니다. 본인 컨트롤러로 이동하게 만드시면 됩니다. -->

<table border="1">
	<tr>
		<td colspan="2">야너두 레시피</td>
		<td colspan="2"><jsp:include page="${loginPage}"></jsp:include></td>
	</tr>
	<tr>
		<td colspan="4"><input value="검색창"></td>
	</tr>
	<tr>
		<td><a href="#">레시피 공유</a></td>
		<td><a href="#">공구</a></td>
		<td><a href="#">밀키트 몰</a></td>
		<td><a href="FoodRecipeC">오늘 뭐 먹지?</a></td>
	</tr>
	<tr>
		<td colspan="4"><jsp:include page="${contentPage }"></jsp:include></td>
	</tr>
</table>


</body>
</html>