package ajax17._01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax17._01.model.TimeReportBean;

@WebServlet("/_01/TimeReport")
public class TimeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
//	    PrintWriter out = response.getWriter();
//	    ServletContext context = getServletContext();
//	    Enumeration<String> en = context.getAttributeNames();
//	    while (en.hasMoreElements()){
//	         String name = (String) en.nextElement();		
//	         out.println(name + "=" + context.getAttribute(name) + "<br>");
//	    }


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TimeZone timezone = null;
		request.setCharacterEncoding("UTF-8"); // 說明傳送到本程式之資料的內碼
		try (PrintWriter out = response.getWriter();) {
			
			String tz = request.getParameter("TimeZone"); // 讀取瀏覽器送來的資料("timeZone")
			if (tz == null || tz.trim().length() == 0) {
				timezone = TimeZone.getDefault();
			} else {
				timezone = TimeZone.getTimeZone(tz);
			}
			TimeReportBean trBean = new TimeReportBean();
			trBean.setTimeZone(timezone);
			out.println(trBean.getTime());
			return;                                   
		} catch (UnsupportedEncodingException e) {
			throw new ServletException(e);
		}
	}
}