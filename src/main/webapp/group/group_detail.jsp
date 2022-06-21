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
<!-- 글제목 -->
<div class="group_detail_title_box">
	<div class="group_detail_title">
		<h3>[${group.area }] ${group.title }</h3>
	</div>
	<div class="group_detail_date">
		<fmt:formatDate value="${group.date }" type="both"/> 
	</div>
	<div class="group_detail_btn">
		<button onclick="location.href='GroupUpdateController?no=${group.no}'">수정</button>
	</div>
</div>

<!-- 글내용 -->
<table id="group_detailTbl">
	<tr>
		<td class="group_detail_hits">조회수 ${group.hits }</td>
		<td class="group_detailTd">
	<%-- 	<c:choose> --%>
			<%-- <c:when test="${empty groupLike.id}"> --%>
			<span id="like">♡</span>
			<%-- </c:when> --%>
<%-- 			<c:otherwise>
			<span id="like">♥</span>
			</c:otherwise>
		</c:choose> --%>
			<span id="like_count">${group.like }</span>
		</td>
		<td>작성자 ${group.id }</td>
	</tr>
	<tr>
		<td class="group_detail_content" colspan="3">${group.txt }</td>
	</tr>
</table>
<h3>댓글</h3>
<form action="GroupCommentController" onsubmit="return groupComment()" name="groupCmtForm">
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