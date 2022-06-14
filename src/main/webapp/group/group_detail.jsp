<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<td>${group.date }</td>
		<td><button onclick="location.href='GroupUpdateController?no=${group.no}'">수정</button></td>
	</tr>
	<tr>
		<td colspan="4">${group.txt }</td>
	</tr>
</table>
<h3>댓글</h3>
<table id="group_commentTbl" border="1">
	<tr>
		<td colspan="2"><input></td>
		<td><button>댓글입력</button></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>댓글내용</td>
		<td>시간</td>
	</tr>
</table>
</body>
</html>