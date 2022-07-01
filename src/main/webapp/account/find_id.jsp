<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="find_idCR">
<table   id="find_T">
<tr>
<td class="find_title">아이디 찾기!!</td>
</tr>



<tr>
<td class="find_txt" >등록된 이메일을 입력해 주세요.<br>

등록된 이름과 이메일 주소가 같아야 아이디를 찾을 수 있습니다!!</td>
</tr>

<tr>
<td> <input type="email" name="W_email"  class="login_result_txt"> </td>
</tr>
<tr>
<td class="find_txt"> 등록된 이름을 입력해 주세요. </td>
</tr>
<tr>
<td> <input name="W_name"  clospan="2"  class="login_result_txt"> </td>
</tr>

<tr>
<td> <button  class="find_button"> 확인 </button> 


</form>




 <input  class="find_button" type="button" value="비밀번호 찾기는 이쪽!"  onclick="location.href='find_pwC'"></input></td>
</tr>



</table>



</body>
</html>