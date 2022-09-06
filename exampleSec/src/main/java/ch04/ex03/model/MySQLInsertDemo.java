package ch04.ex03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLInsertDemo {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://127.0.0.1:3306/test";
		Connection con = DriverManager.getConnection(url, "root11", "");
		con.createStatement();
	}
}
