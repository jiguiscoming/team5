package com.oh.group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.oh.group.Group_DBManager;

public class GroupDAO {

	public static void groupReg(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into group_purchase values(group_purchase_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?)";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			String area = request.getParameter("area");
			
//			id는 세션으로 받기
			pstmt.setString(1, "id");
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4, area);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "등록성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "서버오류");
		}finally {
			Group_DBManager.close(con, pstmt, null);
		}
	}

	public static void getGroups(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select rownum, a.* from (select * from group_purchase order by group_date asc)a order by a.group_date desc";
		
		try {

			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
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
				
				group = new Group(group_no, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
			}
			
			request.setAttribute("groups", groups);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void groupUpdate(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update group_purchase set group_title=?, group_txt=?, group_area=? where group_no=?";
		
		try {
			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			
			String area = request.getParameter("area");
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			int no =Integer.parseInt(request.getParameter("no"));

			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setString(3, area);
			pstmt.setInt(4, no);
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("result", "수정성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "서버오류");
		} finally {
			Group_DBManager.close(con, pstmt, null);
		}
		
	}

	public static void getGroup(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from group_purchase where group_no=?";
		
		try {
			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
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
				
				group1 = new Group(no, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				request.setAttribute("group", group1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void groupDelete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete group_purchase where group_no = ?";
		int no = Integer.parseInt(request.getParameter("no"));
		
		try {
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "서버오류");
		} finally {
			Group_DBManager.close(con, pstmt, null);
		}
	}

	public static void hitsUp(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			해당 게시글 db 먼저 읽음
			String sql1 = "select * from group_purchase where group_no=?";
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql1);
			int no =Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int hits = rs.getInt("group_hits");
				hits ++;

				String sql2 = "update group_purchase set group_hits=? where group_no=?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, hits);
				pstmt.setInt(2, no);
				
				if(pstmt.executeUpdate() == 1) {
					request.setAttribute("result", "조회수 up");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void commentReg(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into group_comment values(group_comment_seq.nextval, ?, ?, ?, sysdate)";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String listno = request.getParameter("no");
			String comment = request.getParameter("comment");
			
			System.out.println(listno);
			System.out.println(comment);
			
//			id는 세션으로 받기
			pstmt.setString(1, listno);
			pstmt.setString(2, "id");
			pstmt.setString(3, comment);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "등록성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "서버오류");
		}finally {
			Group_DBManager.close(con, pstmt, null);
		}
	}

	public static void getComments(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from group_comment where group_comment_listno=? order by group_comment_date desc";
		
		try {

			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
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
			
			request.setAttribute("comment", comment);
			request.setAttribute("comments", comments);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void getRegionGroups(HttpServletRequest request) {
		// 연결준비
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 지역 조건안에 페이징된 게시글 받기 위한 쿼리문
		String sql = "select * from (select rownum as num, a.* from (select * from group_purchase where group_purchase.group_area=? order by group_date desc)a) where num between ? and ?";
		
		try {
			//한글깨짐
			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			// 한페이지에 보여줄 게시글 수 : 5
			int pageSize = 5;
			// 현제 페이지
			String pageNum = request.getParameter("pageNum");
			
			// 메뉴 버튼 누르면 null : 메뉴 누르자마자 첫페이지 이동
			if(pageNum == null) {
				pageNum = "1";
			}
			
			// 현재페이지(int로 파싱), 시작게시글번호, 끝게시글번호 선언 및 초기화
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1)*pageSize+1;
			int endRow = currentPage*pageSize;
			
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
				
				group = new Group(group_no,group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
			}
			
			request.setAttribute("groups", groups);
			request.setAttribute("sql", "select count(*) from group_purchase where group_area='" + region + "'");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void getGroupResearch(HttpServletRequest request) {
		// 연결준비
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 검색 조건 안에 rownum 조건 붙여서 게시글 번호 제한
		String region = request.getParameter("region");
		String sql = "select * from (select rownum as num, a.* from (select * from group_purchase where group_title like ? order by group_date desc)a) where num between ? and ?";
		if(!region.equals("전국")) {
			sql = "select * from (select rownum as num, a.* from (select * from (select * from group_purchase where group_purchase.group_area=?) where group_title like ? order by group_date desc)a) where num between ? and ?";
		}
		try {

			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			// 검색한 값
			String research = request.getParameter("research"); 
			
			// 한페이지에 보여줄 게시글 수 : 5
			int pageSize = 5;
			
			// 현제 페이지
			String pageNum = request.getParameter("pageNum");
			
			// 메뉴 버튼 누르면 null : 메뉴 누르자마자 첫페이지 이동
			if(pageNum == null) {
				pageNum = "1";
			}
			
			// 현재페이지(int로 파싱), 시작게시글번호, 끝게시글번호 선언 및 초기화
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1)*pageSize+1;
			int endRow = currentPage*pageSize;
			
			// 첫번째 ? : 검색한 값  두번째 ? : 첫 게시글 번호  세번째 ? : 마지막 게시글 번호
			if(region.equals("전국")) {
				pstmt.setString(1, "%" + research + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			} else {
				pstmt.setString(1, region);
				pstmt.setString(2, "%" + research + "%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
			}
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;
			
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
				
				group = new Group(group_no,group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
			}
			
			// arraylist를 attribute에 담기
			request.setAttribute("groups", groups);
			if(region.equals("전국")) {
			request.setAttribute("sql", "select count(*) from group_purchase where group_title like '%" + research + "%'");
			} else {
				request.setAttribute("sql", "select count(*) from(select * from group_purchase where group_area='" + region + "') where group_title like '%" + research + "%'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void groupPaging(HttpServletRequest request) {
		//연결 준비
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// rownum(게시글 번호) 보여줌 (게시글번호 ?~?) **쿼리문 조심
		// rownum은 컬럼 안 만들어도 됨. 해당 테이블에 바로 rownum select할 수 있음
		String sql = "select * from (select rownum as num, a.* from (select * from group_purchase order by group_date desc)a) where num between ? and ?";
		
		// 한페이지에 보여줄 게시글 수 : 5
		int pageSize = 5;
		// 현제 페이지
		String pageNum = request.getParameter("pageNum");
		
		// 메뉴 버튼 누르면 null : 메뉴 누르자마자 첫페이지 이동
		if(pageNum == null) {
			pageNum = "1";
		}
		
		// 현재페이지(int로 파싱), 시작게시글번호, 끝게시글번호 선언 및 초기화
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		
		// 여러 객체를 넣을 arraylist 만들어줌
		ArrayList<Group> groups = new ArrayList<Group>();
		// 각자 bean 준비
		Group group = null;
		
		try {
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
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
				
				group = new Group(group_no, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
				
			}
			// arraylist를 attribute에 넣어줌
			request.setAttribute("groups", groups);
			request.setAttribute("sql", "select count(*) from group_purchase");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void groupPageMove(HttpServletRequest request, String sql) {
		// 연결 준비
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 한 페이지에 보여줄 게시글 수 : 5
		int pageSize = 5;
		
		// 현재 접속중인 페이지
		String pageNum = request.getParameter("pageNum");
		
		// 메뉴 누르면 바로 페이지 1로 이동 ( 페이지값 없음 )
		if(pageNum == null) {
			pageNum = "1";
		}
		// 현재페이지(pageNum) int로 다시 담음
		int currentPage = Integer.parseInt(pageNum);
		
		try {
			// 연결
			con = Group_DBManager.connect();
			// sql 문 잘 가져왔는지 확인
//			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 총 게시글 개수 받음
				int count = rs.getInt("count(*)");
				
				// 총 게시글 개수 attribute(count)에 넣음
				request.setAttribute("total", count);
				
					// 총 페이지의 개수
					int pageCount = count/pageSize + (count%pageSize==0?0:1);
					
					// 보여줄 페이지 개수 : 5개
					int pageBlock = 5;
					
					// 시작 페이지와 끝페이지 구함
					int startPage =(int) ((currentPage-1)/pageBlock)*pageBlock+1;
					int endPage = startPage + pageBlock-1;
					
					// 계산된 끝페이지> 전체 페이지수 => 계산된 끝페이지에 전체페이지를 넣음
					if (endPage > pageCount) {
						endPage = pageCount;
					}
					
					// 값 잘 나오는지 syso 찍어보는거 추천
					
					// el문에 필요한 (첫페이지) (끝페이지) (전체페이지수) attribute에 넣음
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageCount", pageCount);
					
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
			Group_DBManager.close(con, pstmt, rs);
		}
		
	}

}
