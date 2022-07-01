<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="account_informationUpdateC" method="post">

<table class="account_table">
 <thead>
<tr>

  <th scope="cols">정보 수정</th>
	<td></td>

</tr>

 </thead>
 <tbody>

<tr>
<th scope="row"> 이름</td>
<td> <input  name="U_name"  value="${sessionScope.accountInfo.account_name }"></td>
</tr>
<tr>
<th scope="row">닉네임</td>
<td><input  name="U_nick"  value="${sessionScope.accountInfo.account_nick }"></td>
</tr>






<tr>
<th scope="row">이메일!</td>
<td><input  name="U_email"  value="${sessionScope.accountInfo.account_email }"></td>
<td></td>
</tr>


<tr>
<th scope="row">휴대폰!</td>
<td><input  name="U_phone"  value="${sessionScope.accountInfo.account_phone }"></td>
<td></td>
</tr>

</tbody>
</table>





<tr>
<td></td>
<td><button  onclick="location.href='account_informationUpdateC'">수정하기!!1!!</button>

</tr>

<tr>
<td></td>
<td></td>
</tr>







</form>



</body>
</html>