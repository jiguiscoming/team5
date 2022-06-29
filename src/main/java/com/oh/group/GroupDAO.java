package com.oh.group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oh.account.UserDAO;
import com.oh.main.DBManager;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class GroupDAO {
	//--------------------------------코드추가부분//
			private Connection con;

			private static final GroupDAO GRDAO = new GroupDAO(DBManager.getDbm().connect());

			private GroupDAO() {
				// TODO Auto-generated constructor stub
			}

			private GroupDAO(Connection con) {
				super();
				this.con = con;
			}

			public static GroupDAO getMkdao() {
				return GRDAO;
			}

			//--------------------------------코드추가부분//
			//CONNECTION con = null; <다 지우기
			// 메서드 STATIC 다 지우기
			// FINALLY 밑 블락에 DBManager.getDbm().close(null, pstmt, null); 로 바꿔주기
			// DBManager. 뒤에 DBManager.getDbm().로 바꿔주기
			
	

	public void groupReg(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql = "insert into group_purchase values(group_purchase_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
		
		try {
			String saveDirectory = request.getServletContext().getRealPath("group_imgFolder");
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280,"utf-8",new DefaultFileRenamePolicy());
			
			System.out.println(saveDirectory);
			

			request.setCharacterEncoding("utf-8");

			pstmt = con.prepareStatement(sql);
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");
			String area = mr.getParameter("area");
			String file = mr.getFilesystemName("file");
			
			

//			id세션받기
//			닉네임 세션받기

			pstmt.setString(1, "id");
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4, area);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setString(7, "nick");
			pstmt.setString(8, file);
			
			if(pstmt.executeUpdate() == 1) {

				System.out.println("성공");

			}
			
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("서버오류");
		}finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void getGroups(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select rownum, a.* from (select * from group_purchase order by group_date asc)a order by a.group_date desc";
		
		try {

			request.setCharacterEncoding("utf-8");
			System.out.println("연결성공");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;

			while(rs.next()) {
				System.out.println("데이터 있음");
				int group_no = rs.getInt("group_no");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				String group_nick = rs.getString("group_nickname");
				String group_img = rs.getString("group_img");
				
				group = new Group(group_no, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits,group_nick,group_img);
				groups.add(group);				
			}
			
			request.setAttribute("groups", groups);
			System.out.println("데이터 담음");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void groupUpdate(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		String sql = "update group_purchase set group_title=?, group_txt=?, group_area=?, group_img=? where group_no=?";
		
		try {

			request.setCharacterEncoding("utf-8");

			String saveDirectory = request.getServletContext().getRealPath("group_imgFolder");
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280,"utf-8",new DefaultFileRenamePolicy());
			

			pstmt = con.prepareStatement(sql);
			
			String area = mr.getParameter("area");
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");
			int no =Integer.parseInt(mr.getParameter("no"));
			String newFile = mr.getFilesystemName("newFile");
			String oldFile = mr.getParameter("oldFile");

			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setString(3, area);
			if(newFile != null) {
				pstmt.setString(4, newFile);
			}else {
				pstmt.setString(4, oldFile);
			}
			pstmt.setInt(5, no);
			
			if(pstmt.executeUpdate()==1) {
				System.out.println("성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버 오류");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		
	}

	public void getGroup(HttpServletRequest request) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from group_purchase where group_no=?";
		
		try {
			request.setCharacterEncoding("utf-8");
			pstmt = con.prepareStatement(sql);
			
			int no =Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			
			Group group1 = null;

			if(rs.next()) {
				
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				String group_nick = rs.getString("group_nickname");
				String group_img = rs.getString("group_img");
				
				group1 = new Group(no, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits,group_nick,group_img);
				request.setAttribute("group", group1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void groupDelete(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql = "delete group_purchase where group_no = ?";
		int no = Integer.parseInt(request.getParameter("no"));
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버오류");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void hitsUp(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			해당 게시글 읽기
//			해당 게시글 db 먼저 읽음
			String sql1 = "select * from group_purchase where group_no=?";
			pstmt = con.prepareStatement(sql1);
			int no =Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int hits = rs.getInt("group_hits");
				hits ++;
				
				// 조회수 up해주기
				String sql2 = "update group_purchase set group_hits=? where group_no=?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, hits);
				pstmt.setInt(2, no);
				
				if(pstmt.executeUpdate() == 1) {
					System.out.println("조회수 up");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버오류");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void commentReg(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql = "insert into group_comment values(group_comment_seq.nextval, ?, ?, ?, sysdate)";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			pstmt = con.prepareStatement(sql);
			String listno = request.getParameter("no");
			String comment = request.getParameter("comment");
			
			System.out.println(listno);
			System.out.println(comment);
			
//			id세션받기
//			id는 세션으로 받기
			pstmt.setString(1, listno);
			pstmt.setString(2, "id");
			pstmt.setString(3, comment);
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("성공");
				request.setAttribute("result", "등록성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "서버오류");
		}finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void getComments(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from group_comment where group_comment_listno=? order by group_comment_date desc";
		
		try {

			request.setCharacterEncoding("utf-8");
			pstmt = con.prepareStatement(sql);
			int listno =Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, listno);
			rs = pstmt.executeQuery();
			
			ArrayList<GroupComment> comments = new ArrayList<GroupComment>();
			GroupComment comment = null;

			while(rs.next()) {
				int comment_no = rs.getInt("group_comment_no");
				int list_no = rs.getInt("group_comment_listno");
				String id = rs.getString("group_comment_id");
				String txt = rs.getString("group_comment_txt"); 
				Date date = rs.getDate("group_comment_date");
				
				comment = new GroupComment(comment_no, list_no, id, txt, date);
				comments.add(comment);				
			}
			
			request.setAttribute("comments", comments);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void getRegionGroups(HttpServletRequest request) {
	
		// 연결준비
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 지역 조건안에 페이징된 게시글 받기 위한 쿼리문
		String sql = "select * from (select rownum as num, a.* from (select * from group_purchase where group_purchase.group_area=? order by group_date desc)a) where num between ? and ?";
		
		try {
			//한글깨짐
			request.setCharacterEncoding("utf-8");
			pstmt = con.prepareStatement(sql);
			
			// 한페이지에 보여줄 게시글 수 : 4
			int pageSize = 4;
			// 현제 페이지
			String pageNum = request.getParameter("pageNum");
			
			// 현재페이지(int로 파싱), 시작게시글번호, 끝게시글번호 선언 및 초기화
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1)*pageSize+1;
			int endRow = currentPage*pageSize;
			
			// 해당 지역 게시글에서 4개씩 끊어서 가져옴
			// 첫번째 ? : 지역 파라미터  두번째? : 시작게시글 번호 세번째 ? : 마지막 게시글 번호
			String region = request.getParameter("region"); 
			pstmt.setString(1, region);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;

			while(rs.next()) {
				int group_no = rs.getInt("group_no");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				String group_nick = rs.getString("group_nickname");
				String group_img = rs.getString("group_img");
				
				group = new Group(group_no,group_id, group_title, group_txt, group_date, group_area, group_like, group_hits,group_nick,group_img);
				groups.add(group);				
			}
			
			request.setAttribute("groups", groups);
			// 전체게시글 구하기위한 sql문 attribute에 넣음
			request.setAttribute("sql", "select count(*) from group_purchase where group_area='" + region + "'");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void getGroupSearch(HttpServletRequest request) {
		// 연결준비
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 지역이 있는지 확인
		// 검색 조건 안에 rownum 조건 붙여서 게시글 번호 제한
		String region = request.getParameter("region");
		//지역이 있으면
		String sql = "select * from (select rownum as num, a.* from (select * from (select * from group_purchase where group_purchase.group_area=?) where group_title like ? order by group_date desc)a) where num between ? and ?";
		//지역이 없으면 = 전국
		if(region.equals("전국") || region.equals("")) {
			sql = "select * from (select rownum as num, a.* from (select * from group_purchase where group_title like ? order by group_date desc)a) where num between ? and ?";
		}
		try {
			
			request.setCharacterEncoding("utf-8");
			pstmt = con.prepareStatement(sql);
			
			// 검색한 값
			String search = request.getParameter("search"); 
			
			// 한페이지에 보여줄 게시글 수 : 4
			int pageSize = 4;
			
			// 현제 페이지
			String pageNum = request.getParameter("pageNum");
			
			// 현재페이지(int로 파싱), 시작게시글번호, 끝게시글번호 선언 및 초기화
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1)*pageSize+1;
			int endRow = currentPage*pageSize;
			
			
			// 전국일때
			// 첫번째 ? : 검색한 값  두번째 ? : 첫 게시글 번호  세번째 ? : 마지막 게시글 번호
			if(region.equals("전국") || region.equals("")) {
				pstmt.setString(1, "%" + search + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			} 
				//지역이 있을때
				else {
				pstmt.setString(1, region);
				pstmt.setString(2, "%" + search + "%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
			}
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;
			
			// 해당 게시글을 groups에 담음
			// 검색결과 있으면 객체에 담아 arraylist에 담기
			while(rs.next()) {
				int group_no = rs.getInt("group_no");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				String group_nick = rs.getString("group_nickname");
				String group_img = rs.getString("group_img");
				
				group = new Group(group_no,group_id, group_title, group_txt, group_date, group_area, group_like, group_hits,group_nick,group_img);
				groups.add(group);				
			}
			
			// arraylist를 attribute에 담음
			request.setAttribute("groups", groups);
			// 전국이라면 전체게시글 수 구하는 sql
			if(region.equals("전국") || region.equals("")) {
			request.setAttribute("sql", "select count(*) from group_purchase where group_title like '%" + search + "%'");
			} 	// 지역+검색이 있다면 해당 지역 게시글 수 구하는 sql
				else {
				request.setAttribute("sql", "select count(*) from(select * from group_purchase where group_area='" + region + "') where group_title like '%" + search + "%'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public void groupPaging(HttpServletRequest request,int pageNum) {
		//연결 준비
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from (select rownum as num, a.* from (select * from group_purchase order by group_date desc)a) where num between ? and ?";
		
		// 한페이지에 보여줄 게시글 수 : 4
		int pageSize = 4;
		// 현제 페이지
		
		
		// 현재페이지(int로 파싱), 시작게시글번호, 끝게시글번호 선언 및 초기화
		int startRow = (pageNum-1)*pageSize+1;
		int endRow = pageNum*pageSize;
		
		// 여러 객체를 넣을 arraylist 만들어줌
		ArrayList<Group> groups = new ArrayList<Group>();
		// 각자 bean 준비
		Group group = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//첫번째 ? = 시작 게시글 번호 , 두번째 ? = 끝 게시글 번호
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			// 읽으면 객체에 넣어주기 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int group_no = rs.getInt("group_no");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				String group_nick = rs.getString("group_nickname");
				String group_img = rs.getString("group_img");
				
				group = new Group(group_no, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits,group_nick,group_img);
				groups.add(group);				
				
			}
			// attribute에 전체 게시글 담음
			request.setAttribute("groups", groups);
			request.setAttribute("sql", "select count(*) from group_purchase");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		
		
	}

	public void groupPageMove(HttpServletRequest request, String sql,int pageNum) {
		// 연결 준비
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 보여줄 게시글 수 : 4
		int pageSize = 4;

		try {
			// 연결
			// sql 문 잘 가져왔는지 확인
//			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 전체 게시글 수(attribute에 담음)
				int count = rs.getInt("count(*)");
				request.setAttribute("total", count);
				
					// 총 페이지의 개수
					int pageCount = count/pageSize + (count%pageSize==0?0:1);
					
					// 보여줄 페이지 개수 : 5개
					int pageBlock = 5;
					
					// 시작 페이지와 끝페이지 구함
					int startPage =(int) ((pageNum-1)/pageBlock)*pageBlock+1;
					int endPage = startPage + pageBlock-1;
					
					// 계산된 끝페이지> 전체 페이지수 => 계산된 끝페이지에 전체페이지를 넣음
					if (endPage > pageCount) {
						endPage = pageCount;
					}
					
					// view에서 필요한 숫자
					// 값 잘 나오는지 syso 찍어보는거 추천
					
					// el문에 필요한 (첫페이지) (끝페이지) (전체페이지수) attribute에 넣음
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageCount", pageCount);
					
					// 페이지 번호 page 배열에 넣음
					// 페이지 번호 출력
					// 보여줄 페이지의 page배열을 생성 => 배열 attribute에 저장
					int j = 0;
					int[] page = new int[endPage-startPage+1];
					
					for(int i = startPage; i<= endPage; i++) {
							page[j] = i;
							j++;
						}
					request.setAttribute("page", page);
					
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		
	}

	// 좋아요 구현 못함
	public void likeUp(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from group_purchase where group_no = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 게시글 번호
			// 게시글 넘버
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "update group_purchase set group_like =? where group_no =?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, rs.getInt("group_like")+1);
				pstmt.setInt(2, no);
				
				// 좋아요 수 up
				pstmt.setInt(1, rs.getInt("group_like")+1);
				pstmt.setInt(2, no);
				
				// 업데이트 되면 객체 담기
				String id = rs.getString("group_id");
				String title = rs.getString("group_title");
				String txt = rs.getString("group_txt");
				Date date = rs.getDate("group_date");
				String area = rs.getString("group_area");
				int like = rs.getInt("group_like");
				int hits = rs.getInt("group_hits");
				String group_nick = rs.getString("group_nickname");
				String group_img = rs.getString("group_img");
				
				Group group;
				if(pstmt.executeUpdate()==1) {
					group = new Group(no, id, title, txt, date, area, like, hits,group_nick,group_img);
					request.setAttribute("group", group);
					System.out.println("등록성공");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버 오류");
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	// 댓글 개수
	public void getCommentsTotal(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from group_comment where group_comment_listno = ?";
		int no = Integer.parseInt(request.getParameter("no"));
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				request.setAttribute("total_comments", rs.getInt("count(*)"));
			}
			
		} catch (Exception e) {
	
		} finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
	}

	public static void sendMessage(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into group_message values(group_message_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);

			String writer = request.getParameter("writer_id");
			String title = request.getParameter("message_title");
			String txt = request.getParameter("message_txt");
			String sender = request.getParameter("send_id");
			
			System.out.println(writer);
			System.out.println(title);
			System.out.println(txt);
			System.out.println(sender);
			
			
//			id세션받기
//			닉네임 세션받기
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4, sender);
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("메세지 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버오류");
		}finally {
			DBManager.getDbm().close(null, pstmt, null);
		}
		
	}

}
