package day0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCTest02 {
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
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from reviewlist";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery("select * from reviewlist");
			ResultSetMetaData rsmd = rs.getMetaData();
			String ctx = "";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}