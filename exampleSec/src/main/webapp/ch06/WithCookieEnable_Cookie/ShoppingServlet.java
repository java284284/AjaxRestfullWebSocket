package pk.web;

import pk.domain.* ;
import javax.servlet.RequestDispatcher ;
import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Support classes

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class ShoppingServlet extends HttpServlet {

  public static final String SELECT_JAVA   = "JAVA";
  public static final String SELECT_XML    = "XML";
  public static final String SELECT_NET    = "NET";
  
  
  public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException, ServletException {
      doPost(request, response) ;
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException, ServletException {

    String action = request.getParameter("bookType");
    request.setCharacterEncoding("UTF-8") ; 

    if ( action.equalsIgnoreCase(SELECT_JAVA) ) {
      processJava(request, response);
    } else if ( action.equalsIgnoreCase(SELECT_XML) ) {
      processXML(request, response);
    } else if ( action.equalsIgnoreCase(SELECT_NET) ) {
      processNet(request, response);
    } 
  
  }
  /**
   * This method performs the "Java Books" selection
   */
  public void processJava(HttpServletRequest request,
                                  HttpServletResponse response)
         throws IOException {
     ShoppingCart sc ;
     // Create the HttpSession object
     HttpSession session = request.getSession();
     System.out.println("in step 1 (java), sessionID=" + session.getId());
     sc = (ShoppingCart)session.getAttribute("ShoppingCart") ;
     if ( sc == null ) { 
     	  sc = new ShoppingCart() ;
    	  session.setAttribute("ShoppingCart", sc) ;
     }
    
     String[] booksSelected = request.getParameterValues("javaBook");
     if  ( booksSelected != null && booksSelected.length > 0 ) {
    	  for ( int n = 0 ; n < booksSelected.length; n++ ) {
    	  	 StringTokenizer st = new StringTokenizer(booksSelected[n], ",") ;
    	  	 String title  = st.nextToken().trim() ;
    	  	 System.out.println("title=" + title) ;
    	  	 title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
    	  	 String bookId = st.nextToken().trim();
    	  	 double price  = Double.parseDouble(st.nextToken().trim()) ;
    	  	 sc.addBook(new Book(bookId, SELECT_JAVA, title, price) ) ;
    	  }
     }
     //response.sendRedirect(response.encodeRedirectURL("xml.jsp"));
     response.sendRedirect("xml.jsp");
  }

  
  public void processXML(HttpServletRequest request,
                                 HttpServletResponse response)
         throws IOException {
    ShoppingCart sc ;
    // Retrieve the HttpSession object
    HttpSession session = request.getSession();
    System.out.println("in step 2 (xml), sessionID=" + session.getId());
    sc = (ShoppingCart)session.getAttribute("ShoppingCart") ;
    if ( sc == null ) { 
     	  sc = new ShoppingCart() ;
    	  session.setAttribute("ShoppingCart", sc) ;
     }
    
    String[] booksSelected = request.getParameterValues("xmlBook");
    if  ( booksSelected != null && booksSelected.length > 0 ) {
    	  for ( int n = 0 ; n < booksSelected.length; n++ ) {
    	  	 StringTokenizer st = new StringTokenizer(booksSelected[n], ",") ;
    	  	 String title  = st.nextToken().trim() ;
    	  	 title = new String(title.getBytes("ISO-8859-1"), "UTF-8") ;
    	  	 String bookId = st.nextToken().trim() ;
    	  	 double price  = Double.parseDouble(st.nextToken().trim()) ;
    	  	 sc.addBook(new Book(bookId, SELECT_XML, title, price) ) ;
    	  }
    }
    //response.sendRedirect(response.encodeRedirectURL("net.jsp"));
    response.sendRedirect("net.jsp");
  }

  
  public void processNet(HttpServletRequest request,
                                    HttpServletResponse response)
         throws IOException, ServletException {
    ShoppingCart sc ;
    // Retrieve the HttpSession object
    HttpSession session = request.getSession();
    System.out.println("in step 3 (Net), sessionID=" + session.getId());
    sc = (ShoppingCart)session.getAttribute("ShoppingCart") ;
    if ( sc == null ) { 
     	  sc = new ShoppingCart() ;
    	  session.setAttribute("ShoppingCart", sc) ;
     }
    
    String[] booksSelected = request.getParameterValues("netBook");
    if  ( booksSelected != null && booksSelected.length > 0 ) {
    	  for ( int n = 0 ; n < booksSelected.length; n++ ) {
    	  	 StringTokenizer st = new StringTokenizer(booksSelected[n], ",") ;
    	  	 String title  = st.nextToken().trim() ;
    	  	 title = new String(title.getBytes("ISO-8859-1"), "UTF-8") ;
    	  	 String bookId = st.nextToken().trim() ;
    	  	 double price  = Double.parseDouble(st.nextToken().trim()) ;
    	  	 sc.addBook(new Book(bookId, SELECT_NET, title, price) ) ;
    	  }
    }
    //response.sendRedirect(response.encodeRedirectURL("win.html"));
    RequestDispatcher rd = request.getRequestDispatcher("billConfirm") ;
    rd.forward(request, response) ;

  
    //generateThankYouResponse(request, response);
    // This user's session is complete.
    //session.invalidate();
  }
  public void processWin(HttpServletRequest request,
                                    HttpServletResponse response)
         throws IOException, ServletException {
     ShoppingCart sc ;
     // Retrieve the HttpSession object
     HttpSession session = request.getSession();
     System.out.println("sessionID=" + session.getId());
  }


}
