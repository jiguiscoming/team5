<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="A_button_table">
		<tr>
			<td style="color=#008000">${r }</td>
		</tr>

	</table>


<div><br><br></div>
<div class="account_message_box"><div >내 정보</div></div>


<div><br><br></div>
 

	<table  class="account_table">



		<tr>
			<th scope="row">이름</th>
			<td>${sessionScope.accountInfo.account_name }
		</tr>
		<tr>
			<th scope="row">닉네임</th>
			<td>${sessionScope.accountInfo.account_nick }
		</tr>

		<th scope="row">비밀번호</th>
		<td><button  class="Account_table_button2" onclick="location.href='account_updatePWconfirmC'">변경하기</button>
		</tr>


		<tr>
			<th scope="row">나이</th>
			<td>${sessionScope.accountInfo.account_age }
		</tr>


		<tr>
			<th scope="row">성별</th>
			<td>${sessionScope.accountInfo.account_gender }
		</tr>


		<tr>
			<th scope="row">생년월일</th>
			<td>${sessionScope.accountInfo.account_birth }
		</tr>



		<tr>
			<th scope="row">이메일</th>
			<td>${sessionScope.accountInfo.account_email }
		</tr>


		<tr>
			<th scope="row">휴대폰</th>
			<td>${sessionScope.accountInfo.account_phone }
		</tr>



		<tr>
			<th scope="row">프로필 사진 등록</th>
			<td><img
				src="account/img/${sessionScope.accountInfo.account_img}">
		</tr>


</table>



<div><br><br></div>






<table  id="A_button_table">



		<tr>
			
			<td><button  class="Account_table_button" onclick="location.href='account_informationUpdateC'">수정하기</button>
		</tr>



		


	</table>





</body>
</html>