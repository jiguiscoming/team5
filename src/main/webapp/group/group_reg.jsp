<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공구 메이트 찾기</title>
</head>
<body>
<form name="groupRegForm" action="GroupRegController" method="post" enctype="multipart/form-data" onsubmit="return groupReg_isEmpty()">
<table id="group_regTbl">
	<tr>
		<td>
			<div class="group_reg_info">내 동네에서 공구메이트 구하기</div>
		</td>
	</tr>
	<tr>
		<td class="group_reg_title">
			<select name="area">
				<option value="서울">서울</option>
				<option value="부산">부산</option>
				<option value="대구">대구</option>
				<option value="인천">인천</option>
				<option value="광주">광주</option>
				<option value="대전">대전</option>
				<option value="울산">울산</option>
				<option value="세종">세종</option>
				<option value="경기">경기</option>
				<option value="경남">경남</option>
				<option value="경북">경북</option>
				<option value="충남">충남</option>
				<option value="충북">충북</option>
				<option value="전남">전남</option>
				<option value="전북">전북</option>
				<option value="강원">강원</option>
				<option value="제주">제주</option>
			</select>
			<input placeholder="제목" name="title">
		</td>
	</tr>
	<tr>
		<td class="group_reg_txt"><textarea name="txt"></textarea></td>
	</tr>
	<tr>
		<td align="left" style="padding-left: 80px;"><input type="file" name="file"></td>
	</tr>
	<tr>
		<td class="group_reg_btn">
			<button type="button" onclick="history.back()">취소</button>
			<button name="pageNum" value="1">등록</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>