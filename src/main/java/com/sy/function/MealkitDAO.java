package com.sy.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sy.function.DBManager;
import com.sy.function.Mealkit;

public class MealkitDAO {

	public static void regmealkit(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_test values (mealkit_test_seq.nextval , ?,?,?,?,?,sysdate )";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31467280, "utf-8",
					new DefaultFileRenamePolicy());

			String mealkit_name = mr.getParameter("mealkit_name");
			String mealkit_price = mr.getParameter("mealkit_price");
			String mealkit_type = mr.getParameter("mealkit_type");
			String mealkit_img = mr.getFilesystemName("mealkit_img");
			String mealkit_txt = mr.getParameter("mealkit_txt");

			System.out.println(mealkit_name);
			System.out.println(mealkit_price);
			System.out.println(mealkit_type);
			System.out.println(mealkit_img);
			System.out.println(mealkit_txt);

			pstmt.setString(1, mealkit_name);
			pstmt.setString(2, mealkit_price);
			pstmt.setString(3, mealkit_type);
			pstmt.setString(4, mealkit_img);
			pstmt.setString(5, mealkit_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void viewmealkit(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				m = new Mealkit();
				m.setMealkit_no(rs.getInt("mealkit_no"));
				m.setMealkit_name(rs.getString("mealkit_name"));
				m.setMealkit_price(rs.getInt("mealkit_price"));
				m.setMealkit_img(rs.getString("mealkit_img"));
				m.setMealkit_txt(rs.getString("mealkit_txt"));
				m.setMealkit_date(rs.getDate("mealkit_date"));

				mealkitlist.add(m);

			}
			request.setAttribute("mealkits", mealkitlist);

		} catch (Exception e) {

		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void getMealkit(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from mealkit_test where mealkit_no=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));

			rs = pstmt.executeQuery();
			Mealkit m = null;

			if (rs.next()) {

				m = new Mealkit();
				m.setMealkit_no(rs.getInt("mealkit_no"));
				m.setMealkit_name(rs.getString("mealkit_name"));
				m.setMealkit_price(rs.getInt("mealkit_price"));
				m.setMealkit_img(rs.getString("mealkit_img"));
				m.setMealkit_txt(rs.getString("mealkit_txt"));
				m.setMealkit_date(rs.getDate("mealkit_date"));

				request.setAttribute("Mealkit", m);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DBManager.close(con, pstmt, rs);

		}

	}

	public static void regReviewMealkit(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_review_test values (mealkit_review_test_seq.nextval ,?,?,?,?,?,sysdate )";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31467280, "utf-8",
					new DefaultFileRenamePolicy());

			// String mealkit_review_id = mr.getParameter("mealkit_review_id");
			String mealkit_review_title = mr.getParameter("mealkit_review_title");
			String mealkit_review_img = mr.getFilesystemName("mealkit_review_img");
			String mealkit_review_txt = mr.getParameter("mealkit_review_txt");
			int mealkit_review_star = Integer.parseInt(mr.getParameter("starpoint"));
			int mealkit_review_mk_no = Integer.parseInt(mr.getParameter("mealkit_review_mk_no"));

			// System.out.println(mealkit_review_id);
			System.out.println(mealkit_review_title);
			System.out.println(mealkit_review_img);
			System.out.println(mealkit_review_txt);
			System.out.println(mealkit_review_star);
			System.out.println(mealkit_review_mk_no);

			// pstmt.setString(1, mealkit_review_id);
			pstmt.setInt(1, mealkit_review_mk_no);
			pstmt.setString(2, mealkit_review_title);
			pstmt.setString(3, mealkit_review_img);
			pstmt.setString(4, mealkit_review_txt);
			pstmt.setInt(5, mealkit_review_star);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void viewReviewMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			ArrayList<MealkitReview> MealkitReviewlist = new ArrayList<MealkitReview>();

			MealkitReview m = null;

			String sql = "select * from mealkit_review_test where mealkit_review_mk_no=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
			rs = pstmt.executeQuery();
	
			
			while (rs.next()) {
				
				m = new MealkitReview();
				m.setMealkit_review_no(rs.getInt("mealkit_review_no"));
				m.setMealkit_review_title(rs.getString("mealkit_review_title"));
				m.setMealkit_review_txt(rs.getString("mealkit_review_txt"));
				m.setMealkit_review_date(rs.getDate("mealkit_review_date"));

				if (rs.getInt("mealkit_review_star") == 10) {
					m.setMealkit_review_star(100);
				} else if (rs.getInt("mealkit_review_star") == 9) {
					m.setMealkit_review_star(90);
				} else if (rs.getInt("mealkit_review_star") == 8) {
					m.setMealkit_review_star(80);
				} else if (rs.getInt("mealkit_review_star") == 7) {
					m.setMealkit_review_star(70);
				} else if (rs.getInt("mealkit_review_star") == 6) {
					m.setMealkit_review_star(60);
				} else if (rs.getInt("mealkit_review_star") == 5) {
					m.setMealkit_review_star(50);
				} else if (rs.getInt("mealkit_review_star") == 4) {
					m.setMealkit_review_star(40);
				} else if (rs.getInt("mealkit_review_star") == 3) {
					m.setMealkit_review_star(30);
				} else if (rs.getInt("mealkit_review_star") == 2) {
					m.setMealkit_review_star(20);
				} else if (rs.getInt("mealkit_review_star") == 1) {
					m.setMealkit_review_star(10);

				}

				MealkitReviewlist.add(m);

			}

			request.setAttribute("MealkitReviewlist", MealkitReviewlist);

		} catch (Exception e) {

		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void RegQnAMealkit(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_review_test values (mealkit_QnA_test_seq.nextval ,?,?,?,?,?,?,sysdate )";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31467280, "utf-8",
					new DefaultFileRenamePolicy());

			int mealkit_QnA_mk_no = Integer.parseInt(mr.getParameter("mealkit_QnA_mk_no"));
			String mealkit_QnA_id = mr.getParameter("mealkit_QnA_id");
			int mealkit_QnA_pw = Integer.parseInt(mr.getParameter("mealkit_QnA_pw"));
			String mealkit_QnA_title = mr.getParameter("mealkit_QnA_title");
			String mealkit_QnA_img = mr.getFilesystemName("files");
			String mealkit_QnA_txt = mr.getParameter("mealkit_QnA_txt");

			// System.out.println(mealkit_review_id);
			System.out.println(mealkit_QnA_mk_no);
			System.out.println(mealkit_QnA_id);
			System.out.println(mealkit_QnA_pw);
			System.out.println(mealkit_QnA_title);
			System.out.println(mealkit_QnA_img);
			System.out.println(mealkit_QnA_txt);

			// pstmt.setString(1, mealkit_review_id);
			pstmt.setInt(1, mealkit_QnA_mk_no);
			pstmt.setString(2, mealkit_QnA_id);
			pstmt.setInt(3, mealkit_QnA_pw);
			pstmt.setString(4, mealkit_QnA_title);
			pstmt.setString(5, mealkit_QnA_img);
			pstmt.setString(6, mealkit_QnA_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	

	
}
