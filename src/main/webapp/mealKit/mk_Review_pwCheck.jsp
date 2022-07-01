<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.oh.main.DBManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
String Review_pw = (String) request.getParameter("Review_pw");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {

	con = DBManager.getDbm().connect();
	String sql = "select * from mealkit_review_test where mealkit_review_no = ?";

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, Review_pw);

	rs = pstmt.executeQuery(); // 읽기전용

	JSONObject jo = new JSONObject();

	if (rs.next()) {

		jo.put("r", "1");

	} else {

		jo.put("r", "0");
	}

	response.setContentType("applocation/json");
	out.print(jo.toJSONString());

} catch (Exception e) {

	e.printStackTrace();

} finally {
	DBManager.getDbm().close(con, pstmt, rs);

}
%>