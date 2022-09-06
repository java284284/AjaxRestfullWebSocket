package ch08.ex02;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
	name = "snServlet", 
	urlPatterns = { "/ch08/servletName" }
) 
public class ServletNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}
   
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><font color='Black'");
        out.println("ServletNameServlet: 觀察Filter的作用<BR>");
        out.println("ServletNameServlet: 透過本Servlet的servlet-name會啟動一個Filter: ServletNameFilter.java <BR></font>");
        out.println("<P>");
        out.println("<small><a href='.'>回前頁</a></small><HR><p>");
        out.println("</body></html>");
        //out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
