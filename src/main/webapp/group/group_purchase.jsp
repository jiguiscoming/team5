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
		<td><a href="#">전국</a></td>
		<td><a href="#">서울</a></td>
		<td><a href="#">부산</a></td>
		<td><a href="#">대구</a></td>
		<td><a href="#">인천</a></td>
		<td><a href="#">광주</a></td>
		<td><a href="#">대전</a></td>
		<td><a href="#">울산</a></td>
		<td><a href="#">세종</a></td>
		<td><a href="#">경기</a></td>
		<td><a href="#">경남</a></td>
		<td><a href="#">경북</a></td>
		<td><a href="#">충북</a></td>
		<td><a href="#">전남</a></td>
		<td><a href="#">전북</a></td>
		<td><a href="#">강원</a></td>
		<td><a href="#">제주</a></td>
	</tr>
</table>
<!-- 글쓰기 버튼 및 검색창 -->
<table id="group_writeTbl" border="1">
	<tr>
		<td><input placeholder="검색"></td>
		<td><button onclick="location.href='GroupRegController'">글쓰기</button></td>
	</tr>
</table>
<!-- 게시글 목록 -->
<table id="group_listTbl" border="1">
	<tr>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
		<td>찜</td>
	</tr>
	<tr>
		<td colspan="5">${result }</td>
	</tr>
	<c:forEach var="group" items="${groups }">
	<tr>
		<td><a href="GroupDetailController?no=${group.no }">${group.title}</a></td>
		<td>${group.id }</td>
		<td>${group.date }</td>
		<td>${group.hits }</td>
		<td>${group.like }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>