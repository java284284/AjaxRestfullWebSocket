package ch03.servletood._04;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ch03/_04/LongRunServlet")
public class LongRunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = new Date();
		String msg1 = sdf.format(start);
		try {
		   Thread.sleep(5000);
		} catch(InterruptedException ex){
			System.out.println("發生例外: " + ex.getMessage());
		}
		Date end = new Date();
		String msg2 = sdf.format(end);
		out.write("<font color='red'>開始時間: " + msg1 + "</font><br>");
		out.write("<font color='blue'>結束時間: " + msg2 + "</font><br>");
		out.close();
	}
}
