<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="account_message_detail_box"><div>쪽지 보기</div></div>
<div class="account_message_detail_btn">
	<button onclick="history.back()">뒤로가기</button>
	<a href="javascript:groupMessage('${message.message_sender}','${receiver_nick}','${sessionScope.accountInfo.account_id}')">답장</a>
</div>

<table id="account_message_detailTbl" border="1">
	<tr>
		<td class="account_message_detail_title">보낸 사람 <span>${message.message_sender}</span></td>
		<td class="account_message_detail_title">보낸 날짜 <span>${message.message_date}</span></td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${message.message_title}</td>
	</tr>
	<tr>
		<td class="account_message_detail_txt" colspan="2">${message.message_txt}</td>
	</tr>
</table>


</body>
</html>