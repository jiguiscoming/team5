<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="GroupUpdateController" method="post" >
<table id="" border="1">
	<tr>
		<td colspan="2">
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
				<option value="전남">전남</option>
				<option value="전북">전북</option>
				<option value="강원">강원</option>
				<option value="제주">제주</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2"><input value="${group.title}" name="title"></td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="txt">${group.txt }</textarea></td>
	</tr>
	<tr>
		<td><button name="no" value="${group.no }">수정하기</button></td>
		<td><button type="button" onclick="location.href='GroupDeleteController?no=${group.no}'">삭제하기</button></td>
	</tr>
</table>
</form>



</body>
</html>