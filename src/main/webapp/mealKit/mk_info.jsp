<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous"> -->


<script type="text/javascript">
	function review_QnA() {
			window.open("<%= request.getContextPath() %>/mealKit/mk_QnA.jsp" , "QnA" , "width = 800 , height=1200" )
			 
	}

</script>	

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>







</head>
<body onload="init();">

	<div class="myslides_main">
		<div class="slideshow-container">


			<div class="mySlides fade">
				<div class="numbertext">1 / 3</div>
				<img
					src="img/${Mealkit.mealkit_img }"
					style="width: 100%">
				<div class="text">Caption Text</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">2 / 3</div>
				<img
					src="https://www.mychef.kr/data/goods/22/02/07/1000002150/1000002150_detail_481.jpg"
					style="width: 100%">
				<div class="text">Caption Two</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">3 / 3</div>
				<img
					src="https://www.mychef.kr/data/goods/22/02/07/1000002150/1000002150_detail_518.jpg"
					style="width: 100%">
				<div class="text">Caption Three</div>
			</div>

			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
				onclick="plusSlides(1)">&#10095;</a>

		</div>
		<br>

		<div style="text-align: center">
			<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
				onclick="currentSlide(2)"></span> <span class="dot"
				onclick="currentSlide(3)"></span>
		</div>

	</div>


	<form name="Calculation" method="get">
		<table border="1" class="mk_Info_tbl1">
			<tr>
				<td colspan="2" style="padding-left: 70px">${Mealkit.mealkit_name }</td>

			</tr>
			<tr>
				<td class="mk_Info_td1">판매가</td>
				<td class="mk_Info_td2">${Mealkit.mealkit_price }원</td>
			</tr>
			<tr>
				<td class="mk_Info_td1">수량</td>
				<td class="mk_Info_td2"><input type=hidden name="sell_price"
					value="${Mealkit.mealkit_price }"> <input type="text"
					name="amount" value="1" size="3" onchange="change();"> <input
					type="button" value=" + " onclick="add();"> <input
					type="button" value=" - " onclick="del();"></td>
			</tr>
			<tr>
				<td class="mk_Info_td1" style="font-weight: 900; color: black;">총
					상품금액</td>
				<td class="mk_Info_td2" style="font-weight: 900; color: black;">
					<input style="font-weight: 900; color: black;" type="text"
					name="sum" size="13" readonly> 원
				</td>
			</tr>
			<tr>
				<td class="mk_Info_td1">찜하기</td>
				<td style="text-align: center;">구매하기</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>





	<table class="mk_Info_tbl2">
		<tr>
			<td class="on"><a href="#detail" id="detail">상품상세정보</a></td>
			<td><a href="#package">배송안내</a></td>
			<td><a href="#change">교환 및 반품안내</a></td>
			<td><a href="#review">상품후기</a></td>
			<td><a href="#QnA">상품문의</a></td>
		</tr>
		<tr>
			<td>상품상세정보</td>
		</tr>
		<tr>
			<td><img
				src="http://mychef.godohosting.com/godo5/product/bulgogi_quesadilla.jpg">
				<img src="http://mychef.godohosting.com/godo5/common/cookingbox.jpg"></td>
		</tr>
	</table>



	<table class="mk_Info_tbl2">
		<tr>
			<td><a href="#detail">상품상세정보</a></td>
			<td class="on"><a href="#package" id="package"> 배송안내</a></td>
			<td><a href="#change">교환 및 반품안내</a></td>
			<td><a href="#review">상품후기</a></td>
			<td><a href="#QnA">상품문의</a></td>
		</tr>
		<tr>
			<td><img
				src="https://www.mychef.kr/data/editor/policy/220609/about_mychef_01_120136.jpg"
				title="about_mychef_01_120136.jpg" class="js-smart-img"></td>
		</tr>
	</table>




	<table class="mk_Info_tbl2">
		<tr>
			<td><a href="#detail">상품상세정보</a></td>
			<td><a href="#package">배송안내</a></td>
			<td class="on"><a href="#change" id='change'> 교환 및 반품안내</a></td>
			<td><a href="#review">상품후기</a></td>
			<td><a href="#QnA">상품문의</a></td>
		</tr>
		<tr>
			<td><img
				src="https://www.mychef.kr/data/editor/policy/220609/about_mychef_02_120033.jpg"
				title="about_mychef_02_120033.jpg" class="js-smart-img"></td>
		</tr>

	</table>



	<table class="mk_Info_tbl2">
		<tr>
			<td><a href="#detail">상품상세정보</a></td>
			<td><a href="#package">배송안내</a></td>
			<td><a href="#change">교환 및 반품안내</a></td>
			<td class="on"><a href="#review" id='review'>상품후기</a></td>
			<td><a href="#QnA">상품문의</a></td>
		</tr>
	</table>



	<div style="text-align: right">
		<a href=#none id="show"
			onclick="if(hide.style.display=='none')
					{hide.style.display='';show.innerText='▲접기'}
					else {hide.style.display='none';show.innerText='상품후기글쓰기'}">상품후기글쓰기
		</a>
		<div id="hide" style="display: none">

			<!-- <main role="main" class="container"> -->
			<form name="form" method="POST" action="Mk_MenuInfo_RegReviewC"
				enctype="multipart/form-data">
				<input name="mealkit_review_mk_no" type="hidden"
					value="${Mealkit.mealkit_no }">
				<!-- 	<div class="pt-1"></div>
				<input type="text" name="mealkit_review_title"
					placeholder="제목을 입력하세요"
					style="border-radius: 5px; width: 100%; padding: 5px;">
				
				<div class="pt-1">
					<textarea id="summernote" name="mealkit_review_txt"></textarea>
					contents 
				</div> -->
				<table class="form-group"
					style="border-style: solid; margin-left: auto">
					<tr>
						<td colspan="2"><input placeholder="제목을 입력하세요"
							name="mealkit_review_title" style="width: 80%"></td>
					</tr>
					<tr style="border-style: solid;">
						<td style="width: 10%">평점</td>
						<td>
							<div class="starpoint_wrap">
								<div class="starpoint_box">
									<label for="starpoint_1" class="label_star" title="0.5"><span
										class="blind">0.5점</span></label> <label for="starpoint_2"
										class="label_star" title="1"><span class="blind">1점</span></label>
									<label for="starpoint_3" class="label_star" title="1.5"><span
										class="blind">1.5점</span></label> <label for="starpoint_4"
										class="label_star" title="2"><span class="blind">2점</span></label>
									<label for="starpoint_5" class="label_star" title="2.5"><span
										class="blind">2.5점</span></label> <label for="starpoint_6"
										class="label_star" title="3"><span class="blind">3점</span></label>
									<label for="starpoint_7" class="label_star" title="3.5"><span
										class="blind">3.5점</span></label> <label for="starpoint_8"
										class="label_star" title="4"><span class="blind">4점</span></label>
									<label for="starpoint_9" class="label_star" title="4.5"><span
										class="blind">4.5점</span></label> <label for="starpoint_10"
										class="label_star" title="5"><span class="blind">5점</span></label>
									<input type="radio" name="starpoint" id="starpoint_1"
										class="star_radio" value="1"> <input type="radio"
										name="starpoint" id="starpoint_2" class="star_radio" value="2">
									<input type="radio" name="starpoint" id="starpoint_3"
										class="star_radio" value="3"> <input type="radio"
										name="starpoint" id="starpoint_4" class="star_radio" value="4">
									<input type="radio" name="starpoint" id="starpoint_5"
										class="star_radio" value="5"> <input type="radio"
										name="starpoint" id="starpoint_6" class="star_radio" value="6">
									<input type="radio" name="starpoint" id="starpoint_7"
										class="star_radio" value="7"> <input type="radio"
										name="starpoint" id="starpoint_8" class="star_radio" value="8">
									<input type="radio" name="starpoint" id="starpoint_9"
										class="star_radio" value="9"> <input type="radio"
										name="starpoint" id="starpoint_10" class="star_radio"
										value="10"> <span class="starpoint_bg"></span>
								</div>
							</div>
						</td>
					</tr>


					<tr>
						<td colspan="2"><textarea onclick="this.value=''"
								name="mealkit_review_txt" style="width: 500px; height: 500px;">내용을 입력하세요 </textarea></td>
					</tr>

					<tr>
						<td colspan="1"><input class="form-control form-control-user"
							type="file" name="mealkit_review_img" id="mealkit_review_img"
							onchange="setThumbnail(event);"></td>
						<td><div id="image_container"></div></td>
					</tr>

				</table>
				<script>
					$('#summernote').summernote({
						placeholder : '내용을 입력해주세요',
						tabsize : 2,
						height : 300
					});
				</script>
				<div class="pt-1 text-right" style="margin-left: auto">
					<button class="btn btn btn-success" type="submit"
						style="width: 10%; padding: 5px;">상품후기등록</button>
				</div>
			</form>
		</div>
		<!-- 	</main>		 -->

	</div>


	<table class="mk_Info_review" border="1">
		
		<c:forEach var="r" items="${MealkitReviewlist }">
			<!-- <table id="faq-title" border="1"> -->
			<tr class="faq-content">
				<td class='star-rating' style="height: 21px;"><span
					style="width:${r.mealkit_review_star }%"> </span></td>
				<td><button class="question" id="que-${r.mealkit_review_no }">${r.mealkit_review_title }</button></td>
				<td>${r.mealkit_review_date }</td>
			</tr>
			<tr class="mk_Info_review_bottom">

				<td class="answer" id="ans-${r.mealkit_review_no }">
					${r.mealkit_review_txt }</td>


			</tr>
		</c:forEach>
	</table>






	<table class="mk_Info_tbl2">
		<tr>
			<td><a href="#detail">상품상세정보</a></td>
			<td><a href="#package">배송안내</a></td>
			<td><a href="#change">교환 및 반품안내</a></td>
			<td><a href="#review">상품후기</a></td>
			<td class="on"><a href="#QnA" id='QnA'>상품문의</a></td>
		</tr>
	</table>

	<table>
		<tr>
			<td><a href="../board/list.php?bdId=goodsqa"
				class="btn_qna_more">상품문의 전체보기</a></td>
			<td ><a 
				href="javascript:review_QnA()" 
				 class="btn_qna_write" >상품문의 글쓰기</a></td>
				
		</tr>

	</table>
		
		<table border="1" class="mk_Info_QnA">
		
		<c:forEach var="q" items="${MealkitQnAlist }">
			<!-- <table id="faq-title" border="1"> -->
			<tr class="faq-content" >
				<td style="width: 60px; text-align: center;"> ${q.mealkit_QnA_no } </td>
				<td><button class="Qna" id="q-${q.mealkit_QnA_no }">${q.mealkit_QnA_title }</button></td>
				<td>${q.mealkit_QnA_id }</td>
				<td>${q.mealkit_QnA_date }</td>
			</tr>
			<tr class="mk_Info_QnA_bottom">
				
				<td class="qnA" id="a-${q.mealkit_QnA_no }"> ${q.mealkit_QnA_txt }</td>


			</tr>
		</c:forEach>

		</table>
		
	
	

		
</body>
<script type="text/javascript" src="mealkit_js/mk_slide.js"></script>


<script type="text/javascript">
const items = document.querySelectorAll('.question');
function openCloseAnswer() {
	const answerId = this.id.replace('que', 'ans');

	if (document.getElementById(answerId).style.display === 'block') {
		document.getElementById(answerId).style.display = 'none';
		document.getElementById(this.id + '-toggle').textContent = '+';
	} else {
		document.getElementById(answerId).style.display = 'block';
		document.getElementById(this.id + '-toggle').textContent = '-';
	}
}
items.forEach(item => item.addEventListener('click', openCloseAnswer));



</script>
<script type="text/javascript">
const its = document.querySelectorAll('.Qna');
function openCloseAnswer() {
	const qnAId = this.id.replace('q', 'a');

	if (document.getElementById(qnAId).style.display === 'block') {
		document.getElementById(qnAId).style.display = 'none';
		document.getElementById(this.id + '-toggle').textContent = '+';
	} else {
		document.getElementById(qnAId).style.display = 'block';
		document.getElementById(this.id + '-toggle').textContent = '-';
	}
}
its.forEach(item => item.addEventListener('click', openCloseAnswer));

</script>

</html>