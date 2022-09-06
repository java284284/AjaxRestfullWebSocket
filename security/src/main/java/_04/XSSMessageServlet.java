package _04;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import _04.model.MessageServiceMySQLDAO;
import _04.model.MessageServiceSQLServerDAO;

@WebServlet("/_04/blog.do")
public class XSSMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		String fromId = request.getParameter("fromid");
		String toId = request.getParameter("id");
		String title = request.getParameter("title");
		if (title == null || title.trim().length() == 0) {
			errorMsgMap.put("TitleError", "必須輸入主旨");
		}
		String content = request.getParameter("content");
		if (content == null || content.trim().length() == 0) {
			errorMsgMap.put("ContentError", "必須輸入內文");
		}
		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
			rd.forward(request, response);
			return;
		}

		String dbtype = (String)session.getAttribute("dbtype");
		if (dbtype == null){
			dbtype = "mysql";
		}
		MessageServiceMySQLDAO my;
		MessageServiceSQLServerDAO ms;
		MessageBean mb = new MessageBean(fromId, toId, title, content);
		int n = 0;

		try {
			if (dbtype.equalsIgnoreCase("mysql")) {
			    my = new MessageServiceMySQLDAO();
			    n = my.insert(mb);
			} else {
			    ms = new MessageServiceSQLServerDAO();
			    n = ms.insert(mb);
			}	
			if (n == 0) {
				errorMsgMap.put("InsertError",	"新增失敗");
			} else {
				
			}
		} catch (NamingException e) {
			errorMsgMap.put("LoginError",
					"LoginServlet->NamingException:" + e.getMessage());
		} catch (SQLException e) {
			errorMsgMap.put("LoginError",
					"LoginServlet->SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
		if (errorMsgMap.isEmpty()) {
			session.setAttribute("MessageInsertOK", "新增留言成功");
			response.sendRedirect(request.getContextPath() + "/index_xss.jsp");
			return;
		} else {
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
			rd.forward(request, response);
			return;
		}
	}
}