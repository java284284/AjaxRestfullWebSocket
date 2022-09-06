package _04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _00_init.GlobalService;
import _04.model.IOrderDAO;
import _04.model.OrderServiceMySQLDAO;
import _04.model.OrderServiceSQLServerDAO;

/**
 * Servlet implementation class XSSAttackServlet
 */
@WebServlet("/_04/orderInsert.do")
public class OrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String amt = request.getParameter("amt");
		double amount = 0;
		try {
			amount = Double.parseDouble(amt);
		}catch(NumberFormatException ex){
			ex.printStackTrace();
		}
		IOrderDAO  dao = null;
		try {		
			if (GlobalService.DB_TYPE.equals(GlobalService.DB_TYPE_SQLSERVER)) {
				dao = new OrderServiceSQLServerDAO();
			} else {
				dao = new OrderServiceMySQLDAO();
			}
		   dao.insert(id, amount);
		} catch(Exception ex){
			throw new ServletException(ex);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
