package ch07.ex06.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch07.ex06.model.Dog;

@WebServlet("/ch07/ListenerTester.do")
public class ListenerTester extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<link rel='stylesheet' href='../css/styles.css' type='text/css' />");
		out.println("<title>Context 測試初始化參數</title>");
		out.println("</head>");
		out.println("<BODY><h2>Context 測試初始化參數</h2>");

		
		out.println("展示ServletContextListener於伺服器啟動時，讀取系統起始參數(小狗的血統)，"
				+ "然後以該血統為參數，建構一個 Dog 物件，並將該物件設定為 Context Scope 的屬性物件<br>");
		out.println("<br>");
		Dog dog = (Dog) getServletContext().getAttribute("myDog");
		if (dog!=null){
		   out.println("狗的品種為:" + dog.getBreed() + "<p>");
		   out.println("請記得觀察寫入 Log 檔內的資訊。");
		} 
		out.println("<BR><BR><font color='red'><small>本畫面直接由Servlet產生</small></font>");
		out.println("<BR><BR><HR><BR><CENTER><small>&lt;&lt;<a href='ch07_04.jsp'>回前頁</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<small>&lt;&lt;<a href='index.jsp'>回第七章首頁</a>&gt;&gt;</small></CENTER>");
		 out.println("</BODY></HTML>");
	}
}