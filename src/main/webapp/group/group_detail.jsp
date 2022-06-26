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
<!-- 나중에 작성지 확인 기능 불러오기 -->
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
		<td>작성자 ${group.id }</td>
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
	</tr>
	<tr>
		<td class="group_detail_content" colspan="3">
			<img src="group_imgFolder/${group.img}">
			<hr>
			${group.txt }
		</td>
	</tr>
</table>

<!-- 댓글쓰기 -->
<div class="group_comment"><h3>댓글</h3></div>

<form action="GroupCommentController" onsubmit="return groupComment()" name="groupCmtForm">
<table id="group_commentTbl">
	<tr>	
		<!-- 닉네임 세션 받기 -->
		<td>id</td>
	</tr>
	<tr>
		<td class="group_commentTd"><textarea name="comment"></textarea></td>
		<td class="group_commentTd"><button name="no" value="${group.no}">입력</button></td>
	</tr>
</table>
</form>

<!-- 댓글 목록 -->
<table id="group_comment_listTbl">
<c:forEach var="comment" items="${comments }">
	<tr style="height: 30px;">
		<td class="group_comment_id">${comment.id}</td>
		<td class="group_comment_date"><fmt:formatDate value="${comment.date}" type="both" dateStyle="long" timeStyle="short"/> </td>
	</tr>
	<tr>
		<td colspan="2"><div class="group_comment_txt">${comment.txt}</div></td>
	</tr>
</c:forEach>
</table>
</body>
</html>