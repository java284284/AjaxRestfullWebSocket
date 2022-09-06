package ch07.ex04.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch07/contextInitParam.do")
public class ContextInitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     response.setContentType("text/html; charset=UTF-8");
	     PrintWriter  out = response.getWriter() ; 
	     
	     out.println("<html><head>");
	     out.println("<link rel='stylesheet' href='../css/styles.css' type='text/css' />");
	     out.println("<title>Context 測試初始化參數</title>");
	     out.println("</head>");
	     out.println("<BODY><h1>Context 測試初始化參數</h1>");
	     out.println("透過getServletContext().getInitParameter(\"adminEmail\")方法，可以讀入定義在&lt;context-param&gt;內的起始參數<BR>");
	     out.println("<p>");
	     out.println("Context 所設定的管理員email(即adminEmail)是" + getServletContext().getInitParameter("adminEmail") );
	     out.println("<BR><BR><font color='red'><small>本畫面直接由Servlet產生</small></font>") ;
	     out.println("<BR><BR><HR><BR><CENTER><small>&lt;&lt;<a href='ch07_04.jsp'>回前頁</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") ;
	     out.println("<small>&lt;&lt;<a href='index.jsp'>回第七章首頁</a>&gt;&gt;</small></CENTER>") ;
	     out.println("</BODY></HTML>");
	     
	}
}


