package ch05.ex04.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch05.ex04.model.Employee;
@WebServlet("/ch05/ex04/elfinal.do")
public class ELVersionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  String nameParam = request.getParameter("name");
		  String empIDParam = request.getParameter("empID");
		  Employee p = new Employee();
		  if (nameParam == null || empIDParam == "") {
			  nameParam = "(未輸入)";
		  }
		  if ( empIDParam == null || empIDParam == "" ) {
			  empIDParam = "-1";
		  }
		  p.setName(nameParam) ;
		  int  n = -99999;
		  try {
			  n = Integer.parseInt(empIDParam);
		  } catch(NumberFormatException e){
			  e.printStackTrace();
		  }
		  p.setEmpID(n) ;
		  request.setAttribute("personKey", p);
		  RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex04/resultFinalELVersion.jsp");
		  rd.forward(request, response);
	}
}