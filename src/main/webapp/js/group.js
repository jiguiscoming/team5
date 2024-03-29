/*수정페이지 넘어가기 전 유효성체크*/
function group_pwOK(userpw){
	let pw = document.groupForm.pw;
	let pwCheck = document.groupForm.pwCheck;
	/*비번이 같지 않으면 true = > 경고*/
	if(pw.value != pwCheck.value){
		alert('비번이 일치하지 않습니다');
		pwCheck.focus();
		return false;
	}
}

/*등록 페이지 유효성체크*/	
function groupReg_isEmpty(){
	let title = document.groupRegForm.title;
	let txt = document.groupRegForm.txt;
	/*빈칸 있으면 true => 경고*/
	if(!title.value){
		alert('제목을 입력해주세요');
		title.focus();
		return false;
	}

	if(!txt.value){
		alert('내용을 입력해주세요');
		txt.focus();
		return false;
	}

}

// 수정사이트 넘어가기 전
// 아이디 세션 받아와서 확인
function groupUpdate_idOK(){
	alert('작성자가 아닙니다');
}

/*수정페이지 유효성체크*/
function groupUpdate_isEmpty(){

	let title_update = document.groupUpdateForm.title;
	let txt_update = document.groupUpdateForm.txt;
	/*빈칸 있으면 true => 경고*/
	if(!title_update.value){
		alert('제목을 입력해주세요');
		title_update.focus();
		return false;
	}

	if(!txt_update.value){
		alert('내용을 입력해주세요');
		txt_update.focus();
		return false;
	}
	
}

/*삭제 전 경고창으로 더블체크*/
function groupDel(no){
	
	let ok = confirm('진짜 삭제하시겠습니까?');
	if(ok){
		location.href='GroupDeleteController?no=' + no + '&region=전국&pageNum=1&search=';
	}
	
}

/*댓글 유효성체크*/
function groupComment(id){
	/*회원아니면*/
	if(!id){
		alert('회원만 이용가능한 서비스 입니다')
		return false;
	}else{
	let comment = document.groupCmtForm.comment;
		
	/*빈칸 있으면 true => 경고*/
	if(!comment.value){
		alert('댓글을 입력해주세요');
		comment.focus();
		return false;
	}
	}
}

let group_message;

function groupMessage(receiver,receiver_nick,userid){
	if(!userid){
		alert('회원만 이용가능한 서비스 입니다');
	}else if(userid == receiver){
		alert('본인에게는 메세지를 보낼 수 없습니다')
	}else{
	group_message = window.open("group/group_message.jsp?nick=" + receiver_nick + "&writer=" + receiver, "message", "width=640 , height=400" );
	}
}


	
function checkMember(userid){
	if(!userid){
		alert('회원만 이용가능한 서비스 입니다');
	}else{
		location.href='GroupRegController';
	}
}

function updateMember(postid,userid, no){
	if(postid != userid){
		alert('해당 게시글 수정 권한이 없습니다');
	}else{
	location.href='GroupUpdateController?no=' + no;
	}
}


