<%@page import="java.sql.SQLException"%>
<%@page import="com.oh.account.DBManager_account"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
--%>

<%


String userId= request.getParameter("id");



Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	String sql = "select * from oh_account where account_id= ?";
	con = DBManager_account.connect();
	pstmt = con.prepareStatement(sql);
	
	pstmt.setString(1, userId);
	rs = pstmt.executeQuery();
	
	JSONObject jo = new JSONObject();
	
	if (rs.next()){
		jo.put("r","1");
	} else {
		jo.put("r","0");
	
		
	}
	
	response.setContentType("application/json");
	out.print(jo.toJSONString());
	
	
	
	
	

} catch (SQLException e) {
	e.printStackTrace();
} finally {
	DBManager_account.close(con, pstmt, rs);
}





%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인</title>
</head>
<body>
	
	
	
	
	
	
	
	
	
</body>
</html>