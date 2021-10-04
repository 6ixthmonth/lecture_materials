package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCTest2 {

	public static void main(String[] args) {
		// settings
		String driver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		// 1. driver load
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. db connection
			con = DriverManager.getConnection(url, user, password);

			// select query
			String sq = "select * from reviewlist order by 1 desc";
			pstmt = con.prepareStatement(sq);
			rs = pstmt.executeQuery();

			String ctx = "";
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				ctx += rsmd.getColumnLabel(i + 1) + "\t";
			}
			ctx += "\n";

			while (rs.next()) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					ctx += rs.getObject(i + 1) + "\t";
				}
				ctx += "\n";
			}

			System.out.println(ctx);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}