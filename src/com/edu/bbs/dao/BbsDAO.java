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
      sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent) ")
      .append("values(bbsnum_seq.nextval,?,?,?,?)");
      try {
         conn = DataBaseUtil.getConnection();
         pstmt = conn.prepareStatement(sql.toString());
         
         pstmt.setString(1, bbsdto.getbTitle());
         pstmt.setString(2, bbsdto.getbName());
         pstmt.setInt(3, bbsdto.getbHit());
         pstmt.setString(4, bbsdto.getbContent());
         
         System.out.println("title:"+bbsdto.getbTitle() + " name:"+bbsdto.getbName() +
               " hit:"+bbsdto.getbHit() +" content:"+bbsdto.getbContent());
         
         cnt = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         DataBaseUtil.printSQLException(e, this.getClass().getName()+"void write(BbsDTO bbsdto)");
      } finally {
         DataBaseUtil.close(conn, pstmt);
      }
   }
   
   //글목록 가져오기
   public ArrayList<BbsDTO> list() {
      ArrayList<BbsDTO> alist = new ArrayList<>();
      BbsDTO bbsdto = null;
      StringBuffer sql = new StringBuffer();
      sql.append("select bnum, btitle, bname, bhit, bcontent, bcdate from bbs ")
         .append("order by bnum desc");
      
      try {
         conn = DataBaseUtil.getConnection();
         pstmt = conn.prepareStatement(sql.toString());
         
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
               bbsdto = new BbsDTO();
               bbsdto.setbNum(rs.getInt("bnum"));
               bbsdto.setbTitle(rs.getString("btitle"));
               bbsdto.setbName(rs.getString("bname"));
               bbsdto.setbHit(rs.getInt("bhit"));
               bbsdto.setbContent(rs.getString("bcontent"));
               bbsdto.setbCdate(rs.getDate("bcdate"));
               alist.add(bbsdto);
         }
         
      } catch (SQLException e) {
         DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> list()");
      } finally {
         DataBaseUtil.close(conn, pstmt,rs);
      }
      
      return alist;
   }
   
 //글 보여주기
   public BbsDTO view(int bnum) {
	   System.out.println("view bnum="+bnum);
      ArrayList<BbsDTO> alist = new ArrayList<>();
      BbsDTO bbsdto = null;
      StringBuffer sql = new StringBuffer();
      String sql2 = "update bbs set BHIT=(BHIT+1) WHERE BNUM=?";
      sql.append("select btitle, bname, bcontent, bcdate, bnum from bbs where bnum=?");
      
      try {
         conn = DataBaseUtil.getConnection();
         pstmt = conn.prepareStatement(sql.toString());
         pstmt.setInt(1, bnum);
         rs = pstmt.executeQuery();
         pstmt = conn.prepareStatement(sql2.toString());
         pstmt.setInt(1, bnum);
         pstmt.executeQuery();
         
         while(rs.next()) {
               bbsdto = new BbsDTO();
               bbsdto.setbTitle(rs.getString("btitle"));
               bbsdto.setbName(rs.getString("bname"));
               bbsdto.setbContent(rs.getString("bcontent"));
               bbsdto.setbCdate(rs.getDate("bcdate"));
               bbsdto.setbNum(rs.getInt("bnum"));
               alist.add(bbsdto);
         }
         
      } catch (SQLException e) {
         DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> view()");
      } finally {
         DataBaseUtil.close(conn, pstmt,rs);
      }
      
      return bbsdto;
   }
   
 //글 수정하기
   public BbsDTO modify(BbsDTO bbsdto) {
	   int cnt = 0;
	      StringBuffer sql = new StringBuffer();
	      sql.append("update bbs set bcontent=? where bnum=?");
	      try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setString(1, bbsdto.getbContent());
	         System.out.println("getbContent: "+bbsdto.getbContent());
	         pstmt.setInt(2, bbsdto.getbNum());
	         System.out.println("getbNum: "+bbsdto.getbNum());
	         
	         cnt = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName()+"void modify(BbsDTO bbsdto)");
	      } finally {
	         DataBaseUtil.close(conn, pstmt);
	      }
      
      return bbsdto;
   }
   
   
   
}