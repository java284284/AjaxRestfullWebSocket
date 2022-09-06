package ch02.ex12.controller;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ch02/ex12/ShowMessage")
public class ShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean notCacheData = false;       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (notCacheData) {
	        response.setHeader("Cache-Control", "no-cache");    // HTTP 1.1
	        response.setHeader("Pragma", "no-cache");           // HTTP 1.1
	        response.setDateHeader("Expires", 0);               // HTTP 1.0
		}
		String browser = "";		
		String type = request.getHeader("user-agent").toUpperCase();
		//System.out.println(type);
		if (type.indexOf("MSIE") >= 0) {
			browser = "MSIE" ; 
		} else if (type.indexOf("FIREFOX") >= 0) {
			browser = "FireFox" ; 
		} else if (type.indexOf("CHROME") >= 0) {
			browser = "Chrome" ; 
		} else  {
			browser = "其他" ;
		}
		String msg = "" ; 
		if (notCacheData) {
			msg = "有通知瀏覽器不要Cache回應";
		} else {
			msg = "未通知瀏覽器不要Cache回應";
		}
	    java.util.Date currentTime = new java.util.Date();
	    String time = String.format("%tr", currentTime);      // 時間 08:26:28 下午
	    String dateUS = String.format("%tD", currentTime);    // 日期 01/02/12
	    String dateTW = (Integer.parseInt(dateUS.substring(6).trim()) + 2000) + "年" + dateUS.substring(0, 2)  + "月" + dateUS.substring(3, 5) + "日";
	    String timeTW = time.substring(9) + time.substring(0, 8) ;
	    out.println("<TABLE Border='2'>" +
	    		"<TR><TD>" + "瀏覽器：" + browser  +  "</TD></TR>" + 
	            "<TR><TD>" + msg +  "</TD></TR>");
	    out.println("<TR><TD>" + "(Servlet)西元" + dateTW + " " + timeTW+ "</TD></TR>");
	    out.println("</TABLE>");
	    out.close();
	}	
}