<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script type="text/javascript">
	$(function() {
			
		$("#join_id").keyup(function() {
	
			
	});
	});
</script>






<title>Insert title here</title>
</head>
<body>

	<form action="joinusC" method="post" name="account"
		onsubmit="return call()" enctype="multipart/form-data">

<input type="hidden" name="join_agree1" value="${param.agree1 }">
				
					<input type="hidden" name="join_agree2" value="${param.agree2 }">
					<input type="hidden"  name="join_agree3" value="${param.agree3 }">
					<input  type="hidden" name="join_agree4" value="${param.agree4 }">
		



<div><br><br></div>
<div class="account_message_box"><div >회원가입</div></div>


<div><br><br></div>
 

		<table  class="account_table">

<!-- 


			<tr>
				<td colspan="2">회원가입</td>
			</tr>
 -->
	
			<tr>
				<th scope="row">이름</th>
				<td><input name="join_name" placeholder="이름을 입력하세요"></td>
			</tr>


			<tr>
				<th scope="row">닉네임</th>
				<td><input name="join_nick" placeholder="닉네임을 입력하세요"></td>
			</tr>


			<tr>
				<th scope="row">나이</th>
				<td><input name="join_age" type="number"
					placeholder="나이를 입력하세요!!""></td>
			</tr>


			<tr>
				<th scope="row">성별</th>
				<td><input name="join_gender" type="radio" checked="checked"
					value="남">남<input name="join_gender" type="radio" value="여">여</td>
			</tr>


			<tr>
				<th scope="row">생년월일</th>
				<td><input name="join_birth"
					placeholder="주민등록상으로 기재된 생년월일을 입력해 주세요"></td>
			</tr>

			<!-- jquery 필요 -->
			<tr>
				<th scope="row">아이디</th>
				<td><input id="join_id" name="join_id"
					placeholder="아이디를 입력하세요" /> <!-- id 중복검사를 위한 class -->
			</tr>


			<tr>
				<th scope="row">비밀번호</th>
				<td><input type="password" name="join_pw"
					placeholder="8~15글자로 대문자, 소문자, 숫자 포함하여 만들어 주세요"></td>
			</tr>


			<tr>
				<th scope="row">비밀번호 확인</th>
				<td><input type="password" name="join_pw2"
					placeholder="비밀번호를 한 번 더 입력해 주세요"></td>
			</tr>


			<tr>
				<th scope="row">비밀번호 확인 질문</th>
				<td><select name="join_pwquestion">
						<option value="기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
						<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
						<option value="자신의 보물 제1호는?">자신의 보물 제1호는?</option>
						<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
						<option value="타인이 모르는 자신만의 신체 비밀이 있다면?">타인이 모르는 자신만의 신체 비밀이 있다면?</option>
						<option value="추억하고 싶은 날짜가 있다면?">추억하고 싶은 날짜가 있다면?</option>
						<option value="았던 선물 중 기억에 남는 독특한 선물은?">받았던 선물 중 기억에 남는 독특한 선물은?</option>
						<option value="유년시절 가장 생각나는 친구 이름은?">유년시절 가장 생각나는 친구 이름은?</option>
						<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
						<option value="읽은 책 중에서 좋아하는 구절이 있다면?">읽은 책 중에서 좋아하는 구절이 있다면?</option>
						<option value="자신이 두번째로 존경하는 인물은?">자신이 두번째로 존경하는 인물은?</option>
						<option value="친구들에게 공개하지 않은 어릴 적 별명이 있다면?">친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
						<option value="초등학교 때 기억에 남는 짝꿍 이름은?">초등학교 때 기억에 남는 짝꿍 이름은?</option>
						<option value="다시 태어나면 되고 싶은 것은?">다시 태어나면 되고 싶은 것은?</option>
						<option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
				</select></td>
			</tr>


			<tr>
				<th scope="row">답변</th>
				<td><input name="join_pwquestiona"<%--  placeholder="${비밀번호확인질문 }" --%>></td>
			</tr>


			<tr>
				<th scope="row">이메일</th>
				<td><input name="join_email" type="email"
					placeholder="이메일을 입력하세요"></td>
			</tr>


			<tr>
				<th scope="row">휴대폰</th>
				<td><input name="join_phone" placeholder="전화번호를 입력하세요"></td>
			</tr>

			<!-- 따로 마이페이지에 저장하는 곳을 만들 예정 -->
			<!-- <tr>
<td>주소</td><td><input name="join_addr" placeholder="주소를 입력하세요" ></td>
</tr>
 -->

			<tr>
				<th scope="row">프로필 사진</th>
				<td><input type="file" name="join_profile" id=""></td>
			</tr>
</table>




<div><br><br></div>





 <table id="A_button_table">

			<tr>
				<td><button class="Account_table_button" onclick="submit">가입하기</button></td>
			</tr>


		</table>


	</form>



</body>
</html>