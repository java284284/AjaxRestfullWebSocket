package ch08.performance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(
	urlPatterns="/ch08/DriverManagerServlet"
)

public class DriverManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try {
			HttpSession session = request.getSession();
			String dbType = (String)session.getAttribute("DBType");
			String url = null;
			
			if (dbType == null){
				session.setAttribute("Message", "沒有Session，請先產生資料表格");
				response.sendRedirect(response.encodeRedirectURL("index.jsp"));
				return;
			}
			if (dbType.equalsIgnoreCase("mysql")){
				Class.forName("com.mysql.jdbc.Driver");
				url = "jdbc:mysql://127.0.0.1:3306/jspdb";
				connection = DriverManager.getConnection(url, "root", "");
				System.out.println("MySQL DriverManagerServlet");
			} else if (dbType.equalsIgnoreCase("sqlserver")){
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=jspdb";
				connection = DriverManager.getConnection(url,"sa", "sa123456");
				System.out.println("SQLServer DriverManagerServlet");
			}
			PreparedStatement pStmt;
			pStmt = connection.prepareStatement("Select * from EmployeeA");
			pStmt.executeQuery();
			session.setAttribute("Target", "DM");
			response.sendRedirect(response.encodeRedirectURL("index.jsp"));
			return ; 
		} catch (SQLException e) {
			System.err.println("SQL 執行失敗:" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
	}
}
