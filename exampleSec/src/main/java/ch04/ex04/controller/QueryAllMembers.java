package ch04.ex04.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch04.ex03.model.Member;
import ch04.ex03.model.RegisterService;
@WebServlet("/ch04/ex04/queryAllMembers.do")
public class QueryAllMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     	RegisterService  rs = new RegisterService();   
	     	Collection<Member>  coll = rs.getAllMembers() ;
	     	request.setAttribute("AllMembers", coll);
	     	RequestDispatcher rd = request.getRequestDispatcher("showAllMembers.jsp");
			rd.forward(request, response);
	     	return ; 
	}
}
