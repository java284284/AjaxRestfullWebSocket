package ch07.ex03 ;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.* ;
import javax.servlet.* ;

import java.io.* ;
@WebServlet(
	urlPatterns="/ch07/z",
	loadOnStartup = 0	
)
public class Zero extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

   public void doGet(HttpServletRequest req,
                     HttpServletResponse res) throws
                     IOException, ServletException {
       res.setContentType("text/html; charset=UTF-8") ;
       PrintWriter out = res.getWriter() ;
       out.println("Hello World, Anytime") ;
   }

   public void doPost(HttpServletRequest req,
                     HttpServletResponse res) throws
                     IOException, ServletException {
     doGet(req, res) ;
   }
}     