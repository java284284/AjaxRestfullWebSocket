package ch00.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext ctx = sce.getServletContext();
    	GlobalService gs = new GlobalService();
    	ctx.setAttribute("sys", gs);
    }
	
}
