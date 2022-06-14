function group_pwOK(){
	let pw = document.groupForm.pw;
	let pwCheck = document.groupForm.pwCheck;
	/*비번이 같지 않으면 true = > 경고*/
	if(pw.value != pwCheck.value){
		alert('비번이 일치하지 않습니다');
		pwCheck.focus();
		return false;
	}
}