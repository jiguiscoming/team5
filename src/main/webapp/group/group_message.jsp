<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공구 메이트에게 쪽지 보내기</title>
<link rel="stylesheet" href="../group_css/group_message.css">
<script type="text/javascript">
function sendMessage(){
	let title = document.getElementById('message_title').value;
	let writer = document.getElementById('writer').value;
	let txt = document.getElementById('message_txt').value;
	let sender = document.getElementById('send_id').value;
	
	location.href='../GroupMessageController?message_title=' + title + '&writer=' + writer + '&send_id=' + sender + '&message_txt=' + txt;
	window.close();
}
</script>
</head>
<body>
<table id="group_messageTbl">
	<tr>
		<td><div class="group_message_box">쪽지 보내기</div></td>
	</tr>
	<tr>
		<td class="group_message_title">제목 <input id="message_title"></td>
	</tr>
	<tr>
		<td class="group_message_writer">
			to ${param.nick}
			<input type="hidden" id="writer" value="${param.writer}">
		</td>
	</tr>
	<tr>
		<td class="group_message_txt"><textarea id="message_txt"></textarea></td>
	</tr>
	<tr>
		<!-- 세션받아서 넣기 -->
		<td class="group_message_btn"><button id="send_id" value="${sessionScope.accountInfo.account_id}" onclick="sendMessage()">보내기</button></td>
	</tr>
</table>
</body>
</html>