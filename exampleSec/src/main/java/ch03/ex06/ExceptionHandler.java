package ch03.ex06;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/ExceptionHandler")
public class ExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        processError(request, response);
	    }
	 
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        processError(request, response);
	    }
	 
	    private void processError(HttpServletRequest request,
	            HttpServletResponse response) throws IOException {
	        // Analyze the servlet exception
	        Throwable throwable = (Throwable) request
	                .getAttribute("javax.servlet.error.exception");
	        Integer statusCode = (Integer) request
	                .getAttribute("javax.servlet.error.status_code");
	        String servletName = (String) request
	                .getAttribute("javax.servlet.error.servlet_name");
	        String requestUri = (String) request
	                .getAttribute("javax.servlet.error.request_uri");
	        if (servletName == null) {
	            servletName = "不知名的程式";
	        }
	        if (requestUri == null) {
	            requestUri = "不知名的請求";
	        }
	         
	        // Set response content type
	          response.setContentType("text/html; charset=UTF-8");
	      
	          PrintWriter out = response.getWriter();
	          out.write("<html><head>"
	          		+ "<link rel='stylesheet' href='../css/styles.css'  type='text/css' />"
	          		+ "<title>Exception/Error 明細</title></head><body>");
	          if(statusCode != 500){
	              out.write("<h3>HTTP狀態碼</h3>");
	              out.write("<strong>Status Code</strong>:"+statusCode+"<br>");
	              out.write("<strong>Requested URI</strong>:"+requestUri);
	          }else{
	              out.write("<h3>例外明細</h3>");
	              out.write("<ul><li>Servlet Name:"+servletName+"</li>");
	              out.write("<li>Exception Name:"+throwable.getClass().getName()+"</li>");
	              out.write("<li>Requested URI:"+requestUri+"</li>");
	              out.write("<li>Exception Message:"+throwable.getMessage()+"</li>");
	              out.write("</ul>");
	          }
	           
	          out.write("<br><br>");
	          out.write("<br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
	          out.write("<a href='" + request.getHeader("referer")+ "'>回前頁</a>");
	          out.write("</body></html>");
	    }
	}