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
<div class="account_message_box"><div >정보 수정</div></div>


<div><br><br></div>
 



		<form action="account_informationUpdateC" method="post">

			<table class="account_table">
				<!-- <thead>
					<tr>

						<th scope="cols">★ ~ 정보 수정</th>
						<th scope="cols"></th>

					</tr>

				</thead> -->
				<tbody>

					<tr>
						<th scope="row">이름</th>
						<td><input name="U_name"
							value="${sessionScope.accountInfo.account_name }"></td>
					</tr>
					<tr>
						<th scope="row">닉네임</th>
						<td><input name="U_nick"
							value="${sessionScope.accountInfo.account_nick }"></td>
					</tr>


					<tr>
						<th scope="row">이메일</th>
						<td><input name="U_email"
							value="${sessionScope.accountInfo.account_email }"></td>
					</tr>


					<tr>
						<th scope="row">휴대폰</th>
						<td><input name="U_phone"
							value="${sessionScope.accountInfo.account_phone }"></td>
					</tr>

				</tbody>



			</table>

<div><br><br></div>




			<table id="A_button_table">


				<tr>

					<td colspan="2"><button class="Account_table_button2"
							onclick="location.href='account_informationUpdateC'">수정하기!</button>
				</tr>

			</table>




		</form>


</body>
</html>