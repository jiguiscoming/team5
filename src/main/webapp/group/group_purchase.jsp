<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공구</title>
</head>
<body>
<div class="group_title"><h2>공구</h2></div>

<!-- 지역 -->
<div id="group_region_box">
<table>
	<tr>
		<td class="group_regionTd"><a href="GroupController?region=전국&pageNum=1&search=">전국</a></td>
		<td class="group_regionTd"><a href="GroupController?region=서울&pageNum=1&search=">서울</a></td>
		<td class="group_regionTd"><a href="GroupController?region=부산&pageNum=1&search=">부산</a></td>
		<td class="group_regionTd"><a href="GroupController?region=대구&pageNum=1&search=">대구</a></td>
		<td class="group_regionTd"><a href="GroupController?region=인천&pageNum=1&search=">인천</a></td>
		<td class="group_regionTd"><a href="GroupController?region=광주&pageNum=1&search=">광주</a></td>
		<td class="group_regionTd"><a href="GroupController?region=대전&pageNum=1&search=">대전</a></td>
		<td class="group_regionTd"><a href="GroupController?region=울산&pageNum=1&search=">울산</a></td>
		<td class="group_regionTd"><a href="GroupController?region=세종&pageNum=1&search=">세종</a></td>
		<td class="group_regionTd"><a href="GroupController?region=경기&pageNum=1&search=">경기</a></td>
		<td class="group_regionTd"><a href="GroupController?region=경남&pageNum=1&search=">경남</a></td>
		<td class="group_regionTd"><a href="GroupController?region=경북&pageNum=1&search=">경북</a></td>
		<td class="group_regionTd"><a href="GroupController?region=충북&pageNum=1&search=">충북</a></td>
		<td class="group_regionTd"><a href="GroupController?region=전남&pageNum=1&search=">전남</a></td>
		<td class="group_regionTd"><a href="GroupController?region=전북&pageNum=1&search=">전북</a></td>
		<td class="group_regionTd"><a href="GroupController?region=강원&pageNum=1&search=">강원</a></td>
		<td class="group_regionTd"><a href="GroupController?region=제주&pageNum=1&search=">제주</a></td>
	</tr>
</table>
</div>

<!-- 글쓰기 버튼(btn) 및 검색창(form) -->

<form action="GroupController">
<table id="group_writeTbl">
	<tr>
		<td><h4>전체글 ${total }</h4></td>
		<td class="group_search">
			<input name="search">
			<input type="hidden" name="region" value="${param.region}">
			<button name="pageNum" value=1>검색</button>
		</td>
		<td class="group_write"><button type="button" onclick="location.href='GroupRegController'">글쓰기</button></td>
	</tr>
</table>
</form>

<!-- 게시글 목록 -->

<table id="group_listTbl">

	<tr>
		<!-- 페이지에 해당하는 게시글 뽑아주기 -->
		<c:forEach var="group" items="${groups }">
		<td class="group_listTd">
			<div class="group_list_date">작성일 ${group.date }</div>
			<div class="group_list_img_box">
			<a href="GroupDetailController?no=${group.no}">
				<img src="group_imgFolder/${group.img}">
			<div class="group_list_region">
				${group.area }
			</div>
			</a>
			</div>
			<div class="group_list_count">
				조회수 ${group.hits }
			</div>
			<div class="group_list_title">
				<a href="GroupDetailController?no=${group.no}">${group.title}</a>
				<br><span>작성자 ${group.nickname }</span>
			</div>
		</td>
		</c:forEach>
	 	<c:if test="${(total % 4) > 0}">
	 	<c:forEach begin="1" end="${4 - (total % 4)}">
		<td class="group_listTd"></td>
		</c:forEach> 
		</c:if> 
	</tr>
</table>

<!-- 페이징 -->

<table id="group_pagingTbl" >
	<tr>
		<!-- 시작점 페이지 > 보일 페이지 수 : 이전버튼 생성 (1페이지~보일 페이지수 볼때는 이전 페이지 필요없음) -->
		<c:if test="${startPage > 5}">
		<td class="group_pagingMove"><a href="GroupController?pageNum=${startPage-5}&region=${param.region}&search=${param.search }">이전</a></td>
		</c:if>
		<!-- 페이지 버튼 -->
		<!-- 열린 페이지에 해당하는 버튼은 a태그 빼줌 -->
		<c:forEach var="page" items="${page}">
			<c:choose>
				<c:when test="${page == pageNum }">
				<td class="group_pagingNow">${page}</td>
				</c:when>
				<c:otherwise>
				<td class="group_pagingTd"><a href="GroupController?region=${param.region}&pageNum=${page}&search=${param.search }">${page}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 끝 페이지 < 전체 페이지수 : 다음버튼 생성 (마지막 페이지 볼때는 다음 페이지 필요없음) -->
		<c:if test="${endPage < pageCount }">
		<td class="group_pagingMove"><a href="GroupController?region=${param.region}&pageNum=${startPage+5}&search=${param.search }">다음</a></td>
		</c:if>
	</tr>
</table>
</body>
</html>