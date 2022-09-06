package ch02.ex08.controller;
import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ch02/sendRedirect2")
public class SendRedirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> sites = new ArrayList<String>();
    public SendRedirect2() {
         sites.add("ch02_08_1.jsp");
         sites.add("ch02_08_2.jsp");
         sites.add("ch02_08_3.jsp");
         sites.add("ch02_08_4.jsp");        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = (int)(Math.random()*sites.size());
		String site = (String)sites.get(index);
        response.sendRedirect(site); // 會回應不同的網頁
	}
}