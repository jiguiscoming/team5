<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../mealkit_css/mk_info.css">
<title>Insert title here</title>
</head>
<body>


	<form name="form" method="POST" action="../Mk_MenuInfo_RegReviewC"
		enctype="multipart/form-data">
		<input name="mealkit_review_mk_no" type="hidden"
			value="${param.no }">
			<input name="mealkit_review_id" type="hidden" value="${param.id }">

		<table class="form-group" style="t-style: solid;"
			border="1">
			<tr>
				<td>제목</td>
				<td><input placeholder="제목을 입력하세요" name="mealkit_review_title"
					style="width: 80%"></td>
			</tr>
			<tr style="border-style: solid;">
				<td>평점</td>
				<td>
					<div class="starpoint_wrap" style="margin-left: 10%">
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
								name="starpoint" id="starpoint_10" class="star_radio" value="10">
							<span class="starpoint_bg"></span>
						</div>
					</div>
				</td>
			</tr>


			<tr>
				<td>내용</td>
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
		<table class="pt-1 text-right" style="margin-left: auto">
			<tr>
				<td>
					<button class="btn btn btn-success" type="submit"
						style="">상품후기등록</button>
				</td>
			</tr>
		</table>
	</form>



</body>
</html>