package ch08.performance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/ch08/CreateTableServlet")
public class CreateTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";

	public CreateTableServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		request.setAttribute("Message", message);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		return;
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		String type = request.getParameter("type");
		String createFaq = "";
		String jndiLookup = "";
		String dropFaq = "Drop Table EmployeeA ";
		Connection connection = null;
		HttpSession session = request.getSession();
		try {

			if (type.equalsIgnoreCase("mysql")) { // 資料庫為MySQL
				
				jndiLookup = "java:comp/env/jdbc/MemberDataBaseMySQL";
				session.setAttribute("jndiLookup", jndiLookup);
				session.setAttribute("DBType", "mysql");
				createFaq = "Create Table EmployeeA (indexNo Integer primary key, "
						+ "name            varchar(30), "
						+ "zip             varchar(5), "
						+ "Addr_1          varchar(30), "
						+ "Addr_2          varchar(30), "
						+ "telDay          varchar(15), "
						+ "telNight        varchar(15), "
						+ "mobile          varchar(15), "
						+ "Email           varchar(50)) "
						+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;";
			} else if (type.equalsIgnoreCase("sqlserver")) { // 資料庫為SQLServer
				jndiLookup = "java:comp/env/jdbc/MemberDataBaseSQLServer";
				                           
				session.setAttribute("jndiLookup", jndiLookup);
				session.setAttribute("DBType", "sqlserver");
				createFaq = "Create Table EmployeeA (indexNo Integer primary key, "
						+ "name            varchar(30), "
						+ "zip             varchar(5), "
						+ "Addr_1          varchar(30), "
						+ "Addr_2          varchar(30), "
						+ "telDay          varchar(15), "
						+ "telNight        varchar(15), "
						+ "mobile          varchar(15), "
						+ "Email           varchar(50)) ";
				;
			}

			message = type + " ";
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(jndiLookup);
			connection = ds.getConnection();
			PreparedStatement pStmt;
			try {
				pStmt = connection.prepareStatement(dropFaq);
				pStmt.executeUpdate();
			} catch (SQLException e) {
				message += " 表格 EmployeeA 刪除失敗:" + e.getMessage();
				//System.err.println("表格 EmployeeA 刪除失敗:" + e.getMessage());
			}
			try {
				pStmt = connection.prepareStatement(createFaq);
				pStmt.executeUpdate();
			} catch (SQLException e) {
				message += " 表格 EmployeeA 新建失敗:" + e.getMessage();
				//System.err.println("表格 EmployeeA 新建失敗:" + e.getMessage());
			}
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("Insert Into EmployeeA values(1001, '張愛家', '100', '台北市中華路３５６號','７樓','02-88456709','02-57980540','0934-923450','ichia@yahoo.com.tw' )");
				stmt.executeUpdate("Insert Into EmployeeA values(1098, '劉的華', '700', '台南市中正北路二段','５６號','06-65556289','06-31358001','0939-028459','derHwa@yahoo.com.tw')");
				stmt.executeUpdate("Insert Into EmployeeA values(2589, '全志賢', '100', '台北市中華路３５６號','２樓之１','02-23451189','02-67900541','0949-025906','ii800@yahoo.com.tw')");
				stmt.executeUpdate("Insert Into EmployeeA values(6608, '送會橋', '407', '台中市西屯路二段','１２５巷５６號１樓','04-31156789','04-57226501','0956-523006','da@yahoo.com.tw')");
				//System.out.println("表格 EmployeeA 紀錄新增成功");
				message += " 表格 EmployeeA 紀錄新增成功" ;
			} catch (SQLException e) {
				message += " 表格 EmployeeA 紀錄新增失敗:" + e.getMessage() ;
				//System.err.println("表格 EmployeeA 紀錄新增失敗:" + e.getMessage());
				e.printStackTrace();
			}

		} catch (NamingException e) {
			throw new ServletException(e);
		} catch (SQLException e) {
			throw new ServletException(e);
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
