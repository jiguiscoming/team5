<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table id="loginOKTbl">
	<tr>
		<td width="150px"></td>
		
		<td class="loginOK_hello">
			 ${sessionScope.accountInfo.account_nick }님 안녕하세요!
		
			<button class="loginOK_mypage" onclick="location.href='mypageHomeC'">마이 페이지</button>	
		
		
			<button  class="loginOK_logout" onclick="location.href='loginC'">로그아웃</button>	
		</td>
	</tr>
</table>

</body>
</html>