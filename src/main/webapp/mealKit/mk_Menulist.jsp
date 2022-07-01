<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="mealkit_js/mealkit.js"></script>
<script type="text/javascript" src="mealkit_js/mk_slide.js"></script>
<script type="text/javascript" src="mealkit_js/mk_info.js"></script>
<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="mealkit_css/mk_slide.css">
<link rel="stylesheet" type="text/css" href="mealkit_css/mk_M.css">
<link rel="stylesheet" type="text/css" href="mealkit_css/mk_info.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<script type="text/javascript">
	$(function() {

		// Menu Tabular
		var $menu_tabs = $('.menu__tabs li a');
		$menu_tabs.on('click', function(e) {
			e.preventDefault();
			$menu_tabs.removeClass('active');
			$(this).addClass('active');

			$('.menu__item').fadeOut(300);
			$(this.hash).delay(300).fadeIn();
		});

	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




			<div class="menu">
		

		<ul class="menu__tabs">
			<li><a class="active" href="#item-1"><i class="fa fa-star"></i> 전체</a></li>
			<li><a href="#item-2"><i class="fa fa-link"></i> 한식</a></li>
			<li><a href="#item-3"><i class="fa fa-photo"></i> 양식</a></li>
			<li><a href="#item-4"><i class="fa fa-user"></i> 일식</a></li>
			<li><a href="#item-5"><i class="fa fa-user"></i> 중식</a></li>
			<li><a href="#item-6"><i class="fa fa-user"></i> 샐러드</a></li>
		</ul>
		<section class="menu__wrapper">
			<article id="item-1" class="menu__item item-active">
				<h3>전체</h3>
				<table border="1"
		class="mk_Menulistbl1" border="1">
		<tr>
			<td ><c:forEach var="m" items="${mealkits }">
					<table border="1" class="mk_MLtbl_1"
						onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'"
						>
						<tr>
							<td class="mk_Ml_td1"><img
							 class="mk_Ml_img"	src="img/${m.mealkit_img }"></td>
						</tr>
						<tr>
							<td class="mk_Ml_td_name">${m.mealkit_name }</td>
						</tr>
						<tr>
							<td>${m.mealkit_no }</td>
						</tr>
						<tr>
							<td class="mk_Ml_td_price">${m.mealkit_price }원</td>
						</tr>
					</table>

				</c:forEach></td>
		</tr>
	</table>
			</article>
			
			<article id="item-2" class="menu__item">
				<h3>한식</h3>
				<table border="1"
		class="mk_Menulistbl1" border="1">
		<tr>
			<td ><c:forEach var="m" items="${korlist }">
					<table border="1" class="mk_MLtbl_1"
						onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'"
						>
						<tr>
							<td class="mk_Ml_td1"><img
							 class="mk_Ml_img"	src="img/${m.mealkit_img }"></td>
						</tr>
						<tr>
							<td class="mk_Ml_td_name">${m.mealkit_name }</td>
						</tr>
						<tr>
							<td>${m.mealkit_no }</td>
						</tr>
						<tr>
							<td class="mk_Ml_td_price">${m.mealkit_price }원</td>
						</tr>
					</table>

				</c:forEach></td>
		</tr>
	</table>
			</article>

			<article id="item-3" class="menu__item">
				<h3>양식</h3>
	<table border="1"
		class="mk_Menulistbl1" border="1">
		<tr>
			<td ><c:forEach var="m" items="${amelist }">
					<table border="1" class="mk_MLtbl_1"
						onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'"
						>
						<tr>
							<td class="mk_Ml_td1"><img
							 class="mk_Ml_img"	src="img/${m.mealkit_img }"></td>
						</tr>
						<tr>
							<td class="mk_Ml_td_name">${m.mealkit_name }</td>
						</tr>
						<tr>
							<td>${m.mealkit_no }</td>
						</tr>
						<tr>
							<td class="mk_Ml_td_price">${m.mealkit_price }원</td>
						</tr>
					</table>

				</c:forEach></td>
		</tr>
	</table>			</article>
	
			<article id="item-4" class="menu__item">
				<h3>일식</h3>
	<table border="1"
		class="mk_Menulistbl1" border="1">
		<tr>
			<td ><c:forEach var="m" items="${jpnlist }">
					<table border="1" class="mk_MLtbl_1"
						onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'"
						>
						<tr>
							<td class="mk_Ml_td1"><img
							 class="mk_Ml_img"	src="img/${m.mealkit_img }"></td>
						</tr>
						<tr>
							<td class="mk_Ml_td_name">${m.mealkit_name }</td>
						</tr>
						<tr>
							<td>${m.mealkit_no }</td>
						</tr>
						<tr>
							<td class="mk_Ml_td_price">${m.mealkit_price }원</td>
						</tr>
					</table>

				</c:forEach></td>
		</tr>
	</table>			</article>
	<article id="item-5" class="menu__item">
				<h3>중식</h3>
	<table border="1"
		class="mk_Menulistbl1" border="1">
		<tr>
			<td ><c:forEach var="m" items="${chnlist }">
					<table border="1" class="mk_MLtbl_1"
						onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'"
						>
						<tr>
							<td class="mk_Ml_td1"><img
							 class="mk_Ml_img"	src="img/${m.mealkit_img }"></td>
						</tr>
						<tr>
							<td class="mk_Ml_td_name">${m.mealkit_name }</td>
						</tr>
						<tr>
							<td>${m.mealkit_no }</td>
						</tr>
						<tr>
							<td class="mk_Ml_td_price">${m.mealkit_price }원</td>
						</tr>
					</table>

				</c:forEach></td>
		</tr>
	</table>			</article>
	<article id="item-6" class="menu__item">
				<h3>샐러드</h3>
	<table border="1"
		class="mk_Menulistbl1" border="1">
		<tr>
			<td ><c:forEach var="m" items="${sallist }">
					<table border="1" class="mk_MLtbl_1"
						onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'"
						>
						<tr>
							<td class="mk_Ml_td1"><img
							 class="mk_Ml_img"	src="img/${m.mealkit_img }"></td>
						</tr>
						<tr>
							<td class="mk_Ml_td_name">${m.mealkit_name }</td>
						</tr>
						<tr>
							<td>${m.mealkit_no }</td>
						</tr>
						<tr>
							<td class="mk_Ml_td_price">${m.mealkit_price }원</td>
						</tr>
					</table>

				</c:forEach></td>
		</tr>
	</table>			</article>
		</section>
		<div class="menu--shadow"></div>
	</div>
			
			
	
	
	<h1>-------------------------------------------------</h1>

	<form action="Mk_MenuInsertC" method="get">
		<table>
			<tr>
				<td>
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>

	


</body>
</html>