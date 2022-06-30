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

<div class="account_message_box">내 쪽지</div>

<table id="account_messageTbl">
	<tr>
		<td class="account_message_title">보낸 사람</td>
		<td class="account_message_title">메세지 제목</td>
		<td class="account_message_title">보낸 날짜</td>
	</tr>
	<c:forEach items="${messages}" var="message">
	<tr>
		<td>${message.message_sender}</td>
		<td>
			<a href="account_messageDetailC?no=${message.message_no}&receiver=${message.message_sender}" >${message.message_title}</a>
		</td>
		<td><fmt:formatDate value="${message.message_date}" type="both" dateStyle="short" timeStyle="short"/></td>
	</tr>
	
	</c:forEach>
</table>


</body>
</html>