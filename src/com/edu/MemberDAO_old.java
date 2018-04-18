package com.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO_old {
	
	private DataSource ds;
	
	MemberDAO_old(){
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:com/env/jdbc/Oracle11g");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public String getName(String id) {
		Connection dbcon = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select name from member where name = 'aaa'";
		String name = null;
		try {
			dbcon = ds.getConnection();
			stmt = dbcon.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				name = rs.getString("name");
				System.out.println(name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbcon != null) dbcon.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return name;
	}
	
}
