<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="group_detailTbl" border="1">
	<tr>
		<td colspan="4"><h2>${group.title }</h2></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td>조회수 ${group.hits }</td>
		<td class="group_like">
			<input type="checkbox" name="like"><label for="like"></label>${group.like }
		</td>
	</tr>
	<tr>
		<td>${group.area }</td>
		<td>${group.id }</td>
		<td><fmt:formatDate value="${group.date }" type="both"/> </td>
		<td><button onclick="location.href='GroupUpdateController?no=${group.no}'">수정</button></td>
	</tr>
	<tr>
		<td colspan="4">${group.txt }</td>
	</tr>
</table>
<h3>댓글</h3>
<form action="GroupCommentController">
<table id="group_commentTbl" border="1">
	<tr>
		<td colspan="2"><textarea name="comment"></textarea></td>
		<td><button name="no" value="${group.no}">댓글입력</button></td>
	</tr>
</table>
</form>
<h3>댓글리스트</h3>
<table id="group_comment_listTbl" border="1">
<c:forEach var="comment" items="${comments }">
	<tr>
		<td><h4>${comment.id}</h4></td>
	</tr>
	<tr>
		<td><fmt:formatDate value="${comment.date}" type="both" dateStyle="long" timeStyle="short"/> </td>
	</tr>
	<tr>
		<td>${comment.txt}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>