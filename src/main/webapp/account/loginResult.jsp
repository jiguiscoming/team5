<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table  id="login_result">
	<tr>
		<td class="login_result_txt">
			<%= request.getAttribute("r")%>
		</td>
	</tr>
</table>

</body>
</html>