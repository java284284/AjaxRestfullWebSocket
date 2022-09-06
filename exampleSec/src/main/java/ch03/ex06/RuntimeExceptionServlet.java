package ch03.ex06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch03/RuntimeExceptionServlet")
public class RuntimeExceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = (int)(Math.random() * 3) ;
		if (num==0) {
		     throw new NullPointerException("發生NullPointerException例外");
		} else if (num==1) {
		     throw new ArithmeticException("發生ArithmeticException例外");
		} else {
			throw new IndexOutOfBoundsException("發生IndexOutOfBoundsException例外");
		} 
	}
     
}
