<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Mealkit-QnA</title>
<link rel="stylesheet" href="../mealkit_css/mk_QnA.css">
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
</head>
<body>


	<table class="mk_QnA_tbl" border="1">
		<tr>
			<td>상품문의 쓰기</td>
		</tr>
		<tr>
			<td><img class="mk_QnA_img" src="img/${Mealkit.mealkit_img }">
			</td>
			<td>${Mealkit.mealkit_name }</td>
		</tr>
	</table>



	<form action="../Mk_MenuInfo_AnswerC" method="get">
		<table border="1" class="mk_QnA_tbl1">
			<tr>
				<td class="mk_QnA_td1">말머리</td>
				<td>상품문의답변</td>
			</tr>
			<tr>
				<td class="mk_QnA_td1">제목</td>
				<td><input style="width: 500px;" placeholder="제목을 입력해주세요."
					name="mealkit_QnA_Answer_title"></td>
			</tr>
			<tr>
				<td class="mk_QnA_td1">내용</td>
				<td><textarea style="width: 650px; height: 350px;" name="mealkit_QnA_Answer_txt"></textarea></td>
			</tr>
		</table>

		<table class="mk_QnA_tbl2">
			<tr>
				<td>
					<button onclick="window.close()">취소</button>
				</td>
				<td>
					<button id="mealkit_Answer_QnA_no" name="mealkit_Answer_QnA_no"	value="${param.no }">등록</button>
				</td>
			</tr>

		</table>
	</form>


</body>
</html>