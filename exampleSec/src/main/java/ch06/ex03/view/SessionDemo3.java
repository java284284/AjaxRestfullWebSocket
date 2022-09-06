package ch06.ex03.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ch06/SD3.do")
public class SessionDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;		
		HttpSession session = request.getSession() ; 
		out.println("<html><head>");
		out.println("<link rel='stylesheet' href='../css/styles.css' type='text/css' />");
        out.println("<title>透過URLRewriting來支援Session</title>");
        out.println("</head>");
        out.println("<body><H1>透過URLRewriting來支援Session(SD3.do)</H1>");
		out.println("Dog 名稱:" + session.getAttribute("dog") + "<BR>");
		out.println("<a href=\"" + response.encodeURL("sd3Result.jsp")  + "\">按我(sd3Result.jsp)</a> " );
		session.setAttribute("mouse", "Micky, 鼠來寶是也...") ; 
		out.println("<P><CENTER><HR>");
		out.println("<small>&lt;&lt;<a href='index.jsp'>回第六章首頁</a>&gt;&gt;</small>");
		out.println("</CENTER>");
		out.println("</body></html>");
	}
}
