function call(){
	
	let join_name  = document.account.join_name;
	let join_nick  = document.account.join_nick;
	let join_age = document.account.join_age;
	let join_gender = document.account.join_gender;
	let join_birth = document.account.join_birth;
	let join_id = document.account.join_id;
	let join_pw = document.account.join_pw;
	let join_pw2 = document.account.join_pw2;
	let join_pwquestion = document.account.join_pwquestion;
	let join_pwquestiona = document.account.join_pwquestiona;
	let join_email = document.account.join_email;
	let join_phone = document.account.join_phone;
	let join_addr = document.account.join_addr;

	
		if(isEmpty(join_name)|| moreThan(join_name,6)){
		alert('본인의 이름을 입력해 주세요!');
		join_name.focus();
		
		return false;
	}
	
		if(isEmpty(join_nick)|| moreThan(join_nick,10)){
		alert('닉네임은 10글자까지만 허용 가능합니다!');
		join_nick.focus();
		
		return false;
	}
	
	
		if(isEmpty(join_age)|| moreThan(join_age,3)){
		alert('본인의 나이를 써 주세요!');
		join_age.focus();
		
		return false;
	}
	
		if(isEmpty(join_birth)|| lessThan(join_birth,6)||moreThan(join_birth,6)){
		alert('주민등록상으로 기재된 생년월일을 입력해 주세요!');
		join_birth.focus();
		
		return false;
	}
		if(isEmpty(join_id)|| moreThan(join_id,15)){
		alert('아이디는 15글자까지 등록 가능합니다!');
		join_birth.focus();
		
		return false;
	}

		if(isEmpty(join_pw)|| lessThan(join_pw,8)|| moreThan(join_id,15)){
		alert('8~15글자로 대문자, 소문자, 숫자 포함하여 만들어 주세요!');
		join_pw.focus();
		
		return false;
	}

	if(notEquals(join_pw,join_pw2)){
		alert ('동일한 비밀번호를 한 번 더 입력해 주세요!')
		join_pw2.focus();
		join_pw2.value= "";
		return false;
		}
	
	if(isEmpty(join_pwquestiona)){
		alert('비밀번호확인질문 답변을 입력해 주세요!');
		join_pwquestiona.focus();
		
		return false;
	}
	
	if(isEmpty(join_phone)|| lessThan(join_phone,11)||moreThan(join_phone,11)){
		alert('-(하이픈) 제외, 전화번호를 기재해 주세요!');
		join_phone.focus();
		
		return false;
	}
	
	if(isEmpty(join_addr)){
		alert('주소를 입력해 주세요!');
		join_addr.focus();
		
		return false;
	}
	
	
	
	
	
	
}