<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


정보 수정~

<form action="account_informationC" method="post" name="account"
		onsubmit="return call()" enctype="multipart/form-data">

<table>


<tr>
<td> ${sessionScope.accountInfo.account_name }</td>
<td> <input  name="U_name"  value="${sessionScope.accountInfo.account_name }"></td>
</tr>
<tr>
<td>닉네임</td>
<td><input  name="U_nick"  value="${sessionScope.accountInfo.account_nick }"></td>
</tr>


<tr>
<td>나이</td>
<td><input  name="U_age"  value="${sessionScope.accountInfo.account_age }"></td>
</tr>


<tr>
<td>성별</td>
<td><input  name="U_gender"  value="${sessionScope.accountInfo.account_gender }"></td>
<td></td>
</tr>


<tr>
<td>생년월일</td>
<td><input  name="U_birth"  value="${sessionScope.accountInfo.account_birth }"></td>
<td></td>
</tr>



<tr>
<td>이메일!</td>
<td><input  name="U_email"  value="${sessionScope.accountInfo.account_email }"></td>
<td></td>
</tr>


<tr>
<td>휴대폰</td>
<td><input  name="U_phone"  value="${sessionScope.accountInfo.account_phone }"></td>
<td></td>
</tr>






<tr>
<td></td>
<td><button  onclick="location.href='account_informationUpdateC'">수정하기!!!!</button>

</tr>

<tr>
<td></td>
<td></td>
</tr>







</table>

</form>



</body>
</html>