<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&family=Sunflower:wght@500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/group.css">
<link rel="stylesheet" href="css/group_reg.css">
<link rel="stylesheet" href="css/group_update.css">
<link rel="stylesheet" href="css/group_detail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="js/group.js"></script>
</head>
<body>
<!-- loginPage , contentPage 컨트롤러 생성시 꼭 넣어주세요! -->
<!-- href="#"는 이동 안 되게 넣어뒀습니다. 본인 컨트롤러로 이동하게 만드시면 됩니다. -->

<div class="index_login_box">
	<div><jsp:include page="${loginPage}"></jsp:include></div>
</div>
<table id="indexTbl" border="1">
	<tr>
		<td class="index_titleTd" colspan="5">
			<div class="index_title">
				<a href="HC">야너두 레시피<img src="img/you.png"></a>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="5" class="index_searchTd">
			<div class="index_search">
				<input placeholder="검색어를 입력하세요">
				<button>검색</button>
			</div>
		</td>
	</tr>
	<tr>
		<td class="index_menu"><div class="index_menu_box"><a href="#">레시피 공유</a></div></td>
		<td class="index_menu"><div class="index_menu_box"><a href="GroupController?region=전국&pageNum=1&search=">공구</a></div></td>
		<td class="index_menu"><div class="index_menu_box"><a href="#">밀키트 몰</a></div></td>
		<td class="index_menu"><div class="index_menu_box"><a href="#">오늘 뭐 먹지?</a></div></td>
		<td></td>
	</tr>
</table>
<table id="index_contentTbl">
	<tr>
		<td colspan="4"><jsp:include page="${contentPage }"></jsp:include></td>
	</tr>
</table>	


</body>
</html>