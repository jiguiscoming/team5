<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginC" method="post">
		<table id="loginTbl">
			<tr>
				<td class="login_id">ID <input name="id"></td>
				<td class="login_pw">PW <input name="pw"></td>
				<td class="login_btn"><button type="submit" >로그인!</button></td>
	</form>
<!-- form 안에 넣어놓으면 loginC로 가는 이슈 때문에 table 끝나기 전에 form 태그를 끝내버렸습니다~!  -->
				<td class="join_btn"><input type="button" value="회원가입" onclick="location.href='agreeC'"></input></td>
				<td class="find_btn"> <input type="button" value="아이디 찾기"  onclick="location.href='find_idC'"></input> </td>
			</tr>
		</table>
</body>
</html>