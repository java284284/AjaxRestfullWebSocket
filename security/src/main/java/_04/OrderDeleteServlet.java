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
@WebServlet("/_04/orderDelete.do")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		int key = 0;
		try {
			key = Integer.parseInt(id);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		IOrderDAO dao = null;
		try {
			if (GlobalService.DB_TYPE.equals(GlobalService.DB_TYPE_SQLSERVER)) {
				dao = new OrderServiceSQLServerDAO();
			} else {
				dao = new OrderServiceMySQLDAO();
			}
			int n = dao.delete(key);
			System.out.println("刪除記錄個數:" + n);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
