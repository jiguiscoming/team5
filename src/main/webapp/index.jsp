<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야너두 레시피</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&family=Sunflower:wght@500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="account_css/loginBtn.css">
<link rel="stylesheet" href="account_css/loginOK.css">
<link rel="stylesheet" href="account_css/loginResult.css">
<link rel="stylesheet" href="account_css/account_find.css">
<link rel="stylesheet" href="account_css/account_table.css">
<link rel="stylesheet" href="group_css/group.css">
<link rel="stylesheet" href="group_css/group_reg.css">
<link rel="stylesheet" href="group_css/group_update.css">
<link rel="stylesheet" href="group_css/group_detail.css">
<link rel="stylesheet" href="mypage_css/mypage_home.css">
<link rel="stylesheet" href="mypage_css/account_information.css">
<link rel="stylesheet" href="mypage_css/account_updatePWR.css">
<link rel="stylesheet" href="mypage_css/account_message.css">
<link rel="stylesheet" href="mypage_css/account_message_detail.css">
<script type="text/javascript" src="js/group.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/agree.js"> </script>

	
</script>
<script type="text/javascript" src="js/ACCheck.js">
	
</script>
<script type="text/javascript" src="js/validCheck.js">
	
</script>




<!-- jy js파일 -->
<!--  <script type="text/javascript" src="agree.js"> </script>
 <script type="text/javascript" src="ACCheck.js"> </script>
 <script type="text/javascript" src="validCheck.js"> </script>
<script type="text/javascript" src = "jQuery.js"></script> -->
<!-- jy js파일 -->



</head>
<body>
<!-- loginPage , contentPage 컨트롤러 생성시 꼭 넣어주세요! -->
<!-- href="#"는 이동 안 되게 넣어뒀습니다. 본인 컨트롤러로 이동하게 만드시면 됩니다. -->

<div class="index_login_box">
	<jsp:include page="${loginPage}"></jsp:include>
</div>
<table id="indexTbl">
	<tr>
		<td class="index_titleTd" colspan="5">
			<div class="index_title">
				<a href="HC">야너두 레시피<img src="img/you.png"></a>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="index_menu">
				<div class="index_menu_box"><a href="FoodRecipeC">레시피 공유</a></div>
				<div class="index_menu_box"><a href="GroupController?region=전국&pageNum=1&search=">공구</a></div>
				<div class="index_menu_box"><a href="Mk_MenuC">밀키트 몰</a></div>
			</div>
		</td>
	</tr>
</table>
<table id="index_contentTbl">
	<tr>
		<td colspan="4"><jsp:include page="${contentPage }"></jsp:include></td>
	</tr>
</table>

<table id="footerTbl">
	<tr>
		<td><span class="footer_title">야너두 레시피<img src="img/you.png"></span></td>
		<td>
			<span class="footer_call">고객센터</span>
			<br>
			<span class="footer_phone">1111-0000</span>
			<br>
			<br>
			<span class="footer_work">MON-FRI 10:00 ~ 17:00</span>
			<br>
			<span class="footer_dayoff">SAT/SUN/HOLIDAY OFF</span>
		</td>
	</tr>
	<tr>
		<td>
			<span>
				회사소개 | 이용약관 | 개인정보처리방침 | 이용안내 
			</span>
		</td>
	</tr>
	<tr>
		<td class="footer_info">
			<span>상호 : 주식회사 야너두레시피</span>
			<span>대표 : 오 팀</span>
			<span>사업자등록번호 :000-00-00000</span>
			<span>통신판매업신고번호 :제5기-야-0802호</span>
			<br>
			<span>대표번호 :1111-0000</span>
			<span>팩스번호 :02-111-0000</span>
			<br>
			<span>OEM,입점 문의 :sales@yanodu.recipe</span>
			<span>광고 마케팅 문의 :mkt@yanodu.recipe</span>
			<br>
			<span>주소 :서울 종로구 종로12길 802</span>
			<span>개인정보관리자 :oh</span>
			<span>호스팅제공 : 소루데스쿠(주)</span>
			<br>
			<span>copyright (c) yanodu.recipe all rights reserved.</span>
		</td>
	</tr>
</table>


</body>
</html>