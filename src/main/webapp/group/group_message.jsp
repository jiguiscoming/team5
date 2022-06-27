<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공구 메이트에게 쪽지 보내기</title>
<link rel="stylesheet" href="../group_css/group_message.css">
</head>
<body>
<form action="GroupMessageController" onsubmit="groupMessageClose()">
<table id="group_messageTbl">
	<tr>
		<td><div class="group_message_box">쪽지 보내기</div></td>
	</tr>
	<tr>
		<td class="group_message_title">제목 <input name="message_title"></td>
	</tr>
	<tr>
		<td class="group_message_writer">to <input name="writer_id" value="id"></td>
	</tr>
	<tr>
		<td class="group_message_txt"><textarea name="message_txt"></textarea></td>
	</tr>
	<tr>
		<td class="group_message_btn"><button name="sending_id" value="id">보내기</button></td>
	</tr>
</table>
</form>

</body>
</html>