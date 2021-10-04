package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		// 드라이버
		String driver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		try {
			// 1. 드라이버 적재 (load)
			Class.forName(driver);

			// 2. DB 접속
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. Statement 작성
			Statement stmt = con.createStatement();

			// select query
			String sql = "SELECT * FROM regions";
			ResultSet rs = stmt.executeQuery(sql);

			String ctx = "";
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String cn = rsmd.getColumnLabel(i + 1);
				ctx += cn + "\t";
			}
			ctx += "\n";
			while (rs.next()) {
				int region_id = rs.getInt("REGION_ID");
				String region_name = rs.getString("REGION_NAME");
				ctx += region_id + "\t\t" + region_name + "\n";
			}

			System.out.println(ctx);

			// insert query
//			String iq = "INSERT INTO reviewlist VALUES (reviewnum_seq.nextval, 'Untitled', 'aaa', sysdate, 'Somewhere', 'Something', 'Somehow')";
//			int iqrslt = stmt.executeUpdate(iq);
//			System.out.println(iqrslt);

			// update query
//			String uq = "UPDATE reviewlist SET title = 'Untitled2', restaurant = 'Somewhere2', menu = 'Something2', review = 'Umm' WHERE reviewnum = 4";
//			int uqrslt = stmt.executeUpdate(uq);
//			System.out.println(uqrslt);

			// delete query
//			String dq = "DELETE FROM reviewlist WHERE reviewnum = 4";
//			int dqrslt = stmt.executeUpdate(dq);
//			System.out.println(dqrslt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}