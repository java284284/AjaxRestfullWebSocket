package ch07.ex07.view;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import ch07.ex07.model.CoffeeBean;

import java.io.*;
import java.util.*;
@WebServlet("/ch07/ch07_07.view")
public class ShowCoffeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		@SuppressWarnings("unchecked")
		List<CoffeeBean> coffeeList = (List<CoffeeBean>) context.getAttribute("COFFEE_LIST");
		Iterator<CoffeeBean> items = coffeeList.iterator();
		out.println("<HTML><HEAD>");
		out.println("<link rel='stylesheet' href='../css/styles.css' type='text/css' />");
		out.println("<TITLE>Coffee Catalog</TITLE>");
		out.println("</HEAD><BODY BGCOLOR='white'>");
		out.println("<TABLE BORDER='5' CELLSPACING='5'><TR><TD><TABLE BORDER='0' CELLSPACING='0' CELLPADDING='0' bgcolor='eedd82'");
		out.println(" WIDTH='600'>");
		out.println("<TR HEIGHT='30'><TD BGCOLOR='#CCCCFF'>&nbsp;</TD></TR>");
		out.println("  <TR><TD BGCOLOR='#CCCCFF' height='60' ALIGN='center' VALIGN='middle'>");
		out.println("    <H3>咖啡目錄</H3>");
		out.println("  </TD>");
		out.println("</TR>");
		//out.println("<TR HEIGHT='15'><TD HEIGHT='15'></TD></TR>");
		out.println("</TABLE>");
		out.println("<TABLE  BORDER='2' CELLPADDING='5' WIDTH='600' bgcolor='eedd82'> ");
		out.println("<TR>");
		out.println("  <TH>代號</TH>");
		out.println("  <TH>咖啡</TH>");
		out.println("  <TH>價格</TH>");
		out.println("  <TH>折扣</TH>");
		out.println("</TR>");
		while (items.hasNext()) {
			CoffeeBean cof = (CoffeeBean) items.next();
			out.println("<TR>");
			out.println("  <TD style='text-align:right;'>" + cof.getCoffeeCode() + "&nbsp;&nbsp;&nbsp;&nbsp;</TD>");
			out.println("  <TD>" + cof.getCoffeeName() + "</TD>");
			out.println("  <TD style='text-align:right;'>" + cof.getPrice() + "</TD>");
			out.println("  <TD style='text-align:center;'>" + cof.getDiscount() + "</TD>");
			out.println("</TR>");
		}  
		out.println("</TABLE></TD></TR></TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.println("<BR><BR><font color='red'><small>本畫面直接由Servlet產生</small></font>");
		out.println("<BR><BR><HR><BR><CENTER><small>&lt;&lt;<a href='index.jsp'>回前頁</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
	}
}
