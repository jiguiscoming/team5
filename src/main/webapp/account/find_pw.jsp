<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="find_pwCR">

		<tr>
			<td>알맞은 아이디와 가입할 때 썼던 비밀번호 질문을 입력해 주세요!</td>
		</tr>
		<tr>
			<td>등록된 정보가 같아야 비밀번호를 찾을 수 있습니다. 개인정보 보호를 위해 비밀번호가 0000으로 변경됩니다.</td>
		</tr>

		<td>등록된 아이디를 입력해 주세요</td>
		</tr>
		<tr>
			<td><input name="W_id"></td>
		</tr>



		<tr>
			<td>비밀번호 확인 질문</td>
			
			</tr><tr>
			
			
			
			<td><select name="W_pwquestion">
					<option value=" 기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
					<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
					<option value="자신의 보물 제1호는?">자신의 보물 제1호는?</option>
					<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
					<option value="타인이 모르는 자신만의 신체 비밀이 있다면?">타인이 모르는 자신만의 신체
						비밀이 있다면?</option>
					<option value="추억하고 싶은 날짜가 있다면?">추억하고 싶은 날짜가 있다면?</option>
					<option value="았던 선물 중 기억에 남는 독특한 선물은?">받았던 선물 중 기억에 남는
						독특한 선물은?</option>
					<option value="유년시절 가장 생각나는 친구 이름은?">유년시절 가장 생각나는 친구 이름은?</option>
					<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
					<option value="읽은 책 중에서 좋아하는 구절이 있다면?">읽은 책 중에서 좋아하는 구절이
						있다면?</option>
					<option value="자신이 두번째로 존경하는 인물은?">자신이 두번째로 존경하는 인물은?</option>
					<option value="친구들에게 공개하지 않은 어릴 적 별명이 있다면?">친구들에게 공개하지 않은
						어릴 적 별명이 있다면?</option>
					<option value="초등학교 때 기억에 남는 짝꿍 이름은?">초등학교 때 기억에 남는 짝꿍
						이름은?</option>
					<option value="다시 태어나면 되고 싶은 것은?">다시 태어나면 되고 싶은 것은?</option>
					<option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
			</select></td>
		</tr>
		
		
		<tr>
			<td>
				답변
			</td>
		</tr>
		
		
		<tr>

			<td><input name="W_pwquestiona"></td>

		</tr>



		<tr>
			<td>
				<button>확인</button>
			</td>
		</tr>
	</form>



</body>
</html>