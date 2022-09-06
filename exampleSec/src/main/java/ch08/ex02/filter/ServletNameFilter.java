package ch08.ex02.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(
	servletNames={"snServlet"}
)
public class ServletNameFilter implements Filter {

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        out.println("<font color='red'> ServletNameFilter: 目前在 ServletNameFilter, 準備呼叫chain.doFilter()進入下一棒<BR></font>");
        chain.doFilter(request, response);
        out.println("<font color='red'> ServletNameFilter: 目前在 ServletNameFilter, 已經由下一棒返回<BR></font>");
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
