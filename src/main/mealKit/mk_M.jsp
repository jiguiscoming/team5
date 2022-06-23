<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<td> <button onclick="location.href='Mk_MenuC'">밀키트</button>  </td>
		</tr>
	</table>

		<h1>-----------------------------</h1>

	<table>
		<tr>
			<td>
			<span> <input type="radio" name="Mk_Mn_type" checked="checked">	<label>전체</label> </span>
			</td>
			<td>
			<span> <input type="radio" name="Mk_Mn_type" checked="checked">	<label>한식</label> </span>
			</td>
			<td>
			<span> <input type="radio" name="Mk_Mn_type" checked="checked">	<label>양식</label> </span>
			</td>
			<td>
			<span> <input type="radio" name="Mk_Mn_type" checked="checked">	<label>일식</label> </span>
			</td>
			<td>
			<span> <input type="radio" name="Mk_Mn_type" checked="checked">	<label>중식</label> </span>
			</td>
			<td>
			<span> <input type="radio" name="Mk_Mn_type" checked="checked">	<label>샐러드</label> </span>
			</td>
			
		</tr>

	</table>
	
	
	<h1>-----------------------------------------</h1>
	
	
	<table>
		<tr>
		
		<td> <jsp:include page="${mealkitPage}"></jsp:include> </td>
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