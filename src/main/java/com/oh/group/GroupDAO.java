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
			
//			id�� �������� �ޱ�
			pstmt.setString(1, "id");
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4, area);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "��ϼ���");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "��������");
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
				int group_posting = rs.getInt("rownum");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				
				group = new Group(group_no, group_posting, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
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
				request.setAttribute("result", "��������");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "��������");
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
				
				int group_posting = 1;
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				
				group1 = new Group(no, group_posting, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
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
				request.setAttribute("result", "���� ����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "��������");
		} finally {
			Group_DBManager.close(con, pstmt, null);
		}
	}

	public static void hitsUp(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			�ش� �Խñ� db ���� ����
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
					request.setAttribute("result", "��ȸ�� up");
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
			
//			id�� �������� �ޱ�
			pstmt.setString(1, listno);
			pstmt.setString(2, "id");
			pstmt.setString(3, comment);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "��ϼ���");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "��������");
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select rownum, a.* from (select * from group_purchase where group_area=?)a order by group_date desc";
		
		try {

			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String region = request.getParameter("region"); 
			pstmt.setString(1, region);
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;

			while(rs.next()) {
				int group_no = rs.getInt("group_no");
				int group_posting = rs.getInt("rownum");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				
				group = new Group(group_no, group_posting, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
			}
			
			request.setAttribute("groups", groups);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void getGroupResearch(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select rownum, a.* from (select * from group_purchase where group_title like ? order by group_date asc)a order by group_date desc";
		
		try {

			request.setCharacterEncoding("utf-8");
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String research = request.getParameter("research"); 
			pstmt.setString(1, "%" + research + "%");
			rs = pstmt.executeQuery();
			
			ArrayList<Group> groups = new ArrayList<Group>();
			Group group = null;

			while(rs.next()) {
				int group_no = rs.getInt("group_no");
				int group_posting = rs.getInt("rownum");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				
				group = new Group(group_no, group_posting, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
			}
			
			request.setAttribute("groups", groups);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
	}

	public static void groupPaging(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// rownum(�Խñ� ��ȣ) ������ (�Խñ۹�ȣ ?~?) **������ ����
		String sql = "select * from (select rownum as num, group_purchase.* from GROUP_PURCHASE) where num between ? and ? order by group_date desc";
		// ���������� ������ �Խñ� �� : 5
		int pageSize = 5;
		String pageNum = request.getParameter("pageNum");
		
		//���� ��ư ������ null : ù������ ������
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		
		// ���� ��ü�� ���� arraylist �������
		ArrayList<Group> groups = new ArrayList<Group>();
		Group group = null;
		
		try {
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
//			ù��° ? = ���� �Խñ� ��ȣ , �ι�° ? = �� �Խñ� ��ȣ
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			
			// ������ ��ü�� �־��ֱ� 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int group_no = rs.getInt("group_no");
				int group_posting = rs.getInt("num");
				String group_id = rs.getString("group_id");
				String group_title = rs.getString("group_title");
				String group_txt = rs.getString("group_txt");
				Date group_date = rs.getDate("group_date");
				String group_area = rs.getString("group_area");
				int group_like = rs.getInt("group_like");
				int group_hits = rs.getInt("group_hits");
				
				group = new Group(group_no, group_posting, group_id, group_title, group_txt, group_date, group_area, group_like, group_hits);
				groups.add(group);				
				
			}
			
			request.setAttribute("groups", groups);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Group_DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void groupPageMove(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from group_purchase";
		// �� �������� ������ �Խñ� �� : 5
		int pageSize = 5;
		// ���� �������� ������
		String pageNum = request.getParameter("pageNum");
		// ���� �޴� ������ �ٷ� ������ 1�� �̵�
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		
		try {
			con = Group_DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// �� �Խñ� ���� ����
				int count = rs.getInt("count(*)");
				// �� �Խñ� ���� attribute�� ����
				request.setAttribute("total", count);
				
					// �� �������� ����
					int pageCount = count/pageSize + (count%pageSize==0?0:1);
					// ������ ������ ���� : 2��
					int pageBlock = 2;
					// ���� �������� �������� ����
					int startPage =(int) ((currentPage-1)/pageBlock)*pageBlock+1;
					int endPage = startPage + pageBlock-1;
					
					// ���� �� �������� ��ü ���������� ũ�� ���������� ��ü�������� ����
					if (endPage > pageCount) {
						endPage = pageCount;
					}
					
					System.out.println("ó�� : " + startPage);
					System.out.println("������ : " + endPage);
					System.out.println("�������� : " + pageCount);
					
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("pageCount", pageCount);
					
					// ������ ��ȣ ���
					// page�迭�� ������ ��������ŭ�� �ε����� ���� => �迭 attribute�� ����
					int[] page = new int[pageBlock];
					int j = 0;

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