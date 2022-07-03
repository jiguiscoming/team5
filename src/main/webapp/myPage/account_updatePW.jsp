<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<div><br><br></div>




<div class="account_message_box"><div >비밀번호 변경</div></div>
<form action="account_updatePWRC" method="post" name="pwform" onsubmit="return call()">


<div><br><br></div>




<table  id="find_T" >

<tr>
<td  class="find_txt">변경할 비밀번호를 입력해 주세요!</td>


</tr>

<tr>
<td > <input  type="password" class="login_result_txt" name="W_pw"> </td>


</tr>

<tr>
<td  class="find_txt"> 한 번 더 입력해 주세요.</td>


</tr>

<tr>
<td> <input type="password"   class="login_result_txt" name="W_pw2"> </td>


</tr>

<tr>
<td> <button  class="find_button">확인</button> </td>


</table>
</form>



<div><br><br></div>







</body>
</html>