package ch06.ex04.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch06/setCookie.do")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		name = java.net.URLEncoder.encode(name, "UTF-8");
		Cookie cookie1 = new Cookie("username", name);
		String date = new java.util.Date().toString();
		Cookie cookie2 = new Cookie("time", date);
		cookie1.setMaxAge(30*60);
		cookie1.setHttpOnly(true);		
		cookie1.setSecure(true);
		cookie2.setMaxAge(30*60);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		RequestDispatcher  view = request.getRequestDispatcher("cookieTemp.jsp");
		view.forward(request, response);		
	}
}
