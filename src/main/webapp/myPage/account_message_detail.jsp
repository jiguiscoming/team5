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


<table border="1">
	<tr>
		<td>
			<button onclick="history.back()">뒤로가기</button>
		</td>
		<td>
			<a href="javascript:groupMessage('${message.message_sender}','${receiver_nick}','${sessionScope.accountInfo.account_id}')">답장</a>
		</td>
	</tr>
	<tr>
		<td>보낸 사람 ${message.message_sender}</td>
		<td>보낸 날짜 ${message.message_date}</td>
	</tr>
	<tr>
		<td colspan="2">제목 ${message.message_title}</td>
	</tr>
	<tr>
		<td colspan="2">${message.message_txt}</td>
	</tr>
</table>


</body>
</html>