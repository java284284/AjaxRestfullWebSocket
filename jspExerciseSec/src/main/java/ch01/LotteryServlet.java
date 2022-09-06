package ch01;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch01/LotteryServlet")
public class LotteryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
	          request.setCharacterEncoding("UTF-8");       // 說明傳送到本程式之資料的內碼
	          String name = request.getParameter("visitor");//讀取瀏覽器送來的資料("visitor")
	          if (name == null || name.trim().length() == 0 ) {
	             name = "訪客";   // 如果讀不到使用者輸入的資料，將變數name設為“訪客”; 
	          }
	          LotteryBean lottery = new LotteryBean();     // LotteryBean負責程式的邏輯運算
	          lottery.setLowerBound(1);                    // 設定LotteryBean所需的必要參數
	          lottery.setUpperBound(49);
	          lottery.setBallNumber(6);
	          Collection coll = lottery.getLuckyNumbers(); // 請LotteryBean產生所需的結果
	          request.setAttribute("visitName", name);     // 將第一項資訊放入request物件內
	          request.setAttribute("luckyNumber", coll);   // 將第二項資訊放入request物件內
	          RequestDispatcher rd =                       // 準備將移轉程式的執行順序
	                 request.getRequestDispatcher("/ch01/goodLuck.jsp");
	          rd.forward(request, response);               // 移轉程式的執行順序
	          return ;                                     // forward()之後會有一個return敘述
	       } catch(UnsupportedEncodingException e) {
	          throw new ServletException(e); 
	       }
	}
}