function call(){
	
	let j_name  = document.account.j_name;
	let j_nick  = document.account.j_nick;
	let j_age = document.account.j_age;
	let j_gender = document.account.j_gender;
	let j_birth = document.account.j_birth;
	let j_id = document.account.j_id;
	let j_pw = document.account.j_pw;
	let j_pw2 = document.account.j_pw2;
	let j_pwquestion = document.account.j_pwquestion;
	let j_pwquestiona = document.account.j_pwquestiona;
	let j_email = document.account.j_email;
	let j_phone = document.account.j_phone;
	let j_addr = document.account.j_addr;

	
		if(isEmpty(j_name)|| moreThan(j_name,6)){
		alert('본인의 이름을 입력해 주세요!');
		j_name.focus();
		
		return false;
	}
	
		if(isEmpty(j_nick)|| moreThan(j_nick,10)){
		alert('닉네임은 10글자까지만 허용 가능합니다!');
		j_nick.focus();
		
		return false;
	}
	
	
		if(isEmpty(j_age)|| moreThan(j_age,3)){
		alert('본인의 나이를 써 주세요!');
		j_age.focus();
		
		return false;
	}
	
		if(isEmpty(j_birth)|| lessThan(j_birth,6)||moreThan(j_birth,6)){
		alert('주민등록상으로 기재된 생년월일을 입력해 주세요!');
		j_birth.focus();
		
		return false;
	}
		if(isEmpty(j_id)|| moreThan(j_id,15)){
		alert('아이디는 15글자까지 등록 가능합니다!');
		j_birth.focus();
		
		return false;
	}

		if(isEmpty(j_pw)|| lessThan(j_pw,8)|| moreThan(j_id,15)){
		alert('8~15글자로 대문자, 소문자, 숫자 포함하여 만들어 주세요!');
		j_pw.focus();
		
		return false;
	}

	if(notEquals(j_pw,j_pw2)){
		alert ('동일한 비밀번호를 한 번 더 입력해 주세요!')
		j_pw2.focus();
		j_pw2.value= "";
		return false;
		}
	
	if(isEmpty(j_pwquestiona)){
		alert('비밀번호확인질문 답변을 입력해 주세요!');
		j_pwquestiona.focus();
		
		return false;
	}
	
	if(isEmpty(j_phone)|| lessThan(j_phone,11)||moreThan(j_phone,11)){
		alert('-(하이픈) 제외, 전화번호를 기재해 주세요!');
		j_phone.focus();
		
		return false;
	}
	
	if(isEmpty(j_addr)){
		alert('주소를 입력해 주세요!');
		j_addr.focus();
		
		return false;
	}
	
	
	
	
	
	
}