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
		${r }

	<c:forEach var="r" items="${MealkitReviewlist }">
		
			<tr >
			
				<td>${r.mealkit_review_star }</td>
				<td><>${r.mealkit_review_title }</td>
				<td>${r.mealkit_review_date }</td>
			</tr>
			<tr >
				
				<td colspan="3">${r.mealkit_review_star } <br> ${r.mealkit_review_txt }</td>
			
			</tr>
		</c:forEach>


</body>
</html>