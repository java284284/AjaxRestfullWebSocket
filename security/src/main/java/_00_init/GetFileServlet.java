package _00_init;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getFile")    
public class GetFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String filename = "";   
    @Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String path = "/images/" + filename;
		String mimeType = getServletContext().getMimeType(path);
		response.setContentType(mimeType);
		try (
		OutputStream os = response.getOutputStream();
		InputStream is = getServletContext().getResourceAsStream(path);
		) {
			int len = 0 ;
			int total  = 0 ;
			byte[] b = new byte[65536];
			while ((len=is.read(b))!=-1){
				os.write(b, 0, len);
				total += len;
			}
			System.out.println("total" + total);
		}
	}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String value1 = request.getParameter("param1"); 
//		String value2 = request.getParameter("param2");
//		String value3 = request.getParameter("age");
//		response.setContentType("text/html; charset=UTF-8"); 
//		PrintWriter out = response.getWriter();
////		OutputStream os = response.getOutputStream();
//		out.println("<html><head></head><body>");
//		out.println("<h1>Hello, 凱蒂(Post)</h1>");
//		out.println("<h2>Hello, 米奇(Post)</h2>");
//		out.println("Hello, Garfield<br>");
//		
//		out.println("param1=" + value1 + "<br>");
//		out.println("param2=" + value2 + "<br>");
//		out.println("param3=" + value3 + "<br>");
//		out.println("</body>  <!-- 這是註解  -->");
//		out.println("</html>");
//		out.close();
		
	}

}
