<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div><br><br></div>
<div class="account_message_box"><div >마이페이지</div></div>


<div><br></div>
 

<table class="mypage_btb"></table>
	<table class="mypage_tb">

		<tr>
			<td rowspan="7" class="box"><img width="300px" class="profile" alt="" src="account/img/${sessionScope.accountInfo.account_img}"></td>
			<TD  rowspan="7" width="15px"></TD>
			<td>
				<button class="information_2" onclick="location.href='account_mypostC'">내 게시글 /
					댓글!</button>
			</td>
		</tr>
		<tr>
			<td>
				<button class="information_1" onclick="location.href='account_informationC'">내 정보</button>
			</td>
		</tr>
		<tr>
			<td><button class="information_2" onclick="location.href='account_messageC'">쪽지</button>
			</td>
		</tr>
		<tr>
			<td><button class="information_1" onclick="location.href='account_paymentC'">결제정보</button>
			</td>
		</tr>
		<tr>
			<td><button class="information_2" onclick="location.href='account_secessionpwC'">탈퇴!</button>
			</td>
		</tr>
		<tr>
			<td><button class="information_1" onclick="location.href='account_noticeC'">공지사항</button>
			</td>
		</tr>
		<tr>
			<td><button class="information_2" onclick="location.href='account_helpC'">1:1 문의하기</button>

			</td>
		</tr>

		<tr>
			<td></td>
		</tr>

	</table>


<div><br><br></div>







</body>
</html>