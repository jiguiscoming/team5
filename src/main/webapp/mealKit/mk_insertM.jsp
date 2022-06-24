<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="Mk_MenuInsertC" method="post"
		enctype="multipart/form-data">
		<table>

			<tr>
				<td>사진</td>
				<td><input type="file" name="mealkit_img"></td>
			</tr>
			<tr>
				<td>메뉴이름</td>
				<td><input name="mealkit_name"></td>
			</tr>
			<tr>
				<td>종류</td>
				<td><select name="mealkit_type">
						<option  value="kor">한식</option>
						<option  value="ame">양식</option>
						<option  value="jpn">일식</option>
						<option  value="chn">중식</option>
						<option  value="sal">샐러드</option>
				</select>
				</td>
			
			</tr>
			
			<tr>
				<td>가격</td>
				<td><input name="mealkit_price"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td> <textarea name="mealkit_txt"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<button>등록</button>
				</td>
			</tr>

		</table>
	</form>




</body>
</html>