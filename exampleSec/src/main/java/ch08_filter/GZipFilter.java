package ch08_filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class GZipFilter
 */
@WebFilter(dispatcherTypes = { 
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD,
		DispatcherType.INCLUDE, 
		DispatcherType.ERROR 
		}, 
		urlPatterns = { 
		"*.jsx",
		"*.cssx", 
		"*.htmlx", 
		"*.jspx", 
		"/" })
public class GZipFilter implements Filter {
	public GZipFilter() {
	}

	public void destroy() {

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String contentType = null;
		if ((contentType = acceptsGZipEncoding(httpRequest)) != null) {
			httpResponse.addHeader("Content-Encoding", contentType);			
			GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(
					httpResponse);
			chain.doFilter(request, gzipResponse);
			gzipResponse.close();
		} else {
			chain.doFilter(request, response);
		}
	}

	private String acceptsGZipEncoding(HttpServletRequest httpRequest) {
		String acceptEncoding = httpRequest.getHeader("Accept-Encoding").toLowerCase();
		if (acceptEncoding == null)
			return null;
		if (acceptEncoding.indexOf("x-gzip") != -1){
			return "x-gzip";
		}
		if (acceptEncoding.indexOf("gzip") != -1){
			return "gzip";
		}
		return null;
	}
}
