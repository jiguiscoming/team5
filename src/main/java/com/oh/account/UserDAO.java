package com.oh.account;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oh.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sy.function.MealkitDAO;

public class UserDAO {
	//--------------------------------코드추가부분//
		private Connection con;

		private static final UserDAO USDAO = new UserDAO(DBManager.getDbm().connect());

		private UserDAO() {
			// TODO Auto-generated constructor stub
		}

		private UserDAO(Connection con) {
			super();
			this.con = con;
		}

		public static UserDAO getMkdao() {
			return USDAO;
		}

		//--------------------------------코드추가부분//
		//CONNECTION con = null; <다 지우기
		// 메서드 STATIC 다 지우기
		// FINALLY 밑 블락에 DBManager.getDbm().close(null, pstmt, null); 로 바꿔주기
		// DBManager. 뒤에 DBManager.getDbm().로 바꿔주기
		
		
		
	public static void fileUpload(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("account/img");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		String join_profile = mr.getFilesystemName("join_profile");
		System.out.println(join_profile);
		request.setAttribute("join_profile", join_profile);

		System.out.println(join_profile);

		String join_name = mr.getParameter("join_name");
		String join_nick = mr.getParameter("join_nick");
		String join_id = mr.getParameter("join_id");
		String join_age = mr.getParameter("join_age");
		String join_gender = mr.getParameter("join_gender");
		String join_birth = mr.getParameter("join_birth");
		String join_pw = mr.getParameter("join_pw");
		String join_pw2 = mr.getParameter("join_pw2");
		String join_pwquestion = mr.getParameter("join_pwquestion");
		String join_pwquestiona = mr.getParameter("join_pwquestiona");
		String join_email = mr.getParameter("join_email");
		String join_phone = mr.getParameter("join_phone");
		String join_addr = mr.getParameter("join_addr");
		String join_agree1 = mr.getParameter("join_agree1");
		String join_agree2 = mr.getParameter("join_agree2");
		String join_agree3 = mr.getParameter("join_agree3");
		String join_agree4 = mr.getParameter("join_agree4");

		request.setAttribute("join_name", join_name);
		request.setAttribute("join_id", join_id);
		request.setAttribute("join_nick", join_nick);
		request.setAttribute("join_age", join_age);
		request.setAttribute("join_gender", join_gender);
		request.setAttribute("join_birth", join_birth);
		request.setAttribute("join_pw", join_pw);
		request.setAttribute("join_pw2", join_pw2);
		request.setAttribute("join_pwquestion", join_pwquestion);
		request.setAttribute("join_pwquestiona", join_pwquestiona);
		request.setAttribute("join_email", join_email);
		request.setAttribute("join_phone", join_phone);
		request.setAttribute("join_addr", join_addr);
		request.setAttribute("join_agree1", join_agree1);
		request.setAttribute("join_agree2", join_agree2);
		request.setAttribute("join_agree3", join_agree3);
		request.setAttribute("join_agree4", join_agree4);

		System.out.println(join_name);

	}

	public static void agree(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	public void createAccount(HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub


		PreparedStatement pstmt = null;	


		String path = request.getSession().getServletContext().getRealPath("account/img");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		String join_profile = mr.getParameter("join_profile");
		System.out.println(join_profile);
		// request.setAttribute("join_profile", join_profile);

		try {

			request.setCharacterEncoding("utf-8");
			String sql = "insert into oh_account values(?,?,?,?,?,?,'오',?,?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);

			String join_name = mr.getParameter("join_name");
			String join_nick = mr.getParameter("join_nick");
			String join_id = mr.getParameter("join_id");
			String join_pw = mr.getParameter("join_pw");
			String join_gender = mr.getParameter("join_gender");
			String join_birth = mr.getParameter("join_birth");
			// String join_addr = request.getParameter("join_addr");
			String join_age = mr.getParameter("join_age");
			String join_pwquestion = mr.getParameter("join_pwquestion");
			String join_pwquestiona = mr.getParameter("join_pwquestiona");
			String join_email = mr.getParameter("join_email");
			// String join_profile = mr.getParameter("join_profile");
			String join_phone = mr.getParameter("join_phone");
			String join_agree1 = mr.getParameter("join_agree1");
			String join_agree2 = mr.getParameter("join_agree2");
			String join_agree3 = mr.getParameter("join_agree3");
			String join_agree4 = mr.getParameter("join_agree4");

			pstmt.setString(1, join_name);
			pstmt.setString(2, join_nick);
			pstmt.setString(3, join_id);
			pstmt.setString(4, join_pw);
			pstmt.setString(5, join_gender);
			pstmt.setString(6, join_birth);

//			pstmt.setString(7, join_addr);
//			pstmt.setString(8, join_age);
//			pstmt.setString(9, join_phone);
//			pstmt.setString(10, join_pwquestion);
//			pstmt.setString(11, join_pwquestiona);
//			pstmt.setString(12, join_email);
//			pstmt.setString(13, join_profile);
//			pstmt.setString(14, agree1);
//			pstmt.setString(15, agree2);
//			pstmt.setString(16, agree3);
//			pstmt.setString(17, agree4);

			pstmt.setString(7, join_age);
			pstmt.setString(8, join_phone);
			pstmt.setString(9, join_pwquestion);
			pstmt.setString(10, join_pwquestiona);
			pstmt.setString(11, join_email);
			pstmt.setString(12, join_profile);
			pstmt.setString(13, join_agree1);
			pstmt.setString(14, join_agree2);
			pstmt.setString(15, join_agree3);
			pstmt.setString(16, join_agree4);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", join_nick + "님, 환영합니다!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public static void confirmJoin(HttpServletRequest request) {

//		String join_name = request.getParameter("join_name");
//		String join_id = request.getParameter("join_id");
//		String join_age = request.getParameter("join_age");
//		String join_gender = request.getParameter("join_gender");
//		String join_birth = request.getParameter("join_birth");
//		String join_pw = request.getParameter("join_pw");
//		String join_pw2 = request.getParameter("join_pw2");
//		String join_pwquestion = request.getParameter("join_pwquestion");
//		String join_pwquestiona = request.getParameter("join_pwquestiona");
//		String join_email = request.getParameter("join_email");
//		String join_phone = request.getParameter("join_phone");
//		String join_addr = request.getParameter("join_addr");
//		
//		
//		
//		
//	
//		request.setAttribute("join_name", join_name);
//		request.setAttribute("join_id", join_id);
//		request.setAttribute("join_age", join_age);
//		request.setAttribute("join_gender", join_gender);
//		request.setAttribute("join_birth", join_birth);
//		request.setAttribute("join_pw", join_pw);
//		request.setAttribute("join_pw2", join_pw2);
//		request.setAttribute("join_pwquestion", join_pwquestion);
//		request.setAttribute("join_pwquestiona", join_pwquestiona);
//		request.setAttribute("join_email", join_email);
//		request.setAttribute("join_phone", join_phone);
//		request.setAttribute("join_addr", join_addr);
//		System.out.println(join_name);

	}

	public void login(HttpServletRequest request) {

		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from oh_account where account_id= ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (userPw.equals(rs.getString("account_pw"))) {
					request.setAttribute("r", "어서 오세요!");

					accountB a = new accountB();

					a.setAccount_id(rs.getString("account_id"));
					a.setAccount_pw(rs.getString("account_pw"));
					a.setAccount_name(rs.getString("account_name"));
					a.setAccount_nick(rs.getString("account_nick"));
					a.setAccount_gender(rs.getString("account_gender"));
					a.setAccount_birth(rs.getString("account_birth"));
					a.setAccount_addr(rs.getString("account_addr"));
					a.setAccount_age(rs.getString("account_age"));
					a.setAccount_phone(rs.getString("account_phone"));
					a.setAccount_pwquestion(rs.getString("account_pwquestion"));
					a.setAccount_pwquestiona(rs.getString("account_pwquestiona"));
					a.setAccount_email(rs.getString("account_email"));
					a.setAccount_img(rs.getString("account_img"));
					a.setAccount_agree1(rs.getString("account_agree1"));
					a.setAccount_agree2(rs.getString("account_agree2"));
					a.setAccount_agree3(rs.getString("account_agree3"));
					a.setAccount_agree4(rs.getString("account_agree4"));
					a.setAccount_date(rs.getString("account_date"));

					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a);
					hs.setMaxInactiveInterval(6000);

					request.setAttribute("loginPage", "account/loginOK.jsp");

				} else {
					request.setAttribute("r", "패스워드를 확인해 주세요!");
					request.setAttribute("loginPage", "account/loginBtn.jsp");
				}
			} else {
				request.setAttribute("r", "가입하지 않은 회원입니다!!!");
				request.setAttribute("loginPage", "account/loginBtn.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public static void logout(HttpServletRequest request) {
		// TODO Auto-generated method stub

		HttpSession hs = request.getSession();
		hs.invalidate();

		request.setAttribute("r", "또 오세요!");

	}

// 세션 유지를 위해 모든 컨트롤러에 넣어 주세요.!

	public void loginCheck(HttpServletRequest request) {
		// TODO Auto-generated method stub

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

		if (acc == null) {
			request.setAttribute("loginPage", "account/loginBtn.jsp");
		} else {
			request.setAttribute("loginPage", "account/loginOK.jsp");

		}

	}

	// id 중복체크
	public int idCheck(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int value = 0;

		try {
			String sql = "select account_id from oh_account where account_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				value = 1;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		return value;
	}

	public  void secession(HttpServletRequest request) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

		try {
			String sql = "DELETE oh_account WHERE account_id = ? ";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, acc.getAccount_id());

			System.out.println(acc.getAccount_id());

			int row = pstmt.executeUpdate();
			/* acc.getAccount_id() */
			/*
			 * if(row == 1) { System.out.println("삭제되었습니다"); }else {
			 * System.out.println("삭제 실패.."); }
			 */

			request.setAttribute("r", "안녕히!");
			request.setAttribute("loginPage", "account/loginBtn.jsp");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

// 탈퇴했을 때 login 체크 기능과 탈퇴 결과 페이지로 가는 기능을 합쳐 놓은 것

	public static void loginCheck_S(HttpServletRequest request) {
		// TODO Auto-generated method stub

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

		if (acc == null) {
			request.setAttribute("r", "안녕히!");
			request.setAttribute("loginPage", "account/loginBtn.jsp");
		} else {
			request.setAttribute("r", "감사합니다!");
			request.setAttribute("loginPage", "account/loginOK.jsp");
		}

	}

	public void findID(HttpServletRequest request) {
		// TODO Auto-generated method stub

		String W_email = request.getParameter("W_email");
		String W_name = request.getParameter("W_name");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from oh_account where account_name= ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, W_name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (W_email.equals(rs.getString("account_email"))) {

					String account_id = rs.getString("account_id");

					request.setAttribute("r", "당신의 아이디는 " + account_id + "입니다!");

				} else {
					request.setAttribute("r", "계정을 찾을 수 없습니다..");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	// 비밀번호 0000으로 변경
	public void findPW(HttpServletRequest request) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String W_id = request.getParameter("W_id");
		String W_pwquestiona = request.getParameter("W_pwquestiona");
		String W_pwquestion = request.getParameter("W_pwquestion");

		try {
			String sql = "select * from oh_account where account_id= ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, W_id);
			rs = pstmt.executeQuery();

			System.out.println(W_id);

			if (rs.next()) {

				if (W_pwquestiona.equals(rs.getString("account_pwquestiona"))) {

					String sql0000 = "UPDATE oh_account SET account_pw = '0000' WHERE account_id = ?";

					pstmt = con.prepareStatement(sql0000);

					pstmt.setString(1, W_id);
					rs = pstmt.executeQuery();
					System.out.println(rs.getString("account_pw"));

					request.setAttribute("r", "비밀번호가 0000으로 변경되었습니다!");

					System.out.println(rs.getString("account_pw"));

				} else {
					request.setAttribute("r", "계정을 찾을 수 없습니다..");

				}
			} else {
				request.setAttribute("r", "계정을 찾을 수 없습니다..");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public static void information(HttpServletRequest request) {
		// TODO Auto-generated method stub

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

	}




	public void confirmPW(HttpServletRequest request) {

		// TODO Auto-generated method stub

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

		
		String W_pw = request.getParameter("W_pw");

		System.out.println(acc.getAccount_pw());
		System.out.println(W_pw);

		if (W_pw.equals(acc.getAccount_pw())) {
			/*
			 * request.setAttribute("r", "비밀번호가 틀렸습니다!");
			 */
			request.setAttribute("contentPage", "myPage/account_updatePW.jsp");

		} else {
			request.setAttribute("r", "비밀번호가 틀렸습니다!");
			request.setAttribute("contentPage", "myPage/account_updatePWR.jsp");

		}

	}

	public void updatePW(HttpServletRequest request) throws IOException {

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String path = request.getSession().getServletContext().getRealPath("account/img");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		String W_pw = mr.getParameter("W_pw");
		String W_pw2 = mr.getParameter("W_pw2");

		System.out.println(W_pw);
		System.out.println(W_pw2);

		try {

			String A_id = acc.getAccount_id();
			System.out.println(A_id);
			System.out.println(W_pw);

			if (W_pw.equals(W_pw2)) {
				String sql = "update oh_account set account_pw = ? where account_id = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, W_pw);
				pstmt.setString(2, A_id);

				rs = pstmt.executeQuery();

				if (pstmt.executeUpdate() == 1) {

					request.setAttribute("r", "비밀번호 변경 성공!");
					request.setAttribute("contentPage", "myPage/account_updatePWR.jsp");
				} else {
					request.setAttribute("r", "비밀번호가 일치하지 않습니다!");
					request.setAttribute("contentPage", "myPage/account_updatePWR.jsp");
				}

			}

			else {
				request.setAttribute("r", "비밀번호가 일치하지 않습니다!");
				request.setAttribute("contentPage", "myPage/account_updatePWR.jsp");
			}
		}

		catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

	}

	public void informationUpdate(HttpServletRequest request) {

		HttpSession hs = request.getSession();
		accountB acc = (accountB) hs.getAttribute("accountInfo");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String U_name = request.getParameter("U_name");
		String U_nick = request.getParameter("U_nick");
		// String U_gender = request.getParameter("U_gender");
		String U_email = request.getParameter("U_email");
		String U_phone = request.getParameter("U_phone");

		try {

			String A_id = acc.getAccount_id();
			String A_name = acc.getAccount_name();
			String A_nick = acc.getAccount_nick();
			// String A_gender = acc.getAccount_gender();
			String A_email = acc.getAccount_email();
			String A_phone = acc.getAccount_phone();

			System.out.println(U_name);
			System.out.println(U_nick);
			// System.out.println(U_gender);
			System.out.println(U_email);
			System.out.println(U_phone);
			System.out.println(U_nick);
			System.out.println(A_id);

			if (rs.next()) {


				if (A_name != U_name || A_nick != U_nick ||  A_email != U_email|| A_phone != U_phone) {
					String sql = "update oh_account set account_name = ?, account_nick = ?, account_email = ?, account_phone = ? where account_id = ?";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, U_name);
					pstmt.setString(2, U_nick);
					pstmt.setString(3, U_email);
					pstmt.setString(4, U_phone);
					pstmt.setString(5, A_id);
					
					rs = pstmt.executeQuery();
					
					request.setAttribute("r", "업데이트 성공!");

					

				}

			
				
			 else {
					request.setAttribute("r", "업데이트 실패.. 관리자에게 문의해 주세요");

				}

			}

		}

		catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}

		/*
		 * if(rs.next()) {
		 * 
		 * con = DBManager.connect();
		 * 
		 * if (A_name != U_name) { String sql =
		 * "update oh_account set account_name = ? where account_id = ?";
		 * 
		 * 
		 * pstmt = con.prepareStatement(sql); pstmt.setString(1, U_name);
		 * pstmt.setString(2, A_id); rs = pstmt.executeQuery();
		 * 
		 * 
		 * }
		 * 
		 * if (A_nick != U_nick) { String sql =
		 * "update oh_account set account_nick = ? where account_id = ?";
		 * 
		 * pstmt = con.prepareStatement(sql); pstmt.setString(1, U_nick);
		 * pstmt.setString(2, A_id); rs = pstmt.executeQuery();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * if (A_age != U_age) { String sql =
		 * "update oh_account set account_age = ? where account_id = ?";
		 * 
		 * pstmt = con.prepareStatement(sql); pstmt.setString(1, U_age);
		 * pstmt.setString(2, A_id); rs = pstmt.executeQuery();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * if (A_gender != U_gender) { String sql =
		 * "update oh_account set account_gender = ? where account_id = ?";
		 * 
		 * con = DBManager.connect(); pstmt = con.prepareStatement(sql);
		 * pstmt.setString(1, U_gender); pstmt.setString(2, A_id);
		 * 
		 * }
		 * 
		 * 
		 * if (A_birth != U_birth) { String sql =
		 * "update oh_account set account_birth = ? where account_id = ?";
		 * 
		 * pstmt = con.prepareStatement(sql); pstmt.setString(1, U_birth);
		 * pstmt.setString(2, A_id); rs = pstmt.executeQuery();
		 * 
		 * }
		 * 
		 * 
		 * 
		 * if (A_email != U_email) { String sql =
		 * "update oh_account set account_email = ? where account_id = ?";
		 * 
		 * pstmt = con.prepareStatement(sql); pstmt.setString(1, U_email);
		 * pstmt.setString(2, A_id); rs = pstmt.executeQuery();
		 * 
		 * 
		 * }
		 * 
		 * if (A_phone != U_phone) { String sql =
		 * "update oh_account set account_phone = ? where account_id = ?";
		 * 
		 * pstmt = con.prepareStatement(sql); pstmt.setString(1, U_phone);
		 * pstmt.setString(2, A_id); rs = pstmt.executeQuery();
		 * 
		 * 
		 * }
		 * 
		 */

		// 혹시 몰라서..
		
	}

}
