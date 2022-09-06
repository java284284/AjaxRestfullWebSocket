package ch02.ex14.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.007")
public class ExtensionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // 設定回應資料的格式為text/html，回應之文字資料的編碼為UTF-8(charset=UTF-8)
		   response.setContentType("text/html; charset=UTF-8");
		   // 由response物件取出Writer物件，此行與前一行的順序不能顛倒	   
		   PrintWriter out = response.getWriter();
		   // 準備產生回應
		   out.print("<HTML><HEAD><link rel='stylesheet' href='../../../css/styles.css'  type='text/css' />");
		   out.print("<TITLE>由Servlet來產生回應</TITLE></HEAD><BODY>");
		   out.print("</HEAD><BODY>");
		   out.print("<H1>Servlet來產生回應</H1>");	   
		   out.print("<H2><font color='Blue'>延伸檔名的對應關係</font></H2>");
		   RequestDispatcher rd = request.getRequestDispatcher("/commons/segmentch02.jsp");
		   rd.include(request, response);
		   out.print("</BODY></HTML>");
		   out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}