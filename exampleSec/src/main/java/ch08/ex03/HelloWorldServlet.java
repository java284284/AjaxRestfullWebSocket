package ch08.ex03;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
	name = "HelloWorldServlet", 
	urlPatterns = "/ch08/hello" 
)     
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}
   
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><font color='Black'>");
        out.println("HelloWorldServlet: 觀察配置多個Filters的執行<BR>");
        out.println("<P>");
        out.println("<small><a href='.'>回前頁</a></small><HR><p>");
        out.println("</body></html>");
        // out.close();  // 不能加入此敘述
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
