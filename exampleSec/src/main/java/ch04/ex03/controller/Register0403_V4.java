package ch04.ex03.controller;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import ch04.ex03.model.*;
@WebServlet("/ch04/ex03/register0403_v4.do")
public class Register0403_V4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();
        request.setAttribute("ErrorMsgKey", errorMsg); 
		// 1. 讀取使用者輸入資料
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String name = request.getParameter("userName");
		String eMail = request.getParameter("eMail");
		String tel = request.getParameter("tel");
		String expericnceStr = request.getParameter("experience");
		// 2. 進行必要的資料轉換
		int experience = 0;
		try {
			experience = Integer.parseInt(expericnceStr.trim());
		} catch (NumberFormatException e) {
			errorMsg.add("使用Java經驗格式錯誤，應該為整數");
		}
		// 3. 檢查使用者輸入資料
		if (userId == null || userId.trim().length() == 0) {
			errorMsg.add("帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.add("密碼欄必須輸入");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.add("姓名欄必須輸入");
		}
		if (eMail == null || eMail.trim().length() == 0) {
			errorMsg.add("EMail欄必須輸入");
		}
		if (tel == null || tel.trim().length() == 0) {
			errorMsg.add("電話號碼欄必須輸入");
		}
		if (experience < 0) {
			errorMsg.add("使用Java經驗應該為正整數或 0 ");
		}
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行 Business Logic 運算
		RegisterService rs = new RegisterService();
		if (rs.idExists(userId)) {
			errorMsg.add("該代號 (" +  userId  + ") 已經存在，請換新的代號");
		} else {
			try {
				Member mem = new Member(userId, password, name, eMail, tel,	experience);
				rs.saveMember(mem);
			} catch (SQLException e) {
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
		}
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("userIdKey", userId);
		if (errorMsg.isEmpty())	{			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			return ; 
		}  else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
     }
}   