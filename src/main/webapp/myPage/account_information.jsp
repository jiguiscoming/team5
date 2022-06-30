<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${r }

<table>

<tr>
<td colspan="2"> 내 정보~ </td>
</tr>


<tr>
<td>이름</td>
<td>${sessionScope.accountInfo.account_name }<td>
</tr>
<tr>
<td>닉네임</td>
<td>${sessionScope.accountInfo.account_nick }<td>
</tr>

<td>비밀번호</td>
<td><button onclick="location.href='account_updatePWconfirmC'">비밀번호 변경</button><td>
</tr>


<tr>
<td>나이</td>
<td>${sessionScope.accountInfo.account_age }<td>
</tr>


<tr>
<td>성별</td>
<td>${sessionScope.accountInfo.account_gender }<td>
<td></td>
</tr>


<tr>
<td>생년월일</td>
<td>${sessionScope.accountInfo.account_birth }<td>
<td></td>
</tr>



<tr>
<td>이메일</td>
<td>${sessionScope.accountInfo.account_email }<td>
<td></td>
</tr>


<tr>
<td>휴대폰</td>
<td>${sessionScope.accountInfo.account_phone }<td>
<td></td>
</tr>



<tr>
<td>프로필 사진 등록!!</td>
<td><img src="account/img/${sessionScope.accountInfo.account_img}"><td>
<td></td>
</tr>



<tr>
<td></td>
<td><button onclick="location.href='account_informationUpdateC'">수정하기!!!</button>

</tr>



<tr>
<td></td>
<td></td>
</tr>







</table>





</body>
</html>