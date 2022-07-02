<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" name="account" onsubmit="return call()"
		enctype="multipart/form-data">

		
<div><br><br></div>
<div class="account_message_box"><div >회원가입</div></div>


<div><br><br></div>
 

		<table class="account_table">


			<tr>
				<th scope="row">이름</th>
				<td>${join_name }
				</td>
			</tr>

			<tr>
				<th scope="row">닉네임</th>
				<td>${join_nick }
				</td>
			</tr>


			<tr>
				<th scope="row">나이</th>
				<td>${join_age }
				</td>
			</tr>


			<tr>
				<th scope="row">성별</th>
				<td>${join_gender }
				</td>
			</tr>


			<tr>
				<th scope="row">생년월일</th>
				<td>${join_birth }
				</td>
			</tr>


			<tr>
				<th scope="row">아이디</th>
				<td>${join_id }
				</td>
			</tr>


			<tr>
				<th scope="row">비밀번호 확인 질문</th>
				<td>${join_pwquestion }
				</td>
			</tr>


			<tr>
				<th scope="row">답변</th>
				<td>${join_pwquestiona }
				</td>
			</tr>


			<tr>
				<th scope="row">이메일</th>
				<td>${join_email }
				</td>
			</tr>


			<tr>
				<th scope="row">휴대폰</th>
				<td>${join_phone }
				</td>
			</tr>



			<tr>
				<th scope="row">프로필 사진 등록</th>
				<td><img width="200px" src="account/img/${join_profile}">
				</td>
			</tr>


		</table>
		
		
		
<div><br><br></div>



		
		
		<table id="A_button_table">


			<tr>
				<td><button class="Account_table_button"
						onclick="form.action='joinusConfirmC'">수정하기</button>
					<button class="Account_table_button2"
						onclick="form.action='createC'">가입하기</button></td>
			</tr>

			<!-- onclick="form.action='createC'"  -->








		</table>


		<input type="hidden" name="join_agree1" value="${join_agree1 }">
		<input type="hidden" name="join_agree2" value="${join_agree2 }">
		<input type="hidden" name="join_agree3" value="${join_agree3 }">
		<input type="hidden" name="join_agree4" value="${join_agree4 }">
		<input type="hidden" name="join_name" value="${join_name }"> <input
			type="hidden" name="join_nick" value="${join_nick }"> <input
			type="hidden" name="join_id" value="${join_id }"> <input
			type="hidden" name="join_age" value="${join_age }"> <input
			type="hidden" name="join_gender" value="${join_gender }"> <input
			type="hidden" name="join_birth" value="${join_birth }"> <input
			type="hidden" name="join_pw" value="${join_pw }"> <input
			type="hidden" name="join_pw2" value="${join_pw2 }"> <input
			type="hidden" name="join_pwquestion" value="${join_pwquestion }">
		<input type="hidden" name="join_pwquestiona"
			value="${join_pwquestiona }"> <input type="hidden"
			name="join_email" value="${join_email }"> <input
			type="hidden" name="join_addr" value="${join_addr }"> <input
			type="hidden" name="join_profile" value="${join_profile}"> <input
			type="hidden" name="join_phone" value="${join_phone}">

	</form>



</body>
</html>