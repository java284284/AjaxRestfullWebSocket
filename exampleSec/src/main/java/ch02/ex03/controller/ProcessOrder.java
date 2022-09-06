package ch02.ex03.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import ch02.ex03.model.Customer;

import java.io.IOException;
@WebServlet("/ch02/survey.do")
public class ProcessOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String DEFAULT_NAME 	= "訪客";
	final String DEFAULT_EMAIL	= "(未輸入)";
	final String DEFAULT_TEL	= "(未輸入)";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request,
			             HttpServletResponse response) throws IOException, 
		 ServletException {
	    // 說明瀏覽器送來之文字資料的編碼
		request.setCharacterEncoding("UTF-8");
	    // 讀取使用者在 <input name='userName' ...>標籤內所輸入的資料，放入變數 name內
		String name = request.getParameter("userName");
		// name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
	    // 如果瀏覽器沒有送來名為userName的資料 或 瀏覽器有送來名為userName的資料，但
	    // 去掉該資料的頭尾空白後，長度為 0		
		if (name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		String email = request.getParameter("eMail");
	    // 如果瀏覽器沒有送來名為eMail的資料 或 瀏覽器有送來名為eMail的資料，但
	    // 去掉該資料的頭尾空白後，長度為 0		
		if (email == null ||  email.length() == 0) {
			email = DEFAULT_EMAIL;
		}
		String tel = request.getParameter("tel");
	    // 如果瀏覽器沒有送來名為tel的資料 或 瀏覽器有送來名為tel的資料，但
	    // 去掉該資料的頭尾空白後，長度為 0		
		if (tel == null || tel.length() == 0) {
			tel = DEFAULT_TEL;
		}
		
		String[] fruits = request.getParameterValues("fruit");
	    // 將四樣資訊裝入CustomerBean型別的物件cust內		
		Customer cust = new Customer(name, email, tel, fruits);
	    // 將cust物件暫存到請求物件內，成為它的屬性物件，屬性物件可以與別的程式共用。		
        request.setAttribute("customer",cust);
        // 程式的執行順序移轉到/ch02/displayCustomerInfo.jsp內        
		RequestDispatcher rd = request.getRequestDispatcher("/ch02/displayCustomerInfo.jsp");
		rd.forward(request, response);		
	}
}