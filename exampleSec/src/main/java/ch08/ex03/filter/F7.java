package ch08.ex03.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
@WebFilter(
	filterName = "F7", 
//	urlPatterns="/ch08/hello",
	dispatcherTypes = {
			DispatcherType.REQUEST 
	}
)
public class F7 implements Filter {

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String servletPath = ((HttpServletRequest)request).getServletPath();
		out.println("<font color='blue'> F7: 目前在 F7, 準備呼叫chain.doFilter()進入下一棒</font><BR>");
		out.println("<font color='blue'> F7: ServletPath=" + servletPath + "</font><BR>");
        chain.doFilter(request, response);
        out.println("<font color='blue'> F7: 目前在 F7, 已經由下一棒返回<BR></font>");
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
