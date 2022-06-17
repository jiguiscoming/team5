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
<td>${j_name }<td>
</tr>
<tr>
<td>닉네임</td>
<td>${j_nick }<td>
</tr>


<tr>
<td>나이</td>
<td>${j_age }<td>
</tr>


<tr>
<td>성별</td>
<td>${j_gender }<td>
<td></td>
</tr>


<tr>
<td>생년월일</td>
<td>${j_name }<td>
<td></td>
</tr>


<tr>
<td>아이디</td>
<td>${j_id }<td>
</tr>


<tr>
<td>비밀번호 확인 질문</td>
<td>${j_pwquestion }<td>
<td></td>
</tr>


<tr>
<td>답변</td>
<td>${j_pwquestiona }<td>
<td></td>
</tr>


<tr>
<td>이메일</td>
<td>${j_email }<td>
<td></td>
</tr>


<tr>
<td>휴대폰</td>
<td>${j_phone }<td>
<td></td>
</tr>


<tr>
<td>주소</td>
<td>${j_addr }<td>
<td></td>
</tr>


<tr>
<td>프로필 사진 등록</td>
<td><img src="account/img/${j_profile}"><td>
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
<input type="hidden" name="j_name" value="${param.j_name }"> 
<input type="hidden" name="j_nick" value="${param.j_nick }"> 
<input type="hidden" name="j_id" value="${param.j_id }"> 
<input type="hidden" name="j_age" value="${param.j_age }"> 
<input type="hidden" name="j_gender" value="${param.j_gender }"> 
<input type="hidden" name="j_birth" value="${param.j_birth }"> 
<input type="hidden" name="j_pw" value="${param.j_pw }"> 
<input type="hidden" name="j_pw2" value="${param.j_pw2 }"> 
<input type="hidden" name="j_pwquestion" value="${param.j_pwquestion }"> 
<input type="hidden" name="j_pwquestiona" value="${param.j_pwquestiona }"> 
<input type="hidden" name="j_email" value="${param.j_email }"> 
<input type="hidden" name="j_addr" value="${param.j_addr }"> 
<input type="hidden" name="j_profile" value="${j_profile}"> 
</td></tr>





<tr>
<td></td>
<td></td>
</tr>







</table>


</form>



</body>
</html>