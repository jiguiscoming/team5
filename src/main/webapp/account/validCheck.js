
// JS 라이브러리 완성!

// 일반적으로 유효성 검사하는 것들

// 함수 형태로 정리해서
// 나중에 필요할 떄 쓰려고( 쓰기 편하게 )

// .jar 쓰던 것처럼 lib(라이브러리) 만들어서 쓰자 ! 

// 문제가 있으면 true, 괜찮으면 false

//<input>을 넣으면..
// 거기에 글자가 없으면 true, 있으면 false

function isEmpty(input) {
	return !input.value; // 값이 없다는 뜻!


	/*if(input.value==""){
		return true;
	}else{
		return false;
	}*/
}

// <input> 과 글자 수를 넣으면
// 그 글자수보다 적으면 true , 아니면 false

function lessThan(input, length) {
	return input.value.length < length;

}
function moreThan(input, length) {
	return input.value.length > length;

}

// <input>을 넣으면
// 한글, 특수문자가 들어 있으면 true, 아니면 false


// input.value = "엠지";

function containKR(input) {
	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._";
	//0123456789
	for (let i = 0; i < input.value.length; i++) {
		if (ok.indexOf(input.value[i]) == -1) {
			return true;

		}


	}

}

function containKRN(input) {
	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._1234567890";
	//0123456789
	for (let i = 0; i < input.value.length; i++) {
		if (ok.indexOf(input.value[i]) == -1) {
			return true;

		}


	}

}
function notcontainN(input) {
	let ok = "1234567890";
	//0123456789
	for (let i = 0; i < input.value.length; i++) {
		if (ok.indexOf(input.value[i]) == -1) {
			return true;

		}


	}

}

// Test


// <input> x2 넣으면 (비번확인)
// 내용이 다르면 true, 아니면 false

function notEquals(input1, input2) {
	/*	if(input1 != input2){
			return true;
		}else{return false;}*/
	return input1.value != input2.value;
}

// <input> 문자열 세트
// 그 문자열 세트가 포함 안 되었으면 true
// 들어 있으면 false

// 조합

function notContains(input, set) {

	// input : 1qwerASD
	// input : ASD


	// set: 123456789 숫자를 반드시 포함시켜라
	// set : QWERTYUIOPASDFGHJKLZXCVBNM
	for (let i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;

}

// <input> 을 넣어서
// 숫자가 아니면 true, 숫자면 false

// input : 123
// input : aaa

function isNotNumber(input) {
	return isNaN(input.value);



}
/*
function DBconfirm(input, set) {
	/*	if(input1 != input2){
			return true;
		}else{return false;}
	return input1.value != input2.value;
}



*/









