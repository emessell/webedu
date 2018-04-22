package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAO {

	public static AdminDAO adminDAO = new AdminDAO();
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	private AdminDAO() {
	}

	// check id
	public AdminSqlResult checkId(String id) {

		AdminSqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id from admin where id = ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sqlresult = AdminSqlResult.ADM_EXIST;
			} else {
				sqlresult = AdminSqlResult.ADM_NONEXIST;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + ":int admin_checkId(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return sqlresult;

	}

	// member check
	public AdminSqlResult adminCheck(String id, String passwd) {

		AdminSqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select passwd from admin where id = ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (passwd.equals(rs.getString("passwd"))) { // login success
					sqlresult = AdminSqlResult.ADM_LOGIN_SUCCESS;
				} else { // password is not correct
					sqlresult = AdminSqlResult.ADM_LOGIN_PW_NOT;
				}
			} else { // no member
				sqlresult = AdminSqlResult.ADM_LOGIN_NOT;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,
					this.getClass().getName() + "SQL RESULT adminCheck(String id, String passwd)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return sqlresult;

	}

	// getAdmin
	public AdminDTO getAdmin(String id) {
		AdminDTO adto = null;

		StringBuffer sql = new StringBuffer();
		sql.append("select id,passwd,name,phone,email,grade from admin where id = ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				adto = new AdminDTO();
				adto.setId(rs.getString("id"));
				adto.setPasswd(rs.getString("passwd"));
				adto.setName(rs.getString("name"));
				adto.setPhone(rs.getString("phone"));
				adto.setEmail(rs.getString("email"));
				adto.setGrade(rs.getString("grade"));
			}

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "SQL RESULT getAdmin(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return adto;
	}

	// getMember
	public MemDTO getMemberAll() {
		MemDTO mdto = null;

		StringBuffer sql = new StringBuffer();
		sql.append("select id,passwd,name,birth,phone,cdate,udate from member");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mdto = new MemDTO();
				mdto.setId(rs.getString("id"));
				mdto.setPasswd(rs.getString("passwd"));
				mdto.setName(rs.getString("name"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setPhone(rs.getString("email"));
				mdto.setCdate(rs.getString("cdate"));
				mdto.setUdate(rs.getString("udate"));
			}

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "SQL RESULT getAdmin(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}

		return mdto;
	}

	public static AdminDAO getInstance() {
		return adminDAO;
	}

	public static void main(String[] args) {
		AdminDAO adao = AdminDAO.getInstance();
		System.out.println(adao);
	}
}
