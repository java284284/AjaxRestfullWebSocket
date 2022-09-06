package ch02;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch02/member.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		String id = request.getParameter("mId");
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String password = request.getParameter("pswd");
		// 讀取使用者所輸入，由瀏覽器送來的 mName 欄位內的資料
		String name = request.getParameter("mName");
		// 讀取使用者所輸入，由瀏覽器送來的 mAddress 欄位內的資料
		String address = request.getParameter("mAddress");
		// 讀取使用者所輸入，由瀏覽器送來的 mPhone 欄位內的資料
		String phone = request.getParameter("mPhone");
		// 讀取使用者所輸入，由瀏覽器送來的 mBirthday 欄位內的資料
		String bday = request.getParameter("mBirthday");
		java.sql.Date date = null;
		try {
			date = java.sql.Date.valueOf(bday);
		} catch (Exception e) {
			;
		}
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String weight = request.getParameter("mWeight");
		double dWeight = -1;
		try {
			dWeight = Double.parseDouble(weight.trim());
		} catch (NumberFormatException e) {
			;
		} catch (NullPointerException e) {
			;
		}
		// MemberBean 扮演封裝輸入資料的角色
		MemberBean mb = new MemberBean(id, name, password, address, phone,
				date, ts, dWeight);
		try {
			MemberFileIO mfio = new MemberFileIO("c:\\data\\member.dat");
			mfio.insertMember(mb);
			request.setAttribute("memberBean", mb);
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch02/InsertMemberSuccess.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (IOException e) {
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch02/InsertMemberError.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		}
	}

}
