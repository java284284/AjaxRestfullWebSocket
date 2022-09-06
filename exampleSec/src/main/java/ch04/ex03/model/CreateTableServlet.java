package ch04.ex03.model;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

@WebServlet("/ch04/ex03/createMember.do")
public class CreateTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sqlDropBLOBTable = "Drop TABLE MemberExample";
        // MySQL 
		/*
		 String sqlCreateBLOBTable =
		 "CREATE TABLE MemberExample (PK int PRIMARY KEY auto_increment, "
		 +
		 " account varchar(32), password varchar(32), name varchar(32), email varchar(64), "
		 + " tel  varchar(15), experience int) "
		 +
		 " ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci";
		 * 
		 */
		String sqlCreateBLOBTable = "CREATE TABLE MemberExample (PK int PRIMARY KEY identity, "
				+ " account varchar(32), password varchar(32), name varchar(32), email varchar(64), "
				+ " tel  varchar(15), experience int) ";
		Statement stmt = null;
		Connection conn = null;

		List<String> errorMsgs = new ArrayList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		List<String> messages = new ArrayList<String>();
		req.setAttribute("messages", messages);
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/MemberDataBase");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlDropBLOBTable);
			messages.add("刪除表格 MemberExample 成功");
		} catch (NamingException e) {
			throw new ServletException(e);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			messages.add("刪除表格 MemberExample 失敗, " + e.getMessage());
		}
		try {
			stmt.executeUpdate(sqlCreateBLOBTable);
			messages.add("建立表格 MemberExample 成功");
			RequestDispatcher rd = req
					.getRequestDispatcher("/ch04/ex03/createTable/createTableSuccess.jsp");
			rd.forward(req, res);
		} catch (SQLException e) {
			messages.add("刪除表格 MemberExample 失敗");
			errorMsgs.add(e.getMessage());
			RequestDispatcher rd = req
					.getRequestDispatcher("/ch04/ex03/createTable/createTableError.jsp");
			rd.forward(req, res);
			return;
		} finally {
			// 這裡一定要 conn.close();
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}