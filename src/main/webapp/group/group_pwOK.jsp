<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
<!-- 나중에 세션 끌어와서 확인 -->
<form action="GroupUpdateController" name="groupForm" onsubmit="return group_pwOK()" method="post">
<table id="group_update_pwTbl">
	<tr>
		<td><div class="group_update_pwTitle">비밀번호 확인</div></td>
	</tr>
	<tr>
		<td class="group_update_pw"><input type="password" name="pwCheck" placeholder="비밀번호를 입력하세요"></td>
	</tr>
	<tr>
		<td class="group_update_pwBtn">
			<input type="hidden" name="no" value="${param.no}">
			<button name="pw" value="${sessionScope.accountInfo.account_pw}">입력</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>