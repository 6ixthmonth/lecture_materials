package day0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEES";
			rs = stmt.executeQuery(sql);
			StringBuffer sb = new StringBuffer();
			while (rs.next()) {
				sb.append(rs.getInt("EMPLOYEE_ID"));
				sb.append("\t");
				sb.append(rs.getString("FIRST_NAME"));
				sb.append(" ");
				sb.append(rs.getString("LAST_NAME"));
				sb.append("\t");
				sb.append(rs.getString("HIRE_DATE"));
				sb.append("\n");
			}
			System.out.println(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}