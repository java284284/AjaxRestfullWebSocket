package ch03.servletood._03;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch03.model.LotteryBean;
import ch03.service.LotteryService;

//@WebServlet("/ch03/_03/LotteryServlet")
public class LotteryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8"); // 說明傳送到本程式之資料的內碼
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			LotteryBean bean = null;
			String type = request.getParameter("type"); // 讀取瀏覽器送來的資料("type")

			LotteryService service = new LotteryService(); // LotteryService負責程式的邏輯運算
			if (type.equalsIgnoreCase("4")) {
				service.setLowerBound(0);
				service.setUpperBound(9);
				service.setBallNumber(4);
				bean = service.getFourStars();

			} else if (type.equalsIgnoreCase("6")) {
				service.setLowerBound(1);
				service.setUpperBound(49);
				service.setBallNumber(6);
				bean = service.getLuckyNumbers();
			}
			out.print(bean);
		} catch (UnsupportedEncodingException e) {
			throw new ServletException(e);
		}

	}

}
