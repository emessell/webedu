package com.edu.bbs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.DataBaseUtil;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsDAOimpl implements RbbsDAO {
	private static RbbsDAO rbdao = new RbbsDAOimpl();

	CallableStatement cst;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	private RbbsDAOimpl () {
		
	}
	
	public static RbbsDAO getInstance() {
		return rbdao;
	}
	
	// 댓글등록
	@Override
	public void write(RbbsDTO rbbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into replybbs (rnum, bnum, rname, rcontent, rgood, rbad, rgroup, rstep, rindent) ")
				.append("values(rbbsnum_seq.nextval,?,?,?,0,0,rbbsnum_seq.nextval,0,0)");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, rbbsdto.getBnum());
			pstmt.setString(2, rbbsdto.getRname());
			pstmt.setString(3, rbbsdto.getRcontent());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void write(RbbsDTO rbbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}

	@Override
	public ArrayList<RbbsDTO> list(int bNum, int startRow, int endRow) {
		ArrayList<RbbsDTO> alist = new ArrayList<>();
		RbbsDTO rbbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select t2.* from (select row_number() over ")
			.append("(ORDER BY rgroup desc, rstep asc) as num, t1.* FROM replybbs t1 where bnum = ?) t2 where num between ? and ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					rbbsdto = new RbbsDTO();
					rbbsdto.setBnum(rs.getInt("Bnum"));
					rbbsdto.setRnum(rs.getInt("Rnum"));
					rbbsdto.setRname(rs.getString("Rname"));
					rbbsdto.setRcontent(rs.getString("Rcontent"));
					rbbsdto.setRgood(rs.getInt("Rgood"));
					rbbsdto.setRbad(rs.getInt("Rbad"));
					rbbsdto.setRcdate(rs.getDate("Rcdate"));
					rbbsdto.setRgroup(rs.getInt("Rgroup"));
					rbbsdto.setRstep(rs.getInt("Rstep"));
					rbbsdto.setRindent(rs.getInt("Rindent"));
					alist.add(rbbsdto);
				}
				
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<RbbsDTO> list(int startRow, int endRow)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return alist;
	}
	
	@Override
	public ArrayList<RbbsDTO> list(int bNum) {
		ArrayList<RbbsDTO> alist = new ArrayList<>();
		RbbsDTO rbbsdto;
		StringBuffer sql = new StringBuffer();
		sql.append("select t2.* from (select row_number() over ")
			.append("(ORDER BY rgroup desc, rstep asc) as num, t1.* FROM replybbs t1) t2 where bNum=?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					rbbsdto = new RbbsDTO();
					rbbsdto.setBnum(rs.getInt("Bnum"));
					rbbsdto.setRnum(rs.getInt("Rnum"));
					rbbsdto.setRname(rs.getString("Rname"));
					rbbsdto.setRcontent(rs.getString("Rcontent"));
					rbbsdto.setRcdate(rs.getDate("Rcdate"));
					rbbsdto.setRgroup(rs.getInt("Rgroup"));
					rbbsdto.setRstep(rs.getInt("Rstep"));
					rbbsdto.setRindent(rs.getInt("Rindent"));
					alist.add(rbbsdto);
				}
				
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<RbbsDTO> list(int startRow, int endRow)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return alist;
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RbbsDTO view(int bNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//댓글 수정
	@Override
	public RbbsDTO modify(String rNum, String rContent) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update replybbs set rcontent=? where rnum=?");
		RbbsDTO rbbsdto = new RbbsDTO();
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			
			pstmt.setString(1, rContent);
			pstmt.setInt(2, Integer.valueOf(rNum));

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void modify(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		return rbbsdto;
	}

	@Override
	public void delete(String rNum) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from replybbs where rnum=?");
		RbbsDTO rbbsdto = new RbbsDTO();
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, Integer.valueOf(rNum));

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void delete(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}

	}

	@Override
	public RbbsDTO pageNav(int bNum, int np) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	   public RbbsDTO replyView(int rNum) {
	      RbbsDTO rbbsdto=null;
	      String sql = "select bnum, rgroup, rstep, rindent from replybbs where rnum = ?";

	      try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());

	         pstmt.setInt(1, rNum);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            rbbsdto = new RbbsDTO();
	            rbbsdto.setBnum(rs.getInt("bNum"));
	            rbbsdto.setRgroup(rs.getInt("rGroup"));
	            rbbsdto.setRstep(rs.getInt("rStep"));
	            rbbsdto.setRindent(rs.getInt("rindent"));
	         }
	         
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO replyView(int bNum)");
	      } finally {
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
	      return rbbsdto;
	   }

	   @Override
	   public void reply(RbbsDTO rbbsdto) {
	      
	      RbbsDTO rbbsdtoV = replyView(rbbsdto.getRnum());
	      updateStep(rbbsdtoV.getRgroup(), rbbsdtoV.getRstep());
	      
	      StringBuffer sql = new StringBuffer();
	      sql.append("insert into replybbs (rnum, bnum, rname, rcontent, rgroup, rstep, rindent) ")
	      .append("values(rbbsnum_seq.nextval,?,?,?,?,?,?)");
	      
	      try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1, rbbsdtoV.getBnum());
	         pstmt.setString(2, rbbsdto.getRname());
	         pstmt.setString(3, rbbsdto.getRcontent());
	         
	         pstmt.setInt(4, rbbsdtoV.getRgroup());
	         pstmt.setInt(5, rbbsdtoV.getRstep()+1);
	         pstmt.setInt(6, rbbsdtoV.getRindent()+1);
	         
	         pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName()+"reply(RbbsDTO rbbsdto)");
	      } finally {
	         DataBaseUtil.close(conn, pstmt);
	      }

	   }

	   @Override
	   public void updateStep(int rgroup, int rstep) {
	      StringBuffer sql = new StringBuffer();
	      sql.append("update replybbs set rstep = rstep+1 where rgroup=? and rstep > ?");
	      
	      try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1, rgroup);
	         pstmt.setInt(2, rstep);
	         pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName()+"updateStep(int rgroup, int rstep)");
	      }  finally {
	         DataBaseUtil.close(conn, pstmt);
	      }
	   }

	@Override
	public ArrayList<RbbsDTO> searchList(String option, String search, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSearchListCount(String option, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(RbbsDTO rbbsdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goodOrBad(String rNum, String goodOrBad) {
		StringBuffer sql = new StringBuffer();
		
		if(goodOrBad.equals("good")) {
			sql.append("update replybbs set rgood = rgood+1 where rnum = ?");
		} else if(goodOrBad.equals("bad")) {
			sql.append("update replybbs set rbad = rbad+1 where rnum = ?");
		}
	      try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1, Integer.parseInt(rNum));
	         pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName()+"void goodOrBad(String rNum, String goodOrBad)");
	      }  finally {
	         DataBaseUtil.close(conn, pstmt);
	      }
	   }

	@Override
	public int replyTotalRec(int bnum) {
		
		int totalRec = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) totalRec from replybbs where bnum = ?");
				
		try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1,bnum);
	         rs = pstmt.executeQuery();
	         
	         while (rs.next()) {
				totalRec = rs.getInt("totalRec");
			}
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName()+"void goodOrBad(String rNum, String goodOrBad)");
	      }  finally {
	         DataBaseUtil.close(conn, pstmt,rs);
	      }
		return totalRec;
		
	}

}
	

