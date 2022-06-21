<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="groupUpdateForm" action="GroupUpdateController" method="post" onsubmit=" return groupUpdate_isEmpty()">
<table id="" border="1">
	<tr>
		<td>
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
		</td>
	</tr>
	
	<tr>
		<td><input value="${group.title}" name="title"></td>
	</tr>
	<tr>
		<td><textarea name="txt">${group.txt }</textarea></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" name="region" value="전국">
			<input type="hidden" name="research">
			<input type="hidden" name="pageNum" value="1">
			<button name="no" value="${group.no }">수정하기
			<button onclick="groupDel(${group.no})">삭제</button>
		</button></td>
	</tr>
</table>
</form>



</body>
</html>