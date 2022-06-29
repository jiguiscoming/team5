<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <script type="text/javascript" src="agree.js"> </script>
<body>

<!-- 이용 약관 동의 -->

<form action="joinusC">

<h1> 야나두 레시피 </h1>
<h5> 이용 약관</h5>
<div style="overflow: scroll; width: 700px; height: 300px;" >
 

 <table border="1" >
   <tr>
    <td> </td>
 </tr>
 </table>
</div>

<h5> 개인정보 수집 및 이용 동의</h5>
<div style="overflow: scroll; width: 700px; height: 300px;" >
 

 <table border="1" >
   <tr>
    <td> </td>
 </tr>
 </table>
</div>

<h5> 프로모션 정보 수신 동의(선택)</h5>
<div style="overflow: scroll; width: 700px; height: 300px;" >
 

 <table border="1" >
   <tr>
    <td> </td>
 </tr>
 </table>
</div>


<h5> 위치기반서비스 이용약관 동의(선택)</h5>
<div style="overflow: scroll; width: 700px; height: 300px;" >
 

 <table border="1" >
   <tr>
    <td> </td>
 </tr>
 </table>
</div>

 <p> <input type="checkbox" name="agree" value="selectall" onclick='selectAll(this)'>전체 선택~ </p>
<p> <input type="checkbox" name="agree1" value="O" id="agree1" onclick='is_checked(this)'>이용 약관 동의 </p>
<p> <input type="checkbox" name="agree2" value="O" id="agree2" onclick='is_checked(this)'>개인정보 수집 및 이용 동의 </p>
<p> <input type="checkbox" name="agree3" value="O" id="agree3" onclick='is_checked(this)'>프로모션 정보 수신 동의(선택) </p>
<p> <input type="checkbox" name="agree4" value="O" id="agree4" onclick='is_checked(this)'>위치기반서비스 이용약관 동의(선택) </p>
<input type="hidden" name="agree1" value='X' id="agree1_hidden"/>
<input type="hidden" name="agree2" value='X' id="agree2_hidden"/>
<input type="hidden" name="agree3" value='X' id="agree3_hidden"/>
<input type="hidden" name="agree4" value='X' id="agree4_hidden"/>







<table>
<tr>
<td><button> 가입하기 </button> </td>

</tr>

</table>

</form>








</body>
</html>