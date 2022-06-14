<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 나중에 세션 끌어와서 확인 -->
<form action="GroupUpdateController" name="groupForm" onsubmit="return group_pwOK()" method="post">
<table>
	<tr>
		<td>비번 확인</td>
	</tr>
	<tr>
		<td><input name="pwCheck"></td>
	</tr>
	<tr>
		<td><button name="pw" value="1234">입력</button></td>
		<td><input type="hidden" name="no" value="${param.no }"></td>
	</tr>
</table>
</form>
</body>
</html>