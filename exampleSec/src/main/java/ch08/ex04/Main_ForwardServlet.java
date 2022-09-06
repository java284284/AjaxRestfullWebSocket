package ch08.ex04;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch08/Main_Forward")
public class Main_ForwardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        out.println("Main_ForwardServlet: 目前在 Main_ForwardServlet, 準備forward ForwardNextServlet.java<BR>");
        RequestDispatcher rd = request.getRequestDispatcher("ForwardNextS");
        rd.forward(request, response);
        out.println("Main_ForwardServlet: 目前在 Main_ForwardServlet, 已經由下一棒ForwardNextServlet.java返回<BR>");
        out.println("<P>");
        out.println("<small><a href='.'>回前頁</a></small><HR><p>");
        //out.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
