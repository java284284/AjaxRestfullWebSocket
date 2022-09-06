package _04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _04.model.IOrderDAO;
import _04.model.OrderBean;
import _04.model.OrderServiceMySQLDAO;
import _04.model.OrderServiceSQLServerDAO;

import com.google.gson.Gson;

import _00_init.GlobalService;

/**
 * Servlet implementation class XSSAttackServlet
 */
@WebServlet("/_04/orderSelect.do")
public class OrderSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		try (PrintWriter out = response.getWriter();) {
			IOrderDAO dao = null;
			if (GlobalService.DB_TYPE.equals(GlobalService.DB_TYPE_SQLSERVER)) {
				dao = new OrderServiceSQLServerDAO();
			} else {
				dao = new OrderServiceMySQLDAO();
			}
			List<OrderBean> list = dao.getAllBeans();
			Gson gson = new Gson();
			out.print(gson.toJson(list));
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
