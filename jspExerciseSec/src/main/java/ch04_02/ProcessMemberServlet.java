package ch04_02;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ch04_02/member.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		String id = request.getParameter("mId");
		// 檢查使用者所輸入的資料
		if (id == null || id.trim().length() == 0) {
			errorMessage.add("帳號欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String password = request.getParameter("pswd");
		// 檢查使用者所輸入的資料
		if (password == null || password.trim().length() == 0) {
			errorMessage.add("密碼欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mName 欄位內的資料
		String name = request.getParameter("mName");
		// 檢查使用者所輸入的資料
		if (name == null || name.trim().length() == 0) {
			errorMessage.add("姓名欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mAddress 欄位內的資料
		String address = request.getParameter("mAddress");
		// 檢查使用者所輸入的資料
		if (address == null || address.trim().length() == 0) {
			errorMessage.add("地址欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mPhone 欄位內的資料
		String phone = request.getParameter("mPhone");

		// 讀取使用者所輸入，由瀏覽器送來的 mBirthday 欄位內的資料
		String bday = request.getParameter("mBirthday");
		// 檢核使用者的輸入資料
		java.sql.Date date = null;
		if (bday != null && bday.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(bday);
			} catch (IllegalArgumentException e) {
				errorMessage.add("生日欄格式錯誤");
			}
		}

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String weight = request.getParameter("mWeight");
		double dWeight = -1;
		// 檢核使用者的輸入資料
		if (weight != null && weight.trim().length() > 0) {
			try {
				dWeight = Double.parseDouble(weight.trim());
			} catch (NumberFormatException e) {
				errorMessage.add("體重欄必須為數值");
			}
		}
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch04_02/InsertMemberError.jsp");
			rd.forward(request, response);
			return;
		}

		// MemberBean 扮演封裝輸入資料的角色
		MemberBean mb = new MemberBean(id, name, password, address, phone,
				date, ts, dWeight);
		try {
			MemberDAO mfio = new MemberDAO();
			mfio.insertMember(mb);
			request.setAttribute("memberBean", mb);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch04_02/InsertMemberSuccess.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
				e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.add("帳號重複，請重新輸入帳號");
			} else {
				errorMessage.add("資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request
				.getRequestDispatcher("/ch04_02/InsertMemberError.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
