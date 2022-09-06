package ch02.ex05.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  1. 本Servlet讀取瀏覽器送來的資料，然後產生文字性資料的回應
 *  2. 通常Servlet不會產生文字性的回應，但如果要產生
 *     文字性的回應，必須編寫下列兩行：
 *     
       // 設定回應資料的格式為text/html，回應之文字資料的編碼為UTF-8(charset=UTF-8)
	   response.setContentType("text/html; charset=UTF-8");
	   // 由response物件取出Writer物件，此行與前一行的順序不能顛倒	   
	   PrintWriter out = response.getWriter();  
 */
@WebServlet("/ch02/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // 設定回應資料的格式為text/html，回應之文字資料的編碼為UTF-8(charset=UTF-8)
	   response.setContentType("text/html; charset=UTF-8");
	   // 由response物件取出Writer物件，此行與前一行的順序不能顛倒	   
	   PrintWriter out = response.getWriter();  
	   // 說明瀏覽器送來的文字資料的編碼為UTF-8	   
	   request.setCharacterEncoding("UTF-8");
	   // 讀取使用者在<input type="text" name="userId">欄位中輸入的資料
	   String id = request.getParameter("userId");
	   if ( id == null || id.trim().length() == 0){
		   id = "未輸入";
	   }
	   // 讀取使用者在<input type="text" name="pswd">欄位中輸入的資料	   
	   String pswd = request.getParameter("pswd");
	   if ( pswd == null || pswd.trim().length() == 0){
		   pswd = "未輸入";
	   }
	   // 讀取使用者在<input type="radio" name="gender">欄位中挑選的性別資料	   
	   String gender = request.getParameter("gender");
	   if ( gender == null ){
		   gender = "未挑選性別";
	   }
	   // 讀取使用者在<input type="checkbox" name="hobby">欄位中輸入的多值資料	   
	   String[] hobby = request.getParameterValues("hobby");
	   
	   // 準備產生回應
	   out.print("<HTML><HEAD>");
	   out.print("<link rel='stylesheet' href='../css/styles.css'  type='text/css' />");
	   out.print("<TITLE>由Servlet來產生回應很累人</TITLE></HEAD><BODY>");
	   out.print("<H1>由Servlet來產生回應很累人</H1>");	   
	   out.print("您的userId為" + id +"<BR>");
	   out.print("您的密碼為" + pswd +"<BR>");
	   out.print("您的性別為" + gender +"<BR>");
	   if (hobby == null) {
		   out.print("您未挑選嗜好<BR>");
	   } else {
		   out.print("您的嗜好為：");
		   for(String h : hobby){
			   out.print("<li>"+h+"</li>");
		   }
	   }
	   out.print("<BR><HR>");
	   out.print("您的IP為" + request.getRemoteHost() +"<BR><BR><BR>");	 
	   RequestDispatcher rd = request.getRequestDispatcher("/commons/segmentch02.jsp");
	   rd.include(request, response);
	   out.print("</BODY></HTML>");
	   out.close();
	}
}
