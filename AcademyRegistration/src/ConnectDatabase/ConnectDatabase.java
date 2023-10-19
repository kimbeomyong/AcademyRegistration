package ConnectDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "hr";
		String pwd = "hr";
		Connection con = null;
		try {
			// 1.드라이버 로드(오라클을 불러오는데 컴퓨터가 여기서 실핼을 해서 알아먹기 때문에 try catch를 해줘야됨.)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracleDriver 적재성공");
//			 2.오라클데이타베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");
			System.out.println("OracleDriver 접속성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("오라클적재실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("오라클 접속실패");
		}
		return con;
	}

	public static void main(String[] args) {
		Connection con = makeConnection();
		// 3.curd 실행
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books order by book_id asc");
			// 4.ResultSet 화면출력
			while (rs.next()) {
				int bookId = rs.getInt("BOOK_ID");
				String title = rs.getString("TITLE");
				String publisher = rs.getString("PUBLISHER");
				int year = rs.getInt("YEAR");
				int price = rs.getInt("PRICE");
				String data = String.format("%3d \t %30s \t %10s \t %s \t %d", bookId, title, publisher, year, price);
				System.out.println(data);
			}

		} catch (SQLException e) {
			System.out.println("statement 오류");
		}
		System.out.println("the end");
	}
}