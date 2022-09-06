package ch08.performance;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
@WebFilter(
	filterName="PerformanceFilter", 
	urlPatterns={"/*"},
	initParams = {
			@WebInitParam(
				name="prefix", 
				value="程式執行效能觀測:"
			)
	}
)
public class PerformanceFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig config;
	private String prefix;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		prefix = config.getInitParameter("prefix");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		long begin, end ; 
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		end = System.currentTimeMillis();

		StringBuffer logMessage = new StringBuffer();
		if (request instanceof HttpServletRequest) {
			logMessage = ((HttpServletRequest) request).getRequestURL();
		}
		logMessage.append("的執行時間: ");
		logMessage.append(end - begin);
		logMessage.append(" 毫秒(ms)");

		if (prefix != null) {
			logMessage.insert(0, prefix);
		}
        String target = (String)session.getAttribute("Target");
        
        if ( target != null && target.equals("DM") &&  req.getServletPath().endsWith("DriverManagerServlet" )) {
        	session.setAttribute("DM","Driver Manager 版，時間=" + (end - begin) + " 毫秒(ms)" );
        }
        if (  target != null &&  target.equals("DS")  &&  req.getServletPath().endsWith("DataSourceServlet" )) {
        	session.setAttribute("DS","Data  Source   版，時間=" + (end - begin) + " 毫秒(ms)" );
        }
	}
	public void destroy() {
		config = null;
		prefix = null;
	}
}
