package com.sy.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oh.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sy.function.Mealkit;

public class MealkitDAO {
//--------------------------------코드추가부분//
	private Connection con;

	private static final MealkitDAO MKDAO = new MealkitDAO(DBManager.getDbm().connect());

	private MealkitDAO() {
		// TODO Auto-generated constructor stub
	}

	private MealkitDAO(Connection con) {
		super();
		this.con = con;
	}

	public static MealkitDAO getMkdao() {
		return MKDAO;
	}

	//--------------------------------코드추가부분//
	//CONNECTION con = null; <다 지우기
	// 메서드 STATIC 다 지우기
	// FINALLY 밑 블락에 DBManager.getDbm().close(null, pstmt, null); 로 바꿔주기
	// DBManager. 뒤에 DBManager.getDbm().로 바꿔주기
	
	public void regmealkit(HttpServletRequest request) {

		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_test values (mealkit_test_seq.nextval , ?,?,?,?,?,sysdate )";
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
				request.setAttribute("r", "��ϼ���");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "��������");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewmealkit(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test";
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
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void getMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from mealkit_test where mealkit_no=?";
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

			DBManager.getDbm().close(null, pstmt, null);

		}

	}

	public void regReviewMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_review_test values (mealkit_review_test_seq.nextval ,?,?,?,?,?,sysdate )";
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
				request.setAttribute("r", "��ϼ���");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "��������");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewReviewMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<MealkitReview> MealkitReviewlist = new ArrayList<MealkitReview>();

			MealkitReview m = null;

			String sql = "select * from mealkit_review_test where mealkit_review_mk_no=?";
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
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void RegQnAMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_QnA_test values (mealkit_QnA_test_seq.nextval ,?,?,?,?,?,?,?,?,0, sysdate )";
			pstmt = con.prepareStatement(sql);

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31467280, "utf-8",
					new DefaultFileRenamePolicy());

			int mealkit_QnA_mk_no = Integer.parseInt(mr.getParameter("mealkit_QnA_mk_no"));
			String mealkit_QnA_id = mr.getParameter("mealkit_QnA_id");
			int mealkit_QnA_pw = Integer.parseInt(mr.getParameter("mealkit_QnA_pw"));
			String mealkit_QnA_title = mr.getParameter("mealkit_QnA_title");
			String mealkit_QnA_img = mr.getFilesystemName("mealkit_QnA_img");
			String mealkit_QnA_txt = mr.getParameter("mealkit_QnA_txt");
			String mealkit_Answer_QnA_title = null;
			String mealkit_Answer_QnA_txt = null;
			// System.out.println(mealkit_review_id);
			System.out.println(mealkit_QnA_mk_no);
			System.out.println(mealkit_QnA_id);
			System.out.println(mealkit_QnA_pw);
			System.out.println(mealkit_QnA_title);
			System.out.println(mealkit_QnA_img);
			System.out.println(mealkit_QnA_txt);

			pstmt.setInt(1, mealkit_QnA_mk_no);
			pstmt.setString(2, mealkit_QnA_id);
			pstmt.setInt(3, mealkit_QnA_pw);
			pstmt.setString(4, mealkit_QnA_title);
			pstmt.setString(5, mealkit_QnA_img);
			pstmt.setString(6, mealkit_QnA_txt);
			pstmt.setString(7, mealkit_Answer_QnA_title);
			pstmt.setString(8, mealkit_Answer_QnA_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��ϼ���");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "��������");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewQnAMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<MealkitQnA> MealkitQnAlist = new ArrayList<MealkitQnA>();

			MealkitQnA m = null;

			String sql = "select * from mealkit_QnA_test where mealkit_QnA_mk_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
			rs = pstmt.executeQuery();

			while (rs.next()) {

				m = new MealkitQnA();
				m.setMealkit_QnA_no(rs.getInt("mealkit_QnA_no"));
				m.setMealkit_QnA_id(rs.getString("mealkit_QnA_id"));
				m.setMealkit_QnA_title(rs.getString("mealkit_QnA_title"));
				m.setMealkit_QnA_txt(rs.getString("mealkit_QnA_txt"));
				m.setMealkit_QnA_date(rs.getDate("mealkit_QnA_date"));
				m.setMealkit_QnA_img(rs.getString("mealkit_QnA_img"));
				m.setMealkit_QnA_Answer_title(rs.getString("mealkit_QnA_Answer_title"));
				m.setMealkit_QnA_Answer_txt(rs.getString("mealkit_QnA_Answer_txt"));

				if (rs.getInt("mealkit_QnA_Answer_Confirm") == 0) {
					m.setMealkit_QnA_Answer_Confirm("�亯�����");
				} else {

					m.setMealkit_QnA_Answer_Confirm("�亯�Ϸ�");
				}

				MealkitQnAlist.add(m);

			}

			request.setAttribute("MealkitQnAlist", MealkitQnAlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void regAnswerQnAMealkit(HttpServletRequest request) {

		PreparedStatement pstmt = null;

		try {
			String sql = "insert into mealkit_Answer_test values (mealkit_Answer_test_seq.nextval ,?,?,?,sysdate )";
			pstmt = con.prepareStatement(sql);

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31467280, "utf-8",
					new DefaultFileRenamePolicy());

			int mealkit_Answer_QnA_no = Integer.parseInt(mr.getParameter("mealkit_Answer_QnA_no"));
			String mealkit_Answer_title = mr.getParameter("mealkit_Answer_title");
			String mealkit_Answer_txt = mr.getParameter("mealkit_Answer_txt");

			// System.out.println(mealkit_review_id);
			System.out.println(mealkit_Answer_QnA_no);
			System.out.println(mealkit_Answer_title);
			System.out.println(mealkit_Answer_txt);

			pstmt.setInt(1, mealkit_Answer_QnA_no);
			pstmt.setString(2, mealkit_Answer_title);
			pstmt.setString(3, mealkit_Answer_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��ϼ���");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "��������");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewAnswerQnAMealkit(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<MealkitAnswer> MealkitAnswerlist = new ArrayList<MealkitAnswer>();

			MealkitAnswer m = null;

			String sql = "select * from mealkit_Answer_test where mealkit_Answer_QnA_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
			rs = pstmt.executeQuery();

			while (rs.next()) {

				m = new MealkitAnswer();
				m.setMealkit_Answer_title(rs.getString("mealkit_Answer_title"));
				m.setMealkit_Answer_txt(rs.getString("mealkit_Answer_txt"));

				MealkitAnswerlist.add(m);

			}

			request.setAttribute("MealkitAnswerlist", MealkitAnswerlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void UpAnswerQnAMealkit(HttpServletRequest request) {

		PreparedStatement pstmt = null;

		try {
			// String sql = "Update mealkit_QnA_test\r\n" + "set
			// mealkit_QnA_Answer_title=?,\r\n" + "set mealkit_QnA_Answer_txt=?,\r\n" + "
			// where mealkit_QnA_no=?";
			String sql = "Update  mealkit_QnA_test\r\n" + "set mealkit_QnA_Answer_title = ?\r\n"
					+ ", mealkit_QnA_Answer_txt = ?\r\n" + ", mealkit_QnA_Answer_Confirm =1\r\n"
					+ "where mealkit_QnA_no= ?\r\n";
			request.setCharacterEncoding("utf-8");

			pstmt = con.prepareStatement(sql);

			String title = request.getParameter("mealkit_QnA_Answer_title");
			String txt = request.getParameter("mealkit_QnA_Answer_txt");
			String no = request.getParameter("mealkit_Answer_QnA_no");

			System.out.println(title);
			System.out.println(txt);
			System.out.println(no);

			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setString(3, no);

			System.out.println(title);
			System.out.println(txt);
			System.out.println(no);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("���� ����");
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewKorMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test where mealkit_type='kor'";
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
			request.setAttribute("korlist", mealkitlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewAmeMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test where mealkit_type='ame'";
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
			request.setAttribute("amelist", mealkitlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewJpnMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test where mealkit_type='jpn'";
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
			request.setAttribute("jpnlist", mealkitlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewChnMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test where mealkit_type='chn'";
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
			request.setAttribute("chnlist", mealkitlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void viewSalMealkit(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			ArrayList<Mealkit> mealkitlist = new ArrayList<Mealkit>();

			Mealkit m = null;

			String sql = "select * from mealkit_test where mealkit_type='sal'";
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
			request.setAttribute("sallist", mealkitlist);

		} catch (Exception e) {

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

}
