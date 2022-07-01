<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<script type="text/javascript">
	function review_QnA() {
			window.open("<%=request.getContextPath()%>/mealKit/mk_QnA.jsp" , "QnA" , "width = 800 , height=1200" )
			 
	}

</script>
<script type="text/javascript">
	function review_QnA_A(no) {
		alert(no);
		
		window.open('mealKit/mk_QnA_A.jsp?no=' + no , "QnA_Answer" , "width = 800 , height=1200" )
			 
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
				<img src="mk_img/${Mealkit.mealkit_img }" style="width: 100%">
				<!-- <div class="text">Caption Text</div> -->
			</div>

			<div class="mySlides fade">
				<div class="numbertext">2 / 3</div>
				<img
					src="https://www.mychef.kr/data/goods/22/02/07/1000002150/1000002150_detail_481.jpg"
					style="width: 100%">
				<!-- <div class="text">Caption Two</div> -->
			</div>

			<div class="mySlides fade">
				<div class="numbertext">3 / 3</div>
				<img
					src="https://www.mychef.kr/data/goods/22/02/07/1000002150/1000002150_detail_518.jpg"
					style="width: 100%">
				<!-- <div class="text">Caption Three</div> -->
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
		<table  class="mk_Info_tbl1" >
			<tr class="mk_Info_cel_tr1">
				<td colspan="2"
					style="font-weight: bold; font-size: 16px;">[야너두] ${Mealkit.mealkit_name }</td>
					

			</tr>
			<tr >
				<td class="mk_Info_td1">짧은설명</td>
				<td class="mk_Info_td2">우리남편 영양만점 간식 우리아이 술안주</td>
			
			</tr>
			<tr>
				<td class="mk_Info_td1">판매가</td>
				<td class="mk_Info_td2">${Mealkit.mealkit_price }원</td>
			

			</tr>
			<tr class="mk_Info_cel_tr4" style="border-bottom: 1px solid #999999;"  >
				<td class="mk_Info_td1">수량</td>
				<td class="mk_Info_td3"> ${Mealkit.mealkit_name } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type=hidden name="sell_price"
					value="${Mealkit.mealkit_price }"> <input type="text"
					name="amount" value="1" size="3" onchange="change();"> <input
					type="button" value=" + " onclick="add();"> <input
					type="button" value=" - " onclick="del();"></td>
				

			</tr>
			<tr>
				<td class="mk_Info_td1" style="font-weight: 900; color: black; font-size: 14px;">총
					상품금액</td>
				<td class="mk_Info_td4" style="font-weight: 900; color: black;">
					<input style="font-weight: 900; color: black;" type="text"
					name="sum" size="13" readonly> 원
				</td>
				

			</tr>
			<tr>
				 <tr>
            <td colspan="2" style="text-align: center;"><button class="mk_Info_td3_button1">찜하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="mk_Info_td3_button" onclick="">구매하기</button> </td>
        </tr>
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

	</table>
	<table style="text-align: center;">
		<tr>
			<td><img style="text-align: center;"
				src="http://mychef.godohosting.com/godo5/product/bulgogi_quesadilla.jpg">
				<img style="text-align: center;"
				src="http://mychef.godohosting.com/godo5/common/cookingbox.jpg"></td>

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
	</table>

	<table class="mk_Info_menuphoto">
		<tr>
			<td><img style="text-align: center;"
				src="https://www.mychef.kr/data/editor/policy/220609/about_mychef_01_120136.jpg"
				title="about_mychef_01_120136.jpg"></td>
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
	</table>

	<table class="mk_Info_menuphoto">
		<tr>
			<td style="text-align: center;"><img style="text-align: center;"
				src="https://www.mychef.kr/data/editor/policy/220609/about_mychef_02_120033.jpg"
				title="about_mychef_02_120033.jpg"></td>
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


	

	

	<table class="mk_Info_write" >
		<tr>
			<td class="mk_Info_wirte_td1">상품후기</td>
			<td style="text-align: right;">
				
				<a id="show" class="mk_info_write_btn" 
				onclick="mk_review_reg('${sessionScope.accountInfo.account_id }', ${Mealkit.mealkit_no })">${sessionScope.accountInfo.account_id }상품후기 글쓰기
				</a>
			</td>
		</tr>
	</table>



	<table class="mk_Info_review"  >

		<c:forEach var="r" items="${MealkitReviewlist }">
			<!-- <table id="faq-title" border="1"> -->
			<tr class="faq-content">
				<td class='star-rating' style="height: 19px;"><span
					style="width:${r.mealkit_review_star }%;"> </span></td>
				<td><button class="question" id="que-${r.mealkit_review_no }">${r.mealkit_review_title }</button></td>
				<td style="text-align: center; font-size: 12px; width: 150px;">${r.mealkit_review_id }</td>
				<td style="text-align: center; font-size: 12px; width: 150px;">${r.mealkit_review_date }</td>
			</tr>
			<tr class="mk_Info_review_ans" >
				<td colspan="4" class="answer" id="ans-${r.mealkit_review_no }">
					${r.mealkit_review_txt }</td>
			</tr>
			<tr></tr>
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

	<table class="mk_Info_write" >
		
		<tr>
			<td class="mk_Info_wirte_td1">상품QnA</td>
			<td style="text-align: right;">  <a href="javascript:review_QnA()" class="mk_info_write_btn">
					<input type="hidden" id="mk_no" value="${Mealkit.mealkit_no }">
					상품문의 글쓰기
			</a></td>

		</tr>

	</table>






	<c:forEach var="q" items="${MealkitQnAlist }">

		<table class="mk_Info_QnA">

			<tr class="faq-content">
				<td style="width: 60px; padding-left:10px; text-align: center; font-size: 12px">
					${q.mealkit_QnA_no }</td>
				<td><button class="Qna" id="q-${q.mealkit_QnA_no }" >${q.mealkit_QnA_title }</button></td>
				<td class="QnA_td" style="width:10%">${q.mealkit_QnA_id }</td>
				<td class="QnA_td">${q.mealkit_QnA_date }</td>
				<td class="QnA_td">${q.mealkit_QnA_Answer_Confirm }</td>

			</tr>
		</table>
		
		<table class="qnA" id="a-${q.mealkit_QnA_no }">
			<tr>
				<td>${q.mealkit_QnA_img }</td>
			</tr>
			<tr>
				<td><img
					src="mealkit_img/icon_qna_q.png"> ${q.mealkit_QnA_title }</td>
			</tr>
			<tr>
				<td>${q.mealkit_QnA_txt }</td>
			</tr>
			<tr>
				<td> <button onclick="reviewQnA_delete(${q.mealkit_QnA_no}, ${q.mealkit_QnA_pw })">삭제</button> <td>
			</tr>
			<tr>
				<td ><img src="mealkit_img/icon_qna_a.png">
					${q.mealkit_QnA_Answer_title }</td>
			</tr>
			<tr>
				<td>${q.mealkit_QnA_Answer_txt }</td>
			</tr>

			<tr>
				
				<td style="text-align: right;">
					<button onclick="review_QnA_A(${q.mealkit_QnA_no } )">답글 달기</button>
				</td>
			</tr>

		</table>

	</c:forEach>







</body>
<script type="text/javascript" src="mealkit_js/mk_slide.js"></script>


<script type="text/javascript">
const items = document.querySelectorAll('.question');
function openCloseAnswer() {
	const answerId = this.id.replace('que', 'ans');

	if (document.getElementById(answerId).style.display === 'table-cell') {
		document.getElementById(answerId).style.display = 'none';
		document.getElementById(this.id + '-toggle').textContent = '+';
	} else {
		document.getElementById(answerId).style.display = 'table-cell';
		document.getElementById(this.id + '-toggle').textContent = '-';
	}
}
items.forEach(item => item.addEventListener('click', openCloseAnswer));



</script>
<script type="text/javascript">
const its = document.querySelectorAll('.Qna');
function openCloseAnswer() {
	const qnAId = this.id.replace('q', 'a');

	if (document.getElementById(qnAId).style.display === 'table') {
		document.getElementById(qnAId).style.display = 'none';

	} else {
		document.getElementById(qnAId).style.display = 'table';
		
	}
}
its.forEach(item => item.addEventListener('click', openCloseAnswer));

</script>

</html>