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


<div><br><br></div>




<div class="account_message_box"><div >내 쪽지</div></div>


<div><br><br></div>




<div class="account_message_back"><button onclick="history.back()">마이페이지 돌아가기</button></div>
<table id="account_messageTbl">
	<tr>
		<td class="account_message_title">보낸 사람</td>
		<td class="account_message_title">메세지 제목</td>
		<td class="account_message_title">보낸 날짜</td>
	</tr>
	<c:forEach items="${messages}" var="message">
	<tr class="account_message_contentsTr">
		<td class="account_message_contents">${message.message_sender}</td>
		<td class="account_message_contents">
			<a href="account_messageDetailC?no=${message.message_no}&receiver=${message.message_sender}" >${message.message_title}</a>
		</td>
		<td class="account_message_contents"><fmt:formatDate value="${message.message_date}" type="both" dateStyle="short" timeStyle="short"/></td>
	</tr>
	
	</c:forEach>
</table>


<div><br><br></div>





</body>
</html>