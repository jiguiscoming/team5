<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mealkit-QnA</title>
    <link rel="stylesheet" href="../mealkit_css/mk_QnA.css">
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
    <script type="text/javascript">

        function setParentText(){

            document.getElementById("mealkit_QnA_mk_no").value =  opener.document.getElementById("mk_no").value 
            

        }

   </script>
	  <script type="text/javascript">
	  function setThumbnail(event) {
			var reader = new FileReader();

			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				img.setAttribute("class", "col-lg-6");
				document.querySelector("div#image_container").appendChild(img);
			};

			reader.readAsDataURL(event.target.files[0]);
		}

	  </script>
</head>
<body onload="setParentText()">		
			
				
			<table class="mk_QnA_tbl" border="1">
			<tr>
			<td> 상품문의 쓰기
            </td>
			</tr>
			<tr>
			<td><img class="mk_QnA_img" src="img/${Mealkit.mealkit_img }"> </td>
			<td>${Mealkit.mealkit_name }</td>
			</tr>
			</table>


			
			<form action="../Mk_MenuInfo_RegQnAC" method="post" enctype="multipart/form-data">
			<table border="1" class="mk_QnA_tbl1">
			<tr>
			<td class="mk_QnA_td1">말머리</td>
			<td>상품문의</td>
			</tr>
			<tr>
			<td class="mk_QnA_td1"> 작성자 </td>
			<td> <input style="width: 300px;" name="mealkit_QnA_id"> </td>
			</tr>
			<tr>
			<td class="mk_QnA_td1"> 비밀번호 </td>
			<td> <input style="width: 300px;"  name="mealkit_QnA_pw"> </td>
			</tr>
			<tr>
			<td class="mk_QnA_td1"> 제목 </td>
			<td> <input style="width: 500px;"  placeholder="제목을 입력해주세요." name="mealkit_QnA_title"> </td>
			</tr>
			<tr>
			<td class="mk_QnA_td1">내용</td>
			<td> <textarea style="width: 650px ; height:350px;" type="text"  name="mealkit_QnA_txt"></textarea> </td>
			</tr>
			<tr>
			<td ><input class="form-control form-control-user"
							type="file" name="mealkit_QnA_img" id="mealkit_QnA_img"
							onchange="setThumbnail(event);"></td>
						<td><div  id="image_container"></div></td>
			</tr>
			</table>
			
			<table class="mk_QnA_tbl2">
			<tr>
			<td> <button onclick="window.close()">취소</button> </td>
			<td> <button id="mealkit_QnA_mk_no" name="mealkit_QnA_mk_no">등록</button> </td>
			</tr>
			
			</table>
			</form>
		
				
<script>
    // 메인화면 페이지 로드 함수
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: '내용을 작성하세요',
            width : 650,
            height: 350,
            maxHeight: 400
        });
    });
</script>
</body>
</html>