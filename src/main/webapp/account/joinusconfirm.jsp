<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="">

<table>

<tr>
<td colspan="2">회원가입!!@!</td>
</tr>


<tr>
<td>이름</td>
<td>${join_name }<td>
</tr>
<tr>
<td>닉네임</td>
<td>${join_nick }<td>
</tr>


<tr>
<td>나이</td>
<td>${join_age }<td>
</tr>


<tr>
<td>성별</td>
<td>${join_gender }<td>
<td></td>
</tr>


<tr>
<td>생년월일</td>
<td>${join_name }<td>
<td></td>
</tr>


<tr>
<td>아이디</td>
<td>${join_id }<td>
</tr>


<tr>
<td>비밀번호 확인 질문</td>
<td>${join_pwquestion }<td>
<td></td>
</tr>


<tr>
<td>답변</td>
<td>${join_pwquestiona }<td>
<td></td>
</tr>


<tr>
<td>이메일</td>
<td>${join_email }<td>
<td></td>
</tr>


<tr>
<td>휴대폰</td>
<td>${join_phone }<td>
<td></td>
</tr>



<tr>
<td>프로필 사진 등록</td>
<td><img src="account/img/${join_profile}"><td>
<td></td>
</tr>

<tr>
<td></td>
<td><button>수정하기</button><button onclick="createC">가입하기</button></td>
</tr>


<tr><td>
<input type="hidden" name="agree1" value="${param.agree1 }"> 
<input type="hidden" name="agree2" value="${param.agree2 }"> 
<input type="hidden" name="agree3" value="${param.agree3 }"> 
<input type="hidden" name="agree4" value="${param.agree4 }"> 
<input type="hidden" name="join_name" value="${param.join_name }"> 
<input type="hidden" name="join_nick" value="${param.join_nick }"> 
<input type="hidden" name="join_id" value="${param.join_id }"> 
<input type="hidden" name="join_age" value="${param.join_age }"> 
<input type="hidden" name="join_gender" value="${param.join_gender }"> 
<input type="hidden" name="join_birth" value="${param.join_birth }"> 
<input type="hidden" name="join_pw" value="${param.join_pw }"> 
<input type="hidden" name="join_pw2" value="${param.join_pw2 }"> 
<input type="hidden" name="join_pwquestion" value="${param.join_pwquestion }"> 
<input type="hidden" name="join_pwquestiona" value="${param.join_pwquestiona }"> 
<input type="hidden" name="join_email" value="${param.join_email }"> 
<input type="hidden" name="join_addr" value="${param.join_addr }"> 
<input type="hidden" name="join_profile" value="${join_profile}"> 
</td></tr>





<tr>
<td></td>
<td></td>
</tr>







</table>


</form>



</body>
</html>