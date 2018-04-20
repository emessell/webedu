package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO(){
		//conn = DataBaseUtil.getConnection();
	}
	
	//check id
	public SqlResult checkId(String id) {
		
		SqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id from member where id = ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sqlresult = SqlResult.MEM_EXIST;
			}else {
				sqlresult = SqlResult.MEM_NONEXIST;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,this.getClass().getName()+":int checkId(String id)");
		}finally {
			DataBaseUtil.close(conn,pstmt,rs);
		}
		
		
		return sqlresult;
		
	}
	
	//insert member
	public SqlResult insertMember(MemDTO member){
		
		int cnt=0;
		SqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member ").append("(id,passwd,name,birth,phone) ")
				.append("values (?,?,?,?,?)");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getPhone());

			cnt = pstmt.executeUpdate();
			sqlresult = SqlResult.MEM_JOIN_SUCCESS;

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, "int insertMember(MemberDTO member)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return sqlresult;
	}
	
	//member check
	public SqlResult memberCheck(String id, String passwd) {
		
		
		SqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select passwd from member where id = ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				if(passwd.equals(rs.getString("passwd"))) { //login success
					sqlresult = SqlResult.MEM_LOGIN_SUCCESS;
				}else { //password is not correct
					sqlresult = SqlResult.MEM_LOGIN_PW_NOT;
				}
			}else { //no member
				sqlresult = SqlResult.MEM_LOGIN_NOT;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,this.getClass().getName()+"SQL RESULT memberCheck(String id, String passwd)");
		}finally {
			DataBaseUtil.close(conn,pstmt,rs);
		}
		
		
		return sqlresult;
		
	}
	
	//getMember(id)
	public MemDTO getMember(String id) {
		MemDTO mdto = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("select id,passwd,name,birth,phone from member where id = ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdto = new MemDTO();
				mdto.setId(rs.getString("id"));
				mdto.setPasswd(rs.getString("Passwd"));
				mdto.setName(rs.getString("name"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,this.getClass().getName()+"SQL RESULT getMember(String id)");
		}finally {
			DataBaseUtil.close(conn,pstmt,rs);
		}
		
		return mdto;
	}
	
	//modify member
	public int updateMember(MemDTO mdto) {
		
		int n = 0;
		
		StringBuffer sql = new StringBuffer();
//		sql.append("update member set passwd=?,name=?,birth=?,phone=? where id = ?");
		sql.append("update member set passwd=?,name=?,phone=? where id = ?");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, mdto.getPasswd());
			pstmt.setString(2, mdto.getName());
//			pstmt.setString(3, mdto.getBirth());
			pstmt.setString(3, mdto.getPhone());
			pstmt.setString(4, mdto.getId());
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,this.getClass().getName()+": int updateMember(MemberDTO mdto)");
		}finally {
			DataBaseUtil.close(conn,pstmt);
		}
		return n;
		
	}
	
	public int deleteMember(String id) {
		int n = 0;
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member where id = ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,this.getClass().getName()+": int deleteMember(String id)");
		}finally {
			DataBaseUtil.close(conn,pstmt);
		}
		return n;
	}
	
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAO();
		System.out.println(mdao);
	}
	
}
























