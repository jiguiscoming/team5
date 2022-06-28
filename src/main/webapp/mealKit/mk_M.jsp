<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="mealkit_js/mealkit.js"></script>
<script type="text/javascript" src="mealkit_js/mk_slide.js"></script>
<script type="text/javascript" src="mealkit_js/mk_info.js"></script>
<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="mealkit_css/mk_slide.css">
<link rel="stylesheet" type="text/css" href="mealkit_css/mk_M.css">
<link rel="stylesheet" type="text/css" href="mealkit_css/mk_info.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">




<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<td>
				<button onclick="location.href='Mk_MenuC'">밀키트</button>
			</td>
		</tr>
	</table>

	<h1>--------------------------------------------------------------------------------------------</h1>



	<table>
		<tr>

			<td><jsp:include page="${mealkitPage}"></jsp:include></td>
		</tr>

	</table>


	<h1>-------------------------------------------------</h1>

	<form action="Mk_MenuInsertC" method="get">
		<table>
			<tr>
				<td>
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>














</body>
</html>