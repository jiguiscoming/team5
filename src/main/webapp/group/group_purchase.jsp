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
		<td><a href="GroupController?region=전국&pageNum=1&research=">전국</a></td>
		<td><a href="GroupController?region=서울&pageNum=1&research=">서울</a></td>
		<td><a href="GroupController?region=부산&pageNum=1&research=">부산</a></td>
		<td><a href="GroupController?region=대구&pageNum=1&research=">대구</a></td>
		<td><a href="GroupController?region=인천&pageNum=1&research=">인천</a></td>
		<td><a href="GroupController?region=광주&pageNum=1&research=">광주</a></td>
		<td><a href="GroupController?region=대전&pageNum=1&research=">대전</a></td>
		<td><a href="GroupController?region=울산&pageNum=1&research=">울산</a></td>
		<td><a href="GroupController?region=세종&pageNum=1&research=">세종</a></td>
		<td><a href="GroupController?region=경기&pageNum=1&research=">경기</a></td>
		<td><a href="GroupController?region=경남&pageNum=1&research=">경남</a></td>
		<td><a href="GroupController?region=경북&pageNum=1&research=">경북</a></td>
		<td><a href="GroupController?region=충북&pageNum=1&research=">충북</a></td>
		<td><a href="GroupController?region=전남&pageNum=1&research=">전남</a></td>
		<td><a href="GroupController?region=전북&pageNum=1&research=">전북</a></td>
		<td><a href="GroupController?region=강원&pageNum=1&research=">강원</a></td>
		<td><a href="GroupController?region=제주&pageNum=1&research=">제주</a></td>
	</tr>
</table>

<!-- 글쓰기 버튼(btn) 및 검색창(form) -->

<form action="GroupController">
<table id="group_writeTbl" border="1">
	<tr>
		<td><h4>전체글 ${total }</h4></td>
		<td>
			<input name="research">
			<input type="hidden" name="region" value="${param.region}">
			<button name="pageNum" value="${param.pageNum}">검색</button>
		</td>
		<td><button type="button" onclick="location.href='GroupRegController'">글쓰기</button></td>
	</tr>
</table>
</form>

<!-- 게시글 목록 -->

<table id="group_listTbl" border="1">
	<!-- 항목 -->
	<tr>
		<td>번호</td>
		<td>지역</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
		<td>찜</td>
	</tr>
	<!-- 전체 게시글 수 -->
	<tr>
		<td colspan="7">${result }</td>
	</tr>
	<!-- 페이지에 해당하는 게시글 뽑아주기 -->
	<c:forEach var="group" items="${groups }">
	<tr>
		<td>${group.no }</td>
		<td>${group.area }</td>
		<td><a href="GroupDetailController?no=${group.no }">${group.title}</a></td>
		<td>${group.id }</td>
		<td>${group.date }</td>
		<td>${group.hits }</td>
		<td>${group.like }</td>
	</tr>
	</c:forEach>
</table>

<!-- 페이징 -->

<table border="1">
	<tr>
		<!-- 시작점 페이지 > 보일 페이지 수 : 이전버튼 생성 (1페이지~보일 페이지수 볼때는 이전 페이지 필요없음) -->
		<c:if test="${startPage > 5}">
		<td><a href="GroupController?pageNum=${startPage-5}&region=${param.region}&research=${param.research }">이전</a></td>
		</c:if>
		<!-- 페이지 버튼 -->
		<!-- 열린 페이지에 해당하는 버튼은 a태그 빼줌 -->
		<c:forEach var="page" items="${page}">
			<c:choose>
				<c:when test="${page == param.pageNum }">
				<td>${page }</td>
				</c:when>
				<c:otherwise>
				<td><a href="GroupController?pageNum=${page}&region=${param.region}&research=${param.research }">${page}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 끝 페이지 < 전체 페이지수 : 다음버튼 생성 (마지막 페이지 볼때는 다음 페이지 필요없음) -->
		<c:if test="${endPage < pageCount }">
		<td><a href="GroupController?pageNum=${startPage+5}&region=${param.region}&research=${param.research }">다음</a></td>
		</c:if>
	</tr>
</table>
</body>
</html>