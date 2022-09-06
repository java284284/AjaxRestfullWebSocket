package ch08.ex05.stringReplace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SearchAndReplaceFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig config;
    private String source, target;
    public void init(FilterConfig fConfig) throws ServletException {
		source = fConfig.getInitParameter("source");
		target = fConfig.getInitParameter("target");
		if (source == null || target == null)
			throw new ServletException("起始參數錯誤, source=" + source + ", target=" + target);
	}
    
    public SearchAndReplaceFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		StringWrapper wrapper = new StringWrapper((HttpServletResponse)response);
		chain.doFilter(request, wrapper);
		
		String responseString = wrapper.toString();
		StringReader sr = new StringReader(responseString);
		BufferedReader br = new BufferedReader(sr);	
		String line = null; 
	      while ( (line=br.readLine())!= null ) {
	    	  line = line.replace(source, target);
	    	  response.getWriter().print(line);
	      }
	}
}
