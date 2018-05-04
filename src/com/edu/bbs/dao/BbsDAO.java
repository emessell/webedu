package com.edu.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.*;
import com.edu.bbs.dto.BbsDTO;

public class BbsDAO {
   private static BbsDAO bdao = new BbsDAO();
   
   Connection conn;
   Statement stmt;
   PreparedStatement pstmt;
   ResultSet rs;
   
   private BbsDAO() {
      System.out.println("DB연결성공!!");
   }
   
   public static BbsDAO getInstance() {
      return bdao;
   }
   
	// 글쓰기
	public void write(BbsDTO bbsdto) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent) ")
				.append("values(bbsnum_seq.nextval,?,?,?,?,bbsnum_seq.currval,0,0)");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setInt(3, bbsdto.getbHit());
			pstmt.setString(4, bbsdto.getbContent());

			System.out.println("title:" + bbsdto.getbTitle() + " name:" + bbsdto.getbName() + " hit:" + bbsdto.getbHit()
					+ " content:" + bbsdto.getbContent());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void write(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
   
	// 글목록 가져오기
	public ArrayList<BbsDTO> list_2() {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select bnum, btitle, bname, bhit, bcontent, bcdate, bgroup, bstep, bIndent from bbs ")
			.append("order by bgroup desc, bstep asc, bcdate desc");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bnum"));
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbHit(rs.getInt("bhit"));
				bbsdto.setbContent(rs.getString("bcontent"));
				bbsdto.setbCdate(rs.getDate("bcdate"));
				bbsdto.setbGroup(rs.getInt("bgroup"));
				bbsdto.setbStep(rs.getInt("bstep"));
				bbsdto.setbIndent(rs.getInt("bIndent"));
				alist.add(bbsdto);
			}

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "ArrayList<BbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return alist;
	}
	
	// 페이징

		public ArrayList<BbsDTO> list(int startRec, int endRec) {
			ArrayList<BbsDTO> alist = new ArrayList<>();
			BbsDTO bbsdto = null;
			StringBuffer sql = new StringBuffer();
			sql.append("select t2.* from (select row_number() over (order by bgroup desc, bstep asc) ")
			.append("as num, t1.* from bbs t1) t2 where num between ? and ?");
			try {
				conn = DataBaseUtil.getConnection();
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setInt(1, startRec);
				pstmt.setInt(2, endRec);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					bbsdto = new BbsDTO();
					bbsdto.setbNum(rs.getInt("bnum"));
					bbsdto.setbTitle(rs.getString("btitle"));
					bbsdto.setbName(rs.getString("bname"));
					bbsdto.setbHit(rs.getInt("bhit"));
					bbsdto.setbContent(rs.getString("bcontent"));
					bbsdto.setbCdate(rs.getDate("bcdate"));
					bbsdto.setbGroup(rs.getInt("bgroup"));
					bbsdto.setbStep(rs.getInt("bstep"));
					bbsdto.setbIndent(rs.getInt("bIndent"));
					alist.add(bbsdto);
				}

			} catch (SQLException e) {
				DataBaseUtil.printSQLException(e, this.getClass().getName() + "ArrayList<BbsDTO> list()");
			} finally {
				DataBaseUtil.close(conn, pstmt, rs);
			}

			return alist;
		}
   
	// 글 보여주기
	public BbsDTO view(int bNum) {
		System.out.println("view bnum=" + bNum);
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = null;
		String sql = "select btitle, bname, bcontent, bcdate, bnum from bbs where bnum=?";
		String sql2 = "update bbs set BHIT=(BHIT+1) WHERE BNUM=?";
		String sql3 = "select bNum from bbs where bNum=(select max(bNum) from bbs where bNum < ?)";
		String sql4 = "select bNum from bbs where bNum=(select min(bNum) from bbs where bNum > ?)";

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setInt(1, bNum);
			pstmt.executeQuery();

			while (rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbContent(rs.getString("bcontent"));
				bbsdto.setbCdate(rs.getDate("bcdate"));
				bbsdto.setbNum(rs.getInt("bnum"));
				alist.add(bbsdto);
			}
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bbsdto.setpNum(rs.getInt("bNum"));
			} else {
				bbsdto.setpNum(bbsdto.getbNum());
			}
			pstmt = conn.prepareStatement(sql4);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bbsdto.setnNum(rs.getInt("bNum"));
			} else {
				bbsdto.setnNum(bbsdto.getbNum());
			}

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "ArrayList<BbsDTO> view()");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return bbsdto;
	}
	
	
   
	// 글 수정하기
	public BbsDTO modify(BbsDTO bbsdto) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update bbs set btitle=?,bcontent=? where bnum=?");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, bbsdto.getbTitle());
			System.out.println("getbContent: " + bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbContent());
			System.out.println("getbContent: " + bbsdto.getbContent());
			pstmt.setInt(3, bbsdto.getbNum());
			System.out.println("getbNum: " + bbsdto.getbNum());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void modify(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}

		return bbsdto;
	}
   
	// 글 삭제
	public void delete(BbsDTO bbsdto) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from bbs where bnum=?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, bbsdto.getbNum());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void delete(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
   
	// 원글 읽어오기
	public BbsDTO replyView(String bNum) {

		BbsDTO bbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select bnum, btitle, bname, bhit, bcontent, bcdate, bgroup, bstep, bindent ")
				.append("from bbs where bnum = ?");
		try {

			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(bNum));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bnum"));
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbHit(rs.getInt("bhit"));
				bbsdto.setbContent(rs.getString("bcontent"));
				bbsdto.setbCdate(rs.getDate("bcdate"));
				bbsdto.setbGroup(rs.getInt("bgroup"));
				bbsdto.setbStep(rs.getInt("bstep"));
				bbsdto.setbIndent(rs.getInt("bindent"));

			}

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + ": BbsDTO replyView(String bNum)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return bbsdto;
	}
	
	// 답글등록하기
	public void reply(BbsDTO bbsdto) {
		
		//이전 댓글 step 업데이트
		updateStep(bbsdto.getbGroup(),bbsdto.getbStep());

		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent) ")
				.append("values(bbsnum_seq.nextval,?,?,?,?,?,?,?)");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setInt(3, bbsdto.getbHit());
			pstmt.setString(4, bbsdto.getbContent());
			pstmt.setInt(5, bbsdto.getbGroup());
			pstmt.setInt(6, bbsdto.getbStep()+1);
			pstmt.setInt(7, bbsdto.getbIndent()+1);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + ": void reply(BbsDTO bbsdto) ");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	
	//답글 들여쓰기
	private void updateStep(int bGroup, int bStep) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update bbs set bstep=bstep+1 where bgroup=? and bstep > ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, bGroup);
			pstmt.setInt(2, bStep);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + ": void updateStep(int bGroup, int bStep) ");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	
	// 원글 읽어오기
	public ArrayList<BbsDTO> pagelist() {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = null;
		String sql = new String();
		
		int w_size = 10; // 한 화면에 보여질 문서의 수
		int p_size = 5; // 한 화면에 보여질 페이지 번호의 수
		int writing_Count = 0; // 총 문서의 수
		int cur_Page = 0; // 현재 페이지
		
		sql="select count(bnum) from bbs";

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("count(bnum)"));
				alist.add(bbsdto);
			}
			
			writing_Count = rs.getInt("bnum");

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "ArrayList<BbsDTO> pagelist()");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return alist;
	}
	
	
	
}