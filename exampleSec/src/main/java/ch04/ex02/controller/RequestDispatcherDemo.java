package ch04.ex02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch04/ex02/RequestDispatcher.do")                    
public class RequestDispatcherDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      如果這四行出現，程式會丟出例外: java.lang.IllegalStateException		 
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Hello, World</body></html>");
//		out.flush();
//		out.close();
		int n = (int)(Math.random()*100) ;
		request.setAttribute("anInteger", new Integer(n) ) ; 
		//RequestDispatcher  rd = request.getRequestDispatcher("rd.jsp") ;
		RequestDispatcher  rd = getServletContext().getRequestDispatcher("rd.jsp") ;
		rd.forward(request, response);			 
	}
}
