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
		sql.append("insert into member (id,passwd,name,birth,phone) values (?,?,?,?,?)");
		
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
	
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAO();
		System.out.println(mdao);
	}
	
}
