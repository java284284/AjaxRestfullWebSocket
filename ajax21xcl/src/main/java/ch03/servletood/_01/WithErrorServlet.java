package ch03.servletood._01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ch03/_01/WithErrorServlet")
public class WithErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/jspdb", "sa", "1234");
			con.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		} 
	}

}
