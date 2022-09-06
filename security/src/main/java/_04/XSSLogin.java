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

import _01.model.CustomerBean;
import _01.model.LoginServiceMySQLDAO;
import _01.model.LoginServiceSQLServerDAO;
@WebServlet("/_04/login.do")  
public class XSSLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		// 1. 讀取使用者輸入資料
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		String dbtype = request.getParameter("dbtype");
		// 2. 進行必要的資料轉換
		// 無
		// 3. 檢查使用者輸入資料
		// 如果 userId 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (userId == null || userId.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		// 如果password欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		if (dbtype == null) {
			dbtype = "sqlserver";
		}
		session.setAttribute("dbtype", dbtype);
		// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給login.jsp
		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行Business Logic運算
		LoginServiceMySQLDAO my;
		LoginServiceSQLServerDAO ms;
		CustomerBean mb = null;
		// 呼叫 my或ms物件的 checkIDPassword_NG()，傳入userid與password兩個參數
		
		try {
			if (dbtype.equalsIgnoreCase("mysql")) {
			    my = new LoginServiceMySQLDAO(session);
			    mb = my.checkPassword_OK(userId, password);
			} else {
			    ms = new LoginServiceSQLServerDAO(session);
			    mb = ms.checkPassword_OK(userId, password);
			}
			
			if (mb != null) {
				// OK, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				session.setAttribute("LoginOK", mb);
				session.setAttribute("MessageLoginOK", "歡迎光臨");
			} else {
				// NG, userid與密碼的組合錯誤，放一個錯誤訊息到 errorMsgMap 之內
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
			}
		} catch (NamingException e) {
			e.printStackTrace();
			errorMsgMap.put("LoginError",
					"LoginServlet->NamingException:" + e.getMessage());
		} catch (SQLException e) {
			errorMsgMap.put("LoginError",
					"LoginServlet->SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
		String requestURI = (String) session.getAttribute("target");
		if (errorMsgMap.isEmpty()) {
			if (requestURI != null) {
				response.sendRedirect(requestURI);
			} else {
				// response.setHeader("Refresh", "0;url=index_xss.jsp");
				response.sendRedirect(request.getContextPath() + "/index_xss.jsp");
			}
			return;
		} else {
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
