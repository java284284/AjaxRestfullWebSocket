package ch08.ex03.filter;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
@WebFilter(
	filterName = "F1" 
//	servletNames="HelloWorldServlet",
//	urlPatterns = {"/ch08/hello"}
)
public class F1 implements Filter {

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String servletPath = ((HttpServletRequest)request).getServletPath();
        out.println("<font color='red'> F1: 目前在 F1, 準備呼叫chain.doFilter()進入下一棒<BR></font>");
		out.println("<font color='red'> F1: ServletPath=" + servletPath + "</font><BR>");
        chain.doFilter(request, response);
        out.println("<font color='red'> F1: 目前在 F1, 已經由下一棒返回<BR></font>");
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
