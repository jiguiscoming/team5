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

  <h1>메뉴 리스트</h1>
	<c:forEach var="m" items="mealkits">
	
	
	<table border="1">
	<tr>
	<td> ${mk_img }</td>
	</tr>
	<tr>
	<td>${mk_name } </td>
	</tr>
	<tr>
	<td>${mk_price }</td>
	</tr>
	</table>

	</c:forEach>
	<h1>리스트 가로 배열 기본형</h1>
<ul>
  <li><a href="javascript:;" target="_blank">1</a></li>
  <li><a href="javascript:;" target="_blank">2</a></li>
  <li><a href="javascript:;" target="_blank">3</a></li>
  <li><a href="javascript:;" target="_blank">4</a></li>
</ul>

<br><br><br><br>

<h1>카드형 리스트</h1>
<ul>
  <li>
    <div class="album-item">
      <div class="album-cover"></div>
      <div class="album-info">
        <p class="album-title">앨범1</p>
        <p class="album-date">2017.02.16.</p>
      </div>
    </div>
  </li>
  <li>
    <div class="album-item">
      <div class="album-cover"></div>
      <div class="album-info">
        <p class="album-title">앨범2</p>
        <p class="album-date">2017.02.16.</p>
      </div>
    </div>
  </li>
  <li>
    <div class="album-item">
      <div class="album-cover"></div>
      <div class="album-info">
        <p class="album-title">앨범3</p>
        <p class="album-date">2017.02.16.</p>
      </div>
    </div>
  </li>
  <li>
    <div class="album-item">
      <div class="album-cover"></div>
      <div class="album-info">
        <p class="album-title">앨범4</p>
        <p class="album-date">2017.02.16.</p>
      </div>
    </div>
  </li>
</ul>
	



</body>
</html>