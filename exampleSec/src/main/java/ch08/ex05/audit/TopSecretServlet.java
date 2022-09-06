package ch08.ex05.audit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch08/TopSecret")
public class TopSecretServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response) ; 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=BIG5");
		PrintWriter out = response.getWriter();		
		out.println("此頁的資訊為宇宙最高機密....(Servlet 3.0)<br><p/>");
		out.println("<a href=" + request.getHeader("referer")  + " >回前頁</a>");
		out.close();
	}
}
