package ch08.ex04;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
	name="MainInclude",
	urlPatterns="/ch08/Main_Include"
)
public class Main_IncludeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        out.println("Main_IncludeServlet: 目前在 Main_IncludeServlet, 準備inlcude IncludeNextServlet.java<BR>");
        RequestDispatcher rd = request.getRequestDispatcher("IncludeNextS");
        rd.include(request, response);
        out.println("Main_IncludeServlett: 目前在 Main_IncludeServlet, 已經由下一棒IncludeNextServlet.java返回<BR>");
        out.println("<P>");
        out.println("<small><a href='.'>回前頁</a></small><HR><p>");
        //out.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
