<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

내 정보 !!

<table>

<tr>
<td colspan="2">회원가입!!@!</td>
</tr>


<tr>
<td>이름</td>
<td>${sessionScope.accountInfo.account_name }<td>
</tr>
<tr>
<td>닉네임</td>
<td>${sessionScope.accountInfo.account_name }<td>
</tr>

<td>비밀번호</td>
<td><button onclick="location.href='account_updatePWconfirmC'">비밀번호 변경</button><td>
</tr>


<tr>
<td>나이</td>
<td>${sessionScope.accountInfo.account_name }<td>
</tr>


<tr>
<td>성별</td>
<td>${sessionScope.accountInfo.account_name }<td>
<td></td>
</tr>


<tr>
<td>생년월일</td>
<td>${sessionScope.accountInfo.account_name }<td>
<td></td>
</tr>



<tr>
<td>이메일</td>
<td>${sessionScope.accountInfo.account_name }<td>
<td></td>
</tr>


<tr>
<td>휴대폰</td>
<td>${sessionScope.accountInfo.account_name }<td>
<td></td>
</tr>



<tr>
<td>프로필 사진 등록!!</td>
<td><img src="account/img/${sessionScope.accountInfo.account_name}"><td>
<td></td>
</tr>



<tr>
<td></td>
<td><button onclick="form.action='joinusConfirmC'">수정하기!!!</button>
<button onclick="form.action='createC'">가입하기!</button></td>
</tr>



<tr>
<td></td>
<td></td>
</tr>







</table>





</body>
</html>