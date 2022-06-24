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
	
	<table class="mk_Menulistbl1" border="1" >
	
	  <c:forEach items="${mealkits }" var="m">
	<table border="1" class="mk_MLtbl_1" onclick="location.href='Mk_MenuInfoC?no=${m.mealkit_no}'">
	<tr>
	       <td class="mk_Ml_td1"> <img class="mk_Ml_img" src="img/${m.mealkit_img }"> </td>
			</tr>   
			<tr>
	       <td > ${m.mealkit_name } </td>
	   </tr>
			<tr>
	       <td > ${m.mealkit_no } </td>
	   </tr>
	   <tr>
	       <td> ${m.mealkit_price }</td>
	 	</tr>
	       	
	</table>
	  </c:forEach>
	  
	</table>
	  

	  
    


</body>
</html>