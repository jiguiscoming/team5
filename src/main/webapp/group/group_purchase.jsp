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
<!-- 지역 -->
<table id="group_regionTbl" border="1">
	<tr>
		<td colspan="17">지역 찾기</td>
	</tr>
	<tr>
		<td><a href="GroupResearchController?region=전국">전국</a></td>
		<td><a href="GroupResearchController?region=서울">서울</a></td>
		<td><a href="GroupResearchController?region=부산">부산</a></td>
		<td><a href="GroupResearchController?region=대구">대구</a></td>
		<td><a href="GroupResearchController?region=인천">인천</a></td>
		<td><a href="GroupResearchController?region=광주">광주</a></td>
		<td><a href="GroupResearchController?region=대전">대전</a></td>
		<td><a href="GroupResearchController?region=울산">울산</a></td>
		<td><a href="GroupResearchController?region=세종">세종</a></td>
		<td><a href="GroupResearchController?region=경기">경기</a></td>
		<td><a href="GroupResearchController?region=경남">경남</a></td>
		<td><a href="GroupResearchController?region=경북">경북</a></td>
		<td><a href="GroupResearchController?region=충북">충북</a></td>
		<td><a href="GroupResearchController?region=전남">전남</a></td>
		<td><a href="GroupResearchController?region=전북">전북</a></td>
		<td><a href="GroupResearchController?region=강원">강원</a></td>
		<td><a href="GroupResearchController?region=제주">제주</a></td>
	</tr>
</table>
<!-- 글쓰기 버튼(btn) 및 검색창(form) -->
<form action="GroupResearchController" method="post">
<table id="group_writeTbl" border="1">
	<tr>
		<td><h4>${total }</h4></td>
		<td><input name="research" placeholder="${param.research }"><button>검색</button></td>
		<td><button type="button" onclick="location.href='GroupRegController'">글쓰기</button></td>
	</tr>
</table>
</form>
<!-- 게시글 목록 -->
<table id="group_listTbl" border="1">
	<tr>
		<td>번호</td>
		<td>지역</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
		<td>찜</td>
	</tr>
	<tr>
		<td colspan="7">${result }</td>
	</tr>
	<c:forEach var="group" items="${groups }">
	<tr>
		<td>${group.posting }</td>
		<td>${group.area }</td>
		<td><a href="GroupDetailController?no=${group.no }">${group.title}</a></td>
		<td>${group.id }</td>
		<td>${group.date }</td>
		<td>${group.hits }</td>
		<td>${group.like }</td>
	</tr>
	</c:forEach>
</table>
<table border="1">
	<tr>
		<c:if test="${startPage > 2}">
		<td><a href="GroupController?pageNum=${startPage-2}">이전</a></td>
		</c:if>
		<c:forEach var="page" items="${page}">
		<td><a href="GroupController?pageNum=${page}">${page}</a></td>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
		<td><a href="GroupController?pageNum=${startPage+2}">다음</a></td>
		</c:if>
	</tr>
</table>
</body>
</html>