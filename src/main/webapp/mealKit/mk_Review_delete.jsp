<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
		function passwordconfirm(no, pw) {
			
			alert(no);
			alert(pw);
		
			
		}

</script>
</head>
<body>
		
		<form action="ReviewDelC">
			<table>
			<tr>
			<td> 비밀번호 입력</td>
			<td> <input id="pw" name="mealkit_review_pw"> </td>
			</tr>
			<tr>
			<td> <button  name="mealkit_review_no" onclick="passwordconfirm(${param.no } , ${param.pw })">삭제 </button> </td>
			<td> <button onclick="window.close()"> 취소</button> </td>
			</tr>
			</table>
		</form>
		
</body>
</html>