package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataBaseUtil {

	private static BasicDataSource dataSource = new BasicDataSource();
	private static DataBaseUtil instance = new DataBaseUtil();

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String serverIP = "127.0.0.1";
	private static final String userName = "jsp";
	private static final String userPass = "jsp1234";

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	private DataBaseUtil() {

		// JDBC ���� ������ DATASOURCE ��ü�� ���ش�.
		dataSource.setDriverClassName(driverName);
		System.out.println("����̹� �ε� ����");
		// DB����
		dataSource.setUrl("jdbc:oracle:thin:@" + serverIP + ":1521:xe");
		dataSource.setUsername(userName);
		dataSource.setPassword(userPass);
		System.out.println("DB ���� ����");
		// Connection Pool ���� :
		// �������� ������ default ������ ���õ�.
		dataSource.setInitialSize(5);
		// ���� ������ connection �� : default - 0

		dataSource.setMaxTotal(10);
		// ���� ������ connection �� : default - 8
		// ������ - ����(-1)

		dataSource.setMaxWaitMillis(1000);
		// Connection �ݳ��� ��ٸ��� �ִ� �ð� : default ������.
		dataSource.setMaxIdle(5);
		// �ִ� �뿩 ������ Connection �� : default - 8, ���� - ������
		dataSource.setMinIdle(5);
		// �ּ� �뿩 ������ Connection �� : default - 0

	}

	public static DataBaseUtil getInstance() {
		return instance;

	}

	public static Connection getConnection(){
		Connection con=null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// con.setAutoCommit(false);
		return con;
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		pstmt = null;
		rs = null;
		conn = null;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = null;
		rs = null;
		conn = null;
	}

	public static void close(Connection conn, PreparedStatement pstmt) {

		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
		pstmt = null;
	}

	public static void close(Statement stmt, ResultSet rs) {

		try {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = null;
		rs = null;
	}

	public static void close(PreparedStatement pstmt, ResultSet rs) {

		try {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = null;
		pstmt = null;
	}

	public static void close(Connection conn) {

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}

	public static void close(PreparedStatement pstmt) {

		try {

			if (pstmt != null)
				pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		pstmt = null;
	}

	public static void printSQLException(SQLException e) {
		while (e != null) {
			System.err.println("SQL State :" + e.getSQLState());
			System.err.println("Error Code :" + e.getErrorCode());
			System.err.println("Message :" + e.getMessage());
			Throwable t = e.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
			e = e.getNextException();
		}
	}

	public static void printSQLException(SQLException e, String errLoc) {
		System.err.println("errLoc : " + errLoc);
		while (e != null) {
			System.err.println("SQL State :" + e.getSQLState());
			System.err.println("Error Code :" + e.getErrorCode());
			System.err.println("Message :" + e.getMessage());
			Throwable t = e.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
			e = e.getNextException();
		}
	}

}
