<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
		function passwordconfirm(pw) {
			
		let pwcf = document.getElementById('pwcf').value;
		let QnA_no = document.getElementById('mealkit_QnA_no').value;
	
		
			
			if (pwcf == pw) {
				
				alert('게시글 삭제가 성공했습니다.')
				location.href='../Mk_MenuInfo_RegQnAC?QnA_no=' + QnA_no ; 
				window.close()
			} else {
				
				alert('비밀번호가 틀렸습니다.')
				window.close()


				
			}
		
			
		}

</script>
</head>
<body>
				
			<table>
			<tr>
			<td> 비밀번호 입력</td>
			<td> <input id="pwcf" name="mealkit_review_pw"> </td>
			</tr>
			<tr>
			 <td> <input type="hidden" id="mealkit_QnA_no" value="${param.no }"> </td>
			<td> <button  name="mealkit_review_no" onclick="passwordconfirm(${param.pw })">삭제 </button> </td>
			<td> <button onclick="window.close()"> 취소</button> </td>
			</tr>
			</table>
	
		
</body>
</html>