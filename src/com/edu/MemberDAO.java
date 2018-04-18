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
		conn = DataBaseUtil.getConnection();
	}
	
	public int insertMember(MemDTO member){

		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member ").append("(id,passwd,name,birth,phone) ")
				.append("values (?,?,?,?,?)");
		try {

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getPhone());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, "int insertMember(MemberDTO member)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return cnt;
	}
	
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAO();
		System.out.println(mdao);
	}
	
}
