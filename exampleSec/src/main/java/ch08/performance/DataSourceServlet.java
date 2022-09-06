package ch08.performance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
@WebServlet(
	urlPatterns="/ch08/DataSourceServlet"
)
public class DataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try {
			HttpSession session = request.getSession();
			Context context = new InitialContext();
			String dbType = (String)session.getAttribute("DBType");
			String lookup = null;
			if (dbType == null){
				session.setAttribute("Message", "沒有Session，請先產生資料表格");
				response.sendRedirect(response.encodeRedirectURL("index.jsp"));
				return;
			}
			if (dbType.equalsIgnoreCase("mysql")){
				lookup = "java:comp/env/jdbc/MemberDataBaseMySQL";
			} else if (dbType.equalsIgnoreCase("sqlserver")){
				lookup = "java:comp/env/jdbc/MemberDataBaseSQLServer";
			}
			
			DataSource ds = (DataSource) context.lookup(lookup);
			connection = ds.getConnection();
			PreparedStatement pStmt;
			pStmt = connection.prepareStatement("Select * from EmployeeA");
			pStmt.executeQuery();
			session.setAttribute("Target", "DS");
			response.sendRedirect(response.encodeRedirectURL("index.jsp"));
			return;
		} catch (SQLException e) {
			System.err.println("SQL 執行失敗:" + e.getMessage());
		} catch (NamingException e) {
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
