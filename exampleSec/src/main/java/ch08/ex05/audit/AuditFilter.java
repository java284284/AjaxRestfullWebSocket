package ch08.ex05.audit;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
@WebFilter(
	filterName="AuditFilter", 
	urlPatterns={"/ch08/TopSecret"}
)
public class AuditFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig fConfig;

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if ( request instanceof ServletRequest && 
			   response instanceof ServletResponse) {
			 FileOutputStream fos = new FileOutputStream("secret.txt", true);
			 OutputStreamWriter osw = new OutputStreamWriter(fos, "BIG5"); 
             PrintWriter out = new PrintWriter(osw);
		     HttpServletRequest  req  = (HttpServletRequest)request;
		     HttpServletResponse resp = (HttpServletResponse)response;
		     String name = req.getRemoteUser();
		     Date date = new Date(); 
		     out.println("使用者:" + name + "於" + date.toString() + "使用標的程式");
		     out.close();
		     chain.doFilter(req, resp);
		}
	}

	public void destroy() {
	}
}
